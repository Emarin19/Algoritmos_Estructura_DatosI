
package hellodraganddrop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Drag and drop basic feature / implementacion
public class HelloDragAndDrop extends Application {

    @Override 
    public void start(Stage stage) {
        stage.setTitle("Hello Drag And Drop");

        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 400, 200);
        scene.setFill(Color.LIGHTGREEN);

        final Text source = new Text(70, 100, "ARRASTRAME");//Fuente
        source.setScaleX(2.0);
        source.setScaleY(2.0);

        final Text target = new Text(270, 100, "SUELTAME");//Objetivo o destino
        target.setScaleX(2.0);
        target.setScaleY(2.0);
        
        //Cuando se hace click sobre la fuente
        source.setOnDragDetected(new EventHandler <MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                //Arrastre fue detectado, iniciar gesto drag and drop
                System.out.println("onDragDetected");
                
                //Permitir cualquier modo de transferencia
                //Tablero de arrastre
                Dragboard db = source.startDragAndDrop(TransferMode.ANY);
                
                //Poner un string en el tablero de arrastre
                ClipboardContent content = new ClipboardContent();//Contenido de portapapeles
                content.putString(source.getText());
                db.setContent(content);
                
                event.consume();
            }
        });

        target.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //El dato es arrastrado sobre el destino
                System.out.println("onDragOver");
                
                /* accept it only if it is  not dragged from the same node 
                 * and if it has a string data */
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                
                event.consume();
            }
        });

        target.setOnDragEntered(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //El gesto de arrastrar y soltar entró en el objetivo
                System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    target.setFill(Color.GREEN);
                }
                
                event.consume();
            }
        });

        target.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                //El mouse se alejó, retire las señales gráficas
                target.setFill(Color.BLACK);
                
                event.consume();
            }
        });
        
        target.setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    target.setText(db.getString());
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);
                
                event.consume();
            }
        });

        source.setOnDragDone(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    source.setText("");
                }
                
                event.consume();
            }
        });

        root.getChildren().add(source);
        root.getChildren().add(target);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

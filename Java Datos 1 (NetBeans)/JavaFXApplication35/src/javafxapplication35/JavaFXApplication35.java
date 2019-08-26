
package javafxapplication35;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXApplication35 extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Drag and Drop");
        stage.setResizable(false);
        
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 400, 300);
        scene.setFill(Color.CORAL);
        
        final Text source = new Text(50, 150, "ARRASTRAME");
        source.setScaleX(1.5);
        source.setScaleY(1.5);
        
        final Text target = new Text(290, 150, "SUELTAME");
        target.setScaleX(1.5);
        target.setScaleY(1.5);
        
        source.setOnDragDetected(new EventHandler <MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("OnDragDetected");
                
                Dragboard db = source.startDragAndDrop(TransferMode.ANY);
                
                ClipboardContent content = new ClipboardContent();
                content.putString(source.getText());
                db.setContent(content);
                
                event.consume();
            }

        });
        
        target.setOnDragOver(new EventHandler <DragEvent>(){
            @Override
            public void handle(DragEvent event) {
                 System.out.println("OnDragOver");
                 
                 if (event.getGestureSource() != target && event.getDragboard().hasString()){
                     event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                 }
                 
                 event.consume();
            }
            
        });
        
        
        target.setOnDragEntered(new EventHandler <DragEvent>(){
            @Override
            public void handle(DragEvent event) {
                 System.out.println("OnDragEntered");
                 
                 if(event.getGestureSource() != target && event.getDragboard().hasString()){
                     target.setFill(Color.GREEN);
                 }
                 
                 event.consume();
            }
            
        });
        
        
        target.setOnDragExited(new EventHandler <DragEvent>(){
            @Override
            public void handle(DragEvent event) {
                 System.out.println("OnDragExited");
                 
                 target.setFill(Color.BLACK);
                 
                 event.consume();
            }
            
        });
        
        target.setOnDragDropped(new EventHandler <DragEvent>(){
            @Override
            public void handle(DragEvent event) {
                System.out.println("OnDragDropper");
                
                Dragboard db = event.getDragboard();
                boolean success = false;
                if(db.hasString()){
                    target.setText(db.getString());
                    success = true;
                }
                
                event.setDropCompleted(success);
                
                event.consume();
            }
            
        });
        
        source.setOnDragDone(new EventHandler <DragEvent>(){
            @Override
            public void handle(DragEvent event) {
                System.out.println("OnDragDone");
                
                if(event.getTransferMode() == TransferMode.MOVE){
                    source.setText("");
                }
                
                event.consume();
            }
            
        });
        
        
        
        
        root.getChildren().addAll(source, target);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

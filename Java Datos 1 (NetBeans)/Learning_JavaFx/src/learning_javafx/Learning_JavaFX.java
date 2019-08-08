
package learning_javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Learning_JavaFX extends Application {
    
    Stage Window;
    Scene scene1, scene2;

    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Window = primaryStage;
        Window.setTitle("Learning JavaFX");
        
        Label label1 = new Label("Welcome to the first scene");
        Button button1 = new Button("New scene");
        button1.setOnAction(e -> Window.setScene(scene2));
        
        Button button0 = new Button("Sig in Example");
        button0.setOnAction(e ->{
            Sig_InExample.Display();
        });
        
        Button orderPizza = new Button("CheckBox Example");
        orderPizza.setOnAction(e -> {
            OrderPizza.pizzaSelected();
        });
       
        
        //Se llama a otro ventana (creada en una clase), está ventana funciona como Alert_Box.
        Button button3 = new Button("Click me");
        button3.setOnAction(e -> Alert_Box.Display("MessageBox", "There a problem with the comunication"));
        
        //Data comunication between windows
        Button button4 = new Button("Click me");
        button4.setOnAction(e -> {
            boolean Result = ConfirmBox.display();
            System.out.println(Result);
        });
        
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> closeProgram());
        
        Window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button0, orderPizza, button1, button3, button4,closeButton);
        layout1.setAlignment(Pos.CENTER);
        
        HBox layoutC = new HBox();
        layoutC.setAlignment(Pos.BASELINE_RIGHT);
        layoutC.getChildren().add(closeButton);
        
        //Border Pane para contener más de dos layouts diferentes en una misma ventana, consultar 
        //la documentación oficial de Oracle para JavaFX.
        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(layout1);
        borderpane.setBottom(layoutC);
        
        scene1 = new Scene(borderpane,300,300);
        scene1.getStylesheets().add("Viper.css");
        
        Button button2 = new Button("Go back");
        button2.setOnAction(e -> Window.setScene(scene1));
        
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 600);
                
        Window.setScene(scene1);
        Window.show();
       
    }
    private void closeProgram(){
        //System.out.println("File is saved!");
        //Window.close();
        Boolean answer = ConfirmBox.display();
        if (answer ==true){
            Window.close();
        }
    }
    
}

package makingmenus_example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MakingMenus_Example extends Application {

    Stage window;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Menus Example");

        //File menu
        Menu fileMenu = new Menu("File");
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("Create a new file..."));
        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit..."));

        //Edit menu
        //El _ es para accder por teclas a dicho menu (Alt + letra inicial)
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("Pasting some crap"));
        //Hay opciones del menu que de acuerdo a las acciones en el programa estan o no desactivadas
        paste.setDisable(true);
        editMenu.getItems().add(paste);

        //Help menu
        Menu helpMenu = new Menu("Help");
        //En un menu se puede definir uno o varios paramentros simultaneamente, por ejemplo los menu de configuracion o de ayuda.
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
            if(showLines.isSelected())
                System.out.println("Program will now display line numbers");
            else
                System.out.println("Hiding line number");
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        //Hay parametros definidos por default
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        //Difficulty RadioMenuItems
        //Hay opciones en un menu que solo pueder ser seleccionadas unicamente, no existe la simultaneidad
        Menu difficultyMenu = new Menu("Difficulty");
        //ToggleGroup sirve para definir que los parametros de un menu solo se puedan seleccionar uno a la vez
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }

}
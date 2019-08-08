
package treeview_example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class TreeView_Example extends Application {
    
    Stage window;
    TreeView<String> tree;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Tree View Example");

        TreeItem<String> root, bucky, megan;
        
        //Root
        root = new TreeItem<String>();
        root.setExpanded(true);
        
        //Bucky
        bucky = makeBranch("Bucky", root);
        makeBranch("Thenewboston", bucky);
        makeBranch("YouTube", bucky);
        makeBranch("Chicken", bucky);
        
        //Megan
        megan = makeBranch("Megan", root);
        makeBranch("Glitter", megan);
        makeBranch("Makeup", megan);
        
        //Create the tree and hide the main Root
        tree = new TreeView<String>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v,oldvalue,newValue) -> {
            if (newValue != null){
                System.out.println(newValue.getValue());
            }
        });
        
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    //Create branches
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<String>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
 
}

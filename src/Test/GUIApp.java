/*
package Test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.Dialog;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;



*/
/**
 * Created by butkoav on 11.05.2016.
 *//*

public class GUIApp extends Application implements EventHandler<ActionEvent>
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void init() throws Exception
    {
        super.init();
        dialog.setTitle("Ha ha ha");
        dialog.setContentText("You've clicked the Button!!!");
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

    }

    Button button;
    Dialog dialog = new Dialog();


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Andrey's first Java application!!!");
        button = new Button();
        button.setText("Click me !");
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                //endApplication();
                showDialog();
            }
        });

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    @Override
    public void handle(ActionEvent event)
    {
        if (event.getSource() == button)
        {

            //showDialog();

            System.exit(0);

        }

    }

    private void showDialog()
    {
        if (!dialog.isShowing())
        {
            dialog.show();

        }
    }
    private void endApplication()
    {
        System.exit(0);
    }
}
*/

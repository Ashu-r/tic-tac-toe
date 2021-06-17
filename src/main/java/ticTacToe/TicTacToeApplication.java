package ticTacToe;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StringBuilder mark = new StringBuilder("X");
        BorderPane layout = new BorderPane();

        Label turn = new Label("Turn: " + mark);
        bigFont(turn);
        layout.setTop(turn);
        ControlGridPane gridPaneControl = new ControlGridPane();
        GridPane gridPane = gridPaneControl.start();

        layout.setCenter(gridPane);
        Scene scene = new Scene(layout);
        ButtonHandler bh = new ButtonHandler(gridPaneControl, mark, turn);
        for (Button b: gridPaneControl.getButtons()) {
            b.setOnAction(bh);
        }
        stage.setScene(scene);
        stage.show();

    }


    public static void bigFont(Labeled o) {
        o.setFont(Font.font("Monospaced", 40));
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}

package ticTacToe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ButtonHandler implements EventHandler<ActionEvent> {
    private final StringBuilder message;
    private final ControlGridPane c;
    private Label l;

    public ButtonHandler(ControlGridPane c, StringBuilder message, Label turn) {
        this.message = message;
        this.c = c;
        this.l = turn;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        boolean isWinner = c.isFinished().length() > 0 && !c.isFinished().equals(" ");

        if (button.getText().matches("[XO]") ||  isWinner) {
            return;
        }

        c.setButtonText(button ,message.toString());
        boolean isO  = message.toString().equals("O");
        message.delete(0, message.length());
        String s = isO ?"X":"O";
        l.setText("Turn: " + s);
        message.append(s);
        if (c.isFinished().length() > 0 && !c.isFinished().equals(" ")) {
            l.setText("The end!");
        }
    }

}

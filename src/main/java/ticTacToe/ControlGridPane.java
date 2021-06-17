package ticTacToe;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class ControlGridPane {
    private ArrayList<Button> buttons;

    public ControlGridPane() {
        GridPane gridPane = new GridPane();
        this.buttons = new ArrayList<>();
        for (int i=0; i < 9; i++) {
            buttons.add(new Button(" "));
        }
    }

    public GridPane start() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        for (Button b: buttons) {
            bigFont(b);

        }

        gridPane.addRow(0,getButton(0),getButton(1),getButton(2));
        gridPane.addRow(1,getButton(3),getButton(4),getButton(5));
        gridPane.addRow(2,getButton(6),getButton(7),getButton(8));

        return gridPane;
    }

    public String isFinished() {
        String xo = "[XO]";
        //horizontal rows
        for (int i=0,j=0; j <3; i +=3,j ++) {
            if (notBlank(getButton(i).getText(),getButton(i+1).getText(),getButton(i+2).getText())) {
                if (btnTextEqual(i, 1, 2)) return getButton(i).getText();
            }
        }
        //vertical columns
        for (int i=0; i <3; i++) {
            if (notBlank(getButton(i).getText(),getButton(i+3).getText(),getButton(i+6).getText())) {
                if (btnTextEqual(i, 3, 6)) return getButton(i).getText();
            }
        }
        if (btnTextEqual(0,4,8)) return getButton(0).getText();
        if (btnTextEqual(2,2,4)) return getButton(2).getText();
        return "";
    }

    private boolean btnTextEqual(int i, int i2, int i3) {
        if (getButton(i).getText().equals(getButton(i + i2).getText())) {
            return getButton(i + i2).getText().equals(getButton(i + i3).getText());
        }
        return false;
    }

    public boolean notBlank(String s1, String s2, String s3) {
        return  !(s1.equals(" ") || s2.equals(" ") || s3.equals(" "));
    }
    public ArrayList<Button> getButtons() {
        return buttons;
    }

    public Button getButton(int index) {
        return buttons.get(index);
    }

    public void setButtonText(Button b, String s) {
        b.setText(s);
    }

    private void bigFont(Labeled o) {
        o.setFont(Font.font("Monospaced", 40));
    }
}

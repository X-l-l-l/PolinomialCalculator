package com.example.temanr1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Objects;

public class Controller {
    public Button b9;
    public Button b6;
    public Button b3;
    public Button b8;
    public Button b5;
    public Button b2;
    public Button b7;
    public Button b4;
    public Button b1;
    public Button b0;
    public Button bminus;
    public Button bpow;
    public Button bplus;
    public Button bint;
    public Button bder;
    public Button bmul;
    public Button bdiv;
    public Button badd;
    public Button bsub;
    public TextArea out;
    public TextField pol1;
    public TextField pol2;
    public Button bx;
    public Button bdel;
    public Button bclear;

    int pol;

    @FXML
    protected void bt1() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "1");
        else
            pol2.setText(pol2.getText() + "1");
    }

    @FXML
    protected void bt2() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "2");
        else
            pol2.setText(pol2.getText() + "2");
    }

    @FXML
    protected void bt3() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "3");
        else
            pol2.setText(pol2.getText() + "3");
    }

    @FXML
    protected void bt4() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "4");
        else
            pol2.setText(pol2.getText() + "4");
    }

    @FXML
    protected void bt5() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "5");
        else
            pol2.setText(pol2.getText() + "5");
    }

    @FXML
    protected void bt6() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "6");
        else
            pol2.setText(pol2.getText() + "6");
    }

    @FXML
    protected void bt7() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "7");
        else
            pol2.setText(pol2.getText() + "7");
    }

    @FXML
    protected void bt8() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "8");
        else
            pol2.setText(pol2.getText() + "8");
    }

    @FXML
    protected void bt9() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "9");
        else
            pol2.setText(pol2.getText() + "9");
    }

    @FXML
    protected void bt0() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "0");
        else
            pol2.setText(pol2.getText() + "0");
    }

    @FXML
    protected void btplus() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "+");
        else
            pol2.setText(pol2.getText() + "+");
    }

    @FXML
    protected void btminus() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "-");
        else
            pol2.setText(pol2.getText() + "-");
    }

    @FXML
    protected void btpow() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "^");
        else
            pol2.setText(pol2.getText() + "^");
    }

    @FXML
    protected void btx() {
        if (pol > 0)
            pol1.setText(pol1.getText() + "x");
        else
            pol2.setText(pol2.getText() + "x");
    }

    @FXML
    protected void btdel() {
        if (pol > 0)
            if(!Objects.equals(pol1.getText(), ""))
                pol1.setText(pol1.getText().substring(0, pol1.getText().length() - 1));
        else
            if(!Objects.equals(pol2.getText(), ""))
                pol2.setText(pol2.getText().substring(0, pol2.getText().length() - 1));
    }

    @FXML
    protected void btadd() {
        Polynomial p1 = new Polynomial();
        p1.extract(pol1.getText());
        Polynomial p2 = new Polynomial();
        p2.extract(pol2.getText());

        out.setText(p1.add(p2).toString());
    }

    @FXML
    protected void btsub() {
        Polynomial p1 = new Polynomial();
        p1.extract(pol1.getText());
        Polynomial p2 = new Polynomial();
        p2.extract(pol2.getText());

        out.setText(p1.sub(p2).toString());
    }

    @FXML
    protected void btmul() {
        Polynomial p1 = new Polynomial();
        p1.extract(pol1.getText());
        Polynomial p2 = new Polynomial();
        p2.extract(pol2.getText());

        out.setText(p1.mul(p2).toString());
    }

    @FXML
    protected void btdiv() {
        Polynomial p1 = new Polynomial();
        p1.extract(pol1.getText());
        Polynomial p2 = new Polynomial();
        p2.extract(pol2.getText());

        out.setText(p1.div(p2).toString());
    }

    @FXML
    protected void btint() {
        Polynomial p1 = new Polynomial();
        p1.extract(pol1.getText());

        out.setText(p1.integ().toString());
    }

    @FXML
    protected void btder() {
        Polynomial p1 = new Polynomial();
        p1.extract(pol1.getText());

        out.setText(p1.deriv().toString());
    }

    @FXML
    protected void btclear() {
        out.setText("");
    }

    @FXML
    protected void changePol1() {
        pol = 1;
    }
    @FXML
    protected void changePol2() {
        pol = -1;
    }
}
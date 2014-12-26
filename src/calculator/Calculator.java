/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Calculator GUI
 *
 * @author Joon
 * @version 0.1 Dec 25, 2014
 */
public class Calculator extends Application {

    final int SIDE = 50;

    int state = 0;

    double operand;
    char operator;
    double answer;

    private Rectangle result;
    private Text display;

    private Rectangle divButton;
    private Rectangle mulButton;
    private Rectangle subButton;
    private Rectangle addButton;
    private Rectangle equalButton;

    private Rectangle acButton;
    private Rectangle negButton;
    private Rectangle perButton;
    private Rectangle decButton;
    private Rectangle button0;
    private Rectangle button1;
    private Rectangle button2;
    private Rectangle button3;
    private Rectangle button4;
    private Rectangle button5;
    private Rectangle button6;
    private Rectangle button7;
    private Rectangle button8;
    private Rectangle button9;

    private Text divText;
    private Text mulText;
    private Text subText;
    private Text addText;
    private Text equalText;

    private Text acText;
    private Text negText;
    private Text perText;
    private Text decText;
    private Text text0;
    private Text text1;
    private Text text2;
    private Text text3;
    private Text text4;
    private Text text5;
    private Text text6;
    private Text text7;
    private Text text8;
    private Text text9;

    @Override
    public void start(Stage primaryStage) {
        result = new Rectangle(200, 100, Color.BLACK);
        display = new Text("0");
        display.setFill(Color.WHITE);
        display.setFont(Font.font("HELVETICA", 50));
        display.setX(160);
        display.setY(80);

        divButton = new OrangeButton(SIDE * 3, SIDE * 2);
        divText = new ButtonText("/", "WHITE", SIDE * 3 + 19, SIDE * 2 + 31);
        mulButton = new OrangeButton(SIDE * 3, SIDE * 3);
        mulText = new ButtonText("X", "WHITE", SIDE * 3 + 19, SIDE * 3 + 31);
        subButton = new OrangeButton(SIDE * 3, SIDE * 4);
        subText = new ButtonText("-", "WHITE", SIDE * 3 + 19, SIDE * 4 + 31);
        addButton = new OrangeButton(SIDE * 3, SIDE * 5);
        addText = new ButtonText("+", "WHITE", SIDE * 3 + 19, SIDE * 5 + 31);
        equalButton = new OrangeButton(SIDE * 3, SIDE * 6);
        equalText = new ButtonText("=", "WHITE", SIDE * 3 + 19, SIDE * 6 + 31);

        //AC button changes to "C" when calculator is in use.
        //Text width becomes 19 and height becomes SIDE*2+31
        acButton = new GreyButton(0, SIDE * 2);
        acText = new ButtonText("AC", "BLACK", 12, SIDE * 2 + 31);

        negButton = new GreyButton(SIDE, SIDE * 2);
        negText = new ButtonText("+/-", "BLACK", SIDE + 10, SIDE * 2 + 31);
        perButton = new GreyButton(SIDE * 2, SIDE * 2);
        perText = new ButtonText("%", "BLACK", SIDE * 2 + 19, SIDE * 2 + 31);

        decButton = new WhiteButton(SIDE * 2, SIDE * 6);
        decText = new ButtonText(".", "BLACK", SIDE * 2 + 19, SIDE * 6 + 31);

        button0 = new WhiteButton(0, SIDE * 6);
        button0.setWidth(100.0);
        text0 = new ButtonText("0", "BLACK", 19, SIDE * 6 + 31);

        button1 = new WhiteButton(0, SIDE * 5);
        text1 = new ButtonText("1", "BLACK", 19, SIDE * 5 + 31);
        button2 = new WhiteButton(SIDE, SIDE * 5);
        text2 = new ButtonText("2", "BLACK", SIDE + 19, SIDE * 5 + 31);
        button3 = new WhiteButton(SIDE * 2, SIDE * 5);
        text3 = new ButtonText("3", "BLACK", SIDE * 2 + 19, SIDE * 5 + 31);
        button4 = new WhiteButton(0, SIDE * 4);
        text4 = new ButtonText("4", "BLACK", 19, SIDE * 4 + 31);
        button5 = new WhiteButton(SIDE, SIDE * 4);
        text5 = new ButtonText("5", "BLACK", SIDE + 19, SIDE * 4 + 31);
        button6 = new WhiteButton(SIDE * 2, SIDE * 4);
        text6 = new ButtonText("6", "BLACK", SIDE * 2 + 19, SIDE * 4 + 31);
        button7 = new WhiteButton(0, SIDE * 3);
        text7 = new ButtonText("7", "BLACK", 19, SIDE * 3 + 31);
        button8 = new WhiteButton(SIDE, SIDE * 3);
        text8 = new ButtonText("8", "BLACK", SIDE + 19, SIDE * 3 + 31);
        button9 = new WhiteButton(SIDE * 2, SIDE * 3);
        text9 = new ButtonText("9", "BLACK", SIDE * 2 + 19, SIDE * 3 + 31);

        setDivButton();
        setMulButton();
        setSubButton();
        setAddButton();
        setEqualButton();
        setACButton();
//        setNegButton();
//        setPerButton();
//        setDecButton();
        setButton0();
        setButton1();
        setButton2();
        setButton3();
        setButton4();
        setButton5();
        setButton6();
        setButton7();
        setButton8();
        setButton9();

        Pane root = new Pane();

        root.getChildren()
                .addAll(result, display, divButton, divText, mulButton, mulText,
                        subButton, subText, addButton, addText, equalButton,
                        equalText, acButton, acText, negButton, negText,
                        perButton, perText, decButton, decText, button0,
                        text0, button1, text1, button2, text2, button3, text3,
                        button4, text4, button5, text5, button6, text6, button7,
                        text7, button8, text8, button9, text9);

        Scene scene = new Scene(root, 191, 341);

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void setDivButton() {
        //Divide Button
        divButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                divButton.setFill(Color.DARKORANGE);
            }
        });
        divButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                divButton.setFill(Color.ORANGE);
                divButton.setStrokeWidth(3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                //divide method.
            }
        });
        divText.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                divButton.setFill(Color.DARKORANGE);
            }
        });
        divText.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                divButton.setFill(Color.ORANGE);
                divButton.setStrokeWidth(3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);
                //divide method.
            }
        });
    }

    private void setMulButton() {
        //Multiply Button
        mulButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mulButton.setFill(Color.DARKORANGE);
            }
        });
        mulButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mulButton.setFill(Color.ORANGE);
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);
                //multiply method.
            }
        });
        mulText.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mulButton.setFill(Color.DARKORANGE);
            }
        });
        mulText.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mulButton.setFill(Color.ORANGE);
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);
                //multiply method.
            }
        });
    }

    private void setSubButton() {
        //Subtract Button
        subButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                subButton.setFill(Color.DARKORANGE);
            }
        });
        subButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                subButton.setFill(Color.ORANGE);
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(3);
                addButton.setStrokeWidth(0.3);
                //subtract method.
            }
        });
        subText.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                subButton.setFill(Color.DARKORANGE);
            }
        });
        subText.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                subButton.setFill(Color.ORANGE);
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(3);
                addButton.setStrokeWidth(0.3);
                //subtract method.
            }
        });
    }

    private void setAddButton() {
        //Add Button
        addButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                addButton.setFill(Color.DARKORANGE);
            }
        });
        addButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                addButton.setFill(Color.ORANGE);
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(3);
                //add method.
                //test
                if (state == 1) {
                    operand = Double.parseDouble(display.getText());
                    operator = '+';
                    state = 2;
                }
                //end test
            }
        });
        addText.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                addButton.setFill(Color.DARKORANGE);
            }
        });
        addText.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                addButton.setFill(Color.ORANGE);
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(3);
                //add method.
            }
        });
    }

    private void setEqualButton() {
        //Equal Button
        equalButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                equalButton.setFill(Color.DARKORANGE);
            }
        });
        equalButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                equalButton.setFill(Color.ORANGE);
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                //equals method.
                //displays answer
                if (state == 3) {
                    switch (operator) {
                        case '+':
                            answer = operand + Double.parseDouble(display.getText());
                            display.setText(answer + "");
                    }

                }

            }
        });
        equalText.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                equalButton.setFill(Color.DARKORANGE);
            }
        });
        equalText.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                equalButton.setFill(Color.ORANGE);
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);
                //equals method.
                //displays answer

            }
        });
    }

    private void setButton0() {
        button0.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button0.setFill(Color.gray(0.85));
            }
        });
        button0.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button0.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "0");
                        fixDisplay();
                    }
                }
            }
        });
        text0.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button0.setFill(Color.gray(0.85));
            }
        });
        text0.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button0.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "0");
                        fixDisplay();
                    }
                }
            }
        });
    }

    private void setButton1() {
        button1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button1.setFill(Color.gray(0.85));
            }
        });
        button1.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button1.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("1");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "1");
                        fixDisplay();
                    }
                } else if (state == 2) {
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("1");
                    state = 3;
                } else if (state == 3) {
                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "1");
                        fixDisplay();
                    }

                }

            }
        });
        text1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button1.setFill(Color.gray(0.85));
            }
        });
        text1.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button1.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("1");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "1");
                        fixDisplay();
                    }
                }
            }
        });
    }

    private void setButton2() {
        button2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button2.setFill(Color.gray(0.85));
            }
        });
        button2.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button2.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("2");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "2");
                        fixDisplay();
                    }
                }
            }
        });
        text2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button2.setFill(Color.gray(0.85));
            }
        });
        text2.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button2.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("2");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "2");
                        fixDisplay();
                    }
                }
            }
        });
    }

    private void setButton3() {
        button3.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button3.setFill(Color.gray(0.85));
            }
        });
        button3.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button3.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("3");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "3");
                        fixDisplay();
                    }
                }
            }
        });
        text3.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button3.setFill(Color.gray(0.85));
            }
        });
        text3.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button3.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("3");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "3");
                        fixDisplay();
                    }
                }
            }
        });
    }

    private void setButton4() {
        button4.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button4.setFill(Color.gray(0.85));
            }
        });
        button4.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button4.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("4");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "4");
                        fixDisplay();
                    }
                }
            }
        });
        text4.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button4.setFill(Color.gray(0.85));
            }
        });
        text4.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button4.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("4");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "4");
                        fixDisplay();
                    }
                }
            }
        });
    }

    private void setButton5() {
        button5.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button5.setFill(Color.gray(0.85));
            }
        });
        button5.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button5.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("5");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "5");
                        fixDisplay();
                    }
                }
            }
        });
        text5.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button5.setFill(Color.gray(0.85));
            }
        });
        text5.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button5.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("5");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "5");
                        fixDisplay();
                    }
                }
            }
        });
    }

    private void setButton6() {
        button6.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button6.setFill(Color.gray(0.85));
            }
        });
        button6.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button6.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("6");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "6");
                        fixDisplay();
                    }
                }
            }
        });
        text6.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button6.setFill(Color.gray(0.85));
            }
        });
        text6.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button6.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("6");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "6");
                        fixDisplay();
                    }
                }
            }
        });
    }

    private void setButton7() {
        button7.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button7.setFill(Color.gray(0.85));
            }
        });
        button7.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button7.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("7");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "7");
                        fixDisplay();
                    }
                }
            }
        });
        text7.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button7.setFill(Color.gray(0.85));
            }
        });
        text7.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button7.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("7");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "7");
                        fixDisplay();
                    }
                }
            }
        });
    }

    private void setButton8() {
        button8.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button8.setFill(Color.gray(0.85));
            }
        });
        button8.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button8.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("8");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "8");
                        fixDisplay();
                    }
                }
            }
        });
        text8.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button8.setFill(Color.gray(0.85));
            }
        });
        text8.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button8.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("8");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "8");
                        fixDisplay();
                    }
                }
            }
        });
    }

    private void setButton9() {
        button9.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button9.setFill(Color.gray(0.85));
            }
        });
        button9.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button9.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("9");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "9");
                        fixDisplay();
                    }
                }
            }
        });
        text9.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button9.setFill(Color.gray(0.85));
            }
        });
        text9.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button9.setFill(Color.gray(0.9));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (state == 0) {
                    // set ac to C
                    acText.setText("C");
                    acText.setX(19);
                    acText.setY(SIDE * 2 + 31);
                    display.setText("9");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "9");
                        fixDisplay();
                    }
                }
            }
        });
    }

    private void setACButton() {
        acButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                acButton.setFill(Color.gray(0.75));
            }
        });
        acButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                acButton.setFill(Color.gray(0.8));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (acText.getText().equals("C")) {
                    acText.setText("AC");
                    acText.setX(12);
                    acText.setY(SIDE * 2 + 31);
                }

                display.setText("0");
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(160);
                state = 0;

            }
        });
        acText.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                acButton.setFill(Color.gray(0.75));
            }
        });
        acText.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                acButton.setFill(Color.gray(0.8));
                divButton.setStrokeWidth(0.3);
                mulButton.setStrokeWidth(0.3);
                subButton.setStrokeWidth(0.3);
                addButton.setStrokeWidth(0.3);

                if (acText.getText().equals("C")) {
                    acText.setText("AC");
                    acText.setX(12);
                    acText.setY(SIDE * 2 + 31);
                }

                display.setText("0");
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(160);
                state = 0;
            }
        });
    }

    public void fixDisplay() {
        switch (display.getText().length()) {
            case 1:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(160);
                break;
            case 2:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(133);
                break;
            case 3:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(106);
                break;
            case 4:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(79);
                break;
            case 5:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(52);
                break;
            case 6:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(25);
                break;
            case 7:
                display.setFont(Font.font("HELVETICA", 42));
                display.setX(25);
                break;
            case 8:
                display.setFont(Font.font("HELVETICA", 36));
                display.setX(23);
                break;
            case 9:
                display.setFont(Font.font("HELVETICA", 32));
                display.setX(20);
                break;
        }
        if (display.getText().length() > 9) {
            //scientific notation.
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

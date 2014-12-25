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

        divButton = new Button("ORANGE", SIDE * 3, SIDE * 2);
        divText = new ButtonText("/", "WHITE", SIDE * 3 + 19, SIDE * 2 + 31);
        mulButton = new Button("ORANGE", SIDE * 3, SIDE * 3);
        mulText = new ButtonText("X", "WHITE", SIDE * 3 + 19, SIDE * 3 + 31);
        subButton = new Button("ORANGE", SIDE * 3, SIDE * 4);
        subText = new ButtonText("-", "WHITE", SIDE * 3 + 19, SIDE * 4 + 31);
        addButton = new Button("ORANGE", SIDE * 3, SIDE * 5);
        addText = new ButtonText("+", "WHITE", SIDE * 3 + 19, SIDE * 5 + 31);
        equalButton = new Button("ORANGE", SIDE * 3, SIDE * 6);
        equalText = new ButtonText("=", "WHITE", SIDE * 3 + 19, SIDE * 6 + 31);

        //AC button changes to "C" when calculator is in use.
        //Text width becomes 19 and height becomes SIDE*2+31
        acButton = new Button("GREY", 0, SIDE * 2);
        acText = new ButtonText("AC", "BLACK", 12, SIDE * 2 + 31);

        negButton = new Button("GREY", SIDE, SIDE * 2);
        negText = new ButtonText("+/-", "BLACK", SIDE + 10, SIDE * 2 + 31);
        perButton = new Button("GREY", SIDE * 2, SIDE * 2);
        perText = new ButtonText("%", "BLACK", SIDE * 2 + 19, SIDE * 2 + 31);

        decButton = new Button("WHITE", SIDE * 2, SIDE * 6);
        decText = new ButtonText(".", "BLACK", SIDE * 2 + 19, SIDE * 6 + 31);

        button0 = new Button("WHITE", 0, SIDE * 6);
        button0.setWidth(100.0);
        text0 = new ButtonText("0", "BLACK", 19, SIDE * 6 + 31);

        button1 = new Button("WHITE", 0, SIDE * 5);
        text1 = new ButtonText("1", "BLACK", 19, SIDE * 5 + 31);
        button2 = new Button("WHITE", SIDE, SIDE * 5);
        text2 = new ButtonText("2", "BLACK", SIDE + 19, SIDE * 5 + 31);
        button3 = new Button("WHITE", SIDE * 2, SIDE * 5);
        text3 = new ButtonText("3", "BLACK", SIDE * 2 + 19, SIDE * 5 + 31);
        button4 = new Button("WHITE", 0, SIDE * 4);
        text4 = new ButtonText("4", "BLACK", 19, SIDE * 4 + 31);
        button5 = new Button("WHITE", SIDE, SIDE * 4);
        text5 = new ButtonText("5", "BLACK", SIDE + 19, SIDE * 4 + 31);
        button6 = new Button("WHITE", SIDE * 2, SIDE * 4);
        text6 = new ButtonText("6", "BLACK", SIDE * 2 + 19, SIDE * 4 + 31);
        button7 = new Button("WHITE", 0, SIDE * 3);
        text7 = new ButtonText("7", "BLACK", 19, SIDE * 3 + 31);
        button8 = new Button("WHITE", SIDE, SIDE * 3);
        text8 = new ButtonText("8", "BLACK", SIDE + 19, SIDE * 3 + 31);
        button9 = new Button("WHITE", SIDE * 2, SIDE * 3);
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

        Scene scene = new Scene(root, 200, 350);

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
                state = 0;
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
                state = 0;
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                    display.setText("4");
                    state = 1;
                } else if (state == 1) {

                    if (!(display.getText().length() >= 9)) {

                        display.setText(display.getText() + "4");
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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
                        display.setX(display.getX() - 27);

                        if (display.getText().length() == 7) {
                            display.setFont(Font.font("HELVETICA", 42));
                            display.setX(display.getX() + 27);
                        }
                        if (display.getText().length() == 8) {
                            display.setFont(Font.font("HELVETICA", 36));
                            display.setX(display.getX() + 25);
                        }
                        if (display.getText().length() == 9) {
                            display.setFont(Font.font("HELVETICA", 32));
                            display.setX(display.getX() + 24);
                        }
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
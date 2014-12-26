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
                setStrokes();
                divButton.setStrokeWidth(3);

                //divide method.
                if (state == 1) {
                    operator = '/';
                    operand = Double.parseDouble(display.getText());
                    state = 2;
                }
                if (state == 3) {
                    deriveAnswer();
                    operator = '/';
                    state = 2;
                }
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
                setStrokes();
                divButton.setStrokeWidth(3);
                //divide method.
                if (state == 1) {
                    operator = '/';
                    operand = Double.parseDouble(display.getText());
                    state = 2;
                }
                if (state == 3) {
                    deriveAnswer();
                    operator = '/';
                    state = 2;
                }
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
                setStrokes();
                mulButton.setStrokeWidth(3);

                //multiply method.
                if (state == 1) {
                    operator = '*';
                    operand = Double.parseDouble(display.getText());
                    state = 2;
                }
                if (state == 3) {
                    deriveAnswer();
                    operator = '*';
                    state = 2;
                }
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
                setStrokes();
                mulButton.setStrokeWidth(3);

                //multiply method.
                if (state == 1) {
                    operator = '*';
                    operand = Double.parseDouble(display.getText());
                    state = 2;
                }
                if (state == 3) {
                    deriveAnswer();
                    operator = '*';
                    state = 2;
                }
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
                setStrokes();
                subButton.setStrokeWidth(3);

                //subtract method.
                if (state == 1) {
                    operator = '-';
                    operand = Double.parseDouble(display.getText());
                    state = 2;
                }
                if (state == 3) {
                    deriveAnswer();
                    operator = '-';
                    state = 2;
                }
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
                setStrokes();
                subButton.setStrokeWidth(3);

                //subtract method.
                if (state == 1) {
                    operator = '-';
                    operand = Double.parseDouble(display.getText());
                    state = 2;
                }
                if (state == 3) {
                    deriveAnswer();
                    operator = '-';
                    state = 2;
                }
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
                setStrokes();
                addButton.setStrokeWidth(3);
                //add method.
                if (state == 1) {
                    operator = '+';
                    operand = Double.parseDouble(display.getText());
                    state = 2;
                }
                if (state == 3) {
                    deriveAnswer();
                    operator = '+';
                    state = 2;
                }
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
                setStrokes();
                addButton.setStrokeWidth(3);
                //add method.
                if (state == 1) {
                    operator = '+';
                    operand = Double.parseDouble(display.getText());
                    state = 2;
                }
                if (state == 3) {
                    deriveAnswer();
                    operator = '+';
                    state = 2;
                }
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
                setStrokes();

                //equals method.
                //displays answer
                if (state == 3) {
                    deriveAnswer();
                    state = 1;
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
                setStrokes();
                //equals method.
                //displays answer
                if (state == 3) {
                    deriveAnswer();
                    state = 2;
                }
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
                setStrokes();

                numberFunction("0");
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
                setStrokes();

                numberFunction("0");
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
                setStrokes();

                numberFunction("1");

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
                setStrokes();

                numberFunction("1");
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
                setStrokes();

                numberFunction("2");
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
                setStrokes();

                numberFunction("2");
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
                setStrokes();

                numberFunction("3");
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
                setStrokes();

                numberFunction("3");
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
                setStrokes();

                numberFunction("4");
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
                setStrokes();

                numberFunction("4");
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
                setStrokes();

                numberFunction("5");
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
                setStrokes();

                numberFunction("5");
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
                setStrokes();

                numberFunction("6");
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
                setStrokes();

                numberFunction("6");
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
                setStrokes();

                numberFunction("7");

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
                setStrokes();

                numberFunction("7");
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
                setStrokes();

                numberFunction("8");
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
                setStrokes();

                numberFunction("8");
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
                setStrokes();

                numberFunction("9");
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
                setStrokes();

                numberFunction("9");
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
                setStrokes();

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
                setStrokes();

                if (acText.getText().equals("C")) {
                    acText.setText("AC");
                    acText.setX(12);
                    acText.setY(SIDE * 2 + 31);
                }

                display.setText("0");
                fixDisplay();
                state = 0;
            }
        });
    }

    public void fixDisplay() {
        //if answer has decimal point at end, remove the decimal point.
        if (display.getText().indexOf(".") == display.getText().length() - 1) {
            display.setText(display.getText().substring(0, display.getText().length() - 1));
        }
        //if answer has decimal place followed by one 0, remove both the decimal point and the 0.
        if (display.getText().indexOf(".") == display.getText().length() - 2
                && display.getText().charAt(display.getText().length() - 1) == '0') {
            display.setText(display.getText().substring(0, display.getText().length() - 2));
        }

        if (display.getText().indexOf(".") == -1) {
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
        } else { // contains a decimal. 
            switch (display.getText().length()) {
                case 1:
                    display.setFont(Font.font("HELVETICA", 50));
                    display.setX(170);
                    break;
                case 2:
                    display.setFont(Font.font("HELVETICA", 50));
                    display.setX(143);
                    break;
                case 3:
                    display.setFont(Font.font("HELVETICA", 50));
                    display.setX(122);
                    break;
                case 4:
                    display.setFont(Font.font("HELVETICA", 50));
                    display.setX(95);
                    break;
                case 5:
                    display.setFont(Font.font("HELVETICA", 50));
                    display.setX(68);
                    break;
                case 6:
                    display.setFont(Font.font("HELVETICA", 50));
                    display.setX(41);
                    break;
                case 7:
                    display.setFont(Font.font("HELVETICA", 42));
                    display.setX(41);
                    break;
                case 8:
                    display.setFont(Font.font("HELVETICA", 36));
                    display.setX(39);
                    break;
                case 9:
                    display.setFont(Font.font("HELVETICA", 32));
                    display.setX(36);
                    break;
            }

        }
        if (display.getText().length() > 9) {
            //scientific notation.
        }
    }

    public void setStrokes() {
        divButton.setStrokeWidth(0.3);
        mulButton.setStrokeWidth(0.3);
        subButton.setStrokeWidth(0.3);
        addButton.setStrokeWidth(0.3);
    }

    private void setACToC() {
        // set ac to C
        acText.setText("C");
        acText.setX(19);
        acText.setY(SIDE * 2 + 31);
    }

    private void numberFunction(String number) {
        if (state == 0 && number != "0") {
            setACToC();
            display.setText(number);
            state = 1;
        } else if (state == 1) {
            if (!(display.getText().length() >= 9)) {
                display.setText(display.getText() + number);
                fixDisplay();
            }
        } else if (state == 2) {
            display.setText(number);
            fixDisplay();
            state = 3;
        } else if (state == 3) {
            if (!(display.getText().length() >= 9)) {
                display.setText(display.getText() + number);
                fixDisplay();
            }
        }
    }

    private void deriveAnswer() throws NumberFormatException {
        switch (operator) {
            case '+':
                operand += Double.parseDouble(display.getText());
                break;
            case '-':
                operand -= Double.parseDouble(display.getText());
                break;
            case '*':
                operand *= Double.parseDouble(display.getText());
                break;
            case '/':
                operand /= Double.parseDouble(display.getText());
                break;
        }
        display.setText(operand + "");
        fixDisplay();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

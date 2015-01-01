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

/**
 * Calculator GUI
 *
 * @author Joon
 * @version 0.8 Dec 31, 2014
 */
public class Calculator extends Application {

    final int SIDE = 50;

    int state = 0;

    double operand;
    char operator;
    double answer;

    private Rectangle result;
    private Text display;

    private OrangeButton divButton;
    private OrangeButton mulButton;
    private OrangeButton subButton;
    private OrangeButton addButton;
    private OrangeButton equalButton;

    private GreyButton acButton;
    private GreyButton negButton;
    private GreyButton perButton;

    private WhiteButton decButton;
    private WhiteButton button0;
    private WhiteButton button1;
    private WhiteButton button2;
    private WhiteButton button3;
    private WhiteButton button4;
    private WhiteButton button5;
    private WhiteButton button6;
    private WhiteButton button7;
    private WhiteButton button8;
    private WhiteButton button9;

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
        subText = new ButtonText("-", "WHITE", SIDE * 3 + 21, SIDE * 4 + 31);
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
        perText = new ButtonText("%", "BLACK", SIDE * 2 + 17, SIDE * 2 + 31);

        decButton = new WhiteButton(SIDE * 2, SIDE * 6);
        decText = new ButtonText(".", "BLACK", SIDE * 2 + 22, SIDE * 6 + 28);

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

        setOrangeButton(divButton, divText, "/");
        setOrangeButton(mulButton, mulText, "*");
        setOrangeButton(addButton, addText, "+");
        setOrangeButton(subButton, subText, "-");
        setOrangeButton(equalButton, equalText, "=");

        setGreyButton(acButton, acText, "AC");
        setGreyButton(negButton, negText, "+/-");
        setGreyButton(perButton, perText, "%");

        setWhiteButton(decButton, decText, ".");
        setWhiteButton(button1, text1, "1");
        setWhiteButton(button2, text2, "2");
        setWhiteButton(button3, text3, "3");
        setWhiteButton(button4, text4, "4");
        setWhiteButton(button5, text5, "5");
        setWhiteButton(button6, text6, "6");
        setWhiteButton(button7, text7, "7");
        setWhiteButton(button8, text8, "8");
        setWhiteButton(button9, text9, "9");
        setWhiteButton(button0, text0, "0");

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

    private void setOrangeButton(OrangeButton operatorButton, Text operatorText, String value) {
        operatorButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                operatorButton.setFill(Color.rgb(224, 126, 15));
            }
        });
        operatorButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                operatorButton.setFill(Color.rgb(249, 138, 17));
                setStrokes();

                if (!value.equals("=")) {
                    operatorButton.setStrokeWidth(3);
                }

                switch (value) {
                    case "+":
                        addMethod();
                        break;
                    case "-":
                        subtractMethod();
                        break;
                    case "*":
                        multiplyMethod();
                        break;
                    case "/":
                        divideMethod();
                        break;
                    case "=":
                        equalsMethod();
                        break;
                }
            }
        });
        operatorText.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                operatorButton.setFill(Color.rgb(224, 126, 15));
            }
        });
        operatorText.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                operatorButton.setFill(Color.rgb(249, 138, 17));
                setStrokes();

                if (!value.equals("=")) {
                    operatorButton.setStrokeWidth(3);
                }

                switch (value) {
                    case "+":
                        addMethod();
                        break;
                    case "-":
                        subtractMethod();
                        break;
                    case "*":
                        multiplyMethod();
                        break;
                    case "/":
                        divideMethod();
                        break;
                    case "=":
                        equalsMethod();
                        break;
                }
            }
        });
    }

    private void divideMethod() throws NumberFormatException {
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

    private void multiplyMethod() throws NumberFormatException {
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

    private void subtractMethod() throws NumberFormatException {
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

    private void addMethod() throws NumberFormatException {
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

    private void equalsMethod() throws NumberFormatException {
        //equals method.
        //displays answer
        if (state == 3) {
            deriveAnswer();
            state = 2;
        }
    }

    private void setWhiteButton(WhiteButton numberButton, Text numberText, String value) {
        numberButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                numberButton.setFill(Color.rgb(191, 193, 195));
            }
        });
        numberButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                numberButton.setFill(Color.rgb(214, 215, 216));
                setStrokes();

                if (value.equals(".")) {
                    decimalPointMethod();
                } else {
                    numberFunction(value);
                }

            }
        });
        numberText.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                numberButton.setFill(Color.rgb(191, 193, 195));
            }
        });
        numberText.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                numberButton.setFill(Color.rgb(214, 215, 216));
                setStrokes();

                if (value.equals(".")) {
                    decimalPointMethod();
                } else {
                    numberFunction(value);
                }

            }
        });
    }

    private void decimalPointMethod() {
        if (state == 0) {
            display.setText("0.");
            fixDisplay(true);
            state = 1;
        } else if (state == 1) {
            if ((display.getText().length() < 10) && display.getText().indexOf(".") == -1) {
                display.setText(display.getText() + ".");
                fixDisplay(true);

            }
        } else if (state == 2) {
            display.setText("0.");
            fixDisplay(true);
            state = 3;
        } else if (state == 3) {
            if ((display.getText().length() < 10) && display.getText().indexOf(".") == -1) {
                display.setText(display.getText() + ".");
                fixDisplay(true);

            }
        }
    }

    private void setGreyButton(GreyButton greyButton, Text greyText, String value) {
        greyButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                greyButton.setFill(Color.rgb(180, 181, 182));
            }
        });
        greyButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                greyButton.setFill(Color.rgb(201, 202, 203));
                setStrokes();

                switch (value) {
                    case "AC":
                        acMethod();
                        break;
                    case "+/-":
                        negPosMethod();
                        break;
                    case "%":
                        percentMethod();
                        break;
                }
            }
        });
        greyText.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                greyButton.setFill(Color.rgb(180, 181, 182));
            }
        });
        greyText.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                greyButton.setFill(Color.rgb(201, 202, 203));
                setStrokes();

                switch (value) {
                    case "AC":
                        acMethod();
                }
            }
        });
    }

    private void acMethod() {
        if (acText.getText().equals("C")) {
            setACtoC();
        }

        display.setText("0");
        fixDisplay(false);
        state = 0;
    }

    private void negPosMethod() {

    }

    private void percentMethod() {
    }

    /**
     *
     * - display text changes if there is a decimal point or a negative symbol
     *
     * - if number value is greater than 999,999,999, then use scientific
     * notation
     *
     * - if number takes up more than 9 spaces(excluding decimal point and
     * negative symbol), cut off the end. if (display.getText().indexOf(".") >
     * -1)
     *
     */
    public void fixDisplay(boolean decButtonPressed) {

        double numberDisplayed = Double.parseDouble(display.getText());

        if (!decButtonPressed && numberDisplayed % 1 == 0) {
            display.setText((int) numberDisplayed + "");
        }

//        if((display.getText().length() > 10 && display.getText().indexOf("-") == -1)
//            || (display.getText().length() > 9 && display.getText().indexOf("-") == 0)){
//            numberDisplayed = (double)Math.round(numberDisplayed * 100000000) / 100000000;
//            display.setText(numberDisplayed + "");
//            System.out.println(display.getText());
//        }
        if (display.getText().length() > 10 && display.getText().indexOf("-") == -1 && display.getText().indexOf(".") >= 0) {
            display.setText(display.getText().substring(0, 10));
        }

        int digitCount = 0;
        for (int i = 0; i < display.getText().length(); i++) {
            if (Character.isDigit(display.getText().charAt(i))) {
                digitCount++;
            }
        }

        //if number can be reprsented as an integer, remove the integer
        switch (digitCount) {
            case 1:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(160);
                if (display.getText().indexOf(".") >= 0) // has decimal point
                {
                    display.setX(display.getX() - 13);
                }
                break;
            case 2:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(133);
                if (display.getText().indexOf(".") >= 0) // has decimal point
                {
                    display.setX(display.getX() - 13);
                }
                break;
            case 3:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(106);
                if (display.getText().indexOf(".") >= 0) // has decimal point
                {
                    display.setX(display.getX() - 13);
                }
                break;
            case 4:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(79);
                if (display.getText().indexOf(".") >= 0) // has decimal point
                {
                    display.setX(display.getX() - 13);
                }
                break;
            case 5:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(52);
                if (display.getText().indexOf(".") >= 0) // has decimal point
                {
                    display.setX(display.getX() - 13);
                }
                break;
            case 6:
                display.setFont(Font.font("HELVETICA", 50));
                display.setX(25);
                if (display.getText().indexOf(".") >= 0) // has decimal point
                {
                    display.setX(display.getX() - 13);
                }
                break;
            case 7:
                display.setFont(Font.font("HELVETICA", 42));
                display.setX(25);
                if (display.getText().indexOf(".") >= 0) // has decimal point
                {
                    display.setX(display.getX() - 9);
                }
                break;
            case 8:
                display.setFont(Font.font("HELVETICA", 36));
                display.setX(23);
                if (display.getText().indexOf(".") >= 0) // has decimal point
                {
                    display.setX(display.getX() - 5);
                }
                break;
            case 9:
                display.setFont(Font.font("HELVETICA", 32));
                display.setX(20);
                if (display.getText().indexOf(".") >= 0) // has decimal point
                {
                    display.setX(display.getX() - 2);
                }
                break;
        }
        if (digitCount > 9) {
            //scientific notation
            display.setText(scientificNotation(display.getText()));
            switch (display.getText().length()) {
                case 8:
                    display.setFont(Font.font("HELVETICA", 42));
                    display.setX(16);
                    break;
                case 9:
                    display.setFont(Font.font("HELVETICA", 36));
                    display.setX(18);
                    break;
                case 10:
                    display.setFont(Font.font("HELVETICA", 32));
                    display.setX(18);
                    break;
            }
        
        if (display.getText().startsWith("0.00000000")){
                        //scientific notation
            display.setText(scientificNotation(display.getText()));
            switch (display.getText().length()) {
                case 8:
                    display.setFont(Font.font("HELVETICA", 42));
                    display.setX(16);
                    break;
                case 9:
                    display.setFont(Font.font("HELVETICA", 36));
                    display.setX(18);
                    break;
                case 10:
                    display.setFont(Font.font("HELVETICA", 32));
                    display.setX(18);
                    break;
            }
        }
            
            System.out.println("operand: " + operand);
        }
    }

    public String scientificNotation(String display) {

        double number = Double.parseDouble(display);
        // ex number = 1,234,567,890
        // return 1.234x10^9
        // ex number = 12,345,678,901
        // return 1.23x10^10
        int exp = (int) Math.floor(Math.log10(number));
        System.out.println("exp:" + exp);
        
        double beginning = number / (Math.pow(10, exp));
        System.out.println("beginning: " + beginning);

        String beginningString = beginning + "";

        if (exp >= 10) {//2 digits in exponent means 3 digits in beginning
            if (beginningString.length() > 3) {
                beginningString = beginningString.substring(0, 4);
            }
        } else {
            if (beginningString.length() > 4) {
                beginningString = beginningString.substring(0, 5);
            }
        }

        return beginningString + "x10^" + exp;

    }

    public void setStrokes() {
        divButton.setStrokeWidth(0.3);
        mulButton.setStrokeWidth(0.3);
        subButton.setStrokeWidth(0.3);
        addButton.setStrokeWidth(0.3);
    }

    private void setACToC() {
        // set AC to C
        acText.setText("C");
        acText.setX(19);
        acText.setY(SIDE * 2 + 31);
    }

    private void setACtoC() {
        // set C to AC
        acText.setText("AC");
        acText.setX(12);
        acText.setY(SIDE * 2 + 31);

    }

    private void numberFunction(String number) {
        if (state == 0 && number != "0") {
            setACToC();
            display.setText(number);
            state = 1;
        } else if (state == 1) {
            if ((display.getText().length() < 9 && display.getText().indexOf(".") == -1) || (display.getText().length() < 10 && display.getText().indexOf(".") > -1)) {
                display.setText(display.getText() + number);
                fixDisplay(true);

            }
        } else if (state == 2) {
            display.setText(number);
            fixDisplay(true);
            state = 3;
        } else if (state == 3) {
            if ((display.getText().length() < 9 && display.getText().indexOf(".") == -1) || (display.getText().length() < 10 && display.getText().indexOf(".") > -1)) {
                display.setText(display.getText() + number);
                fixDisplay(true);

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
        fixDisplay(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

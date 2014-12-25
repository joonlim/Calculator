/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * The <code>ButtonText</code> class extends the javafx.scene.text.Text class
 * and is used for the text on top of the buttons of the calculator.
 *
 * @author Joon
 */
public class ButtonText extends Text {

    public ButtonText(String text, String color, double xCoord, double yCoord) {
        super(text);
        this.setFont(Font.font("HELVETICA", 20));
        this.setX(xCoord);
        this.setY(yCoord);

        if (color.equalsIgnoreCase("white")) {
            this.setFill(Color.WHITE);
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The <code>Button</code> class extends the javafx.scene.shape.Rectangle class
 * and is used for each button on the calculator.
 *
 * @author Joon
 */
public class Button extends Rectangle {

    public Button(String type, double xCoord, double yCoord) {
        super(50, 50, Color.ORANGE);
        this.setStroke(Color.BLACK);
        this.setStrokeWidth(0.3);
        this.setX(xCoord);
        this.setY(yCoord);

        if (type.equalsIgnoreCase("grey") || type.equalsIgnoreCase("gray")) {
            this.setFill(Color.gray(0.8));
        }
        if (type.equalsIgnoreCase("white")) {
            this.setFill(Color.gray(0.9));
        }

    }

}

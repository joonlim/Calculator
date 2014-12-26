/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The <code>Button</code> abstract class extends the
 * javafx.scene.shape.Rectangle class and is used for each button on the
 * calculator.
 *
 * @author Joon
 */
public abstract class Button extends Rectangle {

    public Button(double xCoord, double yCoord) {
        super(50, 50, Color.ORANGE);
        this.setStroke(Color.BLACK);
        this.setStrokeWidth(0.3);
        this.setX(xCoord);
        this.setY(yCoord);


    }

}

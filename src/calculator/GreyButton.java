/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * The <code>GreyButton</code> class extends the <code>Button</code> abstract
 * class and is used for the C button, +/- button, and % button on the
 * calculator.
 *
 * @author Joon
 */
public class GreyButton extends Button {

    public GreyButton(double xCoord, double yCoord) {
        super(xCoord, yCoord);
        this.setFill(Color.gray(0.8));

    }

}

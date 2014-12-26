/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.scene.paint.Color;

/**
 * The <code>WhiteButton</code> class extends the <code>Button</code> abstract
 * class and is used for each number button and decimal button on the
 * calculator(0-9, .).
 *
 * @author Joon
 */
public class WhiteButton extends Button {

    public WhiteButton(double xCoord, double yCoord) {
        super(xCoord, yCoord);
        this.setFill(Color.gray(0.9));
    }
}

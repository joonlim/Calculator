/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.scene.paint.Color;

/**
 * The <code>OrangeButton</code> class extends the <code>Button</code> abstract
 * class and is used for each operator button on the calculator(+, -, /, *, =).
 *
 * @author Joon
 */
public class OrangeButton extends Button {

    public OrangeButton(double xCoord, double yCoord) {
        super(xCoord, yCoord);
        this.setFill(Color.ORANGE);
    }

}

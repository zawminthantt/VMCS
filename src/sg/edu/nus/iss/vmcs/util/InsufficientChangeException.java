/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vmcs.util;

/**
 *
 * @author swemon
 */
public class InsufficientChangeException extends Exception {
    
    private int amountDue;
    
    public InsufficientChangeException(int amountDue) {
        super(amountDue + " is due to change");
        this.amountDue = amountDue;
    }
    
    public int getAmountDue() {
        return amountDue;
    }
    
}

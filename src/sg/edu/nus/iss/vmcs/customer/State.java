/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vmcs.customer;


/**
 *
 * @author NayLA
 */
public interface State {
    
    public void doAction(TransactionController transactionCtrl);
    
}

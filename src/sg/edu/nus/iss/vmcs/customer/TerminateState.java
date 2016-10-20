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
public class TerminateState implements State {

    Action actionPerformed;
    
    @Override
    public void doAction(TransactionController transactionCtrl) {
       
        actionPerformed = Action.started;
        
        System.out.println("Transaction is in TerminateState.");
        /* Perform state-specific tasks here. */
        
        System.out.println("TerminateTransaction: Begin");
        transactionCtrl.getDispenseController().allowSelection(false);
        transactionCtrl.getCoinReceiver().stopReceive();
        transactionCtrl.getCoinReceiver().refundCash();
        if(transactionCtrl.getCustomerPanel()!=null){
                transactionCtrl.getCustomerPanel().setTerminateButtonActive(false);
        }
        transactionCtrl.refreshMachineryDisplay();
        System.out.println("TerminateTransaction: End");
        
         /* Set this to Action.done only when state-specific tasks are done. */
        actionPerformed = Action.done;
        
        if(actionPerformed == Action.done){
            
            transactionCtrl.goNextState(new MaintenanceState());/* This is for state transition. */
            transactionCtrl.PerformTransaction();
        }
    }
    
}

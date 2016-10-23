/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.customer.termination.TerminationStrategyFactory.TerminationType;

/**
 *
 * @author NayLA
 */
public class CancelState extends AbstractTerminationState{

    Action actionPerformed;
    
    @Override
    public void doAction(TransactionController transactionCtrl) {
       
        actionPerformed = Action.started;
        
        System.out.println("Transaction is in CancelState.");
        /* Perform state-specific tasks here. */
        /*System.out.println("CancelTransaction: Begin");
        transactionCtrl.getCoinReceiver().stopReceive();
        transactionCtrl.getCoinReceiver().refundCash();
        transactionCtrl.getDispenseController().allowSelection(true);
        transactionCtrl.refreshMachineryDisplay();
        System.out.println("CancelTransaction: End");*/
        setStrategy(TerminationType.CUSTOMER_ACTION);
        terminate();
        
         /* Set this to Action.done only when state-specific tasks are done. */
        actionPerformed = Action.done;
        
        if(actionPerformed == Action.done){
            
            transactionCtrl.goNextState(new IdleState());/* This is for state transition. */
            transactionCtrl.PerformTransaction();
        }
        
    }
    
}

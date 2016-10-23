/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vmcs.customer;

import jdk.nashorn.internal.ir.SetSplitState;
import sg.edu.nus.iss.vmcs.customer.termination.TerminationStrategyFactory;
import sg.edu.nus.iss.vmcs.customer.termination.TerminationStrategyFactory.TerminationType;

/**
 *
 * @author NayLA
 */
public class TerminateFaultState extends AbstractTerminationState{

    Action actionPerformed;
    
    @Override
    public void doAction(TransactionController transactionCtrl) {
        
        actionPerformed = Action.started;
        
        System.out.println("Transaction is in TerminateState.");
        /* Perform state-specific tasks here. */
        
        /*System.out.println("TerminateFault: Begin");
        transactionCtrl.getDispenseController().allowSelection(false);
        transactionCtrl.getCoinReceiver().refundCash();
        transactionCtrl.refreshMachineryDisplay();
        System.out.println("TerminateFault: End");*/
        setStrategy(TerminationType.DISPENSE_FAULT);	// TODO changeGiver, dispense, coinReceiver
        terminate();
               
         /* Set this to Action.done only when state-specific tasks are done. */
        actionPerformed = Action.done;
        
        if(actionPerformed == Action.done){
            
            transactionCtrl.goNextState(new IdleState());/* This is for state transition. */
            transactionCtrl.PerformTransaction();
        }
        
    }
    
}

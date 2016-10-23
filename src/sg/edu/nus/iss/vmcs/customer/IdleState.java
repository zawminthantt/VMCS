/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vmcs.customer;

import java.awt.Frame;
import sg.edu.nus.iss.vmcs.system.MainController;
import sg.edu.nus.iss.vmcs.system.SimulatorControlPanel;

/**
 *
 * @author NayLA
 */
public class IdleState implements State{

    Action actionPerformed;
       
    @Override
    public void doAction(TransactionController transactionCtrl) {
                   
        actionPerformed = Action.started;
        
        /* Perform state-specific tasks here. */
        System.out.println("Transaction is in IdleState");
        
        transactionCtrl.getCustomerPanel().display();
        transactionCtrl.getDispenseController().updateDrinkPanel();
        transactionCtrl.getDispenseController().allowSelection(true);
        transactionCtrl.getChangeGiver().displayChangeStatus();
        transactionCtrl.getCoinReceiver().setActive(false);
        
        
        /* Set this to Action.done only when state-specific tasks are done. */
        actionPerformed = Action.done; 
        
        if(actionPerformed == Action.done){         
            transactionCtrl.goNextState(new SelectItemState());/* This is for state transition. */
            
        }
        
    }
    
}

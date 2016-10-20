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
public class MaintenanceState implements State{

    Action actionPerformed;
    
    
    @Override
    public void doAction(TransactionController transactionCtrl) {
        
        actionPerformed = Action.started;
        
        System.out.println("Transaction is in MaintenanceState.");
        /* Perform state-specific tasks here. */
        
       /* Do nothing here. All Maintenance activities will be done by MaintenanceController. */
        
        /* Exit maintenance mode only if door is locked. */
        if(transactionCtrl.getMainController().getMachineryController().isDoorClosed()){
            
            System.out.println("Exiting Maintenance Mode.....");
            transactionCtrl.goNextState(new IdleState());/* This is for state transition. */
            transactionCtrl.PerformTransaction();
        }
        
    }
    
}

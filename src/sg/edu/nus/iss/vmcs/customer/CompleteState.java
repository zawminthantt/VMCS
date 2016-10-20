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
public class CompleteState implements State {

    Action actionPerformed;
    
    @Override
    public void doAction(TransactionController transactionCtrl) {
        
        actionPerformed = Action.started;
        /* Perform state-specific tasks here. */
        System.out.println("Transaction is in CoinReceiveState.");
              
        System.out.println("CompleteTransaction: Begin");
        transactionCtrl.getDispenseController().dispenseDrink(transactionCtrl.getSelection());
        int totalMoneyInserted=transactionCtrl.getCoinReceiver().getTotalInserted();
        int change=totalMoneyInserted - transactionCtrl.getPrice();
        if(change>0){
                transactionCtrl.getChangeGiver().giveChange(change);
        }
        else{
                transactionCtrl.getCustomerPanel().setChange(0);
        }
        transactionCtrl.getCoinReceiver().storeCash();
        transactionCtrl.getDispenseController().allowSelection(true);

        transactionCtrl.refreshMachineryDisplay();
        
        System.out.println("CompleteTransaction: End");
        
         /* Set this to Action.done only when state-specific tasks are done. */
        actionPerformed = Action.done; 
        
        if(actionPerformed == Action.done){         
           transactionCtrl.goNextState(new IdleState());/* This is for state transition. */
           transactionCtrl.PerformTransaction();
        
        }
        
    }
    
}

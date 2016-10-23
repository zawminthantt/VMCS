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
public class CoinReceiveState implements State{

    Action actionPerformed;
    
    @Override
    public void doAction(TransactionController transactionCtrl) {
        
        actionPerformed = Action.started;
        
        /* Perform state-specific tasks here. */
        System.out.println("Transaction is in CoinReceiveState.");
        
        if(transactionCtrl.getTotalCoinReceived() >= transactionCtrl.getPrice()){
            
            /* Set this to Action.done only when state-specific tasks are done. */
            actionPerformed = Action.done; 

            if(actionPerformed == Action.done){
                
               transactionCtrl.goNextState(new CompleteState());/* This is for state transition. */
               transactionCtrl.PerformTransaction();
            }
            
        }else{
                
            transactionCtrl.getCoinReceiver().continueReceive();/* Continue to stay in CoinReceiveState */
        }
        
    }
    
}

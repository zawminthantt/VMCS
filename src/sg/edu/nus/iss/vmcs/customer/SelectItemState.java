/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.system.MainController;

/**
 *
 * @author NayLA
 */
public class SelectItemState implements State{
   
    Action actionPerformed;
   
    @Override
    public void doAction(TransactionController transactionCtrl) {
        
         actionPerformed = Action.started;
        
        /* Perform state-specific tasks here. */
        System.out.println("Transaction is in SelectItemState.");
        
        transactionCtrl.setSelection(transactionCtrl.getDrinkIdentifier());
        StoreItem storeItem=transactionCtrl.getMainController().getStoreController().getStoreItem(Store.DRINK,transactionCtrl.getDrinkIdentifier());        
        DrinksBrand drinksBrand=(DrinksBrand)storeItem.getContent();
        transactionCtrl.setPrice(drinksBrand.getPrice());
        transactionCtrl.getChangeGiver().resetChange();
        transactionCtrl.getDispenseController().ResetCan();
        transactionCtrl.getChangeGiver().displayChangeStatus();
        transactionCtrl.getDispenseController().allowSelection(false);
        transactionCtrl.getCoinReceiver().startReceiver();
        transactionCtrl.getCustomerPanel().setTerminateButtonActive(true);
                 
        /* Set this to Action.done only when state-specific tasks are done. */
        actionPerformed = Action.done; 
        
        if(actionPerformed == Action.done){         
           transactionCtrl.goNextState(new CoinReceiveState());/* This is for state transition. */
        }
        
    }
    
}

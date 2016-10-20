/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.customer;

/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */

import java.awt.Frame;

import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.system.MainController;
import sg.edu.nus.iss.vmcs.system.SimulatorControlPanel;

/**
 * This control object coordinates the customer transactions for selection of a drink brand,
 * coin input, storage of coins and termination requests for ongoing transactions.
 * @author Team SE16T5E
 * @version 1.0 2008-10-01
 */
public class TransactionController {
	private MainController mainCtrl;
	private CustomerPanel custPanel;
	private DispenseController dispenseCtrl;
	private ChangeGiver changeGiver;
	private CoinReceiver coinReceiver;

	/**Set to TRUE when change is successfully issued during the transaction.*/
	private boolean changeGiven=false;
	/**Set to TRUE when the drink is successfully dispensed during the transaction.*/
	private boolean drinkDispensed=false;
	/**Price of the selected drink.*/
	private int price=0;
	/**Identifier of the selected drink.*/
	private int selection=-1;
        
        /* Added */
        private int drinkIdentifier;
        private int tolalCoinReceieved;
        
        private static State state;
        
             
         /* Get transaction object and initialize with IdleState at startup. */
        // TransactionController transactionCtrl = TransactionController.setandgetTransactionControllerInstance(new IdleState());
	
	/**
	 * This constructor creates an instance of the TransactionController.
	 * @param mainCtrl the MainController.
	 */
         
        /* Private Constructor prevents instiantiation from other classes. */
        private TransactionController() {

		dispenseCtrl=new DispenseController(this);
		coinReceiver=new CoinReceiver(this);
		changeGiver=new ChangeGiver(this);
                                             
	}

       /**
       * ContextHolder is loaded on the first execution of Context.getInstance() 
       * or the first access to ContextHolder. instance , not before.
       */
       private static class TransactionControllerHolder{

           private static final TransactionController instance = new TransactionController();

       }

       /* Get instance with initialized state. */
       public static TransactionController setandgetTransactionControllerInstance(State state){
          
           TransactionControllerHolder.instance.setState(state);

           return TransactionControllerHolder.instance;
       }

       /* Get instance.*/
       public static TransactionController getTransactionControllerInstance(){

           return TransactionControllerHolder.instance;
       }

       public void setState(State state){
          this.state = state;		
       }

       public State getState(){
          return state;
       }

       public  void PerformTransaction(){

           state.doAction(this);
       }

       public void goNextState(State nextState){
           this.state = nextState;       

       } 
              
       public void setMainController(MainController mCtrl){
           
           mainCtrl = mCtrl;
       }
       
       /************************************************************/      

	/**
	 * This method returns the MainController.
	 * @return the MainController.
	 */
	public MainController getMainController() {
		return mainCtrl;
	}


        
        /* Added */
        public void setDrinkIdentifier(int drinkIdentifier){
            
            this.drinkIdentifier = drinkIdentifier;
        }
        
        /* Added */
        public int getDrinkIdentifier(){
            
            return this.drinkIdentifier;
        }
        /* Added */
        public void setCoinReceived(int CoinReceieved){
            
            this.tolalCoinReceieved = CoinReceieved;
        }
        
        /* Added */
        public int getTotalCoinReceived(){
            
            return this.tolalCoinReceieved;
        }
        
	

	

	



	
	/**
	 * This method refreshes the CustomerPanel when maintainer logs-out.
	 */
	public void refreshCustomerPanel(){
		/*
		if(custPanel==null){
			mainCtrl.getSimulatorControlPanel().setActive(SimulatorControlPanel.ACT_CUSTOMER,true);
		}
		*/
		dispenseCtrl.updateDrinkPanel();
		dispenseCtrl.allowSelection(true);
		changeGiver.displayChangeStatus();
		custPanel.setTerminateButtonActive(true);
	}
	
	/**
	 * This method will close down the transaction control function of the vending
	 * machine.
	 */
	public void closeDown() {
		if (custPanel != null)
			custPanel.closeDown();
	}

	/**
	 * This method sets whether the change is given.
	 * @param changeGiven TRUE the change is given, otherwise FALSE.
	 */
	public void setChangeGiven(boolean changeGiven) {
		this.changeGiven = changeGiven;
	}

	/**
	 * This method returns whether the change is given.
	 * @return TRUE if the change is given, otherwise FALSE.
	 */
	public boolean isChangeGiven() {
		return changeGiven;
	}

	/**
	 * This method sets whether the drink is dispensed.
	 * @param drinkDispensed TRUE the drink is dispensed, otherwise, FALSE.
	 */
	public void setDrinkDispensed(boolean drinkDispensed) {
		this.drinkDispensed = drinkDispensed;
	}

	/**
	 * This method returns whether the drink is dispensed.
	 * @return TRUE if the drink is dispensed, otherwise FALSE.
	 */
	public boolean isDrinkDispensed() {
		return drinkDispensed;
	}

	/**
	 * This method sets the price of the selected drink.
	 * @param price the price of the selected drink.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * This method returns the price of the selected drink.
	 * @return the price of the selected drink.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * This method sets the selected drink index.
	 * @param selection the selected drink index.
	 */
	public void setSelection(int selection) {
		this.selection = selection;
	}

	/**
	 * This method returns the selected drink index.
	 * @return the selected drink index.
	 */
	public int getSelection() {
		return selection;
	}
	
        /*  Added */
        public void setCustomerPanel(CustomerPanel custPanel){
            
            this.custPanel = custPanel;
        }
        
	/**
	 * This method returns the CustomerPanel.
	 * @return the CustomerPanel.
	 */
	public CustomerPanel getCustomerPanel(){
		return custPanel;
	}
	
	/**
	 * This method returns the DispenseController.
	 * @return the DispenseController.
	 */
	public DispenseController getDispenseController(){
		return dispenseCtrl;
	}
	
	/**
	 * This method returns the ChangeGiver.
	 * @return the ChangeGiver.
	 */
	public ChangeGiver getChangeGiver(){
		return changeGiver;
	}
	
	/**
	 * This method returns the CoinReceiver.
	 * @return the CoinReceiver.
	 */
	public CoinReceiver getCoinReceiver(){
		return coinReceiver;
	}
	
	/**
	 * This method refreshes the MachinerySimulatorPanel.
	 */
	public void refreshMachineryDisplay(){
		mainCtrl.getMachineryController().refreshMachineryDisplay();
		
	}
	
	/**
	 * This method will nullify reference to customer panel.
	 */
	public void nullifyCustomerPanel(){
		custPanel=null;
	}
}//End of class TransactionController
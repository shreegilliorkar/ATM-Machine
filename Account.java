package ATM_Machine;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
   Scanner input = new Scanner(System.in);
   DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
   
   // set Customer Number(Account Number)
   public int setCustomerNumber(int customerNumber) {
	   this.customerNumber = customerNumber;
	   return customerNumber;
   }
   
   // get Customer Number (Account Number)
   public int getCustomerNumber() {
	   return customerNumber;
   }
   
   // set Pin Code(Pin Number)
    public int setPinNumber(int pinNumber) {
    	this.pinNumber = pinNumber;
    	return pinNumber;
    }
    
    // get Pin Code(Pin Number)
    public int getPinNumber(){
    	return pinNumber;
    }
    
    //get Check Account Balance
    public double getCheckingBalance(){
    	return checkingBalance;
    }
    
    // get Saving Account Balance
    public double getSavingBalance() {
    	return savingBalance;
    }
    
    // Calculate the Amount after withdrawing amount from Checking Account
    public double calcCheckingWithdraw(double amount) {
    	checkingBalance = (checkingBalance - amount);
    	return checkingBalance;
    }
    
    // Calculate the Amount after withdrawing amount from Saving Account
    public double calcSavingWithdraw(double amount) {
    	savingBalance = (savingBalance - amount);
    	return savingBalance;
    }
    
    // Calculate the Amount after Depositing Amount in Check Account
    public double calcCheckingDeposit(double amount) {
    	checkingBalance = (checkingBalance + amount);
    	return checkingBalance;
    }
    
    // Calculate the Amount after Depositing Amount in Saving Account
    public double calcSavingDeposit(double amount) {
    	savingBalance = (savingBalance + amount);
    	return savingBalance;
    }
    
    //Check if we are having valid account balance to   withdraw Amount from Check Account or not
    public void getCheckingWithdrawInput() {
    	System.out.println("Checking Account Balance: "+ moneyFormat.format(checkingBalance) );
    	System.out.println("Amount you want to withdraw from Checking Account");
    	double amount = input.nextDouble();
    	
    	
    	if((checkingBalance - amount)>= 0) {
    		calcCheckingWithdraw(amount);
    		System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance));
    	}else {
    		System.out.println("Balance cannot be negaitve." + "\n");
    	}
    }
    
    // Check if we are having valid account balance to withdraw Amount from Saving Account or not
    public void getSavingWithdrawInput() {
    	System.out.println("Saving Account Balance: "+ moneyFormat.format(savingBalance) );
    	System.out.println("Amount you want to withdraw from Saving Account");
    	double amount = input.nextDouble();
    	
    	
    	if((savingBalance - amount)>= 0) {
    		calcSavingWithdraw(amount);
    		System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance));
    	}else {
    		System.out.println("Balance cannot be negaitve." + "\n");
    	}
    }
    
    
    //Check if we can deposit amount in Check Account.
    public void getCheckingDepositInput() {
    	System.out.println("Checking Account Balance: "+ moneyFormat.format(checkingBalance));
    	System.out.println("Amount you want to deposit from checking Account: ");
    	double amount = input.nextDouble();
    	
    	if((checkingBalance + amount)>=0) {
    		calcCheckingDeposit(amount);
    		System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance));
    	}else {
    		System.out.println("Balance cannot be negative." +"\n");
    	}
    }
    
    // Check if we can deposit amount in saving Account 
    public void getSavingDepositInput() {
    	System.out.println("Saving Account Balance: "+ moneyFormat.format(savingBalance));
    	System.out.println("Amount you want to deposit from saving Account: ");
    	double amount = input.nextDouble();
    	
    	if((savingBalance + amount)>=0) {
    		calcSavingDeposit(amount);
    		System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance));
    	}else {
    		System.out.println("Balance cannot be negative." +"\n");
    	}
    }
    
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
    
    
}

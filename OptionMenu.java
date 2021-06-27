package ATM_Machine;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

public class OptionMenu extends Account {
  
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer, Integer>  data = new HashMap<Integer, Integer>();
	int selection;
	
	// User Account Login
	public void getLogin() throws IOException{
		
		int x = 1;
		do {
			try {
				// set user credential (Account number, Password)
				data.put(9876543 , 9876);
				data.put(8989898, 1890);
				
				System.out.println("Welcome to the ATM Project!");
				
				System.out.println("Enter your Customer Number: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter your Pin Number: ");
				setPinNumber(menuInput.nextInt());
				
			}
			catch(Exception e) {
				System.out.println("\n" + "Invalid character(s), Only numbers." + "\n");
				x = 2;
			}
			
			// Check valid Password and Account Number
			for(Entry<Integer, Integer> entry : data.entrySet()) {
				if(entry.getKey()==getCustomerNumber() && entry.getValue() == getPinNumber()){
					getAccountType();
				}
			}
			System.out.println("Wrong Cusotmer Number or Pin Number");
		}while( x==1);
		
		
	}

	// After Login Get Account Type
	public void getAccountType() {
		System.out.println("Select the Account you want to access: ");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");
		System.out.println("Choice: ");
		
		selection = menuInput.nextInt();
		// According to user choice call the valid method
		switch(selection) {
		case 1 :
			getChecking();
			break;
		case 2:
			getSaving();
			break;
		case 3: 
			System.out.println("Thank you for Using this ATM, Have a great Day!");
			break;
		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			break;	
		}
	}
	
	// User Saving Account and Operations to be performed on account.
	private void getSaving() {
		System.out.println("Saving Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: - ");
		
		selection = menuInput.nextInt();
		switch(selection) {
		case 1 : 
			System.out.println("Saving Account Balanace: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
			
		case 2: 
			getSavingWithdrawInput();
			getAccountType();
			break
		;
			
		case 3: 
			getSavingDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank you for ysing this ATM, Have a grad Day!");
			break;
			
		default:
			System.out.println("\n" + "Invalid Choice!" + "\n");
			getSaving(); 		
		}	
	}
	
	// User Checking Account and Operations to be performed on account.
	private void getChecking() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: - ");
		
		selection = menuInput.nextInt();
		switch(selection) {
		case 1 : 
			System.out.println("Checking Account Balanace: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
			
		case 2: 
			getCheckingWithdrawInput();
			getAccountType();
			break
		;
			
		case 3: 
			getCheckingDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank you for ysing this ATM, Have a grad Day!");
			break;
			
		default:
			System.out.println("\n" + "Invalid Choice!" + "\n");
			getChecking(); 
			
		}
	}

	
}

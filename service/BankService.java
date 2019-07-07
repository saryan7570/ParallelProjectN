package service;

import bean.BankBean;
import dao.BankDao;

public class BankService {

	BankDao bankDaoObj = new BankDao();
	
	public void bankAccountCreate(BankBean bankBeanObjCreateAccountObj) {
		bankDaoObj.addCustomer(bankBeanObjCreateAccountObj);
	}
	
	public void showBalanceSer(BankBean bankBeanShowBalObj) {
		
		if(bankDaoObj.hm().isEmpty()) {									// CHECKING IF HASH MAP IS EMPTY OR NOT
			System.out.println("Please create an account first.");
		}
		else {
			if(bankDaoObj.hm().containsKey(bankBeanShowBalObj.getAccNo())) {
				System.out.println("Your Account Balance is: " +bankDaoObj.hm().get(bankBeanShowBalObj.getAccNo()).getBalance());			// FETCHING THE BALANCE FROM HASHMAP & PRINTING 
			}
			else {
				System.out.println("No such Account Exist.");
			}
		}
	}
	
	public void depositSer(BankBean bankBeanDepObj) {
		
		if(bankDaoObj.hm().isEmpty()) {
			System.out.println("Please create an account first.");
		}
		else {
			if(bankDaoObj.hm().containsKey(bankBeanDepObj.getAccNo())) {
				float dep = bankBeanDepObj.getDepAmount() + bankDaoObj.hm().get(bankBeanDepObj.getAccNo()).getBalance();						// ADDING DEPOSIT AMOUNT TO BANK ACCOUNT
				bankDaoObj.hm().get(bankBeanDepObj.getAccNo()).setBalance(dep);
				System.out.println("Deposited successfully.");
				System.out.println("Your account balance is: " +bankDaoObj.hm().get(bankBeanDepObj.getAccNo()).getBalance());					// PRINTING THE BANK BALANCE
			}
			else {
				System.out.println("No such Account Exist.");
			}
		}
	}
	
	public void withdrawSer(BankBean bankBeanWithdrawObj) {
		if(bankDaoObj.hm().isEmpty()) {
			System.out.println("Please create an account first.");
		}
		else {
			if(bankBeanWithdrawObj.getWithdrawAmount() > bankDaoObj.hm().get(bankBeanWithdrawObj.getAccNo()).getBalance()) {		// CHECKING IF WITHDRAW AMOUNT IS GREATER THAN BALANCE OR NOT
				System.out.println("Can't withdraw money. Account Balance is low.");
			}
			else {
				if(bankDaoObj.hm().containsKey(bankBeanWithdrawObj.getAccNo())) {
					float dep = bankDaoObj.hm().get(bankBeanWithdrawObj.getAccNo()).getBalance() - bankBeanWithdrawObj.getWithdrawAmount();			// DECREMENTING WITHDRAW AMOUNT FROM BANK ACCOUNT
					bankDaoObj.hm().get(bankBeanWithdrawObj.getAccNo()).setBalance(dep);
					System.out.println("Withdraw successful.");
					System.out.println("Your account balance is: " +bankDaoObj.hm().get(bankBeanWithdrawObj.getAccNo()).getBalance());				// PRINTING REMAINING BALANCE
				}
				else {
					System.out.println("No such Account Exist.");
				}
			}
		}
	}
	
	public void transferSer(BankBean bankBeanFundTransObj) {
		if(bankDaoObj.hm().isEmpty()) {
			System.out.println("Please create an account first.");
		}
		else {
			if(bankDaoObj.hm().containsKey(bankBeanFundTransObj.getSourceAccNo())) {				// CHECKING IF SOURCE ACCOUNT EXIST
				if(bankDaoObj.hm().containsKey(bankBeanFundTransObj.getDestAccNo())){				// CHECKING IF DESTINATION ACCOUNT EXIST
					if(bankDaoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).getBalance() > bankBeanFundTransObj.getTransferAmount()) {		// CHECKING IF TRANSFER AMOUNT IS GREATER THAN BALANCE OR NOT
						float transfer = bankBeanFundTransObj.getTransferAmount();
						bankDaoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).setBalance(bankDaoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).getBalance() - transfer);		// DECREMENTING THE TRANSFER AMOUNT
						bankDaoObj.hm().get(bankBeanFundTransObj.getDestAccNo()).setBalance(bankDaoObj.hm().get(bankBeanFundTransObj.getDestAccNo()).getBalance() + transfer);			// ADDING THE TRANSFER AMOUNT
						System.out.println("Funds Transferred Successfully.");
						System.out.println("Remaining balance in account number "+bankBeanFundTransObj.getSourceAccNo()+" is: " +bankDaoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).getBalance());
					}
					else {
						System.out.println("Can't transfer money. Source Account Balance is low.");
					}
				}
				else {
					System.out.println("Destination Account Not Exist.");
				}
			}
			else {
				System.out.println("Source Account Not Exist.");
			}
		}
	}
}
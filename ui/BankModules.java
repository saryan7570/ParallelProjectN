package ui;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import bean.BankBean;
import service.BankService;

public class BankModules {
	
	BankService bankServiceObj = new BankService();
	Scanner sc = new Scanner(System.in);
	
	//************************************************************************************************
	//*************BANK MAIN MODULES METHODS**********************************************************
	//************************************************************************************************
	public void createAccount() {
		System.out.print("Enter Name: ");
		String name = nameCheck(sc.next());
		System.out.print("Enter Mobile No.: ");
		long mobNo = mobCheck(sc.nextLong());
		long accNo = mobNo - 1234;
		System.out.print("Enter Balance: "); 
		float balance = amountCheck(sc.nextFloat());
		BankBean bankBeanObjCreateAccountObj = new BankBean(accNo, name, mobNo, balance);
		System.out.println("Account created with Account Number: " +accNo);
		bankServiceObj.bankAccountCreate(bankBeanObjCreateAccountObj);
	}
	
	public void showBalance() {
		System.out.print("Enter Account Number: ");
		long accNo = sc.nextLong();
		BankBean bankBeanShowBalObj = new BankBean(accNo);
		bankServiceObj.showBalanceSer(bankBeanShowBalObj);
	}
	
	public void deposit() {
		System.out.print("Enter Account Number: ");
		long accNo = sc.nextLong();
		System.out.print("Enter Deposit Amount: ");
		float depAmount = amountCheck(sc.nextFloat());
		BankBean bankBeanDeptObj = new BankBean(accNo, depAmount);
		bankServiceObj.depositSer(bankBeanDeptObj);
	}
	
	public void withdraw() {
		System.out.print("Enter Account Number: ");
		long accNo = sc.nextLong();
		System.out.print("Enter Withdraw Amount: ");
		float withdrawAmount = amountCheck(sc.nextFloat());
		BankBean bankBeanWithdrawObj = new BankBean(withdrawAmount, accNo);
		bankServiceObj.withdrawSer(bankBeanWithdrawObj);
	}
	
	public void fundTransfer() {
		System.out.println("Enter Source Account Number: ");
		long sourceAccNo = sc.nextLong();
		System.out.println("Enter Destination Account Number: ");
		long destAccNo = sc.nextLong();
		System.out.println("Enter Amount to transfer: ");
		float transferAmount = amountCheck(sc.nextFloat());
		BankBean bankBeanFundTransObj = new BankBean(sourceAccNo, destAccNo, transferAmount);
		bankServiceObj.transferSer(bankBeanFundTransObj);
		String transactions = transferAmount+ " transferred from Account number " +sourceAccNo+ " to " +destAccNo;
		bankBeanFundTransObj = new BankBean(transactions);
	}
	
	public void printTransactions() {
		System.out.println(Arrays.toString(BankBean.transactions));
	}
	//********************************************************************************************************
	
	
	
	
	//********************************************************************************************************
	//*************CHECKER METHODS****************************************************************************
	//********************************************************************************************************
	
	// METHOD TO CHECK IF THE AMOUNT IS SMALLER THAN 0 OR NOT
	public float amountCheck(float amount) {
		while(true) {
			if(amount<=0) {
				System.out.println("Amount should be greater than 0.");
				System.out.println("Enter again: ");
				amount = sc.nextInt();
			}
			else {
				return amount;
			}
		}
	}
	
	// METHOD TO CHECK THE NAME
	public String nameCheck(String name) {
		while(true) {
			if(Pattern.matches("([A-Z])*([a-z])*", name)){
				return name;
			}
			else {
				System.out.println("Name should only have alphabets.");
				System.out.println("Enter again: ");
				name = sc.next();
			}
		}
	}
	
	//	METHOD TO CHECK THE LENGTH OF MOBILE NUMBER
	public long mobCheck(long mob) { 
		while(true) {
			if(String.valueOf(mob).length() < 10) {
				System.out.println("Enter valid mobile number.");
				mob = sc.nextLong();
			}
			else {
				return mob;
			}
		}
	}
	//********************************************************************************************************
}
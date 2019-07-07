package ui;

import java.util.Scanner;

public class BankMainUI {
	
	public static void main(String args[]) {
		int ch;
		char choice;
		BankModules bankModulesObj = new BankModules();
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("\n *********************\n 1. Create Account \n 2. Show Balance \n 3. Deposit \n 4. Withdraw \n 5. Fund Transfer \n 6. Print Transactions \n 7. Exit\n*********************");
			System.out.print("Enter your choice : ");
			ch = sc.nextInt();
			switch(ch) {
			case 1:
				bankModulesObj.createAccount();
				break;
			case 2:
				bankModulesObj.showBalance();
				break;
			case 3:
				bankModulesObj.deposit();
				break;
			case 4:
				bankModulesObj.withdraw();
				break;
			case 5:
				bankModulesObj.fundTransfer();
				break;
			case 6:
				bankModulesObj.printTransactions();
				break;
			case 7:
				System.exit(0);
			}
			System.out.print("Do you want to continue (y/n)...? : ");
			choice = sc.next().charAt(0);
			if(choice == 'y' || choice=='Y')
				continue;
			else {
				System.out.println("Thank You !");
				System.exit(0);
			}
		} while(ch != 7 );
		sc.close();
	}
}
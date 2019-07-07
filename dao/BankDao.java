package dao;

import java.util.HashMap;

import bean.BankBean;

public class BankDao {
	
	BankBean beankBeanObj;
	
	HashMap<Long, BankBean> hm = new HashMap<Long, BankBean>();
	
	public void addCustomer(BankBean beankBeanObj) {			// METHOD TO ADD A CUSTOMER 
		this.beankBeanObj = beankBeanObj;						// BY SAVING THE BANK BEAN OBJECT
		hm.put(beankBeanObj.getAccNo(), beankBeanObj);			// IN HASH MAP
	}
	
	public HashMap<Long, BankBean> hm(){						// METHOD TO RETURN HASH MAP OBJECT
		return hm;
	}
}




















































/*
 * Map<Long, BankBean> hm = new HashMap<Long, BankBean>();
	
	public void accountCreateDao(BankBean bankBeanObjCreateAccountObj) {
		hm.put(bankBeanObjCreateAccountObj.getAccNo(), bankBeanObjCreateAccountObj);
//		for (Map.Entry<Long, BankBean> accNo : hm.entrySet()){
//		    System.out.println(accNo.getKey()+ " : " +accNo.getValue().toString());
//		}
	}
	
	public void showBalDao(BankBean bankBeanShowBalObj) {
		int flag=0;
		if(hm.isEmpty())
			System.out.println("No account exist first create an account");
		else {
			for (Map.Entry<Long, BankBean> bal : hm.entrySet()){
				if(bankBeanShowBalObj.getAccNo() == bal.getKey()) {
					System.out.println("Your account balance is: " +bal.getValue().getBalance());
					flag=1;
				}
				else {
					if(flag==0) {
						System.out.println("Account not exist");
						continue;
					}
				}
				flag=0;
			}
		}
	}
	
	public void depositDao(BankBean bankBeanDepObj) {
		int flag=0;
		if(hm.isEmpty())
			System.out.println("No account exist first create an account");
		else {
			for (Map.Entry<Long, BankBean> bal : hm.entrySet()){
				if(bankBeanDepObj.getAccNo() == bal.getKey()) {
//					BankService bankServiceObj = new BankService();
//					bankServiceObj.depositAmount(bal.getValue());
					bal.getValue().setBalance(bal.getValue().getBalance()+bankBeanDepObj.getDepAmount());
					System.out.println("Your account balance is: " +bal.getValue().getBalance());
					flag=1;
				}
				else {
					if(flag==0)
						System.out.println("Account not exist");
					continue;
				}
				flag=0;
			}
		}
	}
	
	public void withdrawDao(BankBean bankBeanRef) {
		int flag=0;
		if(hm.containsKey(bankBeanRef.getAccNo())) {
			for (Map.Entry<Long, BankBean> bal : hm.entrySet()){
				if(bankBeanRef.getAccNo() == bal.getKey()) {
					bal.getValue().setBalance(bal.getValue().getBalance()-bankBeanRef.getWithdrawAmount());
					System.out.println("Your account balance is: " +bal.getValue().getBalance());
					flag=1;
				}
				else {
					if(flag==0)
						System.out.println("Account not exist");
					continue;
				}
				flag=0;
			}
		}
		else {
			System.out.println("No account exist first create an account");
		}
	}
	
	public void transferDao(BankBean bankBeanFundTransObj) {
		if(hm.isEmpty())
			System.out.println("No account exist first create an account");
		else {
			if(hm.containsKey(bankBeanFundTransObj.getSourceAccNo())){
				if(hm.containsKey(bankBeanFundTransObj.getDestAccNo())) {
					float amt = bankBeanFundTransObj.getTransferAmount();
					BankBean ca2 = (BankBean) hm.get(bankBeanFundTransObj.getDestAccNo());
					float bal = ca2.getBalance() + amt;
					for (Map.Entry<Long, BankBean> yo : hm.entrySet()){
						if(hm.containsKey(bankBeanFundTransObj.getDestAccNo()))
							System.out.println("Your account balance is: " +yo.getValue().getBalance());
					}
				}
				else {
					System.out.println("Destination Account not exist");
				}
			}
			else {
				System.out.println("Source Account not exist");
			}
		}
	}
*/
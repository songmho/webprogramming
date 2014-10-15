package com.songmho.java;

// 5단원의 1번 문제

public class AccountTest_no1 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Account account1, account2;		//클래스 선언
		
		account1=new Account("name1",101,10000);	//초기화
		System.out.println("소유주의 이름은 "+account1.owner_name()+"입니다.");
		account1.deposit(20000);
		account1.withdraw(31000);
		account1.withdraw(30000);
		System.out.println(account1);
		
		account2=new Account("name2",102,300000);		//초기화
		System.out.println("소유주의 이름은 "+account2.owner_name()+"입니다.");
		account2.deposit(20000);
		account2.withdraw(31000000);
		account2.withdraw(30000);
		System.out.println(account2);
		
	}

}

class Account{
	private long number;		//계좌 받는 변수 
	private long balance;		//잔액 받는 변수
	private String owner;		//소유주 받는 변수 
	
	public Account(String owner, long number, long balance){		//생성자
		this.owner=owner;
		this.number=number;
		this.balance=balance;
	}
	
	public long deposit(long amount){		//입금 할 때
		balance=balance+amount;
		System.out.println(amount+"원 입금");
		return balance;
	}
	public long withdraw(long amount){		//출금할 때
		if(amount<=balance){				//출금 금액이 잔액보다 적을 경우
			balance=balance-amount;
			System.out.println(amount+"원 출금");
		}
		
		else								//많을 경우
			System.out.println("잔액 부족");
		return balance;
	}
	
	public String owner_name(){		//owner이름 반환하는 메쏘드
		return this.owner;
	}
	
	public String toString(){
		return ("소유주"+owner+"\t"+"계좌 : "+number+"\t"+"잔액 : "+balance+"원");
	}
	
}

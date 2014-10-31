package com.songmho.java;

public class Listtest{

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		List l1=new NullList();
		List l2=new Pair(1,l1);
		List l5=new Pair(6,l2);
		List l6=new Pair(5,l5);
		List l4=new Pair(4,l6);		//리스트 초기화
		List l3=new Pair(2,l4);
		
		System.out.println(l3.toString());		//l3의 리스트 출력
	
		
		for(Object o:l3){					//foreach문 사용
			int i=(Integer)o;		//Integer 객체를 타입 변환 후 출력
			System.out.println(i);
		}
	}
}

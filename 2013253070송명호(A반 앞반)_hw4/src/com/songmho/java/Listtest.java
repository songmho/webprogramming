package com.songmho.java;

public class Listtest {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		List l1=new NullList();
		List l2=new Pair(1,l1);
		List l3=new Pair(2,l2);
		List l4=new Pair(4,l3);		//리스트 초기화
		
		System.out.println(l3.toString());		//l3의 리스트 출력
		l3.print();		//print메소드를 사용해 l3 리스트 출력
		l3.length();	//l3의 길이 출력
		l3.sum();		//l3의 모든 인자들의 합 출력
		l1=l1.concat(l3);
		l1.print();
		l3=l3.concat(l4);	//l3([2,1])와 l4([4,2,1])를 합쳐 l3에 대입
		l3.print();		//l3 출력
		l3=l3.reverse();	//l4를 뒤집어 l4에 대입
		l3.print();		//l4 출력
	}
}

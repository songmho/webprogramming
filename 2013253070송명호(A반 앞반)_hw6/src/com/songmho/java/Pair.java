package com.songmho.java;

import java.util.Iterator;

public class Pair extends List{		//List를 상속받아 Pair를 만듬

	private int firstElem;
	private List secondElem;
	
	public Pair(int firstElem, List secondElem) {		//생성자
		// TODO 자동 생성된 생성자 스텁
		this.firstElem=firstElem;
		this.secondElem=secondElem;
	}

	@Override
	public boolean isNULL() {		//Pair이므로 null이 아님
		// TODO 자동 생성된 메소드 스텁
		return false;
	}

	@Override
	public boolean isPair() {		//Pair이므로 true
		// TODO 자동 생성된 메소드 스텁
		return true;
	}

	@Override
	public int first() {			//첫번째 인자 반환하는 메소드
		// TODO 자동 생성된 메소드 스텁
		return firstElem;
	}

	@Override
	public List second() {			//뒤에 리스트 반환하는 메소드
		// TODO 자동 생성된 메소드 스텁
		return secondElem;
	}

	@Override
	public String toString() {		//toString 메소드
		// TODO 자동 생성된 메소드 스텁
		return "("+firstElem+","+secondElem.toString()+")";
	}


}

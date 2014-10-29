package com.songmho.java;

public class NullList extends List {		//List 상속 받아 NullList를 만듬

	@Override
	public boolean isNULL() {		//NullList이므로 null
		// TODO 자동 생성된 메소드 스텁
		return true;
	}

	@Override
	public boolean isPair() {		//null이므로 false
		// TODO 자동 생성된 메소드 스텁
		return false;
	}

	@Override
	public int first() {				//처음 값 없음
		// TODO 자동 생성된 메소드 스텁
		return 0;		//예외 발생하기 좋은 위치
	}

	@Override
	public List second() {				//뒤에 리스트도 없음	
		// TODO 자동 생성된 메소드 스텁
		return null;	//예외 발생하기 좋은 위치
	}

	@Override
	public String toString() {			//toString 메소드
		// TODO 자동 생성된 메소드 스텁
		return "()";
	}

}

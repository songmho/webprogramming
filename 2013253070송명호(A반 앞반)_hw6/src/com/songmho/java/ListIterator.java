package com.songmho.java;

import java.util.Iterator;

public class ListIterator implements Iterator {		//Iterator implements 시킴

	List l;
	public ListIterator(List list) {			//생성자
		// TODO 자동 생성된 생성자 스텁
		this.l=list;			
	}

	@Override
	public boolean hasNext() {					//hasNext메소드
		// TODO 자동 생성된 메소드 스텁
		return l.isPair();						//list의 isPair값 반환
	}

	@Override
	public Integer next() {						//next메소드
		// TODO 자동 생성된 메소드 스텁
		if(hasNext()){							//l이 비어있지 않으면
			int number=l.first();				//l의 인자를 받아 number에 초기화
			l=l.second();						//l에 l.second()를 초기화
			return number;						//number반환
		}
		else									//l이 비어있으면
			return null;						//null반환
	}

	@Override
	public void remove() {
		// TODO 자동 생성된 메소드 스텁
		
	}

}

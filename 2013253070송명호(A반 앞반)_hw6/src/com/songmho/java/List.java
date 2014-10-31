package com.songmho.java;

import java.util.Iterator;

abstract public class List implements java.lang.Iterable {		//추상클래스로 선언. Iterable 인터페이스 implements받음
	public abstract boolean isNULL();
	
	public abstract boolean isPair();

	public abstract int first();
	
	public abstract List second();
	
	public abstract String toString();
	

	@Override
	public Iterator iterator() {				//iterator
		// TODO 자동 생성된 메소드 스텁
		return new ListIterator(this);		//ListInterator객체를 선언하여 List의 값을 넣어 반환
	}
	

	public void print(){			//Listtest에 있던 print메소드 옮김
		List l=this;				//List객체를 l에 대입
		System.out.print("[");
		
		while(true){
			if(l.isNULL()){				//l이 null일 때 반복문 종료
				System.out.println("]");
				break;
			}
			else{		//null이 아닐 때 
				System.out.print(l.first() + (l.second().isNULL() ? "" : ","));		//출력
				l=l.second();			// l에 l.second()를 대입
			}
		}
	}
	
	public int length(){				//Listtest에 있던 length메소드 옮김
		int count;						//길이 카운트할 변수
		List l=this;					//List객체를 l에 대입
		count = 0;
		
		while(l.isPair()){			//l이 null이 아닐 때 반복
			count=count+1;			//count를 증가
			l=l.second();			//l.second를 l에 대입
		}
		System.out.println(count);
		return count;			//count반환
	}
	
	public int sum(){			//Listtest에 있던 sum메소드 옮김
		int sum;
		List l=this;			//List객체를 l에 대입
		sum=0;
		while(l.isPair()){		//l이 null이 아닐 때 반복
			sum=sum+l.first();	//sum변수에 ld의 first를 더함
			l=l.second();		//l.second()를 l에 대입
		}
		System.out.println(sum);
		return sum;				//sum반환
	}
	
	public List concat(List l2) {	//Listtest에 있던 concat메소드 옮김 입력 변수 1개 (뒤에 붙을 리스트 )
		if (this.isNULL()) {		//this가 null 일 때
			return l2;
		}
		else {						//this가 null이 아닐 때
			List l = this.second();
			return new Pair(this.first(), l.concat(l2));
		}
	}
	
	public List reverse(){			//Listtest에 있던 reverse메소드 옮김
		if(this.isNULL())			//this가 null 일 때
			return new NullList();
		else{						//this가 null이 아닐 때
			List l=this.second();
			return l.reverse().concat(new Pair(this.first(),new NullList()));
		}
		
	}
	
	/*
	public List _concat(List l2){			//Listtest에 있던 concat메소드 옮김 입력 변수 1개 (뒤에 붙을 리스트 )
		List newlist = null;				//최종으로 출력할 리스트 선언 : newlist		
		List [] list = new List[10000];		//리스트 배열 선언(List 객체가 10000개 이상의 인자를 갖고 있으면 함수가 에러 난다.)
		int i=0;
		int first;
		first=this.first();				//List객체의 first인자를 first에 대입
		list[i]=this.second();			//list[0]에 List객체의 second()를 대입
		
		if(this.isNULL()){					//this가 null이면 l2를 반환시켜야 된다.
			return l2;
		}
		else{
			while(true){					//반복
				if(list[i].isNULL()){		//list배열이 null일 때 끝냄
					break;
				}
				i++;						//i값 증가
				list[i]=list[i-1].second();			//list배열에 이전list의 second() 대입
				
			}
			i=i-1;	
			if(i<=0)				//list배열의 수가 1개일 때 인자는 -1이 되므로 0으로 바꿔줌
				i=0;
			newlist=new Pair(list[i].first(),l2);		//l2와 list배열 마지막리스트의 첫번째 인자를 합해 리스트를 만들고 newlist에 대입
			i=i-1;
			while(true){
				if(i<=0)					//i가 0보다 작으면 반복문 종료
					break;
				newlist=new Pair(list[i].first(),newlist);			//i를 1씩 감소시키며 list배열의 first와 newlist를 합해 리스트를 만들어 newilst에 대입
				i--;
			}
	
			newlist=new Pair(first,newlist);	//first변수와 newlist를 합해 newlist에 대입
			return newlist;		//newlist 반환
		}
	}
	
	
	
	
	
	public List _reverse(){			//Listtest에 있던 reverse메소드 옮김
		List list[]=new List[100];		//List배열 초기화
		int i=0;
		List newlist=null;		//반환과 결과값 저장에 쓸 List변수 선언
		int first;
		
		first=this.first();		//List객체의 첫인자 first변수에 대입
		newlist=new Pair(first,new NullList());		//null과 first를 합해 newlist에 저장
		
		list[i]=this.second();		//list 배열 첫인자에 List객체의 second() 대입
		
		while(true){
			if(list[i].isNULL())		//list배열이 null일 때 종료
				break;
			newlist=new Pair(list[i].first(),newlist);	//i를 1씩 증가하며 list배열의 first와 newlist를 합하여 newlist에 대입한다.
			i++;			
			list[i]=list[i-1].second();		//list배열에 이전 list배열의 second를 대입
		}
		
		return newlist;		//newlist반환
	}*/
}


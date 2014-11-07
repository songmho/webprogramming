package com.songmho.java;

public class Rectangle implements CircumferenceMeasurable {		//인터페이스 상속받은 클래스 구현

	private int x1,x2;
	private int y1,y2;				//변수선언
	
	public Rectangle(int x1, int x2, int y1, int y2){		//생성자
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
	}
	
	public int getX1(){		//x1값 출력 메소드
		return x1;
	}
	
	public int getX2(){		//y2값 출력 메소드
		return x2;
	}
	
	public int getY1(){		//y1값 출력 메소드
		return y1;
	}
	
	public int getY2(){		//y2값 출력 메소드
		return y2;
	}

	@Override
	public double circumference() {			//둘레구하는 메소드
		// TODO 자동 생성된 메소드 스텁
		int S=2*(Math.abs(x1-x2)+Math.abs(y1-y2));
		return S;
	}
}

package com.songmho.java;

public class Circle implements CircumferenceMeasurable {		//인터페이스 상속받은 클래스 구현
	int x;
	int y;
	int r;
	final double PI =3.14;					//변수선언
	public Circle (int x, int y, int r){	//생성자
		this.x=x;
		this.y=y;
		this.r=r;
	}										
	
	public int getX(){						//x값 출력 메소드
		return x;
	}
	public int getY(){						//y값 출력 메소드
		return y;
	}
	public int getR(){						//r값 출력 메소드
		return r;
	}

	@Override
	public double circumference() {			//둘레구하는 메소드
		// TODO 자동 생성된 메소드 스텁
		double S=2*(double)r*PI;
		return S;
	}
	
}

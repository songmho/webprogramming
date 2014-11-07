package com.songmho.java;

public class Test {

	public static void main(String[] args) {		//Test main 메소드
		// TODO 자동 생성된 메소드 스텁
		Circle c=new Circle(1, 2, 4);			//circle 객체 선언
		Rectangle r=new Rectangle(3, 2, 5, 2);	//rectangle 객체 선언
		
		System.out.println("원의 좌표 : "+"("+c.getX()+","+c.getY()+")"+", "
							+"원의 반지름 : "+c.getR()+", "+"원의 둘레 : "+ c.circumference());		//결과 출력
		
		System.out.println("직사각형의  (x1,y1)좌표 : "+"("+r.getX1()+","+r.getY1()+"), "+"직사각형의  (x2,y2)좌표 : "
							+"("+r.getX2()+","+r.getY2()+"), "+"직사각형의 둘레는"+ r.circumference());		//결과 출력
		
	}

}

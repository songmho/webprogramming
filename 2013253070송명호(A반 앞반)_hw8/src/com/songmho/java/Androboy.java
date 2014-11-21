package com.songmho.java;

public class Androboy {				//안드로보이 실루엣그리는 클래스
	public static void draw(TurtleGraphics tg) {
        
		//머리부분
		tg.penDown();
        
        tg.forward(30);
        tg.leftTurn(20);
        tg.forward(30);
        tg.leftTurn(20);
        tg.forward(30);
        tg.leftTurn(20);
        tg.forward(30);						
        
        tg.rightTurn(90);		//오른쪽 더듬이
        tg.forward(25);
        tg.backward(25);
        tg.leftTurn(90);
        
        tg.leftTurn(20);
        tg.forward(30);
        tg.leftTurn(20);
        tg.forward(30);

        tg.rightTurn(70);		//왼쪽 더듬이
        tg.forward(25);
        tg.backward(25);
        tg.leftTurn(70);
        
        tg.leftTurn(20);
        tg.forward(30);
        tg.leftTurn(20);
        tg.forward(30);
        tg.leftTurn(20);
        tg.forward(30);
        tg.leftTurn(20);
        tg.forward(30);
        tg.leftTurn(90);

        tg.forward(170);
        //머리 끝
        
        //몸통 시작
        tg.penUp();
        tg.rightTurn(90);
        tg.forward(10);
        
        tg.penDown();

        tg.rightTurn(90);
        tg.forward(170);
        
        tg.penUp();					//왼쪽 팔 시작
        tg.forward(10);
        tg.penDown();
        
        tg.forward(20);
        tg.leftTurn(90);
        tg.forward(100);
        tg.leftTurn(90);
        tg.forward(20);
        tg.leftTurn(90);
        tg.forward(100);
        
        tg.penUp();
        tg.rightTurn(90);
        tg.forward(10);
        tg.penDown();			//왼쪽 팔 끝
        
       tg.rightTurn(90);
        tg.forward(150);

        tg.leftTurn(90);
        tg.forward(20);
        
        tg.rightTurn(90);		//왼쪽 다리 시작
        tg.forward(70);
        tg.leftTurn(90);
        tg.forward(30);
        tg.leftTurn(90);
        tg.forward(70);			//끝

        tg.rightTurn(90);
        tg.forward(70);

        tg.rightTurn(90);		//오른쪽 다리 시작
        tg.forward(70);
        tg.leftTurn(90);
        tg.forward(30);
        tg.leftTurn(90);
        tg.forward(70);			//끝
        
        tg.rightTurn(90);
        tg.forward(20);
        
        tg.leftTurn(90);
        tg.forward(150);
	  
	    
        tg.rightTurn(120);	//오른쪽 팔 시작
        tg.penUp();
        tg.forward(10);
        tg.penDown();
        
        tg.forward(20);
        tg.leftTurn(90);
        tg.forward(100);
        tg.leftTurn(90);
        tg.forward(20);
        tg.leftTurn(90);
        tg.forward(100);		//끝

        //몸통끝
	}

}

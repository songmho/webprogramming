package com.songmho.java;

public class Rectangle {
	public static void draw(TurtleGraphics tg){
		tg.penDown();
		
		tg.forward(100);
        tg.leftTurn(90);

        tg.forward(100);
        tg.leftTurn(90);

        tg.forward(100);
        tg.leftTurn(90);

       
        tg.forward(100);
	}
}

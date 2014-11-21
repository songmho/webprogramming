package com.songmho.java;

public class Pentagon {
	public static void draw(TurtleGraphics tg){
		tg.penDown();
		
		tg.forward(100);
        tg.leftTurn(72);

        tg.forward(100);
        tg.leftTurn(72);

        tg.forward(100);
        tg.leftTurn(72);

        tg.forward(100);
        tg.leftTurn(72);
       
        tg.forward(100);
	}
}

package com.songmho.java;
import java.awt.Graphics;

import javax.swing.JApplet;


public class Main extends JApplet{
 public void init(){
	 resize(900,700);
 }
 
 public void paint(Graphics g){
	 TurtleGraphics tg=new TurtleGraphics(600,360,0,g);
	 
	// Rectangle.draw(tg);		//사각형
	// Pentagon.draw(tg);		//오각형
	// Octagon.draw(tg);		//팔각형
	//Tree.draw(tg);			//트리
	 Androboy.draw(tg);			//어려운 도형
 }
}

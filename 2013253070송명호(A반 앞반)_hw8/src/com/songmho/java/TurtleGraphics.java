package com.songmho.java;

import java.awt.Graphics;

public class TurtleGraphics {
	private double x;
	private double y;
	private double degree;
	private boolean penup;
	
	private Graphics g;
	
	TurtleGraphics(double x, double y, double degree, Graphics g){
		this.x=x;
		this.y=y;
		this.degree=degree;
		this.g=g;
	
		this.penup=true;
	}

	public void penUp(){
		this.penup=false;
	}
	
	public void penDown(){
		this.penup=true;
	}
	
	public void forward(double steps){
		if(penup){			//penup인 경우
			g.drawLine((int)this.x, (int)(this.y),(int)(x+steps*Math.sin(Math.toRadians(degree))),(int)(y-steps*Math.cos(Math.toRadians(degree))));
			this.x=x+steps*Math.sin(Math.toRadians(degree));
			this.y=y-steps*Math.cos(Math.toRadians(degree));
		}
		else{				//pendown인 경우
			this.x=x+steps*Math.sin(Math.toRadians(degree));
			this.y=y-steps*Math.cos(Math.toRadians(degree));
		}
		
	}
	
	public void backward(double steps){
		forward(-steps);
	}
	
	public void leftTurn(double angle){
		this.degree=this.degree-angle;
	}
	public void rightTurn(double angle){
		this.degree=this.degree+angle;
		
	}
	
	public double getX(){return x;}
	public double getY(){return y;}
	public double getDegree(){return degree;}

	public void setX(double x){this.x=x;}
	public void setY(double y){this.y=y;}
	public void setDegree(double degree){this.degree=degree;}
	
}

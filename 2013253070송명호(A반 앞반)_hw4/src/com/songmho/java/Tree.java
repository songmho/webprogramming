package com.songmho.java;

abstract public class Tree {			//추상클래스로 선언 

	public abstract boolean isNull();
	
	public abstract boolean isBinTree();
	
	public abstract int value();
	
	public abstract Tree left();
	
	public abstract Tree right();
	
	public abstract String toString();
}

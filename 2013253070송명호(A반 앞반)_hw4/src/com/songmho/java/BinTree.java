package com.songmho.java;

public class BinTree extends Tree {

	private Tree leftTree;
	private Tree rightTree;
	private int value;
	
	public BinTree(Tree left, int value, Tree right){
		this.leftTree=left;
		this.value=value;
		this.rightTree=right;
	}
	@Override
	public boolean isNull() {
		// TODO 자동 생성된 메소드 스텁
		return false;
	}

	@Override
	public boolean isBinTree() {
		// TODO 자동 생성된 메소드 스텁
		return true;
	}

	@Override
	public int value() {
		// TODO 자동 생성된 메소드 스텁
		return this.value;
	}

	@Override
	public Tree left() {
		// TODO 자동 생성된 메소드 스텁
		return this.leftTree;
	}

	@Override
	public Tree right() {
		// TODO 자동 생성된 메소드 스텁
		return this.rightTree;
	}

	@Override
	public String toString() {
		// TODO 자동 생성된 메소드 스텁
		String buf=new String("("+leftTree.toString()+" : "+value+" : "+rightTree.toString()+")");
		return buf;
	}

}

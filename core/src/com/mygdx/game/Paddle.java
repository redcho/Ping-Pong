package com.mygdx.game;

public class Paddle extends GameObject {

	private int speed;
	private int score;
	
	public Paddle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void increaseScore(){
		score++;
	}
	
	public int getScore(){
		return score;
	}

	@Override
	public void initSpeed(int speed) {
		// TODO Auto-generated method stub
		this.speed = speed;
	}
	
	public int getSpeed(){
		return speed;
	}

}

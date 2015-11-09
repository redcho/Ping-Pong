package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;

public class Ball extends GameObject{

	int WIDTH = Gdx.graphics.getWidth();
	int HEIGHT = Gdx.graphics.getHeight();

	private int speedx, speedy;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/*
	public boolean isOverlappingWith(Paddle B){
		return (getX() < (B.getX()+B.getWidth()) && (getX()+getWidth()) > B.getX() && getY() < (B.getY()+B.getHeight()) && (getY()+getHeight()) > B.getY()); 
	}
	*/
	public void reset(int WIDTH, int HEIGHT, boolean n){
		Random random = new Random();
		
		setX(WIDTH/2);
		setY(random.nextInt(HEIGHT/2-10) + 20);

		if(n){
			setSpeedX(3);
		}else{
			setSpeedX(-3);
		}
		
		if(random.nextInt(100)%2 == 1){
			setSpeedY(3);
		}else{
			setSpeedY(-3);
		}
	}
	
	@Override
	public void initSpeed(int speed){
		speedx = speed;
		speedy = speed;
	}
	
	public void setSpeedX(int speed){
		speedx = speed;
	}
	
	public void setSpeedY(int speed){
		speedy = speed;
	}
	
	public void reverseX(){
		speedx = -speedx;
	}
	
	public void reverseY(){
		speedy = -speedy;
	}
	
	public int getSpeed(){
		return speedx;
	}

	public void logicUpdate(Paddle left, Paddle right) {
		
		if(getX() > WIDTH){
			left.increaseScore();;
			reset(WIDTH, HEIGHT, false);
		}else if(getX() <= 0){
			right.increaseScore();
			reset(WIDTH, HEIGHT, true);
		}
		
		
		increaseX(speedx);
		decreaseY(speedy);
	}
}

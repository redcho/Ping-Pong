/*package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class MyGdxGame extends ApplicationAdapter {
	
	int WIDTH, HEIGHT;
	ShapeRenderer sp;
	SpriteBatch batch;
	Rectangle left, right, upperLimit, lowerLimit, line;
	int stickspeed;
	BitmapFont font;
	int scoreLeft = 0;
	int scoreRight = 0;
	
	Ball ball;
	
	public Rectangle getRectangle(int x, int y, int width, int height){
		Rectangle rec = new Rectangle();
		rec.x = x;
		rec.y = y;
		rec.width = width;
		rec.height = height;
		return rec;
		
	}
	
	public boolean isOverlapping(Rectangle A, Rectangle B){
		return (A.x < (B.x+B.width) && (A.x+A.width) > B.x && A.y < (B.y+B.height) && (A.y+A.height) > B.y); 
	}
	
	public boolean isOverlapping(Ball A, Rectangle B){
		return (A.getX() < (B.x+B.width) && (A.getX()+A.getWidth()) > B.x && A.getY() < (B.y+B.height) && (A.getY()+A.getHeight()) > B.y); 
	}
	
	public void reset(boolean n){
		System.out.println("I'm in reset");
		Random random = new Random();
		
		ball.setX(WIDTH/2);
		ball.setY(random.nextInt(HEIGHT/2-10) + 20);

		if(n){
			ball.setSpeedX(3);
		}else{
			ball.setSpeedX(-3);
		}
		
		if(random.nextInt(100)%2 == 1){
			ball.setSpeedY(3);
		}else{
			ball.setSpeedY(-3);
		}
	}
	
	public void initializeObjects(){
		left = getRectangle(20,HEIGHT/2-30,5,60);
		right = getRectangle(WIDTH-20,HEIGHT/2-30,5,60);
		ball = new Ball(WIDTH/2,HEIGHT/2,8,8);
		upperLimit = getRectangle(0,HEIGHT-10,WIDTH,5);
		lowerLimit = getRectangle(0,10,WIDTH,5);
		line = getRectangle(WIDTH/2, 10, 2,HEIGHT-20);
	}
	
	public void initializeSpeed(int ballspeed, int stick){
		ball.initSpeed(ballspeed);
		stickspeed = stick;
	}
	
	public void handleInput(){
		
		if( !isOverlapping(left, lowerLimit) && Gdx.input.isKeyPressed(Keys.S))
			left.y -= stickspeed;
		if( !isOverlapping(left, upperLimit) && Gdx.input.isKeyPressed(Keys.W))
			left.y += stickspeed;
		
		if( !isOverlapping(right, lowerLimit) && Gdx.input.isKeyPressed(Keys.DOWN))
			right.y -= stickspeed;
		if( !isOverlapping(right, upperLimit) && Gdx.input.isKeyPressed(Keys.UP))
			right.y += stickspeed;
			
	}
	
	public void logicUpdate(){
		
		if(isOverlapping(ball, upperLimit) || isOverlapping(ball, lowerLimit)){
			ball.reverseY();	
		}
		if(isOverlapping(ball, left) || isOverlapping(ball, right)){
			ball.reverseX();
		}
		
		if(ball.getX() > WIDTH){
			scoreLeft++;
			reset(false);
		}else if(ball.getX() <= 0){
			scoreRight++;
			reset(true);
		}
		
		ball.logicUpdate();
	}
	
	public void draw(){
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sp.begin(ShapeType.Filled);
		sp.setColor(Color.LIGHT_GRAY);
		  sp.rect(left.x,left.y, left.width, left.height);
		  sp.rect(right.x, right.y, right.width, right.height);
		  sp.rect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		sp.setColor(Color.WHITE);
		  sp.rect(upperLimit.x, upperLimit.y, upperLimit.width, upperLimit.height);
		  sp.rect(lowerLimit.x, lowerLimit.y, lowerLimit.width, lowerLimit.height);
		sp.setColor(Color.DARK_GRAY);
		  sp.rect(line.x, line.y, line.width, line.height);
		sp.end();
		
		batch.begin();
		  font.draw(batch, Integer.toString(scoreLeft), WIDTH/2-50, HEIGHT/2+HEIGHT/3);
		  font.draw(batch, Integer.toString(scoreRight), WIDTH/2+50, HEIGHT/2+HEIGHT/3);
		batch.end();
		
	}
	
	@Override
	public void create () {
		
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
		sp = new ShapeRenderer();
		font = new BitmapFont();
		batch = new SpriteBatch();
		
		// Coordinates according to WIDTH and HEIGHT
		initializeObjects();
		
		// Parameters : Ball speed, Stick speed
		initializeSpeed(3, 5);
		
	}

	@Override
	public void render () {
		// Main Loop
		
		handleInput();
		logicUpdate();
		draw();		
	}
}*/

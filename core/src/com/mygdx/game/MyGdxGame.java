package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class MyGdxGame extends ApplicationAdapter {
	
	int WIDTH, HEIGHT;
	ShapeRenderer sp;
	SpriteBatch batch;
	Rectangle upperLimit, lowerLimit, line;
	BitmapFont font;
	
	Ball ball;
	Paddle left, right;

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

	public void initializeObjects(){
		left = new Paddle(20,HEIGHT/2-30,5,60);
		right = new Paddle(WIDTH-20,HEIGHT/2-30,5,60);
		ball = new Ball(WIDTH/2,HEIGHT/2,8,8);
		upperLimit = new Rectangle(0,HEIGHT-10,WIDTH,5);
		lowerLimit = new Rectangle(0,10,WIDTH,5);
		line = new Rectangle(WIDTH/2, 10, 2,HEIGHT-20);
	}
	
	public void initializeSpeed(int ballspeed, int stick){
		ball.initSpeed(ballspeed);
		left.initSpeed(stick);
		right.initSpeed(stick);
	}
	
	public void handleInput(){
		
		if( !left.isOverlappingWith(lowerLimit) && Gdx.input.isKeyPressed(Keys.S))
			left.decreaseY(left.getSpeed());
		if( !left.isOverlappingWith(upperLimit) && Gdx.input.isKeyPressed(Keys.W))
			left.increaseY(left.getSpeed());
		
		if( !right.isOverlappingWith(lowerLimit) && Gdx.input.isKeyPressed(Keys.DOWN))
			right.decreaseY(right.getSpeed());
		if( !right.isOverlappingWith(upperLimit) && Gdx.input.isKeyPressed(Keys.UP))
			right.increaseY(right.getSpeed());
			
	}
	
	public void logicUpdate(){
		
		if(ball.isOverlappingWith(upperLimit) || ball.isOverlappingWith(lowerLimit)){
			ball.reverseY();	
		}
		if(ball.isOverlappingWith(left) || ball.isOverlappingWith(right)){
			ball.reverseX();
		}
		
		ball.logicUpdate(left, right);
	}
	
	public void draw(){
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sp.begin(ShapeType.Filled);
		sp.setColor(Color.LIGHT_GRAY);
		  left.draw(sp);
		  right.draw(sp);
		  ball.draw(sp);
		sp.setColor(Color.WHITE);
		  sp.rect(upperLimit.x, upperLimit.y, upperLimit.width, upperLimit.height);
		  sp.rect(lowerLimit.x, lowerLimit.y, lowerLimit.width, lowerLimit.height);
		sp.setColor(Color.DARK_GRAY);
		  sp.rect(line.x, line.y, line.width, line.height);
		sp.end();
		
		batch.begin();
		  font.draw(batch, Integer.toString(left.getScore()), WIDTH/2-50, HEIGHT/2+HEIGHT/3);
		  font.draw(batch, Integer.toString(right.getScore()), WIDTH/2+50, HEIGHT/2+HEIGHT/3);
		batch.end();
		
	}
	
}

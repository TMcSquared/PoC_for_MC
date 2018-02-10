package com.sample.Main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {
	SpriteBatch batch;
	Screen mainscreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		mainscreen = new Mainmenu(this);
		setScreen(mainscreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

package com.sample.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Mainmenu implements Screen {
	
	MainGame game;
	SpriteBatch batch;
	Texture img;
	float m_width, m_height;
	Stage stage;
	Table table;
	Skin skin;
	TextButton startgame;
	TextButton options;
	TextButton chgame;
	TextButton exit;
	
	Mainmenu(MainGame g){
		game = g;
		batch = g.batch;
		setupUI();
	}

	void setupUI(){
		float pad = 1;
		float width = (float)(Gdx.graphics.getWidth()*0.4f);
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
		
		table = new Table();
		table.setFillParent(true);
		table.setDebug(false);
		
		startgame = new TextButton("Start Game",skin);
		chgame = new TextButton("Choose Game",skin);
		options = new TextButton("Options",skin);
		exit = new TextButton("Exit",skin);
		
		addListeners();
		
		table.add(startgame).width(width).pad(pad);
		table.row();
		table.add(chgame).width(width).pad(pad);
		table.row();
		table.add(options).width(width).pad(pad);
		table.row();
		table.add(exit).width(width).pad(pad);
		
		
		stage.addActor(table);
	}

	void addListeners(){
		startgame.addListener(new ChangeListener(){

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				dispose();
				game.setScreen(new Startgame(game));
				
			}
			
		});
		
		exit.addListener(new ChangeListener(){

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				dispose();
				Gdx.app.exit();
			}
			
		});
		
	}
	
	@Override
	public void show() {
		img = new Texture(Gdx.files.internal("mainmenu/background.png"));
		m_width = Gdx.graphics.getWidth();
		m_height = Gdx.graphics.getHeight();
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		batch.begin();
		batch.draw(img,0,0,m_width,m_height);
		batch.end();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
		m_width = width;
		m_height = height;
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void dispose() {
		img.dispose();
		stage.dispose();
	}
	
	

}

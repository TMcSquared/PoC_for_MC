package com.sample.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Startgame implements Screen {
	
	MainGame game;
	SpriteBatch batch;
	//UI
	Stage stage;
	Table table;
	Skin skin;
	//Widgets
	List<String> gamelist;
	String[] worldlist = {"world 1", "world 2","world 3","world 4"};
	TextButton play;
	TextButton back;
	int m_width;
	int m_height;
	Texture img;
	
	
	Startgame(MainGame g){
		game = g;
		batch = g.batch;
		setupUI();
	}
	
	void setupUI(){
		float pad = 1;
		float width = (float)(Gdx.graphics.getWidth()*0.5f);
		stage = new Stage();
		table = new Table();
		Gdx.input.setInputProcessor(stage);
		skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
		table.setFillParent(true);
		table.setDebug(false);
		
		gamelist = new List<String>(new Skin(Gdx.files.internal("defaultskin/skin/uiskin.json")));
		gamelist.setItems(worldlist);
		
		play = new TextButton("Play",skin);
		back = new TextButton("Back",skin);
		
		addListeners();
		
		
		
		
		stage.addActor(table);
		
	}

	void addListeners(){
		back.addListener(new ChangeListener(){

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				dispose();
				game.setScreen(new Mainmenu(game));
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
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}

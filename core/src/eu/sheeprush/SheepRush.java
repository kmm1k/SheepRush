package eu.sheeprush;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;


import eu.sheeprush.helpers.AssetLoader;
import eu.sheeprush.screens.GameScreen;

public class SheepRush extends Game {

	public GameScreen gameScreen;

	@Override
	public void create() {
		Gdx.app.log("SheepRush", "launching the game");
		AssetLoader.load();
		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

}

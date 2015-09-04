package eu.sheeprush;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import eu.sheeprush.helpers.AssetLoader;
import eu.sheeprush.screens.MenuScreen;

public class SheepRush extends Game {


    @Override
    public void create() {
        Gdx.app.log("SheepRush", "launching the game");
        AssetLoader.load();
        setScreen(new MenuScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }

}

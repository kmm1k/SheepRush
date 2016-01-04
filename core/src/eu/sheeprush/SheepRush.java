package eu.sheeprush;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import eu.sheeprush.helpers.AssetLoader;
import eu.sheeprush.screens.MenuScreen;

public class SheepRush extends Game {


    @Override
    public void create() {
        boolean available = Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer);
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

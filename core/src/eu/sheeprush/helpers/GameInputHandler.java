package eu.sheeprush.helpers;

import com.badlogic.gdx.InputProcessor;

import eu.sheeprush.gameobjects.Sheep;
import eu.sheeprush.gameworld.GameWorld;

/**
 * Created by karl on 30.08.2015.
 */
public class GameInputHandler implements InputProcessor {

    private GameWorld world;
    private Sheep sheep;

    public GameInputHandler(GameWorld world) {
        this.world = world;
        sheep = world.getSheep();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        sheep.touched();
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}

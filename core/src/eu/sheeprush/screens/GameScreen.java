package eu.sheeprush.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import eu.sheeprush.SheepRush;
import eu.sheeprush.gameworld.GameRenderer;
import eu.sheeprush.gameworld.GameWorld;
import eu.sheeprush.helpers.GameInputHandler;

/**
 * Created by karl on 29.08.2015.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;
    private SheepRush sheepRush;

    public GameScreen(SheepRush sheepRush) {
        this.sheepRush = sheepRush;
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx. graphics.getHeight();
        float gameWidth = 180;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midX = (int) gameWidth/2;
        world = new GameWorld(midX, screenWidth, gameHeight);
        renderer = new GameRenderer(world, (int) gameHeight, midX);
        Gdx.input.setInputProcessor(new GameInputHandler(world));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(delta > .1f){
            delta = .1f;
        }
        runTime += delta;
        Application.ApplicationType appType = Gdx.app.getType();
        if (appType == Application.ApplicationType.Android || appType == Application.ApplicationType.iOS) {
            world.update(delta, Gdx.input.getAccelerometerX());
        }
        renderer.render(runTime);
        if (world.isFailed()){
            sheepRush.setScreen(new GameOverScreen(sheepRush, renderer));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

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

    }
}

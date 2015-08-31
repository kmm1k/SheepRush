package eu.sheeprush.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import eu.sheeprush.SheepRush;
import eu.sheeprush.gameoverview.GameOverLogic;
import eu.sheeprush.gameoverview.GameOverRenderer;

/**
 * Created by karl on 31.08.2015.
 */
public class GameOverScreen implements Screen {

    private GameOverLogic gameOverLogic;
    private GameOverRenderer gameOverRenderer;
    private float runTime;
    private SheepRush sheepRush;

    public GameOverScreen(SheepRush sheepRush) {
        this.sheepRush = sheepRush;
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx. graphics.getHeight();
        float gameWidth = 180;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midX = (int) gameWidth/2;
        gameOverLogic = new GameOverLogic(midX, screenWidth, gameHeight);
        gameOverRenderer = new GameOverRenderer(gameOverLogic, (int) gameHeight, midX);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        runTime += delta;
        gameOverLogic.update(delta);
        gameOverRenderer.render(runTime);
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

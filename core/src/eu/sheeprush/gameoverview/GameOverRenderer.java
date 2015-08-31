package eu.sheeprush.gameoverview;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import eu.sheeprush.helpers.AssetLoader;
import eu.sheeprush.helpers.GameScore;

/**
 * Created by karl on 31.08.2015.
 */
public class GameOverRenderer {
    private final OrthographicCamera cam;
    private final SpriteBatch batcher;
    private final ShapeRenderer shapeRenderer;
    private final int midX;
    private final int gameHeight;
    private GameOverLogic gameOverLogic;

    public GameOverRenderer(GameOverLogic gameOverLogic, int gameHeight, int midX) {
        Gdx.app.log("GameOverRenderer", "init");
        this.gameOverLogic = gameOverLogic;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 180, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        this.midX = midX;
        this.gameHeight = gameHeight;
    }

    public void render(float runTime) {
        batcher.begin();
        batcher.enableBlending();
        AssetLoader.font20.draw(batcher, "" + GameScore.score, 100, 20);
        batcher.end();
    }
}

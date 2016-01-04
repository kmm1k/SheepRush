package eu.sheeprush.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import eu.sheeprush.gameobjects.Coin;
import eu.sheeprush.gameobjects.Sheep;
import eu.sheeprush.gameobjects.Water;
import eu.sheeprush.helpers.AssetLoader;
import eu.sheeprush.helpers.GameScore;

/**
 * Created by karl on 29.08.2015.
 */
public class GameRenderer {

    private int midX, gameHeight;
    private ShapeRenderer shapeRenderer;
    private GameWorld world;
    private OrthographicCamera cam;
    private SpriteBatch batcher;
    private Animation sheepAnimation, waterAnimation;
    private TextureRegion sheepJump, frame, waterBg, coinTexture;
    private Sheep sheep;
    private Water water1, water2;
    private Coin coin;

    public GameRenderer(GameWorld world, int gameHeight, int midX) {
        Gdx.app.log("gamerenderer", "init");
        this.world = world;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 180, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        this.midX = midX;
        this.gameHeight = gameHeight;

        initObjects();
        initAssets();
    }

    private void initObjects() {
        sheep = world.getSheep();
        water1 = world.getWater1();
        water2 = world.getWater2();
        coin = world.getCoin();
    }

    private void initAssets() {
        sheepAnimation = AssetLoader.sheepAnimation;
        sheepJump = AssetLoader.sheepJumpFrame;
        waterBg = AssetLoader.waterBg;
        coinTexture = AssetLoader.coinTexture;
        waterAnimation = AssetLoader.waterAnimation;
    }

    public void render(float runTime) {
        Gdx.gl.glClearColor(122 / 255.0f, 222/ 255.0f, 75/ 255.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batcher.begin();
        batcher.enableBlending();
        drawWater(runTime, water1);
        drawWater(runTime, water2);
        drawCoin(runTime);
        drawSheep(runTime);
        AssetLoader.scoreFont.draw(batcher, ""+GameScore.score, 20, 20);
        batcher.end();
    }

    private void drawWater(float runTime, Water water) {
        /* TODO: performance get width/height only in constructor */
        float width = water.getWidth();
        float height = water.getHeight();
        float x = water.getX();
        float y = water.getY();

        batcher.draw(waterBg, x, y, width, height);
    }

    public void drawCoin(float runTime) {
        float width = coin.getWidth();
        float height = coin.getHeight();
        float x = coin.getX();
        float y = coin.getY();

        batcher.draw(coinTexture, x, y, width, height);
    }

    public void drawSheep(float runTime) {
        /* TODO: performance get width/height only in constructor */
        float width = sheep.getWidth();
        float height = sheep.getHeight();
        float x = sheep.getX();
        float y = sheep.getY();
        float originX = width/2.0f;
        float originY = height/2.0f;
        float scaleX = 1;
        float scaleY = 1;
        float rotation = 0;

        if (sheep.isOnGround()) {
            frame = sheepAnimation.getKeyFrame(runTime * world.getSpeed());
        } else {
            frame = sheepJump;
        }
        batcher.draw(frame, x, y,
                originX, originY,
                width, height,
                scaleX, scaleY, rotation);
    }
}

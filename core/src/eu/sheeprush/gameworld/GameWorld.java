package eu.sheeprush.gameworld;

import com.badlogic.gdx.math.Vector2;

import eu.sheeprush.gameobjects.Coin;
import eu.sheeprush.gameobjects.ScrollHandler;
import eu.sheeprush.gameobjects.Sheep;
import eu.sheeprush.gameobjects.Water;
import eu.sheeprush.helpers.AssetLoader;
import eu.sheeprush.helpers.GameScore;

/**
 * Created by karl on 29.08.2015.
 */
public class GameWorld {

    private Sheep sheep;
    private GameScore gameScore;
    private ScrollHandler scrollHandler;
    private Vector2 speed;
    private float jumpTime;
    private boolean failed;

    public GameWorld(int midX, float screenWidth, float gameHeight) {
        gameScore = new GameScore();
        speed = new Vector2(0, 1.0f);
        sheep = new Sheep((int) (midX-35/2f), (int) gameHeight - 60, 35, 60);
        scrollHandler = new ScrollHandler(gameHeight);
        failed = false;
    }

    public float getSpeed() {
        return speed.y;
    }

    public Sheep getSheep() {
        return sheep;
    }

    public boolean isFailed() {
        return failed;
    }

    public void update(float delta, float accelerometerX) {
        /*if(delta > .15f){
            delta = .15f;
        }*/
        scrollHandler.update(delta);
        if (scrollHandler.waterCollision(sheep.getSheepBox()) && sheep.isOnGround()) {
            scrollHandler.stop();
            AssetLoader.gameOverSound.play(1.0f);
            failed = true;
        }

        if (scrollHandler.coinCollision(sheep.getSheepBox())) {
            GameScore.score++;
            AssetLoader.pointGetSound.play(1.0f);
            scrollHandler.getCoin().resetDefault();
        }

        //Gdx.app.log("gameWorld", ""+scrollHandler.getVelocityY());
        if (!sheep.isOnGround()) {
            jumpTime += delta;
            if (jumpTime > 140f/scrollHandler.getVelocityY()){
                jumpTime = 0;
                sheep.setOnGround(true);
            }
        }
        sheep.velocity.x = -accelerometerX / 10 * sheep.SHEEP_MOVE_VELOCITY;
        sheep.update(delta);
    }

    public Water getWater1() {
        return scrollHandler.getWater1();
    }

    public Water getWater2() {
        return scrollHandler.getWater2();
    }

    public Coin getCoin() {
        return scrollHandler.getCoin();
    }
}

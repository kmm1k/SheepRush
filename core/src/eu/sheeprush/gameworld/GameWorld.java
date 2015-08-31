package eu.sheeprush.gameworld;

import com.badlogic.gdx.math.Vector2;

import eu.sheeprush.gameobjects.ScrollHandler;
import eu.sheeprush.gameobjects.Sheep;
import eu.sheeprush.gameobjects.Water;
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

    public GameWorld(int midX, float screenWidth, float gameHeight) {
        gameScore = new GameScore();
        speed = new Vector2(0, 1.0f);
        sheep = new Sheep((int) (midX-35/2f), (int) gameHeight - 60, 35, 60);
        scrollHandler = new ScrollHandler(gameHeight);
    }

    public float getSpeed() {
        return speed.y;
    }

    public Sheep getSheep() {
        return sheep;
    }

    public void update(float delta) {
        /*if(delta > .15f){
            delta = .15f;
        }*/
        scrollHandler.update(delta);
        if (scrollHandler.collides(sheep.getSheepBox()) && sheep.isOnGround()) {
            scrollHandler.stop();
        }

        //Gdx.app.log("gameWorld", ""+scrollHandler.getVelocityY());
        if (!sheep.isOnGround()) {
            jumpTime += delta;
            if (jumpTime > 140f/scrollHandler.getVelocityY()){
                jumpTime = 0;
                sheep.setOnGround(true);
            }
        }
    }

    public Water getWater1() {
        return scrollHandler.getWater1();
    }

    public Water getWater2() {
        return scrollHandler.getWater2();
    }
}

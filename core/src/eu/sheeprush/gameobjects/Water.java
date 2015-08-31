package eu.sheeprush.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;


/**
 * Created by karl on 30.08.2015.
 */
public class Water extends Scrollable{

    private Rectangle waterBox;

    public Water(float x, float y, int width, int height, float scrollSpeed, float gameHeight) {
        super(x, y, width, height, scrollSpeed, gameHeight);
        waterBox = new Rectangle();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        waterBox.set((int) position.x, (int) position.y, width, height);
    }

    @Override
    public void reset(float newY){
        super.reset(newY);
    }

    public boolean collides(Rectangle sheep){
        Gdx.app.log("Rectangle", "sheep: " + sheep);
        Gdx.app.log("Rectangle", "water: " + waterBox);
        return Intersector.overlaps(sheep, waterBox);
    }

}

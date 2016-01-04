package eu.sheeprush.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by karl on 4.01.2016.
 */
public class Coin extends Scrollable {

    private Rectangle coinBox;

    public Coin(float x, float y, int width, int height, float scrollSpeed, float gameHeight) {
        super(x, y, width, height, scrollSpeed, gameHeight);
        coinBox = new Rectangle();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        coinBox.set((int) position.x, (int) position.y, width, height);
    }

    @Override
    public void reset(float newY){
        super.reset(newY);
    }

    public void resetDefault() {
        this.reset(-1 * gameHeight);
    }

    public boolean collides(Rectangle sheep){
        return Intersector.overlaps(sheep, coinBox);
    }
}

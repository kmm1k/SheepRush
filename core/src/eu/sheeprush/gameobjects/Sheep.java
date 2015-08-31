package eu.sheeprush.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;



/**
 * Created by karl on 30.08.2015.
 */
public class Sheep {

    private int width;
    private int height;
    private Vector2 position;

    private Rectangle sheepBox;
    private boolean onGround;

    public Sheep(int x, int y, int width, int height) {
        onGround = true;
        this.height = height;
        this.width = width;
        position = new Vector2(x, y);
        sheepBox = new Rectangle();
        sheepBox.set(x, y, width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public Rectangle getSheepBox() {
        return sheepBox;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public void touched() {
        if (onGround) onGround = false;
    }

    public boolean isOnGround() {
        return onGround;
    }

}

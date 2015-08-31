package eu.sheeprush.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by karl on 30.08.2015.
 */
public class Scrollable {

    protected Vector2 position;
    protected Vector2 velocity;
    protected Vector2 acceleration;
    protected int width;
    protected int height;
    protected float gameHeight;
    protected boolean scrolled;

    public Scrollable(float x, float y, int width, int height, float scrollSpeed, float gameHeight) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, scrollSpeed);
        acceleration = new Vector2(0, 8);
        this.width = width;
        this.height = height;
        this.gameHeight = gameHeight;
        scrolled = false;
    }

    public void update(float delta) {

        /* TODO: move speed and acceleration and velocity to gameworld and update here the pos */
        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));

        if (position.y > gameHeight+height){
            scrolled = true;
        }
    }

    public void stop(){
        velocity.y = 0;
    }

    public void reset(float newY) {
        position.y = newY;
        scrolled = false;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isScrolled() {
        return scrolled;
    }

    public float getTailY(){
        return position.y;
    }

    public float getVelocityY(){
        return velocity.y;
    }

}

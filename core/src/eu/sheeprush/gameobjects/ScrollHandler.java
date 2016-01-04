package eu.sheeprush.gameobjects;


import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;

import eu.sheeprush.helpers.AssetLoader;
import eu.sheeprush.helpers.GameScore;

public class ScrollHandler {

	private Water water1, water2;
	private Coin coin;
	private float gameHeight;
	
	public static final int SCROLL_SPEED = 200;
	private final Sound pointGetSound;
	//public static final int WB_GAP = -270;

	public ScrollHandler(float gameHeight) {
		water1 = new Water(0, -1*gameHeight+35, 180, 35, SCROLL_SPEED, gameHeight);
		water2 = new Water(0, -2*gameHeight+35, 180, 35, SCROLL_SPEED, gameHeight);
		coin = new Coin(30, -1*gameHeight+130, 30, 30, SCROLL_SPEED, gameHeight);
		pointGetSound = AssetLoader.pointGetSound;
		this.gameHeight = gameHeight;
	}

	public void update(float delta) {
		water1.update(delta);
		water2.update(delta);
		coin.update(delta);
		if(water1.isScrolled()){
			GameScore.score++;
			water1.reset(-1*gameHeight);
			pointGetSound.play();
		}
		else if(water2.isScrolled()){
			GameScore.score++;
			water2.reset(-1*gameHeight);
			pointGetSound.play();
		}
        if(coin.isScrolled()){
            coin.reset(-1 * gameHeight);
        }
	}
	
	public void stop() {
		water1.stop();
		water2.stop();
        coin.stop();
	}

	public Water getWater1() {
		return water1;
	}

	public Water getWater2() {
		return water2;
	}

	public boolean waterCollision(Rectangle sheep){
		return ( water2.collides(sheep) || water1.collides(sheep));
	}
	public float getVelocityY() {
		return water1.getVelocityY();
	}

	public Coin getCoin() {
		return coin;
	}

    public boolean coinCollision(Rectangle sheep) {
        return coin.collides(sheep);
    }
}

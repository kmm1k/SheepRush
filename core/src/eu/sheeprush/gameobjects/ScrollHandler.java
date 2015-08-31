package eu.sheeprush.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class ScrollHandler {

	private Water water1, water2;
	private float gameHeight;
	
	public static final int SCROLL_SPEED = 200;
	//public static final int WB_GAP = -270;

	public ScrollHandler(float gameHeight) {
		water1 = new Water(0, 0, 180, 35, SCROLL_SPEED, gameHeight);
		Gdx.app.log("WaterObj", ""+water1);
		water2 = new Water(0, -1*gameHeight, 180, 35, SCROLL_SPEED, gameHeight);
		Gdx.app.log("WaterObj", ""+water2);
		this.gameHeight = gameHeight;
	}

	public void update(float delta) {
		water1.update(delta);
		water2.update(delta);
		if(water1.isScrolled()){
			water1.reset(-1*gameHeight);
		}
		else if(water2.isScrolled()){
			water2.reset(-1*gameHeight);
		}
	}
	
	public void stop() {
		water1.stop();
		water2.stop();
	}

	public Water getWater1() {
		return water1;
	}

	public Water getWater2() {
		return water2;
	}

	public boolean collides(Rectangle sheep){
		return ( water2.collides(sheep) || water1.collides(sheep));
	}

}

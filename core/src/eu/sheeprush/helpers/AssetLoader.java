package eu.sheeprush.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by karl on 29.08.2015.
 */
public class AssetLoader {

    private static TextureAtlas atlas;
    public static TextureRegion sheepFrame1, sheepFrame2, sheepJumpFrame;
    public static TextureRegion waterFrame1, waterFrame2, waterFrame3, waterFrame4;
    public static Animation sheepAnimation, waterAnimation;

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("textures/atlas.txt"));
        sheepFrame1 = atlas.createSprite("sheep4.1");
        sheepFrame2 = atlas.createSprite("sheep4.2");
        waterFrame1 = atlas.createSprite("vesitaust1");
        waterFrame2 = atlas.createSprite("vesitaust2");
        waterFrame3 = atlas.createSprite("vesitaust3");
        waterFrame4 = atlas.createSprite("vesitaust4");
        waterFrame1.flip(false, true);
        waterFrame2.flip(false, true);
        waterFrame3.flip(false, true);
        waterFrame4.flip(false, true);
        sheepJumpFrame = atlas.createSprite("sheep4.jump");


        TextureRegion[] sheep = {sheepFrame1, sheepFrame2};
        sheepAnimation = new Animation(0.10f, sheep);
        sheepAnimation.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] water = {waterFrame1, waterFrame2, waterFrame3, waterFrame4};
        waterAnimation = new Animation(0.06f, water);
        waterAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }

    public static void dispose() {
        atlas.dispose();
    }
}

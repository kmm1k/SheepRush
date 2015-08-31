package eu.sheeprush.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by karl on 29.08.2015.
 */
public class AssetLoader {

    private static TextureAtlas atlas;
    public static TextureRegion sheepFrame1, sheepFrame2, sheepJumpFrame;
    public static TextureRegion waterFrame1, waterFrame2, waterFrame3, waterFrame4;
    public static Animation sheepAnimation, waterAnimation;
    private static FreeTypeFontGenerator generator;
    private static FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    public static BitmapFont font20;

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

        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/triple_dot_digital-7.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        parameter.flip = true;
        parameter.genMipMaps = true;
        parameter.kerning = true;
        parameter.minFilter = Texture.TextureFilter.MipMapNearestNearest;
        parameter.magFilter = Texture.TextureFilter.MipMapNearestNearest;
        font20 = generator.generateFont(parameter);


        TextureRegion[] sheep = {sheepFrame1, sheepFrame2};
        sheepAnimation = new Animation(0.10f, sheep);
        sheepAnimation.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] water = {waterFrame1, waterFrame2, waterFrame3, waterFrame4};
        waterAnimation = new Animation(0.06f, water);
        waterAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }

    public static void dispose() {
        atlas.dispose();
        generator.dispose();
    }
}

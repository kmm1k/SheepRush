package eu.sheeprush.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
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

    public static TextureAtlas atlas;
    public static TextureRegion sheepFrame1, sheepFrame2, sheepJumpFrame;
    public static Animation sheepAnimation, waterAnimation;
    private static FreeTypeFontGenerator generator;
    private static FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    public static BitmapFont font20;
    public static BitmapFont font20buttons;
    public static TextureRegion waterBg;

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("textures/atlas.atlas"));
        sheepFrame1 = atlas.createSprite("sheep4.1");
        sheepFrame2 = atlas.createSprite("sheep4.2");
        waterBg = atlas.createSprite("water");
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
        parameter.color = Color.valueOf("489f9c");
        parameter.flip = false;
        parameter.borderWidth = 1;
        parameter.borderColor = Color.CYAN;
        font20buttons = generator.generateFont(parameter);

        TextureRegion[] sheep = {sheepFrame1, sheepFrame2};
        sheepAnimation = new Animation(0.10f, sheep);
        sheepAnimation.setPlayMode(Animation.PlayMode.LOOP);

    }

    public static void dispose() {
        atlas.dispose();
        generator.dispose();
    }
}

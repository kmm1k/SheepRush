package eu.sheeprush.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

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
    public static TextureRegion waterBg, coinTexture;
    public static Skin skin;
    public static BitmapFont scoreFont;
    private static BitmapFont buttonFont, labelFont;
    public static Sound pointGetSound;
    public static Sound gameOverSound;
    public static Sound swooshSound;


    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("textures/atlas.atlas"));
        skin = new Skin();
        createSprites();

        createFonts();
        skin.add("scoreFont", scoreFont, BitmapFont.class);
        skin.add("buttonFont", buttonFont, BitmapFont.class);
        skin.add("labelFont", labelFont, BitmapFont.class);
        skin.addRegions(atlas);
        skin.load(Gdx.files.internal("textures/defaultSkin.json"));


        TextureRegion[] sheep = {sheepFrame1, sheepFrame2};
        sheepAnimation = new Animation(0.10f, sheep);
        sheepAnimation.setPlayMode(Animation.PlayMode.LOOP);

        pointGetSound = Gdx.audio.newSound(Gdx.files.internal("sounds/point_get.ogg"));
        gameOverSound = Gdx.audio.newSound(Gdx.files.internal("sounds/game_over2.ogg"));
        swooshSound = Gdx.audio.newSound(Gdx.files.internal("sounds/swoosh.ogg"));

    }


    private static void createFonts() {
        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/triple_dot_digital-7.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        parameter.minFilter = Texture.TextureFilter.Nearest;
        parameter.magFilter = Texture.TextureFilter.Nearest;
        parameter.flip = true;
        scoreFont = generator.generateFont(parameter);
        parameter.flip = false;
        parameter.size = 20;
        parameter.borderWidth = 1;
        parameter.borderColor = Color.CYAN;
        buttonFont = generator.generateFont(parameter);
        parameter.size = 24;
        parameter.borderWidth = 1.4f;
        labelFont = generator.generateFont(parameter);
        generator.dispose();
    }

    private static void createSprites() {
        sheepFrame1 = atlas.createSprite("sheep4.1");
        sheepFrame2 = atlas.createSprite("sheep4.2");
        sheepJumpFrame = atlas.createSprite("sheep4.jump");
        waterBg = atlas.createSprite("water");
        coinTexture = atlas.createSprite("coin");
    }

    public static void dispose() {
        atlas.dispose();
        pointGetSound.dispose();
        gameOverSound.dispose();
    }
}

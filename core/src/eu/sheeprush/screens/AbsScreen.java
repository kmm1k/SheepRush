package eu.sheeprush.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;

import eu.sheeprush.SheepRush;
import eu.sheeprush.helpers.AssetLoader;

/**
 * Created by karl on 6.09.2015.
 */
public abstract class AbsScreen {

    private final OrthographicCamera cam;
    protected final FitViewport viewp;
    protected final float gameWidth;
    protected final float gameHeight;
    protected final Preferences prefs;
    protected int savedHighScore;
    protected final SheepRush sheepRush;
    protected final Skin skin;

    public AbsScreen(SheepRush sheepRush) {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        gameWidth = 540;
        gameHeight = screenHeight / (screenWidth / gameWidth);
        cam = new OrthographicCamera();
        cam.setToOrtho(false, gameWidth, gameHeight);
        viewp = new FitViewport(gameWidth, gameHeight, cam);
        this.sheepRush = sheepRush;
        skin = AssetLoader.skin;
        prefs = Gdx.app.getPreferences("preferences");
        savedHighScore = prefs.getInteger("score", 0);
    }

}

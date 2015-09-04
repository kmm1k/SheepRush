package eu.sheeprush.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import eu.sheeprush.SheepRush;
import eu.sheeprush.gameoverview.GameOverLogic;
import eu.sheeprush.gameoverview.GameOverRenderer;
import eu.sheeprush.helpers.AssetLoader;

/**
 * Created by karl on 31.08.2015.
 */
public class GameOverScreen implements Screen {

    private final Table table;
    private final Skin skin;
    private final TextButton buttonReplay;
    private final TextButton buttonMenu;
    private GameOverLogic gameOverLogic;
    private GameOverRenderer gameOverRenderer;
    private float runTime;
    private SheepRush sheepRush;
    private final Stage stage;

    public GameOverScreen(SheepRush sheepRush) {
        this.sheepRush = sheepRush;
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        skin = new Skin(AssetLoader.atlas);
        table = new Table(skin);
        table.setBounds(0, 0, screenWidth, screenHeight);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button.up");
        textButtonStyle.down = skin.getDrawable("button.down");
        textButtonStyle.pressedOffsetX = 5;
        textButtonStyle.font = AssetLoader.font20b;

        buttonReplay = new TextButton("Replay", textButtonStyle);
        buttonReplay.pad(20);

        buttonMenu = new TextButton("Menu", textButtonStyle);
        buttonMenu.pad(20);

        table.add(buttonReplay).space(10);
        table.row();
        table.add(buttonMenu).space(10);
        stage.addActor(table);
        Gdx.app.log("gameover", "made table");
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        buttonReplay.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                sheepRush.setScreen(new GameScreen(sheepRush));
                dispose();
            }
        });

        buttonMenu.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                sheepRush.setScreen(new MenuScreen(sheepRush));
                dispose();
            }
        });
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
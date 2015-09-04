package eu.sheeprush.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import eu.sheeprush.SheepRush;
import eu.sheeprush.helpers.AssetLoader;

/**
 * Created by karl on 31.08.2015.
 */
public class MenuScreen implements Screen {

    private final SheepRush sheepRush;
    private final Stage stage;
    private final Skin skin;
    private final Table table;
    private final TextButton buttonPlay;
    private final TextButton buttonExit;

    public MenuScreen(SheepRush sheepRush) {
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

        buttonPlay = new TextButton("Play", textButtonStyle);
        buttonPlay.pad(20);

        buttonExit = new TextButton("Exit", textButtonStyle);
        buttonExit.pad(20);

        table.add(buttonPlay).space(10);
        table.row();
        table.add(buttonExit).space(10);
        stage.addActor(table);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        buttonPlay.addListener(new InputListener() {
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
        buttonExit.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(100 / 255.0f, 22/ 255.0f, 75/ 255.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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

    }

}

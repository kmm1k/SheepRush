package eu.sheeprush.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import eu.sheeprush.SheepRush;
import eu.sheeprush.gameworld.GameRenderer;
import eu.sheeprush.helpers.AssetLoader;
import eu.sheeprush.helpers.GameScore;

/**
 * Created by karl on 31.08.2015.
 */
public class GameOverScreen extends AbsScreen implements Screen {

    private final Table table;
    private final TextButton buttonReplay;
    private final TextButton buttonMenu;
    private final Stage stage;
    private GameRenderer gameRenderer;

    public GameOverScreen(SheepRush sheepRush, GameRenderer gameRenderer) {
        super(sheepRush);
        this.gameRenderer = gameRenderer;

        if (GameScore.score > savedHighScore) {
            prefs.putInteger("score", GameScore.score);
            prefs.flush();
            savedHighScore = GameScore.score;
        }

        stage = new Stage(viewp);
        Gdx.input.setInputProcessor(stage);

        table = new Table(skin);
        table.setBounds(0, 0, gameWidth, gameHeight);


        buttonReplay = new TextButton("Replay", skin);
        buttonReplay.pad(10);

        buttonMenu = new TextButton("Menu", skin);
        buttonMenu.pad(10);

        float modalX = (gameWidth - (240 + (gameWidth - 240) / 1.5f)) / 2;
        float modalY = (gameHeight - (320 + (gameHeight - 320) / 2)) / 2;
        table.background(skin.getDrawable("modal"));
        table.setHeight(320 + (gameHeight - 320) / 2);
        table.setWidth(240 + (gameWidth - 240) / 1.5f);
        table.setX(modalX);
        table.setY(gameHeight);

        Label scoreLabel = new Label("Score : " + GameScore.score, skin);
        Label highScoreLabel = new Label("High score : " + savedHighScore, skin);
        table.add(highScoreLabel);
        table.row();
        table.add(scoreLabel);
        table.row();
        table.add(buttonReplay).prefWidth(gameWidth - 60).space(10);
        table.row();
        table.add(buttonMenu).prefWidth(gameWidth - 60).space(10);
        table.addAction(Actions.moveTo(modalX,
                modalY,
                0.7f, Interpolation.bounceOut));
        stage.addActor(table);
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
                AssetLoader.swooshSound.play();
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
        gameRenderer.render(delta);
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

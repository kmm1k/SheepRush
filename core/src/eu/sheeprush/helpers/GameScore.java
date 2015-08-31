package eu.sheeprush.helpers;

import com.badlogic.gdx.Gdx;

/**
 * Created by karl on 31.08.2015.
 */
public class GameScore {

    public static int score;

    public static void GameScore() {
        Gdx.app.log("GameScore", "started");
        score = 0;
    }
}

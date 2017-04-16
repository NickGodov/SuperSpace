package alina.glumenko.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alina on 03.04.2017.
 */
public class Star {
    private Vector2 position;
    private float speed;
    private float screenWidth;
    private float screenHeight;

    public Star() {
        screenHeight = Gdx.graphics.getHeight();
        screenWidth = Gdx.graphics.getWidth();
        position = new Vector2((float)Math.random() * screenWidth, (float)Math.random() * screenHeight);
        speed = Cfg.Star.INDEX_SPEED_FROM + (float)Math.random() + Cfg.Star.INDEX_SPEED_TO;
    }

    public void update() {
        position.x -= speed;
        if(position.x < -Cfg.Star.POSITION_X_LIMIT) {
            position.x = screenWidth;
            position.y = (float)Math.random() * screenHeight;
            speed = Cfg.Star.INDEX_SPEED_FROM + (float)Math.random() + Cfg.Star.INDEX_SPEED_TO;
        }
    }

    public Vector2 getPosition() {
        return position;
    }
}

package alina.glumenko.models.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alina on 03.04.2017.
 */
public class Star {
    private static final float INDEX_SPEED_FROM = 2.0f;
    private static final float INDEX_SPEED_TO = 8.0f;
    private static final int POSITION_X_LIMIT = 20;
    private Vector2 position;
    private float speed;
    private float screenWidth;
    private float screenHeight;

    public Star() {
        screenHeight = Gdx.graphics.getHeight();
        screenWidth = Gdx.graphics.getWidth();
        position = new Vector2((float)Math.random() * screenWidth, (float)Math.random() * screenHeight);
        speed = INDEX_SPEED_FROM + (float)Math.random() + INDEX_SPEED_TO;
    }

    public void update() {
        screenHeight = Gdx.graphics.getHeight();
        screenWidth = Gdx.graphics.getWidth();
        position.x -= speed;
        if(position.x < -POSITION_X_LIMIT) {
            position.x = screenWidth;
            position.y = (float)Math.random() * screenHeight;
            speed = INDEX_SPEED_FROM + (float)Math.random() + INDEX_SPEED_TO;
        }
    }

    public Vector2 getPosition() {
        return position;
    }
}

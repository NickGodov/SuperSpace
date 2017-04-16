package alina.glumenko.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alina on 26.03.2017.
 */
public class Bullet {
    private Vector2 position;
    private boolean active;

    public Vector2 getPosition() {
        return position;
    }

    public boolean isActive() {
        return active;
    }

    public Bullet() {
        position = new Vector2(0, 0);
        active = false;
    }

    public void destroy() {
        active = false;
    }

    public void setup(float x, float y) {
        position.x = x;
        position.y = y;
        active = true;
    }

    public void update() {
        position.x += Cfg.Bullet.SPEED;
        if(position.x > Gdx.graphics.getWidth()) {
            destroy();
        }
    }

    public float getWidth() {
        return Cfg.Bullet.DRAW_WIDTH;
    }

    public float getHeight() {
        return Cfg.Bullet.DRAW_HEIGHT;
    }
}

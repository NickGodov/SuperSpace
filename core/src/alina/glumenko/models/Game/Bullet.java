package alina.glumenko.models.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alina on 26.03.2017.
 */
public class Bullet {
    public static final int WIDTH = 32;
    public static final int HEIGHT = 18;
    private Vector2 position;
    private float speed = 12.0f;
    private boolean active;
    private Hero owner;

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

    public void setup(Hero owner, float x, float y) {
        this.owner = owner;
        position.x = x;
        position.y = y;
        active = true;
    }

    public void update() {
        position.x += speed;
        if(position.x > Gdx.graphics.getWidth()) {
            destroy();
        }
    }
}

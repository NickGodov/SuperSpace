package alina.glumenko.models.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alina on 26.03.2017.
 */
public class Asteroid {
    public static final float SIZE = 64;
    private static Texture texture;
    private Vector2 position;
    private float speed;
    private Rectangle rect;
    private float angle;
    private int maxHp;
    private int hp;

    public int getMaxHp() {
        return maxHp;
    }

    public Rectangle getRect() {
        return rect;
    }

    public Asteroid() {
        position = new Vector2((float)Math.random() * 1280 + 1280, (float)Math.random() * 720);
        speed = 3.0f + (float)Math.random() + 5.0f;
        angle = (float)Math.random() * 360.0f;
        if(texture == null) {
            texture = new Texture("asteroid64.png");
        }
        rect = new Rectangle(position.x, position.y, 64, 64);
        maxHp = 2 + (int)(Math.random() * 6);
        hp = maxHp;
    }

    public void recreate() {
        position.x = (float)Math.random() * 1280 + 1280;
        position.y = (float)Math.random() * 720;
        speed = 3.0f + (float)Math.random() + 5.0f;
        angle = (float)Math.random() * 360.0f;
        maxHp = 2 + (int)(Math.random() * 6);
        hp = maxHp;
    }

    public void render(SpriteBatch batch) {
        float scale = 0.4f + hp * 0.2f;
        batch.draw(texture, position.x, position.y, 32, 32, 64, 64, scale, scale, angle, 0, 0, 64, 64, false, false);
    }

    public void update() {
        position.x -= speed - hp * 0.4f;
        angle += speed / 2;
        if(position.x < -64) {
            recreate();
        }
        rect.x = position.x;
        rect.y = position.y;
    }

    public boolean takeDamage(int dmg) {
        hp -= dmg;
        if(hp <= 0) {
            recreate();
            return true;
        }
        return false;
    }

    public Vector2 getPosition() {
        return position;
    }
}

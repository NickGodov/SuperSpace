package alina.glumenko.models.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alina on 26.03.2017.
 */
public class Asteroid {
    public static final float SIZE = 64;
    private static final float INDEX_SPEED_FROM = 3.0f;
    private static final float INDEX_SPEED_TO = 5.0f;
    private static final float INDEX_SCALE = 0.2f;
    private static final float INDEX_WEIGHT = 0.4f;
    private static final int INDEX_MAXHP_FROM = 2;
    private static final int INDEX_MAXHP = 6;
    private static final float INDEX_ANGLE = 360.0f;
    private Vector2 position;
    private float speed;
    private Circle circle;
    private float angle;
    private float scale;
    private int maxHp;
    private int hp;
    private float screenWidth;
    private float screenHeight;

    public Asteroid() {
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        position = new Vector2((float)Math.random() * screenWidth + screenWidth, (float)Math.random() * screenHeight);
        speed = INDEX_SPEED_FROM + (float)Math.random() + INDEX_SPEED_TO;
        angle = (float)Math.random() * INDEX_ANGLE;
        maxHp = INDEX_MAXHP_FROM + (int)(Math.random() * INDEX_MAXHP);
        hp = maxHp;
        scale = INDEX_WEIGHT + hp * INDEX_SCALE;
        circle = new Circle(position.x, position.y, SIZE/2);
    }

    public void recreate() {
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        position.x = (float)Math.random() * screenWidth + screenWidth;
        position.y = (float)Math.random() * screenHeight;
        speed = INDEX_SPEED_FROM + (float)Math.random() + INDEX_SPEED_TO;
        angle = (float)Math.random() * INDEX_ANGLE;
        maxHp = INDEX_MAXHP_FROM + (int)(Math.random() * INDEX_MAXHP);
        hp = maxHp;
    }

    public void update() {
        position.x -= speed - hp * INDEX_WEIGHT;
        scale = INDEX_WEIGHT + hp * INDEX_SCALE;
        angle += speed / 2;
        if(position.x < -SIZE) {
            recreate();
        }
        circle.x = position.x;
        circle.y = position.y;
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

    public float getAngle() {
        return angle;
    }

    public float getScale() {
        return scale;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public Circle getCircle() {
        return circle;
    }
}

package alina.glumenko.models.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alina on 26.03.2017.
 */

public class Hero {
    private static final int HERO_WIDTH = 85;
    private static final int HERO_HEIGHT = 50;
    private final int BULLETS_COUNT = 200;
    public static Bullet[] bullets;
    private Vector2 position;
    private float speed;
    private int fireRate;
    private int fireCounter;
    private Rectangle rect;
    private int hp;
    private int score;

    public Vector2 getPosition() {
        return position;
    }

    public void addScore(int s) {
        score += s;
    }

    public int getScore() {
        return score;
    }

    public Rectangle getRect() {
        return rect;
    }

    public int getHp() {
        return hp;
    }

    public Hero() {

        position = new Vector2(100, 330);
        speed = 10.0f;
        fireRate = 8;
        hp = 15;
        score = 0;
        rect = new Rectangle(position.x, position.y, HERO_WIDTH, HERO_HEIGHT);
    }

    public boolean takeDamage(int dmg) {
        hp -= dmg;
        if (hp <= 0) {
            return true;
        }
        return false;
    }

    public void moveUp() {
        position.y += speed;
        if (position.y > Gdx.graphics.getHeight()) {
            position.y = -rect.getHeight();
        }

        rect.setPosition(position.x, position.y);
    }

    public void moveDown() {
        position.y -= speed;
        if (position.y < 0) {
            position.y = Gdx.graphics.getHeight();
        }

        rect.setPosition(position.x, position.y);
    }

    public void moveLeft() {
        position.x -= speed;
        if (position.x < 0) {
            position.x = 0;
        }

        rect.setPosition(position.x, position.y);
    }

    public void moveRight() {
        position.x += speed;
        if (position.x + rect.getWidth() > Gdx.graphics.getWidth()) {
            position.x = Gdx.graphics.getWidth() - rect.getWidth();
        }

        rect.setPosition(position.x, position.y);
    }

    public void moveTo(float x, float y) {
        if (x < position.x + 40) {
            position.x -= speed;
        }
        if (x > position.x + 40) {
            position.x += speed;
        }
        if (y < position.y + 30) {
            position.y -= speed;
        }
        if (y > position.y + 30) {
            position.y += speed;
        }

        rect.setPosition(position.x, position.y);
    }

    public void attack() {
        fireCounter++;
        if (fireCounter > fireRate) {
            fireCounter = 0;
            fire();
        }
    }

    public void fire() {
        for (int i = 0; i < bullets.length; i++) {
            if (!bullets[i].isActive()) {
                bullets[i].setup(this, position.x + 48, position.y + 24);
                break;
            }
        }
    }
}

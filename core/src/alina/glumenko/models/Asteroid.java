package alina.glumenko.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid extends PassiveUnit {
    private Vector2 position;
    private float speed;
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
        speed = Cfg.Asteroid.INDEX_SPEED_FROM + (float)Math.random() + Cfg.Asteroid.INDEX_SPEED_TO;
        angle = (float)Math.random() * Cfg.Asteroid.INDEX_ANGLE;
        maxHp = Cfg.Asteroid.INDEX_MAXHP_FROM + (int)(Math.random() * Cfg.Asteroid.INDEX_MAXHP);
        hp = maxHp;
        scale = Cfg.Asteroid.INDEX_WEIGHT + hp * Cfg.Asteroid.INDEX_SCALE;
        setHitbox(new Circle(position.x, position.y, Cfg.Asteroid.SIZE/2));
    }

    public void recreate() {
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        position.x = (float)Math.random() * screenWidth + screenWidth;
        position.y = (float)Math.random() * screenHeight;
        speed = Cfg.Asteroid.INDEX_SPEED_FROM + (float)Math.random() + Cfg.Asteroid.INDEX_SPEED_TO;
        angle = (float)Math.random() * Cfg.Asteroid.INDEX_ANGLE;
        maxHp = Cfg.Asteroid.INDEX_MAXHP_FROM + (int)(Math.random() * Cfg.Asteroid.INDEX_MAXHP);
        hp = maxHp;
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

    @Override
    public void updateUnit() {
        position.x -= speed - hp * Cfg.Asteroid.INDEX_WEIGHT;
        scale = Cfg.Asteroid.INDEX_WEIGHT + hp * Cfg.Asteroid.INDEX_SCALE;
        angle += speed / 2;
        if(position.x < -Cfg.Asteroid.SIZE) {
            recreate();
        }

        Circle c = (Circle) getHitbox();
        c.x = position.x;
        c.y = position.y;
    }
}

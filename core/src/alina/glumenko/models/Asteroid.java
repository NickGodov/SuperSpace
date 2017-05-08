package alina.glumenko.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid extends PassiveUnit {
    private float speed;
    private float angle;
    private float scale;
    private int maxHp;
    private int hp;

    public Asteroid() {
        init();
    }

    private void init() {
        speed = Cfg.Asteroid.INDEX_SPEED_FROM + (float) Math.random() + Cfg.Asteroid.INDEX_SPEED_TO;
        angle = (float) Math.random() * Cfg.Asteroid.INDEX_ANGLE;
        maxHp = Cfg.Asteroid.INDEX_MAXHP_FROM + (int) (Math.random() * Cfg.Asteroid.INDEX_MAXHP);
        hp = maxHp;
        scale = Cfg.Asteroid.INDEX_WEIGHT + hp * Cfg.Asteroid.INDEX_SCALE;

        Vector2 center = new Vector2((float) Math.random() * Gdx.graphics.getWidth() + Gdx.graphics.getWidth(), (float) Math.random() * Gdx.graphics.getHeight());
        setHitbox(new Circle(center, Cfg.Asteroid.SIZE / 2));
    }

    public void takeDamage(int dmg) {
        hp -= dmg;

        if (hp < 0) {
            init();
        }
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

        float x = getXPosition() - (speed - hp*Cfg.Asteroid.INDEX_WEIGHT);

        ((Circle) getHitbox()).setX(x);

        scale = Cfg.Asteroid.INDEX_WEIGHT + hp * Cfg.Asteroid.INDEX_SCALE;
        angle += speed / 2;

        if(getXPosition() < -Cfg.Asteroid.SIZE) {
            init();
        }
    }

    @Override
    public float getXPosition() {
        return ((Circle) getHitbox()).x;
    }

    @Override
    public float getYPosition() {
        return ((Circle) getHitbox()).y;
    }
}

package alina.glumenko.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hero extends GameUnit {
    private Bullet[] bullets;
    private int fireCounter;
    private int hp;
    private int score;

    public Hero() {
        score = 0;
        setHitbox(new Rectangle(100, 330, Cfg.Hero.HERO_WIDTH, Cfg.Hero.HERO_HEIGHT));
        bullets = new Bullet[Cfg.Hero.BULLETS_COUNT];
        createBullets();
    }

    private void createBullets() {
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }
    }

    public boolean takeDamage(int dmg) {
        hp -= dmg;

        return hp < 0;
    }

    public void moveUp() {
        float y = getYPosition() + Cfg.Hero.SPEED;

        if (y > Gdx.graphics.getHeight() - Cfg.Hero.HERO_HEIGHT)
            ((Rectangle) getHitbox()).setY(Gdx.graphics.getHeight() - Cfg.Hero.HERO_HEIGHT);
        else
            ((Rectangle) getHitbox()).setY(y);
    }

    public void moveDown() {
        float y = getYPosition() - Cfg.Hero.SPEED;
        ((Rectangle) getHitbox()).setY(Math.max(y, 0));
    }

    public void moveLeft() {
        float x = getXPosition() - Cfg.Hero.SPEED;
        ((Rectangle) getHitbox()).setX(Math.max(x, 0));
    }

    public void moveRight() {
        float x = getXPosition() + Cfg.Hero.SPEED;

        if (x > Gdx.graphics.getWidth() - Cfg.Hero.HERO_WIDTH)
            ((Rectangle) getHitbox()).setX(Gdx.graphics.getWidth() - Cfg.Hero.HERO_WIDTH);
        else
            ((Rectangle) getHitbox()).setX(x);
    }

    public void moveTo(float x, float y) {
        // Method stub
    }

    public void attack() {
        fireCounter++;
        if (fireCounter > Cfg.Hero.FIRE_RATE) {
            fireCounter = 0;
            fire();
        }
    }

    private void fire() {
        for (int i = 0; i < bullets.length; i++) {
            if (!bullets[i].isActive()) {
                bullets[i].setup(getXPosition() + Cfg.Hero.HERO_WIDTH, getYPosition() + Cfg.Hero.HERO_HEIGHT / 2);
                break;
            }
        }
    }

    @Override
    public float getXPosition() {
        return ((Rectangle) getHitbox()).getX();
    }

    @Override
    public float getYPosition() {
        return ((Rectangle) getHitbox()).getY();
    }

    public void addScore(int s) {
        score += s;
    }

    public int getScore() {
        return score;
    }

    public int getHp() {
        return hp;
    }

    public Bullet[] getBullets() {
        return bullets;
    }
}

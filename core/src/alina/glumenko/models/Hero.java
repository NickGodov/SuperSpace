package alina.glumenko.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hero extends GameUnit{
    private Bullet[] bullets;
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

    public Bullet[] getBullets() {
        return bullets;
    }

    public Hero() {
        position = new Vector2(100, 330);
        speed = Cfg.Hero.SPEED;
        fireRate = Cfg.Hero.FIRE_RATE;
        hp = Cfg.Hero.HP;
        score = 0;
        rect = new Rectangle(position.x, position.y, Cfg.Hero.HERO_WIDTH, Cfg.Hero.HERO_HEIGHT);
        bullets = new Bullet[Cfg.Hero.BULLETS_COUNT];
        createBullets();
    }

    private void createBullets() {
        for(int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }
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
        if (x < position.x + Cfg.Hero.HERO_WIDTH/2) {
            position.x -= speed;
        }
        if (x > position.x + Cfg.Hero.HERO_WIDTH/2) {
            position.x += speed;
        }
        if (y < position.y + Cfg.Hero.HERO_HEIGHT/2) {
            position.y -= speed;
        }
        if (y > position.y + Cfg.Hero.HERO_HEIGHT/2) {
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

    private void fire() {
        for (int i = 0; i < bullets.length; i++) {
            if (!bullets[i].isActive()) {
                bullets[i].setup(position.x + Cfg.Hero.HERO_WIDTH, position.y + Cfg.Hero.HERO_HEIGHT/2);
                break;
            }
        }
    }
}

package alina.glumenko.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends PassiveUnit{

    private boolean active;

    public boolean isActive() {
        return active;
    }

    public Bullet() {
        setHitbox(new Rectangle(0,0,1,1));
        active = false;
    }

    public void destroy() {
        active = false;
    }

    public void setup(float x, float y) {
        setHitbox(new Rectangle(x,y,1,1));
        active = true;
    }

    public float getWidth() {
        return Cfg.Bullet.DRAW_WIDTH;
    }

    public float getXPosition() {
        return ((Rectangle)getHitbox()).getX();
    }

    public float getYPosition() {
        return ((Rectangle)getHitbox()).getY();
    }

    public float getHeight() {
        return Cfg.Bullet.DRAW_HEIGHT;
    }

    @Override
    public void updateUnit() {
        Rectangle rect = (Rectangle) getHitbox();
        rect.setX(rect.getX() + Cfg.Bullet.SPEED);

        if (rect.getX() > Gdx.graphics.getWidth()) {
            destroy();
        }
    }
}

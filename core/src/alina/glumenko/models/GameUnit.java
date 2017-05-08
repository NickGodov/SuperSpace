package alina.glumenko.models;

import com.badlogic.gdx.math.Shape2D;

public abstract class GameUnit {

    private Shape2D hitbox;

    public Shape2D getHitbox() {
        return hitbox;
    }

    public void setHitbox(Shape2D hitbox) {
        this.hitbox = hitbox;
    }

}

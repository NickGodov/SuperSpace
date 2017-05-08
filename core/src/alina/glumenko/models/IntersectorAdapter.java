package alina.glumenko.models;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;

public class IntersectorAdapter {

    public static boolean overlaps(GameUnit object1, GameUnit object2) throws ClassNotFoundException {


        if (object1.getHitbox() instanceof Circle) {

            if (object2.getHitbox() instanceof Circle) {
                return Intersector.overlaps((Circle) object1.getHitbox(), (Circle) object2.getHitbox());
            }

            if (object2.getHitbox() instanceof Rectangle) {
                return Intersector.overlaps((Circle) object1.getHitbox(), (Rectangle) object2.getHitbox());
            }

        }

        if (object1.getHitbox() instanceof Rectangle && object2.getHitbox() instanceof Rectangle) {
                return Intersector.overlaps((Rectangle) object1.getHitbox(), (Rectangle) object2.getHitbox());
        }

        throw new ClassNotFoundException("Hitbox class is not valid!");
    }

}

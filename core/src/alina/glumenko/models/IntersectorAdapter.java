package alina.glumenko.models;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;

public class IntersectorAdapter {

    public static boolean overlaps(GameUnit object1, GameUnit object2) throws ClassNotFoundException {

        String c1 = object1.getHitbox().getClass().getName();
        String c2 = object2.getHitbox().getClass().getName();

        if (c1.equals("Circle")) {

            if (c2.equals("Circle")) {
                return Intersector.overlaps((Circle) object1.getHitbox(), (Circle) object2.getHitbox());
            }

            if (c2.equals("Rectangle")) {
                return Intersector.overlaps((Circle)object1.getHitbox(), (Rectangle) object2.getHitbox());
            }

        }

        if (c1.equals("Rectangle")) {
            if (c2.equals("Rectangle")) {
                return Intersector.overlaps((Circle)object1.getHitbox(), (Rectangle) object2.getHitbox());
            }
        }
        
        throw new ClassNotFoundException("Hitbox class is not valid!");
    }

}

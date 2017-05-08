package alina.glumenko.models;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

import java.util.*;

public class GameModel {

    private Hero hero;
    private Star[] stars;
    private List<Asteroid> asteroids;

    public GameModel() {
        restart();
    }

    /*
     * Вынесите в фабрику
     */
    private void createStars() {
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    /*
     * Вынесите в фабрику
     */
    private void createAsteroids() {
        asteroids = new ArrayList<Asteroid>();
        for (int i = 0; i < Cfg.GameModel.ASTEROIDS_COUNT; i++) {
            asteroids.add(new Asteroid());
        }
    }

    private void updateAsteroids() {
        for (int i = 0; i < asteroids.size(); i++) {

            asteroids.get(i).updateUnit();

            try {
                if (IntersectorAdapter.overlaps(asteroids.get(i), hero)) {

                    asteroids.get(i).takeDamage(Cfg.GameModel.DAMAGE);
                    hero.addScore(Cfg.GameModel.DAMAGE * asteroids.get(i).getMaxHp());

                    if (hero.takeDamage(Cfg.GameModel.DAMAGE)) {
                        restart();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateBullets() {
        Bullet[] bullets = hero.getBullets();
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive()) {
                bullets[i].updateUnit();

                for (Asteroid a : asteroids) {
                    try {
                        if (IntersectorAdapter.overlaps(a, bullets[i])) {
                            bullets[i].destroy();
                            a.takeDamage(Cfg.GameModel.DAMAGE);
                            hero.addScore(Cfg.GameModel.DAMAGE * a.getMaxHp());
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void updateStars() {
        for (int i = 0; i < stars.length; i++) {
            stars[i].update();
        }
    }

    public void update() {
        //update stars
        updateStars();

        //update bullets
        updateBullets();

        //update asteroids
        updateAsteroids();
    }

    public void restart() {
        this.hero = new Hero();
        createAsteroids();
        this.stars = new Star[Cfg.GameModel.STARS_COUNT];
        createStars();
    }

    //clear arrays
    public void dispose() {
        stars = new Star[0];
    }

    public Hero getHero() {
        return hero;
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public Star[] getStars() {
        return stars;
    }
}

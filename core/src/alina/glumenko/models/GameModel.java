package alina.glumenko.models;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

public class GameModel {

    private Hero hero;
    private Star[] stars;
    private Asteroid[] asteroids;

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
        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i] = new Asteroid();
        }
    }


    private void updateAsteroids() {
        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i].updateUnit();

            try {
                if (IntersectorAdapter.overlaps(asteroids[i], hero)) {
                    if (asteroids[i].takeDamage(Cfg.GameModel.DAMAGE)) {
                        hero.addScore(Cfg.GameModel.DAMAGE * asteroids[i].getMaxHp());
                    }
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
                for (int j = 0; j < asteroids.length; j++) {

                    try {
                        if (IntersectorAdapter.overlaps(asteroids[i], bullets[i])) {
                            bullets[i].destroy();
                            if (asteroids[j].takeDamage(Cfg.GameModel.DAMAGE)) {
                                hero.addScore(Cfg.GameModel.DAMAGE * asteroids[j].getMaxHp());
                            }
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
        this.asteroids = new Asteroid[Cfg.GameModel.ASTEROIDS_COUNT];
        createAsteroids();
        this.stars = new Star[Cfg.GameModel.STARS_COUNT];
        createStars();
    }

    //clear arrays
    public void dispose() {
        stars = new Star[0];
        asteroids = new Asteroid[0];
    }

    public Hero getHero() {
        return hero;
    }

    public Asteroid[] getAsteroids() {
        return asteroids;
    }

    public Star[] getStars() {
        return stars;
    }
}

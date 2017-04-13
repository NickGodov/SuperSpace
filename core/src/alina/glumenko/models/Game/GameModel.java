package alina.glumenko.models.Game;

import com.badlogic.gdx.math.Intersector;

/**
 * Created by Alina on 29.03.2017.
 */
public class GameModel {

    private static GameModel gameModel = new GameModel();
    private Hero hero;
    private static final int DAMAGE = 1;
    private static final int STARS_COUNT = 300;
    private Star[] stars;
    private final int ASTEROIDS_COUNT = 40;
    private Asteroid[] asteroids;

    public static GameModel getInstance() {
        return gameModel;
    }

    private GameModel() {
        restart();
    }

    private void createStars() {
        for(int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    private void createAsteroids() {
        for(int i = 0; i < asteroids.length; i++) {
            asteroids[i] = new Asteroid();
        }
    }

    private void updateAsteroids() {
        for(int i = 0; i < asteroids.length; i++) {
            asteroids[i].update();

            //check collision with hero
            if(Intersector.overlaps(asteroids[i].getCircle(), hero.getRect())) {
                if(asteroids[i].takeDamage(DAMAGE)) {
                    hero.addScore(DAMAGE * asteroids[i].getMaxHp());
                }
                if(hero.takeDamage(DAMAGE)) {
                    restart();
                }
            }
        }
    }

    private void updateBullets() {
        Bullet[] bullets = hero.getBullets();
        for(int i = 0; i < bullets.length; i++) {
            bullets[i].update();
            for(int j = 0; j < asteroids.length; j++) {
                if(asteroids[j].getCircle().contains(bullets[i].getPosition())) {
                    bullets[i].destroy();
                    if(asteroids[j].takeDamage(DAMAGE)) {
                        hero.addScore(DAMAGE * asteroids[j].getMaxHp());
                    }
                }
            }
        }
    }

    private void updateStars() {
        for(int i = 0; i < stars.length; i++) {
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
        this.asteroids = new Asteroid[ASTEROIDS_COUNT];
        createAsteroids();
        this.stars = new Star[STARS_COUNT];
        createStars();
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

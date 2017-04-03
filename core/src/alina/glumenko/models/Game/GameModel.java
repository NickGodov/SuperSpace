package alina.glumenko.models.Game;

/**
 * Created by Alina on 29.03.2017.
 */
public class GameModel {

    private Hero hero;
    private final int ASTEROIDS_COUNT = 40;
    private Asteroid[] asteroids;
    private float levelTime;

    private static final int STARS_COUNT = 300;
    private Star[] stars;

    public GameModel() {
        this.hero = new Hero();
        this.asteroids = new Asteroid[ASTEROIDS_COUNT];
        createAsteroids();
        this.stars = new Star[STARS_COUNT];
        createStars();
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

    public void update() {
        //update stars
//        for(int i = 0; i < stars.length; i++) {
//            stars[i].update();
//        }

        //update asteroids
        for(Asteroid asteroid : asteroids) {
            asteroid.update();
        }
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

package alina.glumenko.models.Game;

/**
 * Created by Alina on 29.03.2017.
 */
public class GameModel {

    private Hero hero;
    private final int ASTEROIDS_COUNT = 40;
    private Asteroid[] asteroids;
    private int level;
    private float levelTime;

    public GameModel() {
        this.hero = new Hero();
    }

    public Hero getHero() {
        return hero;
    }

    public void update(float delta) {

    }

    public Asteroid[] getAsteroids() {
        return asteroids;
    }
}

package alina.glumenko.models;

/**
 * Created by Alina on 16.04.2017.
 */
public class Cfg {

    public static class Asteroid {

        //side of texture
        public static final float SIZE = 64;

        //random speed
        public static final float INDEX_SPEED_FROM = 2.0f;
        public static final float INDEX_SPEED_TO = 4.0f;

        //random scale
        public static final float INDEX_SCALE = 0.2f;
        public static final float INDEX_WEIGHT = 0.4f;

        //random health
        public static final int INDEX_MAXHP_FROM = 2;
        public static final int INDEX_MAXHP = 6;

        public static final float INDEX_ANGLE = 180.0f;
    }

    public static class Bullet {
        public static final int WIDTH = 32;
        public static final int HEIGHT = 18;
        public static final float DRAW_WIDTH = WIDTH/3;
        public static final float DRAW_HEIGHT = HEIGHT/3;
        public static final float SPEED = 12.0f;
    }

    public static class GameModel {
        public static final int DAMAGE = 1;
        public static final int STARS_COUNT = 300;
        public static final int ASTEROIDS_COUNT = 40;
    }

    public static class Hero {
        public static final int HERO_WIDTH = 85;
        public static final int HERO_HEIGHT = 50;
        public static final int BULLETS_COUNT = 200;
        public static final float SPEED = 10.0f;
        public static final int FIRE_RATE = 8;
        public static final int HP = 3;
    }

    public static class Star {
        public static final float INDEX_SPEED_FROM = 2.0f;
        public static final float INDEX_SPEED_TO = 4.0f;
        public static final int POSITION_X_LIMIT = 20;
    }
}

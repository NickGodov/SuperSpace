package alina.glumenko.controllers;

import alina.glumenko.models.GameModel;
import alina.glumenko.models.Hero;
import alina.glumenko.screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by Alina on 26.03.2017.
 */
public class GameController {

    private GameModel model;
    private GameScreen gameScreen;
    private Hero hero;

    public GameController(GameModel model, GameScreen gameScreen) {
        this.model = model;
        this.gameScreen = gameScreen;
    }

    public void update(float delta) {
        hero = model.getHero();

        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            hero.moveUp();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            hero.moveDown();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            hero.moveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            hero.moveRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            hero.attack();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            gameScreen.switchPause();
        }
        if(Gdx.input.isTouched()) {
            hero.moveTo(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
        }
    }
}

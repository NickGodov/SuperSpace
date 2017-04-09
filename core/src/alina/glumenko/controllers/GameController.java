package alina.glumenko.controllers;

import alina.glumenko.models.Game.GameModel;
import alina.glumenko.models.Game.Hero;
import alina.glumenko.screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by Alina on 26.03.2017.
 */
public class GameController {

    private GameScreen gameScreen;
    private GameModel model;

    private static GameController gameController = new GameController();

    public static GameController getInstance() {
        return gameController;
    }

    private GameController() {
        this.model = GameModel.getInstance();
        this.gameScreen = GameScreen.getInstance();
    }

    public void update(float delta) {
        Hero hero = model.getHero();

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
            gameScreen.setPauseScreen();
        }
        if(Gdx.input.isTouched()) {
            hero.moveTo(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
        }
    }
}

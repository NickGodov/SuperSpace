package alina.glumenko.screens;


import alina.glumenko.SuperSpace;
import alina.glumenko.controllers.GameController;
import alina.glumenko.models.Game.GameModel;
import alina.glumenko.views.GameRender;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Alina on 29.03.2017.
 */
public class MenuScreen implements Screen {

    private SuperSpace game;
    private GameModel model;
    private GameRender render;
    private GameController controller;

    private static MenuScreen menuScreen = new MenuScreen();

    private MenuScreen() {
        this.game = SuperSpace.getInstance();
    }

    public static MenuScreen getInstance() {
        return menuScreen;
    }

    @Override
    public void show() {
        model = GameModel.getInstance();
        render = GameRender.getInstance();
        controller = GameController.getInstance();
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        controller.update(delta);
        render.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        Gdx.input.setCatchBackKey(false);
        render.dispose();
    }

    public void setGameScreen() {
        this.dispose();
        game.setScreen(game.game);
    }
}

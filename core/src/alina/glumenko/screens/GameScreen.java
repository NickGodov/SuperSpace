package alina.glumenko.screens;

import alina.glumenko.SuperSpace;
import alina.glumenko.controllers.GameController;
import alina.glumenko.models.GameModel;
import alina.glumenko.views.GameRender;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Alina on 29.03.2017.
 */
public class GameScreen implements Screen {

    private SuperSpace game;
    private GameModel model;
    private GameController controller;
    private GameRender render;

    public GameScreen(SuperSpace game) {
        this.game = game;
    }


    @Override
    public void show() {
        model = new GameModel();
        render = new GameRender(model);
        controller = new GameController(model, this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        controller.update(delta);
        model.update();
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
        this.dispose();
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        Gdx.input.setCatchBackKey(false);
        render.dispose();
    }

    public void setPauseScreen() {
        this.dispose();
        game.setScreen(new PauseScreen(game));
    }
}

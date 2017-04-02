package alina.glumenko.screens;

import alina.glumenko.SuperSpace;
import alina.glumenko.controllers.GameController;
import alina.glumenko.models.Game.GameModel;
import alina.glumenko.views.GameRender;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Alina on 29.03.2017.
 */
public class GameScreen implements Screen {

    private GameModel model;
    private GameController controller;
    private GameRender render;

    public GameScreen(SuperSpace superSpace) {
    }

    @Override
    public void show() {
        model = new GameModel();
        render = new GameRender(model);
        controller = new GameController(model);
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

    }

    @Override
    public void dispose() {

    }
}

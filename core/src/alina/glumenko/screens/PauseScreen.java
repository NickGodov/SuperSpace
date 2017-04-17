package alina.glumenko.screens;

import alina.glumenko.SuperSpace;
import alina.glumenko.controllers.PauseController;
import alina.glumenko.views.PauseRender;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Alina on 08.04.2017.
 */
public class PauseScreen implements Screen {

    private SuperSpace game;
    private PauseRender render;
    private PauseController controller;

    public PauseScreen(SuperSpace game) {
        this.game = game;
    }

    @Override
    public void show() {
        render = new PauseRender();
        controller = new PauseController(render, game);
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
        this.dispose();
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        Gdx.input.setCatchBackKey(false);
        render.dispose();
    }
}

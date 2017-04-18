package alina.glumenko.screens;

import alina.glumenko.SuperSpace;
import alina.glumenko.controllers.MenuController;
import alina.glumenko.views.MenuRender;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Alina on 29.03.2017.
 */
public class MenuScreen implements Screen {

    private SuperSpace game;
    private MenuRender render;
    private MenuController controller;

    public MenuScreen(SuperSpace game) {
        this.game = game;
    }

    @Override
    public void show() {
        render = new MenuRender();
        controller = new MenuController(render, this);
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

    public void setGameScreen() {
        this.dispose();
        game.setScreen(new GameScreen(game));
    }

    public void setCatalogScreen() {
        this.dispose();
        game.setScreen(new GameScreen(game));
    }

    public void setHelpScreen() {
        this.dispose();
        game.setScreen(new GameScreen(game));
    }
}

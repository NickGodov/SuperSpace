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
public class MenuScreen implements Screen, InputProcessor {

    SuperSpace game;
    private GameModel model;
    private GameRender render;
    private GameController controller;
    private SpriteBatch batch;
    private BitmapFont fnt;
    private Texture bgtexture;

    public MenuScreen(SuperSpace superSpace) {
        this.game = superSpace;
    }

    @Override
    public void show() {
        model = GameModel.getInstance();
        render = GameRender.getInstance();
        controller = GameController.getInstance();
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);
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

    @Override
    public boolean keyDown(int keycode) {
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.BACK) {
            this.dispose();
            game.setScreen(game.menu);
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

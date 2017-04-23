package alina.glumenko.screens;

import alina.glumenko.SuperSpace;
import alina.glumenko.controllers.GameController;
import alina.glumenko.controllers.PauseController;
import alina.glumenko.models.GameModel;
import alina.glumenko.views.GameRender;
import alina.glumenko.views.PauseRender;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Alina on 29.03.2017.
 */
public class GameScreen implements Screen {

    private SuperSpace game;
    private GameModel gameModel;
    private GameController gameController;
    private GameRender gameRender;
    private PauseRender pauseRender;
    private PauseController pauseController;
    private State state = State.UNPAUSED;

    public GameScreen(SuperSpace game) {
        this.game = game;
    }

    @Override
    public void show() {
        gameModel = new GameModel();
        gameRender = new GameRender(gameModel);
        gameController = new GameController(gameModel, this);

        pauseRender = new PauseRender();
        pauseController = new PauseController(pauseRender, this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        switch (state) {
            case UNPAUSED:
                gameModel.update();
                gameController.update(delta);
                gameRender.render();
                break;
            case PAUSED:
                pauseRender.render();
                break;
            default:
                state = State.UNPAUSED;
                break;
        }
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
        gameRender.dispose();
        gameModel.dispose();
        pauseRender.dispose();
    }

    public void setMenuScreen() {
        this.dispose();
        game.setScreen(game.menuScreen);
    }

    public void switchPause() {
        switch (state) {
            case PAUSED:
                state = State.UNPAUSED;
                break;
            case UNPAUSED:
                state = State.PAUSED;
                break;
            default:
                state = State.UNPAUSED;
                break;
        }
    }

    private enum State { PAUSED, UNPAUSED }
}

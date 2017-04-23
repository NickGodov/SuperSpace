package alina.glumenko.controllers;

import alina.glumenko.screens.GameScreen;
import alina.glumenko.views.PauseRender;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Alina on 17.04.2017.
 */
public class PauseController {

    private PauseRender render;
    private GameScreen gameScreen;

    public PauseController(PauseRender render, GameScreen gameScreen) {
        this.render = render;
        this.gameScreen = gameScreen;
        createButtonListeners();
    }

    public void createButtonListeners() {

        render.getButtons().get("Resume").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameScreen.switchPause();
            }
        });

        render.getButtons().get("Menu").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameScreen.setMenuScreen();
            }
        });
    }
}

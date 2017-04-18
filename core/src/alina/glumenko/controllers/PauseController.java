package alina.glumenko.controllers;

import alina.glumenko.SuperSpace;
import alina.glumenko.screens.GameScreen;
import alina.glumenko.screens.MenuScreen;
import alina.glumenko.screens.PauseScreen;
import alina.glumenko.views.PauseRender;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.Map;

/**
 * Created by Alina on 17.04.2017.
 */
public class PauseController {
    private PauseRender render;
    private Map<String, TextButton> buttons;

    private PauseScreen pauseScreen;

    public PauseController(PauseRender render, PauseScreen pauseScreen) {
        this.render = render;
        this.pauseScreen = pauseScreen;
        buttons = render.getButtons();

    }

    public void update(float delta) {

        buttons.get("Resume").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pauseScreen.setGameScreen();
            }
        });

        buttons.get("Menu").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pauseScreen.setMenuScreen();
            }
        });
    }
}

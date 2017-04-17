package alina.glumenko.controllers;

import alina.glumenko.SuperSpace;
import alina.glumenko.screens.GameScreen;
import alina.glumenko.screens.MenuScreen;
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
    private SuperSpace game;
    private Map<String, TextButton> buttons;

    public PauseController(PauseRender render, SuperSpace game) {
        this.render = render;
        this.game = game;
    }

    public void update(float delta) {
        buttons = render.getButtons();

        buttons.get("Resume").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        buttons.get("Menu").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });
    }
}

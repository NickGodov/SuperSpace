package alina.glumenko.controllers;


import alina.glumenko.SuperSpace;
import alina.glumenko.screens.GameScreen;
import alina.glumenko.views.MenuRender;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.Map;

/**
 * Created by Alina on 08.04.2017.
 */
public class MenuController {

    private MenuRender render;
    private SuperSpace game;
    private Map<String, TextButton> buttons;

    public MenuController(MenuRender render, SuperSpace game) {
        this.render = render;
        this.game = game;
    }

    public void update(float delta) {
        buttons = render.getButtons();

        buttons.get("Start").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        buttons.get("Catalog").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        buttons.get("Help").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        buttons.get("Exit").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });
    }
}

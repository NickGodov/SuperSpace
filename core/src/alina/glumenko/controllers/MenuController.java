package alina.glumenko.controllers;

import alina.glumenko.screens.GameScreen;
import alina.glumenko.screens.MenuScreen;
import alina.glumenko.views.MenuRender;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.Map;

/**
 * Created by Alina on 08.04.2017.
 */
public class MenuController {

    private MenuRender render;
    private MenuScreen menuScreen;
    private Map<String, TextButton> buttons;

    public MenuController(MenuRender render, MenuScreen menuScreen) {
        this.render = render;
        this.menuScreen = menuScreen;
        buttons = render.getButtons();
    }

    public void update(float delta) {

        buttons.get("Start").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuScreen.setGameScreen();
            }
        });

        buttons.get("Catalog").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuScreen.setCatalogScreen();
            }
        });

        buttons.get("Help").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuScreen.setHelpScreen();
            }
        });

        buttons.get("Exit").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }
}

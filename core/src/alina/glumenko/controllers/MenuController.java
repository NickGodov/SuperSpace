package alina.glumenko.controllers;

import alina.glumenko.screens.MenuScreen;
import alina.glumenko.views.MenuRender;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Alina on 08.04.2017.
 */
public class MenuController {

    private MenuRender render;
    private MenuScreen menuScreen;

    public MenuController(MenuRender render, MenuScreen menuScreen) {
        this.render = render;
        this.menuScreen = menuScreen;
        createButtonListeners();
    }

    public void createButtonListeners() {

        render.getButtons().get("Start").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuScreen.setGameScreen();
            }
        });

        render.getButtons().get("Catalog").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuScreen.setCatalogScreen();
            }
        });

        render.getButtons().get("Help").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuScreen.setHelpScreen();
            }
        });

        render.getButtons().get("Exit").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }
}

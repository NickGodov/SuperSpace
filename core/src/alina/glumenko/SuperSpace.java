package alina.glumenko;

import alina.glumenko.screens.GameScreen;
import alina.glumenko.screens.MenuScreen;
import com.badlogic.gdx.Game;

/**
 * Created by Alina on 29.03.2017.
 */
public class SuperSpace extends Game {

    public GameScreen game;
    public MenuScreen menu;

    @Override
    public void create() {
        game = new GameScreen(this);
        menu = new MenuScreen(this);
        setScreen(menu);
    }

    @Override
    public void render() {
        super.render();
    }
}

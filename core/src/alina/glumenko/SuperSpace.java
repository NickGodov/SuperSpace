package alina.glumenko;

import alina.glumenko.screens.GameScreen;
import alina.glumenko.screens.MenuScreen;
import com.badlogic.gdx.Game;

/**
 * Created by Alina on 29.03.2017.
 */
public class SuperSpace extends Game {

    public MenuScreen menuScreen;
    public GameScreen gameScreen;

    @Override
    public void create() {
        gameScreen = new GameScreen(this);
        menuScreen =  new MenuScreen(this);
        setScreen(menuScreen);
    }

    @Override
    public void render() {
        super.render();
    }
}

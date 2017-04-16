package alina.glumenko;

import alina.glumenko.screens.GameScreen;
import alina.glumenko.screens.MenuScreen;
import alina.glumenko.screens.PauseScreen;
import com.badlogic.gdx.Game;

/**
 * Created by Alina on 29.03.2017.
 */
public class SuperSpace extends Game {

    public GameScreen game;
    public MenuScreen menu;
    public PauseScreen pause;

    private static SuperSpace superSpace = new SuperSpace();

    public static SuperSpace getInstance() {
        return superSpace;
    }

    @Override
    public void create() {
        game = GameScreen.getInstance();
        menu =  MenuScreen.getInstance();
        pause =  PauseScreen.getInstance();
        setScreen(game);
    }

    @Override
    public void render() {
        super.render();
    }
}

package alina.glumenko.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Alina on 09.04.2017.
 */
public class MenuRender {

    private static MenuRender menuRender = new MenuRender();
    private Stage stage;
    private Skin skin;
    private Texture bkg;
    private TextButton startButton;
    private TextButton exitButton;
    private TextButton catalogButton;
    private TextButton helpButton;
    private Map<String, TextButton> buttons;

    public static MenuRender getInstance() {
        return menuRender;
    }

    private MenuRender() {
        buttons = new LinkedHashMap<String, TextButton>();
        stage = new Stage();
        fillStage();
        createBkg();
        Gdx.input.setInputProcessor(stage);
    }

    private void fillStage() {
        createButtons();
        stage.addActor(startButton);
        stage.addActor(catalogButton);
        stage.addActor(helpButton);
        stage.addActor(exitButton);
    }

    private void createBkg() {
        Pixmap pixmap = new Pixmap( Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);
        pixmap.setColor(8/255f, 49/255f, 66/255f, 1.0f);
        pixmap.fillRectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bkg = new Texture(pixmap);
    }

    private void createButtons() {
        int margin = 10;
        int i = 0;

        createSkin();
        startButton = new TextButton("Start", skin);
        catalogButton = new TextButton("Catalog", skin);
        helpButton = new TextButton("Help", skin);
        exitButton = new TextButton("Exit", skin);

        //create dictionary
        buttons.put(startButton.getText().toString(), startButton);
        buttons.put(catalogButton.getText().toString(), catalogButton);
        buttons.put(helpButton.getText().toString(), helpButton);
        buttons.put(exitButton.getText().toString(), exitButton);

        //set positions
        for (TextButton button : buttons.values()) {
            button.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , Gdx.graphics.getHeight()/2 - i * margin - i * Gdx.graphics.getHeight()/10);
            i++;
        }
    }

    private void createSkin() {
        //create font
        BitmapFont font = new BitmapFont();
        skin = new Skin();
        skin.add("default", font);

        //create texture for button
        Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/10, Pixmap.Format.RGB888);
        pixmap.setColor(8/255f, 49/255f, 66/255f, 1.0f);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        //create button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);
    }

    public void  render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().begin();
        stage.getBatch().draw(bkg, 0, 0);
        stage.getBatch().end();
        stage.act();
        stage.draw();
    }

    public void dispose() {
        try {
            stage.getBatch().dispose();
            bkg.dispose();
        } catch (Exception e) {

        }
    }

    public Map<String, TextButton> getButtons() {
        return buttons;
    }
}

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
 * Created by Alina on 17.04.2017.
 */
public class PauseRender {

    private Stage stage;
    private Skin skin;
    private Texture bkg;
    private TextButton resumeButton;
    private TextButton menuButton;
    private Map<String, TextButton> buttons;


    public PauseRender() {
        buttons = new LinkedHashMap<String, TextButton>();
        stage = new Stage();
        fillStage();
        createBkg();
        Gdx.input.setInputProcessor(stage);
    }

    private void fillStage() {
        createButtons();
        stage.addActor(resumeButton);
        stage.addActor(menuButton);
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
        resumeButton = new TextButton("Resume", skin);
        menuButton = new TextButton("Menu", skin);

        //create dictionary
        buttons.put(resumeButton.getText().toString(), resumeButton);
        buttons.put(menuButton.getText().toString(), menuButton);

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

        //colors
        Color lightPink = new Color(245/255f, 170/255f, 190/255f, 1.0f);
        Color darkPink = new Color(200/255f, 130/255f, 160/255f, 1.0f);
        Color pink = new Color(255/255f, 130/255f, 160/255f, 1.0f);

        //create texture for button
        Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/10, Pixmap.Format.RGB888);
        pixmap.setColor(pink);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        //create button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", pink);
        textButtonStyle.down = skin.newDrawable("background", darkPink);
        textButtonStyle.checked = skin.newDrawable("background", darkPink);
        textButtonStyle.over = skin.newDrawable("background", lightPink);
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
            skin.dispose();
        } catch (Exception e) {

        }
    }

    public Map<String, TextButton> getButtons() {
        return buttons;
    }
}

package alina.glumenko.views;

import alina.glumenko.models.Game.Asteroid;
import alina.glumenko.models.Game.GameModel;
import alina.glumenko.models.Game.Star;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Alina on 26.03.2017.
 */
public class GameRender {

    private GameModel model;

    private SpriteBatch batch;
    private Texture bkg;
    private Texture textureBullet;
    private Texture textureAstr;
    private Texture textureStar;
    private BitmapFont fnt;
    private Texture textureHero;

    public GameRender(GameModel model) {

        batch = new SpriteBatch();
        this.model = model;

        loadTextures();
    }

    private void loadTextures() {
        textureHero = new Texture("ship85x50.png");
        textureAstr = new Texture("asteroid64.png");
        textureBullet = new Texture("bullet32x18.png");
        createBkg();
    }

    public void  render() {
        batch.begin();
        model.update();
        drawBkg();
        drawAsteroids();
        drawHero();
        drawUI();
        batch.end();
    }

    private void createBkg() {
        Pixmap pixmap = new Pixmap( Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);
        pixmap.setColor(35/255f, 21/255f, 34/255f, 1.0f);
        pixmap.fillRectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bkg = new Texture(pixmap);
    }

    private void createStar() {
        int starSize = 5;
        Pixmap pixmap = new Pixmap( Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fillCircle(0, 0, starSize);
        textureStar = new Texture(pixmap);
    }

    private void drawBkg(){
        batch.draw(bkg, 0 , 0);
//        for(Star star : model.getStars()) {
//            batch.draw(textureStar, star.getPosition().x, star.getPosition().y);
//        }
    }

    private void drawUI() {

    }

    private void drawAsteroids() {
        for(Asteroid asteroid : model.getAsteroids()) {
            batch.draw(textureAstr, asteroid.getPosition().x, asteroid.getPosition().y,
                        asteroid.SIZE/2, asteroid.SIZE/2,
                        asteroid.SIZE, asteroid.SIZE,
                        asteroid.getScale(), asteroid.getScale(),
                        asteroid.getAngle(), 0, 0,
                        (int)asteroid.SIZE, (int)asteroid.SIZE, false, false);
        }
    }

    private void drawHero() {
        batch.draw(textureHero, model.getHero().getPosition().x, model.getHero().getPosition().y, model.getHero().getRect().width, model.getHero().getRect().height);
    }

    public void dispose() {
        try {
            batch.dispose();
            textureHero.dispose();
            textureAstr.dispose();
            textureBullet.dispose();
            bkg.dispose();
        } catch (Exception e) {

        }
    }

}

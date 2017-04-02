package alina.glumenko.views;

import alina.glumenko.models.Game.Asteroid;
import alina.glumenko.models.Game.GameModel;
import alina.glumenko.models.Game.Hero;
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
    }

    public void  render() {
        Hero hero = model.getHero();
        batch.begin();
        drawBkg();
        drawAsteroids();
        drawHero();
        batch.end();
    }

    private void drawBkg(){

    }

    private void drawAsteroids() {
//        for(Asteroid asteroid : model.getAsteroids()) {
//            batch.draw(textureAstr, asteroid.getPosition().x, asteroid.getPosition().y, asteroid.SIZE, asteroid.SIZE);
//        }
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

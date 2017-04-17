package alina.glumenko.views;

import alina.glumenko.models.*;
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

    private BitmapFont font;
    private GameModel model;
    private SpriteBatch batch;
    private Texture bkg;
    private Texture textureBullet;
    private Texture textureAstr;
    private Texture textureStar;
    private Texture textureHP;
    private Texture texturePoint;
    private Texture textureBonusHP;
    private Texture textureBonusPoint;
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
        textureHP = new Texture("health.png");
        texturePoint = new Texture("point.png");
        textureBonusHP = new Texture("bonus-health.png");
        textureBonusPoint = new Texture("bonus-point.png");

        createBkg();
        createStar();
        createFont();
    }

    public void  render() {
        batch.begin();
        drawBkg();
        drawStars();
        drawAsteroids();
        drawHero();
        drawBullets();
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
        int starSize = 1;
        Pixmap pixmap = new Pixmap(5, 5, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fillCircle(0, 0, starSize);
        textureStar = new Texture(pixmap);
    }

    private void createFont() {
        font = new BitmapFont();
        font.setColor(Color.WHITE);
    }

    private void drawBkg(){
        batch.draw(bkg, 0 , 0);
    }

    private void drawUI() {
        int padding = 10;
        int distBetween = 5;
        int margin = textureHP.getWidth() + distBetween;
        int scoreX = padding * 2 + texturePoint.getWidth();
        int scoreY = padding * 2 + textureHP.getHeight() + texturePoint.getHeight()/2;


        for(int i = 0; i < model.getHero().getHp(); i++) {
            batch.draw(textureHP, 0 + i * margin + padding, padding);
        }
        batch.draw(texturePoint, padding, padding * 2 + textureHP.getHeight());
        font.draw(batch, "" + model.getHero().getScore(), scoreX, scoreY);
    }

    private void drawAsteroids() {
        for(Asteroid asteroid : model.getAsteroids()) {
            batch.draw(textureAstr, asteroid.getPosition().x - Cfg.Asteroid.SIZE/2, asteroid.getPosition().y - Cfg.Asteroid.SIZE/2,
                    Cfg.Asteroid.SIZE/2, Cfg.Asteroid.SIZE/2,
                    Cfg.Asteroid.SIZE, Cfg.Asteroid.SIZE,
                        asteroid.getScale(), asteroid.getScale(),
                        asteroid.getAngle(), 0, 0,
                        (int)Cfg.Asteroid.SIZE, (int)Cfg.Asteroid.SIZE, false, false);
        }
    }

    private void drawHero() {
        batch.draw(textureHero, model.getHero().getPosition().x, model.getHero().getPosition().y, model.getHero().getRect().width, model.getHero().getRect().height);
    }

    private void drawBullets() {
        for(Bullet bullet : model.getHero().getBullets()) {
            if(bullet.isActive()) {
                batch.draw(textureBullet, bullet.getPosition().x - Cfg.Bullet.WIDTH/2, bullet.getPosition().y - Cfg.Bullet.HEIGHT/2, bullet.getWidth(), bullet.getHeight());
            }
        }
    }

    private void drawStars() {
        for(Star star : model.getStars()) {
            batch.draw(textureStar, star.getPosition().x, star.getPosition().y);
        }
    }

    public void dispose() {
        try {
            batch.dispose();
            textureHero.dispose();
            textureAstr.dispose();
            textureBullet.dispose();
            font.dispose();
            bkg.dispose();
            textureStar.dispose();
            textureHP.dispose();
            texturePoint.dispose();
            textureBonusHP.dispose();
            textureBonusPoint.dispose();
            textureHero.dispose();
        } catch (Exception e) {

        }
    }

}

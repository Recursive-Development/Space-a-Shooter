package com.shako.spaceshooter.screens.game;

// --- libGDX ---
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// --- Customs ---
import com.shako.game.engine.Base2DScreen;

/**
 *
 * @author Timur Kashapov
 */

public class GameScreen extends Base2DScreen {

    /** */
    private SpriteBatch batch;

    /** */
    private Sprite heroShip;

    /** */
    private Texture texture;

    /** */
    private float
            dvx    = -0.15f,
            dvy    = -1.0f;

    /** Фоновое изображение для экрана игры. */
    private Texture bkgd;

    /** */
    private BitmapFont font = new BitmapFont();

    /**
     *
     * @param game libGDX Game class
     */
    public GameScreen(Game game) {
        super(game);

        batch = new SpriteBatch();
        batch.getProjectionMatrix().idt();

        texture = new Texture(Gdx.files.internal("android/assets/heroship.gif"));

        heroShip = new Sprite(texture);

        bkgd     = new Texture(Gdx.files.internal("android/assets/space/a.jpg"));

    }

    @Override
    public void render(float delta) {
         super.render(delta);


        if ( Gdx.input.isKeyPressed(Input.Keys.UP) )    dvy += 0.03f;
        if ( Gdx.input.isKeyPressed(Input.Keys.DOWN) )  dvy -= 0.03f;
        if ( Gdx.input.isKeyPressed(Input.Keys.LEFT) )  dvx -= 0.03f;
        if ( Gdx.input.isKeyPressed(Input.Keys.RIGHT) ) dvx += 0.03f;

        // gl - Interface wrapping all the methods of OpenGL ES
        //
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(bkgd, -1.0f, -1.0f, 2.0f, 2.0f);
        batch.draw(heroShip, dvx, dvy, 0.3f, 0.3f);
        //System.out.printf("heroship coordinates [%.1f %.1f]\n", heroShip.getOriginX(), heroShip.getOriginY());

        batch.end();


    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void dispose() {

        batch.dispose();
        super.dispose();
    }
}

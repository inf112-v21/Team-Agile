package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.skeleton.app.RoboRally;

public class WinGameScreen implements Screen{

        public int playerIdwon;

        private SpriteBatch batch;
        private BitmapFont font;
        public String text;


        public WinGameScreen(StartGame,int id) {
            this.playerIdwon = id;

        }

        @Override
        public void show() {
            font = new BitmapFont();
            text = Integer.toString(playerIdwon);

        }

        @Override
        public void render(float v) {
            Gdx.gl.glClearColor(1, 1, 1, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            batch.begin();
            font.draw(batch, text, 300, 300);
            batch.end();

        }

        @Override
        public void resize(int i, int i1) {

        }

        @Override
        public void pause() {

        }

        @Override
        public void resume() {

        }

        @Override
        public void hide() {

        }

        @Override
        public void dispose() {

        }
    }


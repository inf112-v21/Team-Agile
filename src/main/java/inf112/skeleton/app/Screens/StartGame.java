package inf112.skeleton.app.Screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.skeleton.app.MainMenu;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.Screens.MultiplayerScreen;

public class StartGame extends Game implements ApplicationListener {

    private MainMenu mainMenu;
    private RoboRally gameScreen;
    private MultiplayerScreen multiplayerScreen;
    public SpriteBatch batch;
    public BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();

        setMainMenuScreen();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
            setGameScreen();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            setMainMenuScreen();
        }

        super.render();


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    public void setMainMenuScreen() {
        mainMenu = new MainMenu(this);
        dispose();
        this.setScreen(mainMenu);
    }

    public void setGameScreen(){
        gameScreen = new RoboRally("MapNumber1.tmx", false);
        dispose();
        this.setScreen(gameScreen);
    }

    public void hostGameScreen(int players) {
        gameScreen = new RoboRally("MapNumber1.tmx", true , players);
        dispose();
        this.setScreen(gameScreen);
    }

    public void setMultiplayerScreen(){
        multiplayerScreen = new MultiplayerScreen(this);
        dispose();
        this.setScreen(multiplayerScreen);

    }
}

package inf112.skeleton.app;

import com.badlogic.gdx.*;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenu extends InputAdapter implements Screen {

    private SpriteBatch batch;
    protected Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    private TextureAtlas atlas;
    //protected Skin skin;

    private GameCamera cam;

    private static final int MAINMENU_WIDTH = 500;
    private static final int MAINMENU_HEIGHT = 1500;

    private static final int EXIT_BUTTON_WIDTH = 250;
    private static final int EXIT_BUTTON_HEIGHT = 120;
    private static final int EXIT_BUTTON_Y = 100;
    private static final int MULTIPLAYER_BUTTON_WIDTH = 300;
    private static final int MULTIPLAYER_BUTTON_HEIGHT = 120;
    private static final int MULTIPLAYER_BUTTON_Y = 230;

    private static final int LOGO_WIDTH = 200;
    private static final int LOGO_HEIGHT = 125;
    private static final int LOGO_Y = 450;

    //final RoboRally game;

    Texture MultiplayerButtonActive;
    Texture BackgroundImage;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture StartGameImage;
    Texture ExitGameImage;

    Texture logo;

    private StartGame game;

    public MainMenu(StartGame game){
        this.game = game;
        batch = new SpriteBatch();

        StartGameImage = new Texture("assets/Start_Game.png");
        BackgroundImage = new Texture("assets/background1.png");
        ExitGameImage = new Texture("assets/Exit_game.png");

        Gdx.input.setInputProcessor(this);


    /*
		MultiplayerButtonActive = new Texture("play_button_active.png");
		MultiplayerButtonInactive = new Texture("play_button_inactive.png");
		exitButtonActive = new Texture("exit_button_active.png");
		exitButtonInactive = new Texture("exit_button_inactive.png");
		logo = new Texture("logo.png");

		//game.scrollingBackground.setSpeedFixed(true);
		//game.scrollingBackground.setSpeed(ScrollingBackground.DEFAULT_SPEED);

		final MainMenu mainMenuScreen = this;



		Gdx.input.setInputProcessor(new InputAdapter() {

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				//Exit button
				//int x = SpaceGame.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;
                int x = MAINMENU_WIDTH / 2 - EXIT_BUTTON_WIDTH;
				if (cam.getInputInGameWorld().x < x + EXIT_BUTTON_WIDTH && cam.getInputInGameWorld().x > x &&
                        MAINMENU_HEIGHT - cam.getInputInGameWorld().y < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT &&
                        MAINMENU_HEIGHT - cam.getInputInGameWorld().y > EXIT_BUTTON_Y) {
					mainMenuScreen.dispose();
					Gdx.app.exit();
				}

				//Play game button
				//x = SpaceGame.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;
                x = MAINMENU_WIDTH / 2 - MULTIPLAYER_BUTTON_WIDTH;
				if (cam.getInputInGameWorld().x < x + MULTIPLAYER_BUTTON_Y &&
                        cam.getInputInGameWorld().x > x &&
                        MAINMENU_HEIGHT - cam.getInputInGameWorld().y < MULTIPLAYER_BUTTON_Y + MULTIPLAYER_BUTTON_HEIGHT &&
                        MAINMENU_HEIGHT - cam.getInputInGameWorld().y > MULTIPLAYER_BUTTON_Y) {
					mainMenuScreen.dispose();
					//starting RoboRally game from main menu
                    Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
                    cfg.setTitle("RoboRally Game");
                    //format 2.0711:1
                    cfg.setWindowedMode(1398,675);
                    cfg.setResizable(false);

                    new Lwjgl3Application(new RoboRally("MapNumber1.tmx", true), cfg);
				//	game.setScreen(new MainGameScreen(game));
				}

				return super.touchUp(screenX, screenY, pointer, button);
			}

		});

     */



    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(button == Input.Buttons.LEFT) {
            if (screenX > 1398/2 - LOGO_WIDTH/2 && screenX < 800 && screenY > 252 && screenY < 347) {
                System.out.println("Start");
                game.setGameScreen();
            }
            if (screenX > 1398/2 - LOGO_WIDTH/2 && screenX < 800 && screenY > 402 && screenY < 495) {
                System.out.println("Exit");
                Gdx.app.exit();
            }
        }
        if(button == Input.Buttons.RIGHT) {
            System.out.println("x" + screenX + "y" + screenY);
        }

        return false;
    }

    @Override
    public void show() {


    }

    @Override
    public void render(float v) {

        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        //posisjoner først, så størrelse. gjør akkurat det samme med nye bilder
        batch.draw(BackgroundImage, 0,0 , 1398,675 );
        batch.draw(StartGameImage, 1398/2 - LOGO_WIDTH/2,300, LOGO_WIDTH, LOGO_HEIGHT);
        batch.draw(ExitGameImage, 1398/2 - LOGO_WIDTH/2,150 , LOGO_WIDTH, LOGO_HEIGHT);
        //
        batch.end();




/*
        //game.scrollingBackground.updateAndRender(delta, game.batch);

        int x = MAINMENU_WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;
        if (cam.getInputInGameWorld().x < x + EXIT_BUTTON_WIDTH && cam.getInputInGameWorld().x > x &&
                MAINMENU_HEIGHT - cam.getInputInGameWorld().y < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT &&
                MAINMENU_HEIGHT - cam.getInputInGameWorld().y > EXIT_BUTTON_Y) {
            batch.draw(exitButtonActive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
            if (Gdx.input.isTouched()) {

            }
        } else {
            batch.draw(exitButtonInactive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }

        //x = SpaceGame.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;
        if (cam.getInputInGameWorld().x < x + MULTIPLAYER_BUTTON_WIDTH &&
                cam.getInputInGameWorld().x > x &&
                MAINMENU_HEIGHT - cam.getInputInGameWorld().y < MULTIPLAYER_BUTTON_Y + MULTIPLAYER_BUTTON_HEIGHT &&
                MAINMENU_HEIGHT - cam.getInputInGameWorld().y > MULTIPLAYER_BUTTON_Y) {
            batch.draw(MultiplayerButtonActive, x, MULTIPLAYER_BUTTON_Y, MULTIPLAYER_BUTTON_WIDTH, MULTIPLAYER_BUTTON_HEIGHT);
            if (Gdx.input.isTouched()) {

            }
        } else {
            batch.draw(MultiplayerButtonInactive, x, MULTIPLAYER_BUTTON_Y, MULTIPLAYER_BUTTON_WIDTH, MULTIPLAYER_BUTTON_HEIGHT);
        }

        batch.draw(logo, MAINMENU_WIDTH / 2 - LOGO_WIDTH / 2, LOGO_Y, LOGO_WIDTH, LOGO_HEIGHT);

        batch.end();

         */

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

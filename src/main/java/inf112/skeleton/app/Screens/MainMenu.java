package inf112.skeleton.app.Screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import inf112.skeleton.app.Screens.StartGame;

public class MainMenu extends InputAdapter implements Screen {

    private SpriteBatch batch;
    Texture BackgroundImage;

    private TextButton joinGame;
    private TextButton hostGame;
    private TextButton exitGame;
    private Stage stage;

    private StartGame game;

    public MainMenu(StartGame game){
        this.game = game;
        batch = new SpriteBatch();
        BackgroundImage = new Texture("assets/background1.png");
    }

    @Override
    public void show() {

        stage = new Stage();

        Skin skin = new Skin(Gdx.files.internal("skin/skin.json"));

        joinGame = new TextButton("Join Game" , skin);
        joinGame.setPosition(600, 300);
        joinGame.setSize(200,50);

        hostGame = new TextButton("Host Game" , skin);
        hostGame.setPosition(600, 200);
        hostGame.setSize(200,50);

        exitGame = new TextButton("Exit Game" , skin);
        exitGame.setPosition(600, 100);
        exitGame.setSize(200,50);

        stage.addActor(joinGame);
        stage.addActor(hostGame);
        stage.addActor(exitGame);

        joinGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setGameScreen();
            }
        });

        hostGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setMultiplayerScreen();
            }
        });
        exitGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });

        Gdx.input.setInputProcessor(stage);


    }

    @Override
    public void render(float v) {

        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(BackgroundImage, 0,0 , 1398,675 );
        batch.end();

        stage.act(v);
        stage.draw();
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

package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MultiplayerScreen implements Screen {

    private SpriteBatch batch;
    private StartGame game;
    Texture BackgroundImage;
    private TextButton buttonconfirm;
    private TextField playernumbers;
    private Label textlabel;

    private Stage stage;

    public MultiplayerScreen(StartGame game) {
        this.game = game;



    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        BackgroundImage = new Texture("assets/background1.png");

        stage = new Stage();

        Skin skin = new Skin(Gdx.files.internal("skin/skin.json"));

        textlabel = new Label("Enter amount of players", skin);
        textlabel.setPosition(350, 300);
        textlabel.setSize(200, 50);

        buttonconfirm = new TextButton("continue" , skin);

        buttonconfirm.setPosition(600, 200);
        buttonconfirm.setSize(200,50);


        playernumbers = new TextField("", skin);
        playernumbers.setPosition(600,300);
        playernumbers.setSize(200, 50);



        stage.addActor(buttonconfirm);
        stage.addActor(playernumbers);
        stage.addActor(textlabel);

        playernumbers.setTextFieldListener(new TextField.TextFieldListener() {
            public void keyTyped(TextField textField, char c) {
                if (c == '\n') textField.getOnscreenKeyboard().show(false);
            }
        });



        buttonconfirm.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                host();
            }
        });



        Gdx.input.setInputProcessor(stage);
    }

    public void host() {
        int players = Integer.parseInt(playernumbers.getText());
        game.hostGameScreen(players);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
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

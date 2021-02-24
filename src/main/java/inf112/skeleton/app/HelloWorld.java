package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import inf112.skeleton.app.Object.InputHandler;
import inf112.skeleton.app.Object.Robot;

public class HelloWorld extends InputAdapter implements ApplicationListener {
    public static final int V_WIDTH = 400;
    public static final int V_HEIGHT = 400;

    private SpriteBatch batch;
    private BitmapFont font;

    private TiledMap map;
    private TiledMapTileLayer boardLayer, playerLayer, holeLayer, flagLayer;

    private OrthogonalTiledMapRenderer render;

    private TiledMapTileLayer.Cell playerCell, playerWonCell, playerDiedCell;


   // private ArrayList<Flag> flaggene = new ArrayList<>();

    //ArrayList<FlagID> playerids = new ArrayList<>();

    private Integer flagsToTake = 2;


    TextureRegion dead;

    TextureRegion win;

    private OrthographicCamera camera;

    private ExtendViewport viewport;

    Robot test;



    TextureRegion state1;

    TextureRegion[][] tr;


    Vector2 playerPosition;


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);


        camera = new OrthographicCamera();
        viewport = new ExtendViewport(5,5);


        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("tutorial.tmx");

        //Layers initialize
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");

        //Vector2 flag1 = new Vector2(5, 5);
        //flaggene.add(new Flag(flag1, 1));

        render = new OrthogonalTiledMapRenderer(map , 1/300f);

        //camera.position.set(gameport.getWorldWidth() / 2, gameport.getWorldHeight() / 2, 0);

        Texture texture = new Texture("player.png");


        // splitter opp player.png bildet og definerer størrelsen
        tr = TextureRegion.split(texture, 300, 300);

        state1 = tr[0][0];
        dead = tr[0][1];
        win = tr[0][2];


        playerPosition = new Vector2(0, 0);

        test = new Robot(state1,0,0);

        InputHandler myhandler = new InputHandler(test);


        /**
         * Hmm, tror kanskje dere blir nødt til å bruke sprites her ja.
         * Usikker, men vet ikke om noen annen måte å gjøre det på. Alternative blir å bytte ut selve bilde med en rotert versjon.
         * Altså at man har alle de roterte bildene lagret.
         */

        Gdx.input.setInputProcessor(myhandler);


    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        render.setView((OrthographicCamera) viewport.getCamera());
        render.render();


        render.getBatch().setProjectionMatrix(viewport.getCamera().combined);
        render.getBatch().begin();
        test.draw(render.getBatch());
        render.getBatch().end();



        if (holeLayer.getCell((int) test.getX(), (int) test.getY()) != null) {
            test.setRegion(dead);
        } else if (flagLayer.getCell((int) test.getX(), (int) test.getY()) != null) {
            test.setRegion(win);
        } else {
            test.setRegion(state1);
        }


    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);

        viewport.getCamera().update();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }




    /*
    public void allFlagsTaken(Player player) {
        if (player.getFlag() == flagsToTake) {
            Gdx.app.exit();
        }

    }
    */


}

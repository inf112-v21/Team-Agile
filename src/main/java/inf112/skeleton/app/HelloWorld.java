package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;

public class HelloWorld extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;

    private TiledMap map;
    private TiledMapTileLayer boardLayer, playerLayer, holeLayer, flagLayer;

    private OrthogonalTiledMapRenderer render;
    private OrthographicCamera camera;

    private TiledMapTileLayer.Cell playerCell, playerWonCell, playerDiedCell;


    private ArrayList<Flag> flaggene = new ArrayList<>();

    private Integer flagsToTake = 2;


    private Sprite currentPlayer;


    Vector2 playerPosition;

    Player robotPlayer;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("tutorial.tmx");

        //Layers initialize
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer = (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");

        Vector2 flag1 = new Vector2(5, 5);
        flaggene.add(new Flag(flag1, 1));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 5, 5);

        camera.update();

        render = new OrthogonalTiledMapRenderer(map, 1 / 300f);

        render.setView(camera);

        Texture texture = new Texture("player.png");


        //currentplayer = new Sprite(texture);
        //currentplayer.rotate(90);


        // splitter opp player.png bildet og definerer størrelsen
        TextureRegion[][] tr = TextureRegion.split(texture, 300, 300);

        // definerer vanlig player condition
        playerCell = new TiledMapTileLayer.Cell();
        playerCell.setTile(new StaticTiledMapTile(tr[0][0]));


        // definerer player condition når vunnet
        playerWonCell = new TiledMapTileLayer.Cell();
        playerWonCell.setTile(new StaticTiledMapTile(tr[0][2]));

        // definerer player condition når død
        playerDiedCell = new TiledMapTileLayer.Cell();
        playerDiedCell.setTile(new StaticTiledMapTile(tr[0][1]));

        // definerer player start-vektor (start posisjon)
        playerPosition = new Vector2(2, 2);


        //currentPlayer = new Sprite(tr[0][1]);

        playerCell.setRotation(90);
        System.out.println(playerCell.getRotation());


        /**
         * Hmm, tror kanskje dere blir nødt til å bruke sprites her ja.
         * Usikker, men vet ikke om noen annen måte å gjøre det på. Alternative blir å bytte ut selve bilde med en rotert versjon.
         * Altså at man har alle de roterte bildene lagret.
         */



        robotPlayer = new Player(playerPosition, playerLayer);

        Gdx.input.setInputProcessor(robotPlayer);


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

        render.render();



        if (holeLayer.getCell((int) playerPosition.x, (int) playerPosition.y) != null) {
            playerLayer.setCell((int) playerPosition.x, (int) playerPosition.y, playerDiedCell);
        } else if (flagLayer.getCell((int) playerPosition.x, (int) playerPosition.y) != null) {
            playerLayer.setCell((int) playerPosition.x, (int) playerPosition.y, playerWonCell);
            robotPlayer.visitFlag(1);
        } else {
            playerLayer.setCell((int) playerPosition.x, (int) playerPosition.y, playerCell);
        }
        allFlagsTaken(robotPlayer);


    }


    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    public void allFlagsTaken(Player player) {
        if (player.getFlag() == flagsToTake) {
            Gdx.app.exit();
        }

    }

}

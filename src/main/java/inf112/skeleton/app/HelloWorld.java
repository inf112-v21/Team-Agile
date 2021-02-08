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
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input;

public class HelloWorld extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;

    private TiledMap map;
    private TiledMapTileLayer board,player,hole, flag;

    private OrthogonalTiledMapRenderer render;
    private OrthographicCamera camera;

    private TiledMapTileLayer.Cell playerCell, playerWonCell, playerDiedCell;

    Vector2 playerPosition;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("tutorial.tmx");

        //Layers initialize
        board = (TiledMapTileLayer) map.getLayers().get("Board");
        player = (TiledMapTileLayer) map.getLayers().get("Player");
        hole = (TiledMapTileLayer) map.getLayers().get("Hole");
        flag = (TiledMapTileLayer) map.getLayers().get("Flag");

        camera = new OrthographicCamera();
        camera.setToOrtho(false,5,5);


        camera.update();

        render = new OrthogonalTiledMapRenderer(map, 1/300f);

        render.setView(camera);

        Texture texture = new Texture("player.png");

        TextureRegion[][] tr = TextureRegion.split(texture,300,300);

        playerCell = new TiledMapTileLayer.Cell();
        playerCell.setTile(new StaticTiledMapTile(tr[0][0]));

        playerWonCell = new TiledMapTileLayer.Cell();
        playerWonCell.setTile(new StaticTiledMapTile(tr[0][0]));

        playerDiedCell = new TiledMapTileLayer.Cell();
        playerDiedCell.setTile(new StaticTiledMapTile(tr[0][0]));

        playerPosition = new Vector2(2,2);

        Gdx.input.setInputProcessor(this);





    }

    @Override
    public boolean keyUp(int keycode) {
        player.setCell((int) playerPosition.x, (int) playerPosition.y, null);

        switch(keycode) {
            case Input.Keys.LEFT:
                playerPosition.set(playerPosition.x - 1, playerPosition.y);
                break;
            case Input.Keys.RIGHT:
                playerPosition.set(playerPosition.x + 1, playerPosition.y);
                break;
            case Input.Keys.UP:
                playerPosition.set(playerPosition.x, playerPosition.y + 1);
                break;
            case Input.Keys.DOWN:
                playerPosition.set(playerPosition.x, playerPosition.y - 1);
                break;
        }

        player.setCell((int) playerPosition.x, (int) playerPosition.y, playerCell);

        return false;
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

        player.setCell((int) playerPosition.x, (int) playerPosition.y, playerCell);



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
}

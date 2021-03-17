package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Wall {
    /**vegger skal stoppe spille og laser
     veggene har hver sin type int(tror eg) som e id for den type vegg.
     me må si at koden ska henta denne id-en, og ut ifra id-en gi egenskapene me trenge.
     men!, det e jo sånn at noe av veggene har samme id, men forskjellige egenskaper.
     eksempel id 31. det e ein av toppveggene, så den har egenskapen at den ska stoppe spillere
     fra å flytte seg lenger nord og dermed ut av spill brettet. men det finnes en vegg med
     id 31 midt på brettet også, denne har en ekstra egenskap. nemlig å stoppe spillere fra å beve seg ned på
     brikken veggen står, så den skjermer altså spillere fra brikken veggen selv står på, dersom spillerene prøver å
     bevege seg i sør-gående retning.
     **/
    TiledMapTileLayer wallLayer;
    Integer ID;


    public Wall(TiledMapTileLayer layer, Vector2 wallPos, Integer wallID){

        //første hente layer
        this.wallLayer = layer;
        //eg e lost
        // føle med deg
        // eg klare ikkje å se ka metoder eg ska bruke eller koss det henge sammen.
        // e det ints? e det noe eg kan kalle på for å hente verdiene? e et noe som mangle før eg kan hente de?
        // må e importe noe så eg ska bruke? eg ane ikkje lenger
        // altså e ganske usikker sjøl, drive å loke på andres repositories nå, ser at de fleste har skrevet det i samme mappe som vår InputHandler.
        // det med trenge å gjør å gi restriksjoner på bevegelse med veggene. Men fortsatt så vett eg ikkje kossen eg hente fram veggene fra Tiled.
        //kanskej det som e det største problemet akkurat nå
        // ja å jo først kunne hente vegger for så å gi de egenskaper antar eg.
        // kossen tenke du å gjør det?
        if(layer. & ID.compareTo(wallID)){

        }




    }
}

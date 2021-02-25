package inf112.skeleton.app.Cards;

import java.util.ArrayList;

public class Deck {


    public ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();

    public void createDeck() {


        // Programcard.Direction[] directions = new Programcard.Direction.values();


        //Opprette BACKUP kort
        //for (int x = 430; x <= 480; x += 10) {
        //    Programcard card = new Programcard(Programcard.MoveType.BACKUP, x, Programcard.Direction());
        //    deck.add(card);
        //    cards[cardsInDecks++] = new Programcard(priotity(x), "action", )

        }

    }


    //public void shuffleDeck() {
    //    Collections.shuffle(cards);
    //}

//public void createDeck() {

/*

backuo(liste[10,20,30,40], )
    for(går gjennom alle movetypes i enum){

        // går gjennom backup i første iterasjon
        for(liste i backup){
        Programcard[] card = new Programcard(backup, prioritet, SOUTH, 0, -1);
        cards.add(Programcard);
        }

        // går gjennom rotate right i andre iterasjon
        for(liste i rotate right){
        Programcard[] card = new Programcard(backup, prioritet, SOUTH, 0, -1);
        cards.add(Programcard);

    }
 */

// new programcar_:  Programcard(MoveType type, int priority, Direction direction, int dx, int dy)

//for (int i = 80; i <= 420 ; i += 20) {
//   Programcard[] card = new Programcard();
//   cards.add(Programcard);
//}

//    }
//}
    /*


    deck klassen: lager antall kort og deler ut til players


    programCard: funksjonene til hvert kort. move1(dx, dy, endringRotasjon, prioritet)
                                             move2(MoveType)

                                             public class MoveType() {
                                                 public static BackUp {ddfdfeofgeg}




har en bevegelse (Flytt frem 1, Flytt frem 2, Flytt frem 3, Flytt bakover 1, Roter 90 grader H, Roter 90 grader V, Roter 180 grader)
har en prioritet (alle bevegelseskort må ha unik prioritet innenfor sin klasse, og mellom klassene (bevegelsestypene) skal intervallet ikke være overlappende)
backup: 6 kort (430 - 480, intervall 10)
u-turn: 6 kort (10 - 60, intervall 10)
rotate right: 18 kort (80-420, intervall 20)
rotate left: 18 kort (70-410, intervall 20)
move 1: 18 kort (490 - 650, intervall 10)
move 2: 12 kort (670 - 780, intervall 10)
move 3: 6 kort (790 - 840, intervall 10)

 */


package inf112.skeleton.app.Cards;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {


    public ArrayList<Programcard> deck = new ArrayList<Programcard>();

    public void createDeck() {
        // Programcard.Direction[] directions = new Programcard.Direction.values();


        //Opprette BACKUP kort
        for (int x = 430; x <= 480; x += 10) {
            Programcard card = new Programcard(Programcard.MoveType.BACKUP, x , 0);
            deck.add(card);



            //    cards[cardsInDecks++] = new Programcard(priotity(x), "action", )

        }
        //rotate
        for (int x = 430; x <= 480; x += 10) {
            Programcard card = new Programcard(Programcard.MoveType.0, x, ROTASJON);
            deck.add(card);

    }


    //public void shuffleDeck() {
    //    Collections.shuffle(cards);
}

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


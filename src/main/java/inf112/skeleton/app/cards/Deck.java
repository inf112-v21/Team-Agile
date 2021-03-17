package inf112.skeleton.app.cards;

import inf112.skeleton.app.object.Robot;
import java.util.*;

public class Deck {

    ArrayList<PlayingCard> deck;

    public Deck() {
        createDeck();
        shuffle();
    }

    public ArrayList<PlayingCard> createDeck() {
        deck = new ArrayList<>();
        for(int i=430;i<=480;i += 10) {
            PlayingCard backup = new PlayingCard(MoveType.BACKUP, i);
            deck.add(backup);
        }

        for(int i=10;i<=60;i += 10) {
            PlayingCard uturn = new PlayingCard(MoveType.UTURN, i);
            deck.add(uturn);
        }

        for(int i=490;i<=660;i += 10) {
            PlayingCard move1 = new PlayingCard(MoveType.MOVEONE, i);
            deck.add(move1);
        }

        for(int i=670;i<=780;i += 10) {
            PlayingCard move2 = new PlayingCard(MoveType.MOVETWO, i);
            deck.add(move2);
        }

        for(int i=790;i<=840;i += 10) {
            PlayingCard move3 = new PlayingCard(MoveType.MOVETHREE, i);
            deck.add(move3);
        }
        for(int i=70;i<=410;i += 20) {
            PlayingCard rotateLeft = new PlayingCard(MoveType.ROTATE_LEFT, i);
            deck.add(rotateLeft);
        }
        for(int i=80;i<=420;i += 20) {
            PlayingCard rotateRight = new PlayingCard(MoveType.ROTATE_RIGHT, i);
            deck.add(rotateRight);
        }
        return deck;
    }

    public int getSize() {
        return deck.size();
    }

    public PlayingCard getIndex(int index) { return deck.get(index); }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public void dealOutCards(List<Robot> players) {
        for (Robot player : players) {
            int hp = player.healthpoint;
            for(int i = 0; i < hp ; i++) {
                player.getCards().add(deck.remove(i));
            }
        }
    }
}

/*

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
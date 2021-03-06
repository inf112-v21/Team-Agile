package inf112.skeleton.app.cards;

import inf112.skeleton.app.map.object.Robot;
import java.util.*;

/**
 * Deck klassen lager et Deck objekt hvor det opprettes
 * en fullstendig kortstokk med riktig antall av forskjellige
 * typer kort, som så stokkes for å kunne deles ut tilfeldig
 * til hver av spillerne.
 *
 * @author Team Agile
 *
 */

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
        createDeck();
        shuffle();
        for (Robot player : players) {
            int hp = player.robotHealthPoint;
            for(int i = 0; i < hp ; i++) {
                player.getCards().add(deck.remove(i));
            }
        }
    }
    public void dealCards(Robot player) {
        int hp = player.robotHealthPoint;
        for(int i = 0; i < hp ; i++) {
            player.getCards().add(deck.remove(i));
        }

    }
}
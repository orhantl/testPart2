package objects;

import java.util.ArrayList;
import java.util.Random;

public class PlayingSet {

    private ArrayList<Card> game;

    public PlayingSet() {
    }

    public PlayingSet(ArrayList<Card> game) {
        this.game = game;
    }

    public ArrayList<Card> getGame() {
        return game;
    }

    public void setGame(ArrayList<Card> game) {
        this.game = game;
    }
    
    // to initialize a set of 52 playing cards
    public ArrayList<Card> initialization() {
        Card a = new Card();
        ArrayList<Card> game = new ArrayList();

        for (int i = 0; i < a.getColor().size(); i++) {
            for (String rank : a.getRank()) {
                Card c = new Card();
                c.setCardValue(rank);
                c.setSuite(a.getColor().get(i));
                game.add(c);
            }
        }
        return game;
    }
 
    // to pseudo-randomly shuffle a set of 52 playing cards   
    public ArrayList<Card> initShuffle(ArrayList<Card> newGame) {
        ArrayList<Card> game = new ArrayList();
        ArrayList<Card> shuffledGame = new ArrayList();
        for (Card c : newGame) {
            game.add(c);
        }

        for (int i = 0; i < newGame.size(); i++) {           
            Random rand = new Random();
            int randNber = rand.nextInt(game.size()); 
            shuffledGame.add(game.get(randNber));            
            game.remove(game.get(randNber));
        }
        return shuffledGame;
    }
    
    // to print cards by pack of 13
    public void layOut(ArrayList<Card> game) {
        for (int i = 0; i < game.size(); i++) {
            System.out.println(game.get(i));
            if ((i + 1) % 13 == 0) {
                System.out.println("...");
            }
        }
    }

    @Override
    public String toString() {
        String card = "";        
        for (int i = 0; i < game.size(); i++){
            if (i != 51) {
                card += String.valueOf(game.get(i)) + " / ";
            }
            if (i == (game.size()-1)){
                card += String.valueOf(game.get(i));               
            }
        }
        return card;
    }
}

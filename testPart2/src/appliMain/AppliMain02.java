package appliMain;

import DB.Dictionnary;
import objects.PlayingSet;

public class AppliMain02 {

    public static void main(String[] args) {
        Dictionnary dico = new Dictionnary();

        
        // retrieve from PlayingCard DB a set of ordered 52 playing cards
        PlayingSet ps = new PlayingSet(dico.retrieveCards());
              
        // insert into PlayingCard DB a set of ordered 52 playing cards as a String
        
        dico.insertCards(ps.toString());
        
        // insert into PlayingCard DB a set of unordered 52 playing cards as a String
        PlayingSet ps2 = new PlayingSet(ps.initShuffle(ps.getGame()));
        dico.insertCards(ps2.toString());
    }

}

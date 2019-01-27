
package objects;

import java.util.ArrayList;
import static java.util.Arrays.asList;

public class Card {
    
    private String suite;
    private String cardValue;
    private ArrayList<String> color;
    private ArrayList<String> rank;
    
    public Card(){
    }

    public Card(String suite, String cardValue) {
        this.suite = suite;
        this.cardValue = cardValue;
    }

    public Card(String suite, String cardValue, ArrayList<String> color, ArrayList<String> rank) {
        this.suite = suite;
        this.cardValue = cardValue;
        this.color = color;
        this.rank = rank;
    }
    
    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCardValue() {
        return cardValue;
    }

    public void setCardValue(String value) {
        this.cardValue = value;
    }

    public void setColor(ArrayList<String> color) {
        this.color= color;
    }
    
    public ArrayList<String> getColor() {
        ArrayList<String> colorList = new ArrayList<>(asList("Coeur", 
                "Carreau", "Trèfle", "Pique"));
        color = colorList;
        return color;
    }

    public ArrayList<String> getRank() {
        ArrayList<String> rankList = new ArrayList<>(asList("As", "2", "3",
                "4", "5", "6", "7", "8", "9", "10", "Valet", "Reine", "Roi"));
        rank = rankList;
        return rank;
    }

    public void setRank(ArrayList<String> rank) {
        this.rank = rank;
    }
    
    @Override
    public String toString() {
        return cardValue + " de " + suite;
    }
    
    
    
    
}

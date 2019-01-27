package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import objects.Card;

public class Dictionnary {

    private AccessDB ab;

    public Dictionnary() {
        this.ab = getAb();
    }

    private AccessDB getAb() {
        return new AccessDB();
    }

    public ArrayList<Card> retrieveCards() {
        ArrayList<Card> set = new ArrayList();
        String req = "select cardValue, suite from cardSet ";

        try (Statement stm = ab.getStatement();) {
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                Card c = new Card();
                c.setCardValue(rs.getString("cardValue"));
                c.setSuite(rs.getString("suite"));
                set.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("problem with retrieveCards() : " + ex.getMessage());
        }
        return set;
    }

    public void insertCards(String s) {
        String req = "insert setOfCards (sequence) VALUES (?) ";

        try (PreparedStatement pstm = ab.getPreparedStatement(req);) {
            pstm.setString(1, s);
            int lineCount = pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("insertCards : " + ex.getMessage());
        }
    }

    public void updateSetOfCards(String s, int i) {
        String req = "update setOfCards set sequence = ? WHERE setID = ?";
        try (PreparedStatement pstm = ab.getPreparedStatement(req);) {
            pstm.setString(1, s);
            pstm.setInt(2, i);
            int lineCount = pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("update SetOfCards : " + ex.getMessage());
        }
    }

}

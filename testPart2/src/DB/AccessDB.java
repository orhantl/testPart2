package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessDB {

    private Connection cnt;

    public AccessDB() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PLAYINGCARD";
        String user = "sa";
        String mdp = "sabis";

        try {
            cnt = DriverManager.getConnection(url, user, mdp);
        } catch (SQLException ex) {
            System.out.println("Connection problem to DB  : " + ex.getMessage());
        }
    }

    public Statement getStatement() throws SQLException {
        Statement stm = cnt.createStatement();
        return stm;
    }

    public PreparedStatement getPreparedStatement(String req) throws SQLException {
        PreparedStatement pstm = cnt.prepareStatement(req);
        return pstm;
    }

    public void close() throws SQLException {
        if (cnt != null) {
            cnt.close();
            cnt = null;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); 
        close();
    }
}

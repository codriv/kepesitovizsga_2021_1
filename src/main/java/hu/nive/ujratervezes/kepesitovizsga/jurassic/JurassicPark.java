package hu.nive.ujratervezes.kepesitovizsga.jurassic;


import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {

    MariaDbDataSource dataSource;

    public JurassicPark(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        try(Connection con = dataSource.getConnection();
            Statement stmt = con.createStatement()) {
            return getResult(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot reach database!");
        }
    }

    private List<String> getResult(Statement stmt) throws SQLException {
        try (ResultSet rs = stmt.executeQuery("select breed from dinosaur where actual > expected order by breed")) {
            List<String> breeds = new ArrayList<>();
            while (rs.next()) {
                String breed = rs.getString("breed");
                breeds.add(breed);
            }
            return breeds;
        }
    }
}

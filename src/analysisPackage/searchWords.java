package analysisPackage;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class searchWords {

    private java.sql.Statement stat = null;
    private java.sql.ResultSet set = null;
    private java.sql.PreparedStatement prepStat = null;
    private ArrayList<wordsData> wordsArray = new ArrayList<>();
    private wordsData wordsdata;

    ArrayList<String> search;

    public searchWords(ArrayList<String> words) {
        search = new ArrayList<String>();
        search = words;
    }

    public ArrayList<wordsData> getDB() throws SQLException {

        if (search.size() == 1) {

            String temp = search.get(0);
            searchData(temp);

        } else {

            for (int loop = 0; loop < search.size(); loop++) {
                searchData(search.get(loop));
            }
        }

        return wordsArray;
    }

    private void searchData(String keyword) throws SQLException {

        String query = "SELECT * FROM index_table WHERE word = ?";

        java.sql.Connection con = DriverManager.getConnection("JDBC:sqlite:./db/index.db");
        java.sql.PreparedStatement prepStat = con.prepareStatement(query);

        prepStat.setString(1, keyword);

        set = prepStat.executeQuery();

        if (set != null && set.next()) {

            do {

                wordsdata = new wordsData(set.getString("word"), set.getString("path"), "found");
                wordsArray.add(wordsdata);

            } while (set.next());

        } else {

            wordsdata = new wordsData(keyword, "not found", "not found");
            wordsArray.add(wordsdata);

        }

        set.close();
    }
}

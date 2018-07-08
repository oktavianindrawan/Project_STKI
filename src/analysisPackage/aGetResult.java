package analysisPackage;

import GUI_Package.mainFrame;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.id.IndonesianAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

public class aGetResult {

    private ArrayList<String> resultToken;
    private ArrayList<String> resultStop;
    private ArrayList<String> resultSuffix;
    private ArrayList<String> resultCase;
    private int totalRemove;
    private int totalStem;

    private java.sql.Statement stat = null;
    private java.sql.ResultSet set = null;
    private java.sql.PreparedStatement prepStat = null;

    public aGetResult() {

        resultToken = new ArrayList<String>();
        resultStop = new ArrayList<String>();
        resultSuffix = new ArrayList<String>();
        resultCase = new ArrayList<String>();

        createIndex();

    }

    public void singleGetResult(String source) {

        analyzeDocument(source);

        removeAndSort();
        removeIndexDuplicate();

        try {
            removeStopWords();
        } catch (SQLException ex) {
            Logger.getLogger(aGetResult.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            removeSuffix();
        } catch (ParseException ex) {
            Logger.getLogger(aGetResult.class.getName()).log(Level.SEVERE, null, ex);
        }

        caseFold();
    }

    public void multiGetResult(ArrayList<String> source) {

        for (int loop = 0; loop < source.size(); loop++) {

            analyzeDocument(source.get(loop));
        }

        removeAndSort();
        removeIndexDuplicate();

        try {
            removeStopWords();
        } catch (SQLException ex) {
            Logger.getLogger(aGetResult.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            removeSuffix();
        } catch (ParseException ex) {
            Logger.getLogger(aGetResult.class.getName()).log(Level.SEVERE, null, ex);
        }

        caseFold();

    }

    private void analyzeDocument(String path) {

        // get word using apache tika
        String temp = null;
        Tika convert = new org.apache.tika.Tika();
        java.io.File file = new java.io.File(path);

        try {

            // save words from file generate by apache tika
            temp = convert.parseToString(file);

        } catch (IOException ex) {
            Logger.getLogger(aGetResult.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TikaException ex) {
            Logger.getLogger(aGetResult.class.getName()).log(Level.SEVERE, null, ex);
        }

        // generate token and save to temporary token array string
        String[] token = temp.split("\\W+");

        // convert array string token to array list
        List<String> list = Arrays.asList(token);
        Set<String> set = new HashSet<String>(list);
        String[] result = new String[set.size()];
        set.toArray(result);

        for (int loop = 0; loop < result.length; loop++) {

            // save token to arraylist
            resultToken.add(result[loop]);
            fillIndex(result[loop], path);
        }

        token = null;
        list = null;
        set = null;
        result = null;
    }

    private void removeAndSort() {

        Set<String> removeDuplicate = new LinkedHashSet<String>(resultToken);
        resultToken.clear();
        resultToken.addAll(removeDuplicate);
        resultToken.sort(String::compareToIgnoreCase);
    }

    private void removeStopWords() throws SQLException {

        clearJDBC();

        resultStop.addAll(resultToken);

        java.sql.Connection con = DriverManager.getConnection("JDBC:sqlite:./db/stopwords.db");

        stat = con.createStatement();
        set = stat.executeQuery("SELECT * FROM 'stopwords'");

        while (set.next()) {
            String word = set.getString("words");
            for (int loop = 0; loop < resultStop.size(); loop++) {
                String temp = resultStop.get(loop);
                if (temp.equals(word)) {
                    resultStop.set(loop, " - ");
                    totalRemove = totalRemove + 1;
                }
            }
        }

        con.close();
    }

    private void removeSuffix() throws ParseException {

        IndonesianAnalyzer id = new IndonesianAnalyzer(Version.LUCENE_35);
        QueryParser parse = new QueryParser(Version.LUCENE_35, "", id);

        for (int loop = 0; loop < resultToken.size(); loop++) {

            String temp = resultToken.get(loop).toLowerCase();
            Query res = parse.parse(temp);
            String resTemp = res.toString();

            if (temp.equals("")) {
                resultSuffix.add(" - ");
            }

            if (temp.equals(resTemp)) {
                resultSuffix.add(" - ");
            } else {
                resultSuffix.add(" - ");
            }

            if (!temp.equals(resTemp)) {
                resultSuffix.add(resTemp);
                totalStem = totalStem + 1;
            }

        }
    }

    private void createIndex() {

        clearJDBC();

        try {

            java.sql.Connection con = DriverManager.getConnection("JDBC:sqlite:./db/index.db");

            java.sql.DatabaseMetaData meta = con.getMetaData();

            stat = con.createStatement();
            stat.execute("CREATE TABLE IF NOT EXISTS index_table(word STRING (25) NOT NULL, path STRING (100) NOT NULL)");

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(aGetResult.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void fillIndex(String value, String path) {

        clearJDBC();

        try {

            String query = "INSERT INTO index_table (word, path) VALUES (?,?)";

            java.sql.Connection con = DriverManager.getConnection("JDBC:sqlite:./db/index.db");
            java.sql.PreparedStatement prepStat = con.prepareStatement(query);

            prepStat.setString(1, value);
            prepStat.setString(2, path);
            prepStat.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(aGetResult.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void removeIndexDuplicate() {

        clearJDBC();

        try {

            java.sql.Connection con = DriverManager.getConnection("JDBC:sqlite:./db/index.db");

            java.sql.DatabaseMetaData meta = con.getMetaData();

            stat = con.createStatement();
            stat.execute("delete from index_table where word in(select word from index_table group by word having count(*) >1)");

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(aGetResult.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void caseFold() {

        for (int loop = 0; loop < resultToken.size(); loop++) {

            String temp = resultToken.get(loop).toLowerCase();

            if (resultToken.get(loop).equals(temp)) {
                resultCase.add(" - ");
            } else {
                resultCase.add(temp);
            }
        }

    }

    private void clearJDBC() {

        stat = null;
        set = null;
        prepStat = null;

    }

    public int getRemovedWords() {
        return totalRemove;
    }

    public int getRemovedStem() {

        return totalStem;
    }

    public ArrayList<String> getResult() {
        return resultToken;
    }

    public ArrayList<String> getStop() {
        return resultStop;
    }

    public ArrayList<String> getSuffix() {

        return resultSuffix;
    }

    public ArrayList<String> getCaseFold() {

        return resultCase;
    }

}

package analysisPackage;

import java.util.ArrayList;

public class wordsData {

    private String word;
    private String path;
    private String status;

    public wordsData(String word, String path, String status) {

        this.word = word;
        this.path = path;
        this.status = status;
    }

    public String getWord() {
        return word;
    }

    public String getPath() {
        return path;
    }

    public String getStatus() {
        return status;
    }
}

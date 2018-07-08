package conversionPackage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.tika.exception.TikaException;

public class conOperation {

    public conOperation(String sourcePath, String outputPath) {

        org.apache.tika.Tika convert = new org.apache.tika.Tika();
        java.io.File file = new java.io.File(sourcePath);

        try {

            java.io.BufferedWriter writeFile = new java.io.BufferedWriter(new java.io.FileWriter(outputPath, true));

            String temp = convert.parseToString(file);
            writeFile.write(temp);
            writeFile.flush();
            writeFile.close();

        } catch (IOException ex) {
            Logger.getLogger(conOperation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TikaException ex) {
            Logger.getLogger(conOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


package analysisPackage;

import java.util.ArrayList;
import javax.swing.JFileChooser;

public class aGetResource {

    private String singleFilePath;
    private String singleFileName;
    private ArrayList<String> multiFilePath = new ArrayList<String>();
    private ArrayList<String> multiFileName = new ArrayList<String>();

    public void getSingleFile() {

        javax.swing.JFileChooser choose = new javax.swing.JFileChooser();
        choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = choose.showOpenDialog(null);

        if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {

            java.io.File file = new java.io.File(choose.getSelectedFile().getAbsolutePath());
            boolean check = file.exists();

            if (!check) {

                javax.swing.JOptionPane.showMessageDialog(null, "No file selected");

            } else {

                if (!choose.getSelectedFile().getAbsolutePath().contains(".doc")) {

                    if (!choose.getSelectedFile().getAbsolutePath().contains(".docx")) {

                        javax.swing.JOptionPane.showMessageDialog(null, "File type not supported");
                    } else {

                        singleFilePath = file.toString();
                        singleFileName = file.getName();
                    }
                } else {

                    singleFilePath = file.toString();
                    singleFileName = file.getName();
                }
            }

        }
    }

    public void getMultiFile() {

        boolean check = false;
        int fileTotal = 0;

        javax.swing.JFileChooser choose = new javax.swing.JFileChooser();
        choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
        choose.setMultiSelectionEnabled(true);

        int returnValue = choose.showOpenDialog(null);

        java.io.File[] fileList = choose.getSelectedFiles();
        fileTotal = fileList.length;

        if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {

            for (int loop = 0; loop < fileTotal; loop++) {

                if (!fileList[loop].getName().contains(".doc")) {

                    if (!fileList[loop].getName().contains(".docx")) {

                        check = true;
                    } else {
                        check = false;
                    }
                } else {
                    check = false;
                }
            }

            if (check) {

                javax.swing.JOptionPane.showMessageDialog(null, "One of selected files contain unsupported extension");

            } else {

                for (int loop_2 = 0; loop_2 < fileTotal; loop_2++) {

                    multiFilePath.add(fileList[loop_2].getPath());
                    multiFileName.add(fileList[loop_2].getName());
                }
            }
        } else {

            multiFilePath = null;
            multiFileName = null;
        }
    }

    public ArrayList<String> getMultiFilePath() {
        return multiFilePath;
    }

    public ArrayList<String> getMultiFileName() {
        return multiFileName;
    }

    public String getSingleFilePath() {
        return singleFilePath;
    }

    public String getSingleFileName() {
        return singleFileName;
    }
}

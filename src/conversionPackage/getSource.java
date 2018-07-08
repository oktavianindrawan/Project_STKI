package conversionPackage;

import javax.swing.JFileChooser;

public class getSource {

    private String sourcePath;

    public getSource() {

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

                        sourcePath = file.toString();
                    }

                } else {

                    sourcePath = file.toString();
                }
            }
        }
    }

    public String getSourcePath() {
        return sourcePath;
    }

}

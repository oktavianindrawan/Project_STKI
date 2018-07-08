package conversionPackage;

public class getOutput {

    private String outputPath;

    public getOutput() {

        javax.swing.JFileChooser choose = new javax.swing.JFileChooser();
        int returnValue = choose.showSaveDialog(null);

        if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {

            if (choose.getSelectedFile().getAbsolutePath().contains(".txt") == true) {

                outputPath = choose.getSelectedFile().getAbsolutePath();

            } else {

                outputPath = choose.getSelectedFile().getAbsolutePath() + ".txt";
            }
        }
    }

    public String getOutputLocation() {
        return outputPath;
    }

}

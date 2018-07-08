package analysisPackage;

import java.util.ArrayList;

public class resFrame extends javax.swing.JFrame {

    /**
     * Creates new form resFrame
     */
    public resFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resultPanel = new javax.swing.JPanel();
        resultDecoPanel14 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        wsLabel = new javax.swing.JLabel();
        clauseLabel = new javax.swing.JLabel();
        wsField = new javax.swing.JTextField();
        clauseField = new javax.swing.JTextField();
        foundLabel = new javax.swing.JLabel();
        foundField = new javax.swing.JTextField();
        missingLabel = new javax.swing.JLabel();
        missingField = new javax.swing.JTextField();
        resultScroller = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Result");
        setName("resFrame"); // NOI18N

        resultPanel.setBackground(new java.awt.Color(236, 236, 236));
        resultPanel.setPreferredSize(new java.awt.Dimension(280, 200));

        resultDecoPanel14.setBackground(new java.awt.Color(65, 131, 215));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("SEARCH RESULT");

        javax.swing.GroupLayout resultDecoPanel14Layout = new javax.swing.GroupLayout(resultDecoPanel14);
        resultDecoPanel14.setLayout(resultDecoPanel14Layout);
        resultDecoPanel14Layout.setHorizontalGroup(
            resultDecoPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultDecoPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        resultDecoPanel14Layout.setVerticalGroup(
            resultDecoPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultDecoPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        statusPanel.setBackground(new java.awt.Color(236, 236, 236));

        wsLabel.setBackground(new java.awt.Color(236, 236, 236));
        wsLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        wsLabel.setText("Words Searched");

        clauseLabel.setBackground(new java.awt.Color(236, 236, 236));
        clauseLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        clauseLabel.setText("Clause");

        wsField.setEditable(false);
        wsField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        clauseField.setEditable(false);
        clauseField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        foundLabel.setBackground(new java.awt.Color(236, 236, 236));
        foundLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        foundLabel.setText("Found");

        foundField.setEditable(false);
        foundField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        missingLabel.setBackground(new java.awt.Color(236, 236, 236));
        missingLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        missingLabel.setText("Missing");

        missingField.setEditable(false);
        missingField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(wsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(wsField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(clauseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(clauseField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(foundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(foundField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(missingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(missingField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wsField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foundField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(missingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(missingField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clauseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clauseField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        resultTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Word", "Location", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultTable.getTableHeader().setReorderingAllowed(false);
        resultScroller.setViewportView(resultTable);

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultDecoPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addComponent(statusPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addComponent(resultDecoPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(resultScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setTable(ArrayList<wordsData> resData, int count, String clause, int found, int missing) {

        clauseField.setText(clause);
        wsField.setText(String.valueOf(count));
        foundField.setText(String.valueOf(found));
        missingField.setText(String.valueOf(missing));

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) resultTable.getModel();

        for (int loop = 0; loop < resData.size(); loop++) {
            model.addRow(new Object[]{resData.get(loop).getWord(), resData.get(loop).getPath(), resData.get(loop).getStatus()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clauseField;
    private javax.swing.JLabel clauseLabel;
    private javax.swing.JTextField foundField;
    private javax.swing.JLabel foundLabel;
    private javax.swing.JTextField missingField;
    private javax.swing.JLabel missingLabel;
    private javax.swing.JPanel resultDecoPanel14;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JScrollPane resultScroller;
    private javax.swing.JTable resultTable;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField wsField;
    private javax.swing.JLabel wsLabel;
    // End of variables declaration//GEN-END:variables
}
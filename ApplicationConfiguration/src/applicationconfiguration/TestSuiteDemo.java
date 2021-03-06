/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationconfiguration;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author home
 */
public class TestSuiteDemo extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement prepareStatement = null;
    ResultSet resultSet= null;
    Statement statement;

    /**
     * Creates new form TestSuiteDemo
     */
    public TestSuiteDemo() {
        initComponents();
        this.showTableData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        AddBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        HomeBtn = new javax.swing.JButton();
        SignOutBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ModuleName_TextField = new javax.swing.JTextField();
        ScenarioName_TextField = new javax.swing.JTextField();
        TestCase_TextField = new javax.swing.JTextField();
        TestCaseDescription_TextField = new javax.swing.JTextField();
        ExecutionFlag_ComboBox = new javax.swing.JComboBox<>();
        lMessage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TestSuite_Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        AddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Button-Add-icon.png"))); // NOI18N
        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Files-Edit-file-icon (1).png"))); // NOI18N
        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bin-2-icon.png"))); // NOI18N
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        ClearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Actions-edit-clear-icon (1).png"))); // NOI18N
        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        RefreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Button-Refresh-icon (1).png"))); // NOI18N
        RefreshBtn.setText("Refresh");
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });

        HomeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        HomeBtn.setText("Home");
        HomeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBtnActionPerformed(evt);
            }
        });

        SignOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SignOut-icon (1).png"))); // NOI18N
        SignOutBtn.setText("SignOut");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SignOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HomeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(AddBtn)
                .addGap(18, 18, 18)
                .addComponent(UpdateBtn)
                .addGap(18, 18, 18)
                .addComponent(DeleteBtn)
                .addGap(18, 18, 18)
                .addComponent(ClearBtn)
                .addGap(18, 18, 18)
                .addComponent(RefreshBtn)
                .addGap(18, 18, 18)
                .addComponent(HomeBtn)
                .addGap(18, 18, 18)
                .addComponent(SignOutBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test Suite Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel1.setText("Module Name:");

        jLabel2.setText("Scenario Name:");

        jLabel3.setText("Test Case Name:");

        jLabel4.setText("Test Case Description: ");

        jLabel5.setText("Execution Flag:");

        ExecutionFlag_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        lMessage.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        lMessage.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ModuleName_TextField)
                            .addComponent(ScenarioName_TextField)
                            .addComponent(TestCase_TextField)
                            .addComponent(TestCaseDescription_TextField)
                            .addComponent(ExecutionFlag_ComboBox, 0, 177, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ModuleName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScenarioName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TestCase_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TestCaseDescription_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExecutionFlag_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(lMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test Suite Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        TestSuite_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module Name", "Scenario Name", "Test Case Name", "Test Case Description", "Execution Flag"
            }
        ));
        TestSuite_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestSuite_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TestSuite_Table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 1110, 542);
    }// </editor-fold>//GEN-END:initComponents

    public void addUserIntoDatabase() {
        try {
            con = MySQLConnection.getConnection();

            //Write a query to insert data into database
            String insertData = "insert into testsuite(Module_Name,Scenario_Name,TestCase_Name,ScenarioDescription,ExecutionFlag) values(?,?,?,?,?)";

            prepareStatement = con.prepareStatement(insertData);
            prepareStatement.setString(1, ModuleName_TextField.getText());
            prepareStatement.setString(2, ScenarioName_TextField.getText());
            prepareStatement.setString(3, TestCase_TextField.getText());
            prepareStatement.setString(4, TestCaseDescription_TextField.getText());
            prepareStatement.setString(5, ExecutionFlag_ComboBox.getSelectedItem().toString());
            if (!ModuleName_TextField.getText().equals("")) {
                prepareStatement.execute();
                lMessage.setText("Data added successfully");
            } else {
                JOptionPane.showMessageDialog(null, "insufficent informations");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                con.close();
                prepareStatement.close();
                resultSet.close();
            } catch (Exception e) {

            }
        }
    }


    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
          try {
            this.addUserIntoDatabase();
            this.showTableData();
        } catch (Exception ex) {
            Logger.getLogger(TestSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
            try {
            
            this.showTableData();
            lMessage.setText("Table data refreshed successfully");
            
        } catch (Exception ex) {
            Logger.getLogger(TestSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
        try {
            close();
            new HomePage().setVisible(true);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_HomeBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        try {
            lMessage.setText("");
            DefaultTableModel model = (DefaultTableModel) TestSuite_Table.getModel();
            if (TestSuite_Table.getSelectedRow() == -1) {
                if (TestSuite_Table.getRowCount() == 0) {
                    lMessage.setText("Table is empty");
                } else {
                    lMessage.setText("You must select a record");
                }
            } else {
                con = MySQLConnection.getConnection();

                int row = TestSuite_Table.getSelectedRow();
                String value = TestSuite_Table.getModel().getValueAt(row, 2).toString();

                String deleteQuery = "delete from testsuite where TestCase_Name = '" + value + "'";

                prepareStatement = con.prepareStatement(deleteQuery);

                prepareStatement.executeUpdate();

                this.showTableData();

                lMessage.setText("Deteted " + value + " successfully");

            }
        } catch (SQLException ex) {
            lMessage.setText("Somthing went wrong while deleting the data from the table");
        } catch (Exception ex) {
            Logger.getLogger(TestSuite.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                prepareStatement.close();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        try {
            lMessage.setText("");
            DefaultTableModel model = (DefaultTableModel) TestSuite_Table.getModel();
            if (TestSuite_Table.getSelectedRow() == -1) {
                if (TestSuite_Table.getRowCount() == 0) {
                    lMessage.setText("Table is empty");
                } else {
                    lMessage.setText("You must select a record");
                }
            } else {

                con = MySQLConnection.getConnection();

                String modulename = ModuleName_TextField.getText();
                String scenarioName = ScenarioName_TextField.getText();
                String tesCaseName = TestCase_TextField.getText();
                String testCaseDescription = TestCaseDescription_TextField.getText();
                String executionFlag = ExecutionFlag_ComboBox.getSelectedItem().toString();

                String updateQuery = "update testsuite set Module_Name = '" + modulename + "', Scenario_Name ='" + scenarioName + "' ,TestCase_Name= '" + tesCaseName + "', ScenarioDescription = '" + testCaseDescription + "',ExecutionFlag = '" + executionFlag + "' where TestCase_Name= '" + tesCaseName + "'";

                statement = con.createStatement();

                statement.executeUpdate(updateQuery);

                this.showTableData();

                lMessage.setText("Data updated successfully");
            }
        } catch (Exception e) {
            lMessage.setText("Somthing went wrong while updating table data");
        } finally {
            try {
                con.close();
                prepareStatement.close();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void TestSuite_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestSuite_TableMouseClicked

        DefaultTableModel model = (DefaultTableModel) TestSuite_Table.getModel();
        ModuleName_TextField.setText(model.getValueAt(TestSuite_Table.getSelectedRow(), 0).toString());
        ScenarioName_TextField.setText(model.getValueAt(TestSuite_Table.getSelectedRow(), 1).toString());
        TestCase_TextField.setText(model.getValueAt(TestSuite_Table.getSelectedRow(), 2).toString());
        TestCaseDescription_TextField.setText(model.getValueAt(TestSuite_Table.getSelectedRow(), 3).toString());
        ExecutionFlag_ComboBox.setSelectedItem(model.getValueAt(TestSuite_Table.getSelectedRow(), 4).toString());

    }//GEN-LAST:event_TestSuite_TableMouseClicked

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        ModuleName_TextField.setText("");
        ScenarioName_TextField.setText("");
        TestCase_TextField.setText("");
        TestCaseDescription_TextField.setText("");
        ExecutionFlag_ComboBox.setSelectedItem("No");
    }//GEN-LAST:event_ClearBtnActionPerformed

    public void close() {

        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    }

    public void showTableData() {
        try {
            con = MySQLConnection.getConnection();
            String query = "select * from testsuite";
            prepareStatement = con.prepareStatement(query);
            resultSet = prepareStatement.executeQuery();
            TestSuite_Table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            System.out.println("Unable to featch Data from database");
            JOptionPane.showMessageDialog(null, "Unable to featch Data from database");
        } finally {
            try {
                con.close();
                prepareStatement.close();
                resultSet.close();
            } catch (Exception e) {

            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JComboBox<String> ExecutionFlag_ComboBox;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JTextField ModuleName_TextField;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JTextField ScenarioName_TextField;
    private javax.swing.JButton SignOutBtn;
    private javax.swing.JTextField TestCaseDescription_TextField;
    private javax.swing.JTextField TestCase_TextField;
    private javax.swing.JTable TestSuite_Table;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lMessage;
    // End of variables declaration//GEN-END:variables
}

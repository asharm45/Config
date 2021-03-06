/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationconfiguration;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author home
 */
public class TestSuite extends javax.swing.JFrame {

    Connection con = null;
    ResultSet resultSet = null;
    PreparedStatement prepareStatement = null;
    Statement statement;

    /**
     * Creates new form TestSuite
     */
    public TestSuite() throws Exception {
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
        Add_btn = new javax.swing.JButton();
        Edit_btn = new javax.swing.JButton();
        Refresh_btn = new javax.swing.JButton();
        Clear_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        Back_Btn = new javax.swing.JButton();
        SignOut_Btn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ModuleName_Label = new javax.swing.JLabel();
        ScenarioDescription_Label = new javax.swing.JLabel();
        TestCaseName_Label = new javax.swing.JLabel();
        ExecutionFlag_Label = new javax.swing.JLabel();
        ScenarioName_Label = new javax.swing.JLabel();
        ModuleName_TextField = new javax.swing.JTextField();
        Scenarion__TextField = new javax.swing.JTextField();
        TestCaseName_TextField = new javax.swing.JTextField();
        ScenarionDescription_TextField = new javax.swing.JTextField();
        ExecutionFlag_ComboBox = new javax.swing.JComboBox<>();
        lMessage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TestSuiteTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        Add_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demoapplication/img/Button-Add-icon.png"))); // NOI18N
        Add_btn.setText("Add");
        Add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_btnActionPerformed(evt);
            }
        });

        Edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demoapplication/img/Files-Edit-file-icon (1).png"))); // NOI18N
        Edit_btn.setText("Update");
        Edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_btnActionPerformed(evt);
            }
        });

        Refresh_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demoapplication/img/Button-Refresh-icon (1).png"))); // NOI18N
        Refresh_btn.setText("Refresh");
        Refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh_btnActionPerformed(evt);
            }
        });

        Clear_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demoapplication/img/Actions-edit-clear-icon (1).png"))); // NOI18N
        Clear_btn.setText("Clear");
        Clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_btnActionPerformed(evt);
            }
        });

        delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demoapplication/img/bin-2-icon.png"))); // NOI18N
        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        Back_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demoapplication/img/home.png"))); // NOI18N
        Back_Btn.setText("Home");
        Back_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_BtnActionPerformed(evt);
            }
        });

        SignOut_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demoapplication/img/SignOut-icon.png"))); // NOI18N
        SignOut_Btn.setText("SignOut");
        SignOut_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignOut_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SignOut_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Edit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Add_btn)
                .addGap(18, 18, 18)
                .addComponent(Edit_btn)
                .addGap(18, 18, 18)
                .addComponent(delete_btn)
                .addGap(18, 18, 18)
                .addComponent(Clear_btn)
                .addGap(18, 18, 18)
                .addComponent(Refresh_btn)
                .addGap(18, 18, 18)
                .addComponent(Back_Btn)
                .addGap(18, 18, 18)
                .addComponent(SignOut_Btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test Suite Informaion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        ModuleName_Label.setText("Module Name:");

        ScenarioDescription_Label.setText("Scenario Description:");

        TestCaseName_Label.setText("Test Case Name:");

        ExecutionFlag_Label.setText("Execution Flag:");

        ScenarioName_Label.setText("Scenarion Name:");

        ModuleName_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModuleName_TextFieldActionPerformed(evt);
            }
        });

        Scenarion__TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Scenarion__TextFieldActionPerformed(evt);
            }
        });

        ExecutionFlag_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        lMessage.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lMessage.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ModuleName_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScenarioDescription_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TestCaseName_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExecutionFlag_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScenarioName_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ModuleName_TextField)
                            .addComponent(Scenarion__TextField)
                            .addComponent(TestCaseName_TextField)
                            .addComponent(ScenarionDescription_TextField)
                            .addComponent(ExecutionFlag_ComboBox, 0, 164, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ModuleName_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModuleName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ScenarioName_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Scenarion__TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TestCaseName_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TestCaseName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScenarioDescription_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScenarionDescription_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExecutionFlag_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExecutionFlag_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addComponent(lMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TestSuiteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module Name", "Scenario Name", "Test Case", "Scenario Description", "Execution Flag"
            }
        ));
        TestSuiteTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestSuiteTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TestSuiteTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1261, 544));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ModuleName_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModuleName_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModuleName_TextFieldActionPerformed

    private void Scenarion__TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Scenarion__TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Scenarion__TextFieldActionPerformed

    public void addUserIntoDatabase() {
        try {
            con = MySQLConnection.getConnection();

            //Write a query to insert data into database
            String insertData = "insert into testsuite(Module_Name,Scenario_Name,TestCase_Name,ScenarioDescription,ExecutionFlag) values(?,?,?,?,?)";

            prepareStatement = con.prepareStatement(insertData);
            prepareStatement.setString(1, ModuleName_TextField.getText());
            prepareStatement.setString(2, Scenarion__TextField.getText());
            prepareStatement.setString(3, TestCaseName_TextField.getText());
            prepareStatement.setString(4, ScenarionDescription_TextField.getText());
            prepareStatement.setString(5, ExecutionFlag_ComboBox.getSelectedItem().toString());
            if (!ModuleName_TextField.getText().equals("")) {
                prepareStatement.execute();
                JOptionPane.showMessageDialog(null, "Data added successfully");
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


    private void Add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_btnActionPerformed

//        lMessage.setText("");
//        DefaultTableModel model = (DefaultTableModel) TestSuiteTable.getModel();
//        if(!ModuleName_TextField.getText().trim().equals("")){
//            model.addRow(new Object[]{ModuleName_TextField.getText(),Scenarion__TextField.getText(),TestCaseName_TextField.getText(),ScenarionDescription_TextField.getText(),ExecutionFlag_ComboBox.getSelectedItem()});
//        }el   se{
//            lMessage.setText("Module name should not be left blank");
//        }
        try {
            this.addUserIntoDatabase();
            this.showTableData();
        } catch (Exception ex) {
            Logger.getLogger(TestSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Add_btnActionPerformed

    private void Edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_btnActionPerformed
        try {
            lMessage.setText("");
            DefaultTableModel model = (DefaultTableModel) TestSuiteTable.getModel();
            if (TestSuiteTable.getSelectedRow() == -1) {
                if (TestSuiteTable.getRowCount() == 0) {
                    lMessage.setText("Table is empty");
                } else {
                    lMessage.setText("You must select a record");
                }
            } else {

                con = MySQLConnection.getConnection();

                String modulename = ModuleName_TextField.getText();
                String scenarioName = Scenarion__TextField.getText();
                String tesCaseName = TestCaseName_TextField.getText();
                String scenarionDescription = ScenarionDescription_TextField.getText();
                String executionFlag = ExecutionFlag_ComboBox.getSelectedItem().toString();

                String updateQuery = "update testsuite set Module_Name = '" + modulename + "', Scenario_Name ='" + scenarioName + "' ,TestCase_Name= '" + tesCaseName + "', ScenarioDescription = '" + scenarionDescription + "',ExecutionFlag = '" + executionFlag + "' where TestCase_Name= '" + tesCaseName + "'";

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
//            model.setValueAt(ModuleName_TextField.getText(), TestSuiteTable.getSelectedRow(), 0);
//            model.setValueAt(Scenarion__TextField.getText(), TestSuiteTable.getSelectedRow(), 1);
//            model.setValueAt(TestCaseName_TextField.getText(), TestSuiteTable.getSelectedRow(), 2);
//            model.setValueAt(ScenarionDescription_TextField.getText(), TestSuiteTable.getSelectedRow(), 3);
//            model.setValueAt(ExecutionFlag_ComboBox.getSelectedItem().toString(), TestSuiteTable.getSelectedRow(), 4);   
        //} 

    }//GEN-LAST:event_Edit_btnActionPerformed

    public void showTableData() throws Exception {
        try {
            con = MySQLConnection.getConnection();
            String query = "select * from testsuite";
            prepareStatement = con.prepareStatement(query);
            resultSet = prepareStatement.executeQuery();
            TestSuiteTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {

        } finally {
            try {
                con.close();
                prepareStatement.close();
                resultSet.close();
            } catch (Exception e) {

            }
        }
    }


    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        try {
            lMessage.setText("");
            DefaultTableModel model = (DefaultTableModel) TestSuiteTable.getModel();
            if (TestSuiteTable.getSelectedRow() == -1) {
                if (TestSuiteTable.getRowCount() == 0) {
                    lMessage.setText("Table is empty");
                } else {
                    lMessage.setText("You must select a record");
                }
            } else {
                con = MySQLConnection.getConnection();

                int row = TestSuiteTable.getSelectedRow();
                String value = TestSuiteTable.getModel().getValueAt(row, 2).toString();

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
    }//GEN-LAST:event_delete_btnActionPerformed

    private void TestSuiteTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestSuiteTableMouseClicked

        DefaultTableModel model = (DefaultTableModel) TestSuiteTable.getModel();
        ModuleName_TextField.setText(model.getValueAt(TestSuiteTable.getSelectedRow(), 0).toString());
        Scenarion__TextField.setText(model.getValueAt(TestSuiteTable.getSelectedRow(), 1).toString());
        TestCaseName_TextField.setText(model.getValueAt(TestSuiteTable.getSelectedRow(), 2).toString());
        ScenarionDescription_TextField.setText(model.getValueAt(TestSuiteTable.getSelectedRow(), 3).toString());
        ExecutionFlag_ComboBox.setSelectedItem(model.getValueAt(TestSuiteTable.getSelectedRow(), 4).toString());

    }//GEN-LAST:event_TestSuiteTableMouseClicked

    private void Clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_btnActionPerformed
        ModuleName_TextField.setText("");
        Scenarion__TextField.setText("");
        TestCaseName_TextField.setText("");
        ScenarionDescription_TextField.setText("");
    }//GEN-LAST:event_Clear_btnActionPerformed

    public void close() {

        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    }

    private void Back_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back_BtnActionPerformed
        try {
            close();
            new HomePage().setVisible(true);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_Back_BtnActionPerformed

    private void Refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_btnActionPerformed
        try {

            this.showTableData();
            lMessage.setText("");
            JOptionPane.showMessageDialog(null, "Table data refreshed successfully");
        } catch (Exception ex) {
            Logger.getLogger(TestSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Refresh_btnActionPerformed

    private void SignOut_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignOut_BtnActionPerformed
        try {
            close();
            new login().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't sign out :(");
        }
    }//GEN-LAST:event_SignOut_BtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_btn;
    private javax.swing.JButton Back_Btn;
    private javax.swing.JButton Clear_btn;
    private javax.swing.JButton Edit_btn;
    private javax.swing.JComboBox<String> ExecutionFlag_ComboBox;
    private javax.swing.JLabel ExecutionFlag_Label;
    private javax.swing.JLabel ModuleName_Label;
    private javax.swing.JTextField ModuleName_TextField;
    private javax.swing.JButton Refresh_btn;
    private javax.swing.JLabel ScenarioDescription_Label;
    private javax.swing.JLabel ScenarioName_Label;
    private javax.swing.JTextField ScenarionDescription_TextField;
    private javax.swing.JTextField Scenarion__TextField;
    private javax.swing.JButton SignOut_Btn;
    private javax.swing.JLabel TestCaseName_Label;
    private javax.swing.JTextField TestCaseName_TextField;
    private javax.swing.JTable TestSuiteTable;
    private javax.swing.JButton delete_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lMessage;
    // End of variables declaration//GEN-END:variables
}

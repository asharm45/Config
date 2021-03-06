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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author home
 */
public class TestManualDemo extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement prepareStatement = null;
    ResultSet resultSet = null;
    Statement statement;

    public TestManualDemo() {
        initComponents();
        showTableData();
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
        TestCaseName_TextField = new javax.swing.JTextField();
        Username_TextField = new javax.swing.JTextField();
        Password_TextField = new javax.swing.JTextField();
        lMessage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TestManualData_Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        SignOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SignOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HomeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test Case Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel1.setText("Test Case Name:");

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

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
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TestCaseName_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(Username_TextField)
                            .addComponent(Password_TextField))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TestCaseName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Username_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Password_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136)
                .addComponent(lMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test Cases", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        TestManualData_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test Case Name", "Username", "Password"
            }
        ));
        TestManualData_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestManualData_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TestManualData_Table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1064, 559);
    }// </editor-fold>//GEN-END:initComponents

    public void addUserIntoDatabase() {
        try {
            con = MySQLConnection.getConnection();
            String insertData = "insert into testdata_manual(TestCaseName,Username,Password) values(?,?,?)";

            prepareStatement = con.prepareStatement(insertData);
            prepareStatement.setString(1, TestCaseName_TextField.getText());
            prepareStatement.setString(2, Username_TextField.getText());
            prepareStatement.setString(3, Password_TextField.getText());
            if (!TestCaseName_TextField.getText().equals("")) {
                prepareStatement.execute();
                lMessage.setText("Data saved successfully");
            } else {
                JOptionPane.showMessageDialog(null, "insufficent informations");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                con.close();
                prepareStatement.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unable to close connection");
            }
        }
    }

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
        try {
            close();
            new HomePage().setVisible(true);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_HomeBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        try {
            addUserIntoDatabase();
            showTableData();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        try {
            lMessage.setText("");
            DefaultTableModel model = (DefaultTableModel) TestManualData_Table.getModel();
            if (TestManualData_Table.getSelectedRow() == -1) {
                if (TestManualData_Table.getRowCount() == 0) {
                    lMessage.setText("Table is empty");
                } else {
                    lMessage.setText("You must select a record");
                }
            } else {

                con = MySQLConnection.getConnection();

                String tc_name = TestCaseName_TextField.getText();
                String u_name = Username_TextField.getText();
                String password = Password_TextField.getText();

                String updateQuery = "update testdata_manual set TestCaseName = '" + tc_name + "', Username ='" + u_name + "' ,Password= '" + password + "' where TestCaseName= '" + tc_name + "'";

                statement = con.createStatement();

                statement.executeUpdate(updateQuery);

                this.showTableData();

                lMessage.setText("Data updated successfully");
            }
        } catch (Exception e) {
            lMessage.setText("Somthing went wrong while updating table data");
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                prepareStatement.close();
                resultSet.close();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        try {
            lMessage.setText("");
            DefaultTableModel model = (DefaultTableModel) TestManualData_Table.getModel();
            if (TestManualData_Table.getSelectedRow() == -1) {
                if (TestManualData_Table.getRowCount() == 0) {
                    lMessage.setText("Table is empty");
                } else {
                    lMessage.setText("You must select a record");
                }
            } else {
                con = MySQLConnection.getConnection();
                int row = TestManualData_Table.getSelectedRow();
                String value = TestManualData_Table.getModel().getValueAt(row, 0).toString();

                String deleteQuery = "delete from testdata_manual where TestCaseName = '" + value + "'";

                prepareStatement = con.prepareStatement(deleteQuery);

                prepareStatement.executeUpdate();

                this.showTableData();

                lMessage.setText("Deteted " + value + " successfully");

            }
        } catch (SQLException ex) {
            lMessage.setText("Somthing went wrong while deleting the data from the table");
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TestSuite.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                prepareStatement.close();
                resultSet.close();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        TestCaseName_TextField.setText("");
        Username_TextField.setText("");
        Password_TextField.setText("");
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        try {
            this.showTableData();
            lMessage.setText("");
            lMessage.setText("Table data refreshed successfully");
            // JOptionPane.showMessageDialog(null, "Table data refreshed successfully");
        } catch (Exception ex) {
            Logger.getLogger(TestSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void SignOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignOutBtnActionPerformed
        try {
            close();
            new login().setVisible(true);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_SignOutBtnActionPerformed

    private void TestManualData_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestManualData_TableMouseClicked
        DefaultTableModel model = (DefaultTableModel) TestManualData_Table.getModel();
        TestCaseName_TextField.setText(model.getValueAt(TestManualData_Table.getSelectedRow(), 0).toString());
        Username_TextField.setText(model.getValueAt(TestManualData_Table.getSelectedRow(), 1).toString());
        Password_TextField.setText(model.getValueAt(TestManualData_Table.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_TestManualData_TableMouseClicked

    public void close() {

        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    }

    public void showTableData() {
        try {
            con = MySQLConnection.getConnection();
            String query = "select * from testdata_manual";
            prepareStatement = con.prepareStatement(query);
            resultSet = prepareStatement.executeQuery();
            TestManualData_Table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                prepareStatement.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unable to close connection");

            } finally {
                try {
                    con.close();
                    prepareStatement.close();
                    resultSet.close();
                } catch (Exception e) {

                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JTextField Password_TextField;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JButton SignOutBtn;
    private javax.swing.JTextField TestCaseName_TextField;
    private javax.swing.JTable TestManualData_Table;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JTextField Username_TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lMessage;
    // End of variables declaration//GEN-END:variables
}

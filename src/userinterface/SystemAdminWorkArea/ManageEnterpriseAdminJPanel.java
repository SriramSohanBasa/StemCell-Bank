/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.AdminRole;
import Business.UserAccount.UserAccount;
import Magic.Design.MyJLabel;
import Magic.Design.MyTableFormat;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import Magic.Design.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author parth
 */
public class ManageEnterpriseAdminJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private Enterprise enterprise;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public ManageEnterpriseAdminJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;

        tblEnterprise.getTableHeader().setDefaultRenderer(new MyTableFormat());
        tblAdminUserName.getTableHeader().setDefaultRenderer(new MyTableFormat());
        populateTable();
       
    }
private boolean checkUserIdExists(String userName) {
        if (system.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
            if (system.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
                for (Network network : system.getNetworkList()) {
                    for (Enterprise enterprise : network.getEnterprise_Directory().getEnterpriseList()) {
                        if (enterprise.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
                            if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {
                                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                    if (organization.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
                                        return true;

                                    } else {
                                        return false;
                                    }

                                }
                            } else {
                                return true;
                            }
                        } else {
                            return false;

                        }
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return false;
    }
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblEnterprise.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterprise_Directory().getEnterpriseList()) {
                
                Object[] row = new Object[6];
                row[0] = enterprise;
                row[1] = enterprise.getEnterpriseType().getValue();
                row[2] = network.getName();
                row[5] = enterprise.getEmail();
                row[3] = enterprise.getContact();
                row[4] = enterprise.getZipcode();
             
                model.addRow(row);
                
            }
        }
    }

        private void populateAdminTable(Enterprise enterprise1) {
     
            DefaultTableModel model = (DefaultTableModel) tblAdminUserName.getModel();

            model.setRowCount(0);
       
            for (UserAccount user : enterprise1.getUserAccountDirectory().getUserAccountList()) {
                Object[] row = new Object[3];
                row[0] = enterprise;
                row[1] = user.getEmployee().getName();
                row[2] = user.getUsername();
                model.addRow(row);
            }
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblManageAdminEnterprises = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAdminUserName = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblCreateAdmin = new javax.swing.JLabel();
        lblEnterprise = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblAdminName = new javax.swing.JLabel();
        txtAdminName = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnCreateAdmin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEnterprise = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setBackground(new java.awt.Color(0, 51, 255));
        setMinimumSize(new java.awt.Dimension(1150, 770));
        setPreferredSize(new java.awt.Dimension(1150, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(1550, 70));

        lblManageAdminEnterprises.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblManageAdminEnterprises.setForeground(new java.awt.Color(255, 255, 255));
        lblManageAdminEnterprises.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManageAdminEnterprises.setText("Manage Admin for Enterprise");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblManageAdminEnterprises, javax.swing.GroupLayout.PREFERRED_SIZE, 1204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 316, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblManageAdminEnterprises, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, -1));

        tblAdminUserName.setBackground(new java.awt.Color(0, 0, 0));
        tblAdminUserName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 255, 204)));
        tblAdminUserName.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblAdminUserName.setForeground(new java.awt.Color(255, 255, 255));
        tblAdminUserName.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "Admin Name", "UserName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAdminUserName.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblAdminUserName.setGridColor(new java.awt.Color(0, 0, 0));
        tblAdminUserName.setRowHeight(30);
        jScrollPane3.setViewportView(tblAdminUserName);
        if (tblAdminUserName.getColumnModel().getColumnCount() > 0) {
            tblAdminUserName.getColumnModel().getColumn(0).setResizable(false);
            tblAdminUserName.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblAdminUserName.getColumnModel().getColumn(1).setResizable(false);
            tblAdminUserName.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 720, 200));

        jPanel2.setBackground(new java.awt.Color(0, 51, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 400));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setVerifyInputWhenFocusTarget(false);

        lblCreateAdmin.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblCreateAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblCreateAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreateAdmin.setText("Create Admin");

        lblEnterprise.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        lblEnterprise.setText("Enterprise:");

        txtName.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txtName.setEnabled(false);

        lblAdminName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblAdminName.setForeground(new java.awt.Color(255, 255, 255));
        lblAdminName.setText("Admin Name:");

        txtAdminName.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txtAdminName.setEnabled(false);

        lblUsername.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username:");

        txtUserName.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txtUserName.setEnabled(false);

        lblPassword.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password:");

        txtPassword.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txtPassword.setEnabled(false);

        btnCreateAdmin.setBackground(new java.awt.Color(0, 0, 0));
        btnCreateAdmin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCreateAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateAdmin.setText("Create Admin");
        btnCreateAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCreateAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnterprise)
                    .addComponent(lblAdminName)
                    .addComponent(lblUsername)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateAdmin)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtAdminName)
                        .addComponent(txtUserName)
                        .addComponent(txtPassword)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCreateAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnterprise)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdminName)
                    .addComponent(txtAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnCreateAdmin)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 380, 400));

        tblEnterprise.setBackground(new java.awt.Color(0, 0, 0));
        tblEnterprise.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 255, 204)));
        tblEnterprise.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        tblEnterprise.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "Enterprise Type", "Network", "Contact", "Zipcode", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEnterprise.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEnterprise.setGridColor(new java.awt.Color(0, 0, 0));
        tblEnterprise.setRowHeight(30);
        tblEnterprise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEnterpriseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEnterprise);
        if (tblEnterprise.getColumnModel().getColumnCount() > 0) {
            tblEnterprise.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblEnterprise.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblEnterprise.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblEnterprise.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblEnterprise.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblEnterprise.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 720, 210));
    }// </editor-fold>//GEN-END:initComponents

    private void tblEnterpriseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEnterpriseMouseClicked
        // TODO add your handling code here:
        int row = tblEnterprise.getSelectedRow();
        if (row < 0) {
             JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please select a row from the Table</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
            
            
            //JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Enterprise enterprise2 = (Enterprise) tblEnterprise.getValueAt(row, 0);
        enterprise = enterprise2 ;

       txtName.setText(enterprise2.getName());
       txtAdminName.setEnabled(true);
       txtUserName.setEnabled(true);
       txtPassword.setEnabled(true);
       
       populateAdminTable(enterprise2);
        
    }//GEN-LAST:event_tblEnterpriseMouseClicked

    private void btnCreateAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAdminActionPerformed
        
        int selectedRow = tblEnterprise.getSelectedRow();
        
        if(txtAdminName.getText().isEmpty())
        {
        txtAdminName.setBorder(BorderFactory.createLineBorder(Color.RED));
        txtAdminName.setForeground(Color.red);
        } 
        
        if(txtUserName.getText().isEmpty())
        {
        txtUserName.setBorder(BorderFactory.createLineBorder(Color.RED));
        txtUserName.setForeground(Color.red);
        } 
        
        if(txtPassword.getText().isEmpty())
        {
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
        txtPassword.setForeground(Color.red);
        } 
        
        
        if (selectedRow < 0){
            //JOptionPane.showMessageDialog(null, "Please select a row to Process" ,"Warning" , JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please select a row to process! </b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
            
            
            return;
        }
        
        else if (txtUserName.getText().isEmpty() || txtAdminName.getText().isEmpty() || txtPassword.getText().isEmpty()    )
        {
           //JOptionPane.showMessageDialog(null, "All fields are mandatory!","Warning",JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(null,new JLabel(  "<html><b>All fields are mandatory!</b></html>") , "Error", JOptionPane.ERROR_MESSAGE);
           return;
        }
        
        
        else if (!checkUserIdExists(txtUserName.getText())){
            txtUserName.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtUserName.setForeground(Color.red);
            JOptionPane.showMessageDialog(null,new JLabel(  "<html><b>User name already present!</b></html>"),"Warning",JOptionPane.WARNING_MESSAGE);
            return;
            }
         
        else if (txtPassword.getText().length() < 4 ){
            txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtPassword.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, new JLabel("<html><b>Password should be more than 4 digit!!</b></html>") , "Error", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null, "Password should be more than 4 characters","Warning",JOptionPane.WARNING_MESSAGE);
            return;
            }
        
        
        
        else    
        {
        
        String username = txtUserName.getText();
        String password = String.valueOf(txtPassword.getPassword());
       
        Employee employee = enterprise.getEmployeeDirectory().createEmployee(txtAdminName.getText());       
        
        UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new AdminRole());
        populateAdminTable(enterprise);
        
        populateAdminTable(enterprise);
          
        JOptionPane.showMessageDialog(null, new JLabel("<html><b>New Admin credentials created!</b></html>"));
        
        dB4OUtil.storeSystem(system);
        
          txtAdminName.setText("");
          txtUserName.setText("");
          txtPassword.setText("");
          txtName.setText("");  
          txtAdminName.setEnabled(false);
          txtUserName.setEnabled(false);
          txtPassword.setEnabled(false);
          txtName.setEnabled(false);  
        }
             
    }//GEN-LAST:event_btnCreateAdminActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAdmin;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAdminName;
    private javax.swing.JLabel lblCreateAdmin;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JLabel lblManageAdminEnterprises;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblAdminUserName;
    private javax.swing.JTable tblEnterprise;
    private javax.swing.JTextField txtAdminName;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}

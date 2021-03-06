/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RoomRole;

import Business.Enterprise.Enterprise;
import Business.Organization.RoomOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HouseRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class RoomJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private RoomOrganization organization;
    private Enterprise enterprise;
    /**
     * Creates new form RoomJPanel
     */
 

    public RoomJPanel(JPanel userProcessContainer, UserAccount account, RoomOrganization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organization = organization;
        this.enterprise = enterprise;
        populateTable();
    }

    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) houseRequestJTable.getModel();
        DefaultTableModel doneModel = (DefaultTableModel) doneJTable.getModel();
        
        model.setRowCount(0);
        doneModel.setRowCount(0);
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[3];
            row[0] = request.getMessage();
            row[1] = request;
            row[2] = request.getSender().getUsername();
            if (request.getStatus().equals("Under review")) {
                model.addRow(row);
            } else {
                doneModel.addRow(row);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        houseRequestJTable = new javax.swing.JTable();
        approveButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        doneJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));

        houseRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Message", "Status", "Provider"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(houseRequestJTable);

        approveButton.setBackground(new java.awt.Color(255, 255, 255));
        approveButton.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        approveButton.setText("Approve");
        approveButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        approveButton.setContentAreaFilled(false);
        approveButton.setOpaque(true);
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
            }
        });

        doneJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Message", "Status", "Provider"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        doneJTable.setEnabled(false);
        jScrollPane2.setViewportView(doneJTable);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setText("Room provider approval");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(jLabel1)))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(approveButton)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
        for (int i : houseRequestJTable.getSelectedRows()) {
            HouseRequest request = (HouseRequest) houseRequestJTable.getValueAt(i, 1);
            request.setStatus("Approved");
        }
        populateTable();
    }//GEN-LAST:event_approveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveButton;
    private javax.swing.JTable doneJTable;
    private javax.swing.JTable houseRequestJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hichi
 */
public class Administracion extends javax.swing.JFrame {

    /**
     * Creates new form Administracion
     */
    public Administracion() {
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

        jPanel1 = new javax.swing.JPanel();
        BTNConfigCuenta = new javax.swing.JButton();
        BTNOpcionesAdmin = new javax.swing.JButton();
        BTNRespaldo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LFoto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LUser = new javax.swing.JLabel();
        LRol = new javax.swing.JLabel();
        ButtonExit = new javax.swing.JButton();
        BTNListaContacto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(15, 0, 105));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(15, 0, 105));

        BTNConfigCuenta.setBackground(new java.awt.Color(17, 81, 0));
        BTNConfigCuenta.setForeground(new java.awt.Color(255, 255, 255));
        BTNConfigCuenta.setText("Cambiar configuración de la cuenta");
        BTNConfigCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNConfigCuentaActionPerformed(evt);
            }
        });

        BTNOpcionesAdmin.setBackground(new java.awt.Color(17, 81, 0));
        BTNOpcionesAdmin.setForeground(new java.awt.Color(255, 255, 255));
        BTNOpcionesAdmin.setText("Opciones de administrador");
        BTNOpcionesAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNOpcionesAdminActionPerformed(evt);
            }
        });

        BTNRespaldo.setBackground(new java.awt.Color(17, 81, 0));
        BTNRespaldo.setForeground(new java.awt.Color(255, 255, 255));
        BTNRespaldo.setText("Respaldo de la Información");
        BTNRespaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNRespaldoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Rol:");

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fotografia:");

        jLabel6.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(237, 178, 0));
        jLabel6.setText("Administración");

        LUser.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        LUser.setForeground(new java.awt.Color(255, 191, 0));
        LUser.setText("___________________");

        LRol.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        LRol.setForeground(new java.awt.Color(255, 191, 0));
        LRol.setText("______________________");

        ButtonExit.setBackground(new java.awt.Color(97, 0, 0));
        ButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        ButtonExit.setText("Salir");
        ButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExitActionPerformed(evt);
            }
        });

        BTNListaContacto.setBackground(new java.awt.Color(17, 81, 0));
        BTNListaContacto.setForeground(new java.awt.Color(255, 255, 255));
        BTNListaContacto.setText("Lista - Contacto");
        BTNListaContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNListaContactoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNRespaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(LUser, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LRol)
                                            .addComponent(BTNOpcionesAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BTNListaContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(17, 17, 17)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BTNConfigCuenta)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LUser)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(LFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LRol)
                        .addGap(17, 17, 17)
                        .addComponent(BTNConfigCuenta)
                        .addGap(18, 18, 18)
                        .addComponent(BTNListaContacto)
                        .addGap(18, 18, 18)
                        .addComponent(BTNOpcionesAdmin)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNRespaldo)
                    .addComponent(ButtonExit))
                .addGap(168, 168, 168))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        // TODO add your handling code here:
        //reorganizacion
        ListContact lc = new ListContact();
        lc.Regorganizar_Contact(LUser.getText());
        Login open = new Login();
        open.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void BTNOpcionesAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNOpcionesAdminActionPerformed
        // TODO add your handling code here:
        OpcionesAdmin opcAdmin = new OpcionesAdmin();
        opcAdmin.setVisible(true);
        opcAdmin.user = LUser.getText();
        //this.dispose();
    }//GEN-LAST:event_BTNOpcionesAdminActionPerformed

    private void BTNConfigCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNConfigCuentaActionPerformed
        // TODO add your handling code here:
        ConfigCuenta config = new ConfigCuenta();
        config.setVisible(true);
        config.user = LUser.getText();
        //this.dispose();
    }//GEN-LAST:event_BTNConfigCuentaActionPerformed

    private void BTNRespaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNRespaldoActionPerformed
        // TODO add your handling code here:
        JFileChooser save = new JFileChooser();
        save.setCurrentDirectory(new File("."));
        save.setDialogTitle("Seleccione carpeta.");
        save.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        save.setAcceptAllFileFilterUsed(false);
        if (save.showOpenDialog(this)== JFileChooser.APPROVE_OPTION) {
            File file = save.getCurrentDirectory();
            BackupClass bc = new BackupClass();
            bc.Backup_Public(LUser.getText(), file.getAbsolutePath());
            JOptionPane.showMessageDialog(null,"Respaldo con exito.","Respaldo", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_BTNRespaldoActionPerformed

    private void BTNListaContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNListaContactoActionPerformed
        // TODO add your handling code here:
        ListaContacto open = new ListaContacto();
        open.setVisible(true);
        open.LUser.setText(LUser.getText());     
    }//GEN-LAST:event_BTNListaContactoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNConfigCuenta;
    private javax.swing.JButton BTNListaContacto;
    public static javax.swing.JButton BTNOpcionesAdmin;
    public static javax.swing.JButton BTNRespaldo;
    private javax.swing.JButton ButtonExit;
    public static javax.swing.JLabel LFoto;
    public static javax.swing.JLabel LRol;
    public static javax.swing.JLabel LUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class ConfigCuenta extends javax.swing.JFrame {

    /**
     * Creates new form ConfigCuenta
     */
    public ConfigCuenta() {
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

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BTNDarseDeBaja = new javax.swing.JButton();
        jDCDate = new com.toedter.calendar.JDateChooser();
        TFAddPassword = new javax.swing.JTextField();
        LabelLevel = new javax.swing.JLabel();
        TFAddAltEmail = new javax.swing.JTextField();
        TFAddPhoneNumber = new javax.swing.JTextField();
        BTNAddPhoto = new javax.swing.JButton();
        TFAddPhoto = new javax.swing.JTextField();
        ButtonExit = new javax.swing.JButton();

        jLabel7.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(237, 178, 0));
        jLabel7.setText("CREAR CUENTA");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(15, 0, 105));

        jPanel1.setBackground(new java.awt.Color(15, 0, 105));

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("____________________________");

        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("____________________________");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nueva contraseña");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nuevo correo alterno");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de nacimiento");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nuevo teléfono");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nueva fotografía");

        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("o");

        jLabel11.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(237, 178, 0));
        jLabel11.setText("Información de la cuenta");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Actualizar información");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BTNDarseDeBaja.setBackground(new java.awt.Color(204, 0, 51));
        BTNDarseDeBaja.setForeground(new java.awt.Color(255, 255, 255));
        BTNDarseDeBaja.setText("Darse de baja");
        BTNDarseDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNDarseDeBajaActionPerformed(evt);
            }
        });

        TFAddPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFAddPasswordActionPerformed(evt);
            }
        });
        TFAddPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFAddPasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFAddPasswordKeyTyped(evt);
            }
        });

        LabelLevel.setForeground(new java.awt.Color(255, 0, 0));

        TFAddAltEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFAddAltEmailFocusLost(evt);
            }
        });
        TFAddAltEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFAddAltEmailKeyTyped(evt);
            }
        });

        TFAddPhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFAddPhoneNumberKeyTyped(evt);
            }
        });

        BTNAddPhoto.setBackground(new java.awt.Color(18, 30, 49));
        BTNAddPhoto.setText("...");
        BTNAddPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAddPhotoActionPerformed(evt);
            }
        });

        TFAddPhoto.setText("Seleccionar archivo");
        TFAddPhoto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFAddPhotoKeyTyped(evt);
            }
        });

        ButtonExit.setBackground(new java.awt.Color(97, 0, 0));
        ButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        ButtonExit.setText("Salir");
        ButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TFAddPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFAddAltEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDCDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFAddPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFAddPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTNAddPhoto))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(BTNDarseDeBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ButtonExit))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(245, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFAddPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(TFAddAltEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDCDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addGap(7, 7, 7)
                .addComponent(TFAddPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFAddPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNAddPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(ButtonExit))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTNDarseDeBaja)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String user;
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // Enviar datos verificados para realizar el insert
        ReadFile rf = new ReadFile();//instance class
        Password ClassPass = new Password();//instance class
        String levelPass = ClassPass.algorithmPass(TFAddPassword.getText());
        //validate not null fieldtext
        if ((TFAddPassword.getText().length() != 0) && (TFAddPhoneNumber.getText().length() != 0) && 
            (TFAddAltEmail.getText().length() != 0)&& (!TFAddPhoto.getText().equals("Seleccionar archivo")) && (jDCDate.getDate() != null)) 
        {
            if (levelPass.equals("Nivel Alto.") || levelPass.equals("Nivel Medio.") || levelPass.equals("Nivel Medio alto.")) 
            {
                String formato = jDCDate.getDateFormatString();               
                Date fecha = jDCDate.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat(formato);
                String passCypher = ClassPass.P_encode("meia", TFAddPassword.getText());//encode
                int Tel = 0;
                Tel = Integer.parseInt(TFAddPhoneNumber.getText());
                String message = rf.InsertUser2(user,passCypher,String.valueOf(sdf.format(fecha).toString()),
                                               TFAddAltEmail.getText(), Tel,photo,false,true);
                if (message.equals("Modificado con exito.")) {
                    JOptionPane.showMessageDialog(null,message, "Modificar Usuario", JOptionPane.INFORMATION_MESSAGE);
                    //Regresar al Login
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,message, "Crear Uusario", JOptionPane.INFORMATION_MESSAGE);
                }     
            }else{
                JOptionPane.showMessageDialog(null,"Aumente nivel de contraseña.", "Campo Contraseña", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Existen todavia campos vacios.", "Campo Vacio", JOptionPane.INFORMATION_MESSAGE);
        }      

    }//GEN-LAST:event_jButton1ActionPerformed

    private void TFAddPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFAddPasswordActionPerformed
        // Insert password the new user
    }//GEN-LAST:event_TFAddPasswordActionPerformed

    private void TFAddPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddPasswordKeyReleased
        //Permiso para modificar la etiqueta
        LabelLevel.setOpaque(true);
        // Para modificar el nivel de la contraseña
        String password = TFAddPassword.getText();
        //instancear clase
        Password CP = new Password();//class password
        String levelPass = CP.algorithmPass(password);
        //color panel
        Color BlueN = new Color(9,0,103);
        //depend the level
        if(levelPass.equals("Nivel Bajo."))
        {
            LabelLevel.setText(levelPass);
            LabelLevel.setForeground(Color.red);
            LabelLevel.setBackground(BlueN);
        }
        else if (levelPass.equals("Nivel Medio."))
        {
            LabelLevel.setText(levelPass);
            LabelLevel.setForeground(Color.orange);
            LabelLevel.setBackground(BlueN);
        }
        else if (levelPass.equals("Nivel Medio alto."))
        {
            LabelLevel.setText(levelPass);
            LabelLevel.setForeground(Color.yellow);
            LabelLevel.setBackground(BlueN);
        }
        else if (levelPass.equals("Nivel Alto."))
        {
            LabelLevel.setText(levelPass);
            LabelLevel.setForeground(Color.green);
            LabelLevel.setBackground(BlueN);
        }
        else
        {
            LabelLevel.setText(levelPass);
            LabelLevel.setForeground(Color.white);
            LabelLevel.setBackground(BlueN);
        }
    }//GEN-LAST:event_TFAddPasswordKeyReleased

    private void TFAddPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddPasswordKeyTyped
        // varchar 40
        if (TFAddPassword.getText().length()== 40)
        {
            evt.consume();
        }
    }//GEN-LAST:event_TFAddPasswordKeyTyped

    //Method for ER email
    private boolean isEmail(String email)
    {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\\\\\+]+(\\.[\\w\\\\]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(email);
        if (mat.find()) {
            return true;
        }
        else
        {
            return false;
        }
    }
    private void TFAddAltEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFAddAltEmailFocusLost
        // TODO add your handling code here:
        if (isEmail(TFAddAltEmail.getText())) {
            //no hace nada porque esta bien
        }else{
            JOptionPane.showMessageDialog(null,"Email Incorrecto","Validar email", JOptionPane.INFORMATION_MESSAGE);
            TFAddAltEmail.requestFocus();
        }
    }//GEN-LAST:event_TFAddAltEmailFocusLost

    private void TFAddAltEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddAltEmailKeyTyped
        // varchar 40
        if (TFAddAltEmail.getText().length()== 40)
        {
            evt.consume();
        }
    }//GEN-LAST:event_TFAddAltEmailKeyTyped

    private void TFAddPhoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddPhoneNumberKeyTyped
        // Solo puede ingresar numeros
        char c = evt.getKeyChar();

        if (c<'0' || c>'9') {
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo números", "Valdiar números", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_TFAddPhoneNumberKeyTyped

    //BTNAddPhoto
     JFileChooser select = new JFileChooser();
     File file;
     byte[] photo;
     
    private void BTNAddPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAddPhotoActionPerformed
        // Get photo
        if (select.showDialog(null, null) == JFileChooser.APPROVE_OPTION ) {
            file = select.getSelectedFile();
            if (file.canRead()) {
                if (file.getName().endsWith("jpg")||file.getName().endsWith("png") || file.getName().endsWith("gif")) {
                    //instance class
                    ReadFile rf = new ReadFile();
                    photo = rf.OpenFile(file);
                    TFAddPhoto.setText(file.getPath().toString());
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Archivo no compatible");
            }
        }
    }//GEN-LAST:event_BTNAddPhotoActionPerformed

    private void TFAddPhotoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddPhotoKeyTyped
        // varchar 200
        if (TFAddAltEmail.getText().length()== 200)
        {
            evt.consume();
        }
    }//GEN-LAST:event_TFAddPhotoKeyTyped

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void BTNDarseDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNDarseDeBajaActionPerformed
        // TODO add your handling code here:
        ReadFile rf = new ReadFile();
        boolean isAdmin= false;
        isAdmin = rf.DropOut(user);
        if (isAdmin == true) {
            JOptionPane.showMessageDialog(null,"Un admin no puede.", "Usuario no vigente incorrecto", JOptionPane.INFORMATION_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"El usuario se dio de baja.", "Usuario no vigente", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
      
    }//GEN-LAST:event_BTNDarseDeBajaActionPerformed

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
            java.util.logging.Logger.getLogger(ConfigCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAddPhoto;
    private javax.swing.JButton BTNDarseDeBaja;
    private javax.swing.JButton ButtonExit;
    private javax.swing.JLabel LabelLevel;
    private javax.swing.JTextField TFAddAltEmail;
    private javax.swing.JTextField TFAddPassword;
    private javax.swing.JTextField TFAddPhoneNumber;
    private javax.swing.JTextField TFAddPhoto;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDCDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

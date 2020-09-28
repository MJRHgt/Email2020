
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
 * @author walte
 */
public class CrearCuenta extends javax.swing.JFrame {
    

    /**
     * Creates new form CrearCuenta
     */
    public CrearCuenta() {
        initComponents();   
        TFAddPhoto.setEditable(false);//No edit field
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
        TFAddUser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TFAddLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTNAddPhoto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TFAddPhoto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TFAddAltEmail = new javax.swing.JTextField();
        ButtonInsert = new javax.swing.JButton();
        TFAddPassword = new javax.swing.JTextField();
        ButtonRegresar = new javax.swing.JButton();
        TFAddName = new javax.swing.JTextField();
        LabelLevel = new javax.swing.JLabel();
        TFAddPhoneNumber = new javax.swing.JTextField();
        jDCDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(15, 0, 105));
        jPanel1.setForeground(new java.awt.Color(15, 0, 105));

        TFAddUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFAddUserKeyTyped(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Apellido");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fotografía");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Correo alterno");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Usuario");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Constraseña");

        TFAddLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFAddLastNameKeyTyped(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Teléfono");

        BTNAddPhoto.setBackground(new java.awt.Color(18, 30, 49));
        BTNAddPhoto.setText("...");
        BTNAddPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAddPhotoActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nacimiento");

        TFAddPhoto.setText("Seleccionar archivo");
        TFAddPhoto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFAddPhotoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(237, 178, 0));
        jLabel2.setText("CREAR CUENTA");

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

        ButtonInsert.setBackground(new java.awt.Color(34, 161, 0));
        ButtonInsert.setForeground(new java.awt.Color(255, 255, 255));
        ButtonInsert.setText("CREAR CUENTA");
        ButtonInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonInsertMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonInsertMouseExited(evt);
            }
        });
        ButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonInsertActionPerformed(evt);
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

        ButtonRegresar.setBackground(new java.awt.Color(191, 0, 0));
        ButtonRegresar.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRegresar.setText("REGRESAR");
        ButtonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRegresarMouseExited(evt);
            }
        });
        ButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegresarActionPerformed(evt);
            }
        });

        TFAddName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFAddNameKeyTyped(evt);
            }
        });

        LabelLevel.setForeground(new java.awt.Color(255, 0, 0));

        TFAddPhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFAddPhoneNumberKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFAddName, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(ButtonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(TFAddPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                    .addComponent(BTNAddPhoto))
                                .addComponent(TFAddAltEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TFAddPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TFAddLastName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDCDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TFAddPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(205, 205, 205))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFAddUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TFAddName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFAddLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(TFAddPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFAddAltEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDCDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFAddPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TFAddPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTNAddPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonRegresar)
                    .addComponent(ButtonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegresarActionPerformed
        //Regresar al Login
        Login open = new Login();
        open.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonRegresarActionPerformed

    private void ButtonRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRegresarMouseExited
        // Change color
        Color RojoN = new Color(191,0,0);
        ButtonRegresar.setBackground(RojoN);
    }//GEN-LAST:event_ButtonRegresarMouseExited

    private void ButtonRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRegresarMouseEntered
        // Change color
        Color RojoN = new Color(237,0,0);
        ButtonRegresar.setBackground(RojoN);
    }//GEN-LAST:event_ButtonRegresarMouseEntered

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

    private void TFAddPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFAddPasswordActionPerformed
        // Insert password the new user

    }//GEN-LAST:event_TFAddPasswordActionPerformed

    private void ButtonInsertMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonInsertMouseExited
        // Change color
        Color VerdeN = new Color(34,161,0);
        ButtonInsert.setBackground(VerdeN);
    }//GEN-LAST:event_ButtonInsertMouseExited

    private void ButtonInsertMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonInsertMouseEntered
        // Change color
        Color VerdeN = new Color(42,199,0);
        ButtonInsert.setBackground(VerdeN);
    }//GEN-LAST:event_ButtonInsertMouseEntered

    private void ButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonInsertActionPerformed
        // Enviar datos verificados para realizar el insert
        ReadFile rf = new ReadFile();//instance class
        Password ClassPass = new Password();//instance class
        String levelPass = ClassPass.algorithmPass(TFAddPassword.getText());
        //validate not null fieldtext
        if ((TFAddPassword.getText().length() != 0) && (TFAddPhoneNumber.getText().length() != 0) && (TFAddUser.getText().length() != 0)
                && (TFAddName.getText().length() != 0) && (TFAddLastName.getText().length() != 0) && (TFAddAltEmail.getText().length() != 0)
                && (!TFAddPhoto.getText().equals("Seleccionar archivo")) && (jDCDate.getDate() != null)) 
        {
            if (levelPass.equals("Nivel Alto.") || levelPass.equals("Nivel Medio.") || levelPass.equals("Nivel Medio alto.")) 
            {
                String formato = jDCDate.getDateFormatString();               
                Date fecha = jDCDate.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat(formato);
                String passCypher = ClassPass.P_encode("meia", TFAddPassword.getText());//encode
                int Tel = 0;
                Tel = Integer.parseInt(TFAddPhoneNumber.getText());
                String message = rf.InsertUser(TFAddUser.getText(),TFAddName.getText(),TFAddLastName.getText(),passCypher,String.valueOf(sdf.format(fecha).toString()),
                                               TFAddAltEmail.getText(), Tel,photo,false,true);
                if (message.equals("Se registro con exito.")) {
                    JOptionPane.showMessageDialog(null,message, "Crear Usuario", JOptionPane.INFORMATION_MESSAGE);
                    //Regresar al Login
                    Login open = new Login();
                    open.setVisible(true);
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
    }//GEN-LAST:event_ButtonInsertActionPerformed

    private void TFAddPhoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddPhoneNumberKeyTyped
        // Solo puede ingresar numeros
        char c = evt.getKeyChar();
        
        if (c<'0' || c>'9') {
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo números", "Valdiar números", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_TFAddPhoneNumberKeyTyped

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

    private void TFAddUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddUserKeyTyped
        // varchar 20
        if (TFAddUser.getText().length()== 20) 
        {
         evt.consume(); 
        } 
    }//GEN-LAST:event_TFAddUserKeyTyped

    private void TFAddNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddNameKeyTyped
        // varchar 30
        if (TFAddName.getText().length()== 30) 
        {
         evt.consume(); 
        } 
    }//GEN-LAST:event_TFAddNameKeyTyped

    private void TFAddLastNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddLastNameKeyTyped
        // varchar 30
        if (TFAddLastName.getText().length()== 30) 
        {
         evt.consume(); 
        } 
    }//GEN-LAST:event_TFAddLastNameKeyTyped

    private void TFAddPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddPasswordKeyTyped
        // varchar 40
        if (TFAddPassword.getText().length()== 40) 
        {
         evt.consume(); 
        }
    }//GEN-LAST:event_TFAddPasswordKeyTyped

    private void TFAddAltEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddAltEmailKeyTyped
        // varchar 40
        if (TFAddAltEmail.getText().length()== 40) 
        {
         evt.consume(); 
        }
    }//GEN-LAST:event_TFAddAltEmailKeyTyped

    private void TFAddPhotoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFAddPhotoKeyTyped
        // varchar 200
        if (TFAddAltEmail.getText().length()== 200) 
        {
         evt.consume(); 
        }
    }//GEN-LAST:event_TFAddPhotoKeyTyped

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
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAddPhoto;
    private javax.swing.JButton ButtonInsert;
    private javax.swing.JButton ButtonRegresar;
    private javax.swing.JLabel LabelLevel;
    private javax.swing.JTextField TFAddAltEmail;
    private javax.swing.JTextField TFAddLastName;
    private javax.swing.JTextField TFAddName;
    private javax.swing.JTextField TFAddPassword;
    private javax.swing.JTextField TFAddPhoneNumber;
    private javax.swing.JTextField TFAddPhoto;
    private javax.swing.JTextField TFAddUser;
    private com.toedter.calendar.JDateChooser jDCDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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

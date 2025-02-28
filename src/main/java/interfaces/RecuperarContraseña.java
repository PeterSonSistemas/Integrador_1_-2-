/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

/**
 *
 * @author JESSY
 */
public class RecuperarContraseña extends javax.swing.JFrame {

    private Login login;
    
    /**
     * Creates new form RecuperarContraseña
     */
    public RecuperarContraseña() {
        initComponents();
        
        //Descactivas la opción de ampliar pantalla
        setResizable(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_RegresarLogin_RecuContra = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_NombreUsuario_RecuContra = new javax.swing.JTextField();
        btn_Cambiar_RecuContra = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_Contraseña_RecuContra = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(30, 49, 99));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\JESSY\\OneDrive - Universidad Tecnologica del Peru\\ciclo 7\\integrador 1\\proyecto 1\\SupertPet\\src\\main\\java\\Imagenes\\interfaz\\ImgRecuperarContraseña\\imagen1.png")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SuperPet");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 140, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\JESSY\\OneDrive - Universidad Tecnologica del Peru\\ciclo 7\\integrador 1\\proyecto 1\\SupertPet\\src\\main\\java\\Imagenes\\interfaz\\ImgRecuperarContraseña\\imagen2.png")); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        btn_RegresarLogin_RecuContra.setText("<");
        btn_RegresarLogin_RecuContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarLogin_RecuContraActionPerformed(evt);
            }
        });
        jPanel1.add(btn_RegresarLogin_RecuContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 40, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Regresar al login");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, 30));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("¿Te olvidaste tu contraseña o deseas ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("cambiar tus datos?");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 250, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingresa tu nuevo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ingresa tu nueva");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        txt_NombreUsuario_RecuContra.setBackground(new java.awt.Color(30, 49, 99));
        txt_NombreUsuario_RecuContra.setForeground(new java.awt.Color(255, 255, 255));
        txt_NombreUsuario_RecuContra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre de Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(txt_NombreUsuario_RecuContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 310, 60));

        btn_Cambiar_RecuContra.setBackground(new java.awt.Color(171, 148, 239));
        btn_Cambiar_RecuContra.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cambiar_RecuContra.setText("Cambiar");
        btn_Cambiar_RecuContra.setBorder(null);
        btn_Cambiar_RecuContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cambiar_RecuContraActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Cambiar_RecuContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 250, 40));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\JESSY\\OneDrive - Universidad Tecnologica del Peru\\ciclo 7\\integrador 1\\proyecto 1\\SupertPet\\src\\main\\java\\Imagenes\\interfaz\\ImgRecuperarContraseña\\imagen4.png")); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, 140, 20));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\JESSY\\OneDrive - Universidad Tecnologica del Peru\\ciclo 7\\integrador 1\\proyecto 1\\SupertPet\\src\\main\\java\\Imagenes\\interfaz\\ImgRecuperarContraseña\\imagen4.png")); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 120, 20));

        jLabel9.setFont(new java.awt.Font("Palatino Linotype", 0, 8)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("RECUPERA O MODIFICA TU CUENTA");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, -1, 30));

        txt_Contraseña_RecuContra.setBackground(new java.awt.Color(30, 49, 99));
        txt_Contraseña_RecuContra.setForeground(new java.awt.Color(255, 255, 255));
        txt_Contraseña_RecuContra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        txt_Contraseña_RecuContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Contraseña_RecuContraActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Contraseña_RecuContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 310, 60));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("© 2024. Creado y diseñado por Peter Son Alcoser");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setlog(Login log){
        this.login = log;
    }
    
    private void btn_RegresarLogin_RecuContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarLogin_RecuContraActionPerformed
        
        
        login.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btn_RegresarLogin_RecuContraActionPerformed

    private void txt_Contraseña_RecuContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Contraseña_RecuContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Contraseña_RecuContraActionPerformed

    private void btn_Cambiar_RecuContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cambiar_RecuContraActionPerformed
        
        VisualizarCuentaCambiada vcc = new VisualizarCuentaCambiada();
        vcc.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btn_Cambiar_RecuContraActionPerformed

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
            java.util.logging.Logger.getLogger(RecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecuperarContraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Cambiar_RecuContra;
    public javax.swing.JButton btn_RegresarLogin_RecuContra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField txt_Contraseña_RecuContra;
    public javax.swing.JTextField txt_NombreUsuario_RecuContra;
    // End of variables declaration//GEN-END:variables
}

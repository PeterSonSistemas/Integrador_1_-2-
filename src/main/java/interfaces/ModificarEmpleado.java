/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

/**
 *
 * @author JESSY
 */
public class ModificarEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarEmpleado
     */
    public ModificarEmpleado() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ck_Activo_ModificarEmpleado = new javax.swing.JCheckBox();
        ck_Inactivo_ModificarEmpleado = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cbx_PuestoTrabajo_ModificarEmpleado = new javax.swing.JComboBox<>();
        btn_CrearPuesto_ModificarEmpleado = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_Apellido_ModificarEmpleado = new javax.swing.JTextField();
        txt_DNI_ModificarEmpleado = new javax.swing.JTextField();
        txt_NumeroContacto_ModificarEmpleado = new javax.swing.JTextField();
        txt_Nombre_ModificarEmpleado = new javax.swing.JTextField();
        cbx_Sexo_ModificarEmpleado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_Modificar_ModificarEmpleado = new javax.swing.JButton();
        btn_Cancelar_ModificarEmpleado = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(248, 241, 216));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\JESSY\\OneDrive - Universidad Tecnologica del Peru\\ciclo 7\\integrador 1\\proyecto 1\\SupertPet\\src\\main\\java\\Imagenes\\interfaz\\ImgRegistrarEmpleado\\imagen1.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 30, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel4.setText("SuperPet");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 140, 30));

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel2.setText("Puesto de trabajo del empleado:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        ck_Activo_ModificarEmpleado.setBackground(new java.awt.Color(248, 241, 216));
        ck_Activo_ModificarEmpleado.setText("Activo");
        ck_Activo_ModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_Activo_ModificarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(ck_Activo_ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        ck_Inactivo_ModificarEmpleado.setBackground(new java.awt.Color(248, 241, 216));
        ck_Inactivo_ModificarEmpleado.setText("Inactivo");
        jPanel1.add(ck_Inactivo_ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\JESSY\\OneDrive - Universidad Tecnologica del Peru\\ciclo 7\\integrador 1\\proyecto 1\\SupertPet\\src\\main\\java\\Imagenes\\interfaz\\ImgRegistrarEmpleado\\imagen2.png")); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cbx_PuestoTrabajo_ModificarEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rellenador", "Cajero", "Gestión de almacén" }));
        jPanel1.add(cbx_PuestoTrabajo_ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 220, 30));

        btn_CrearPuesto_ModificarEmpleado.setBackground(new java.awt.Color(250, 187, 92));
        btn_CrearPuesto_ModificarEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_CrearPuesto_ModificarEmpleado.setText("Crear puesto laboral");
        btn_CrearPuesto_ModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CrearPuesto_ModificarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_CrearPuesto_ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 150, -1));

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel6.setText("Estado del Empleado:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\JESSY\\OneDrive - Universidad Tecnologica del Peru\\ciclo 7\\integrador 1\\proyecto 1\\SupertPet\\src\\main\\java\\Imagenes\\interfaz\\ImgRegistrarEmpleado\\imagen3.png")); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("© 2024. Creado y diseñado por Peter Son Alcoser");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 640));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel8.setText("Datos del empleado:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        txt_Apellido_ModificarEmpleado.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jPanel2.add(txt_Apellido_ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 280, 30));

        txt_DNI_ModificarEmpleado.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        txt_DNI_ModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DNI_ModificarEmpleadoActionPerformed(evt);
            }
        });
        jPanel2.add(txt_DNI_ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 280, 30));

        txt_NumeroContacto_ModificarEmpleado.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jPanel2.add(txt_NumeroContacto_ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 280, 30));

        txt_Nombre_ModificarEmpleado.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        txt_Nombre_ModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nombre_ModificarEmpleadoActionPerformed(evt);
            }
        });
        jPanel2.add(txt_Nombre_ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 280, 30));

        cbx_Sexo_ModificarEmpleado.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        cbx_Sexo_ModificarEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino" }));
        jPanel2.add(cbx_Sexo_ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 150, 30));

        jLabel9.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel9.setText("Nombres:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel10.setText("Apellidos:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel11.setText("DNI:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel12.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel12.setText("Sexo:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel13.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel13.setText("Número de contacto:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        btn_Modificar_ModificarEmpleado.setBackground(new java.awt.Color(250, 187, 92));
        btn_Modificar_ModificarEmpleado.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        btn_Modificar_ModificarEmpleado.setText("Modificar");
        btn_Modificar_ModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Modificar_ModificarEmpleadoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Modificar_ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 240, 30));

        btn_Cancelar_ModificarEmpleado.setBackground(new java.awt.Color(16, 60, 173));
        btn_Cancelar_ModificarEmpleado.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        btn_Cancelar_ModificarEmpleado.setText("Cancelar");
        btn_Cancelar_ModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancelar_ModificarEmpleadoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Cancelar_ModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 580, 100, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\JESSY\\OneDrive - Universidad Tecnologica del Peru\\ciclo 7\\integrador 1\\proyecto 1\\SupertPet\\src\\main\\java\\Imagenes\\interfaz\\ImgRegistrarEmpleado\\imagen4.png")); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 600));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 550, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ck_Activo_ModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_Activo_ModificarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ck_Activo_ModificarEmpleadoActionPerformed

    private void txt_Nombre_ModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nombre_ModificarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nombre_ModificarEmpleadoActionPerformed

    private void txt_DNI_ModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DNI_ModificarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DNI_ModificarEmpleadoActionPerformed

    private void btn_Modificar_ModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Modificar_ModificarEmpleadoActionPerformed
        GestionarEmpleado ge = new GestionarEmpleado();
        ge.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_Modificar_ModificarEmpleadoActionPerformed

    private void btn_CrearPuesto_ModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrearPuesto_ModificarEmpleadoActionPerformed
        CrearPuestoTrabajo2 cpt2 = new CrearPuestoTrabajo2();
        cpt2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_CrearPuesto_ModificarEmpleadoActionPerformed

    private void btn_Cancelar_ModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cancelar_ModificarEmpleadoActionPerformed
        GestionarEmpleado ge = new GestionarEmpleado();
        ge.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_Cancelar_ModificarEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar_ModificarEmpleado;
    private javax.swing.JButton btn_CrearPuesto_ModificarEmpleado;
    private javax.swing.JButton btn_Modificar_ModificarEmpleado;
    private javax.swing.JComboBox<String> cbx_PuestoTrabajo_ModificarEmpleado;
    private javax.swing.JComboBox<String> cbx_Sexo_ModificarEmpleado;
    private javax.swing.JCheckBox ck_Activo_ModificarEmpleado;
    private javax.swing.JCheckBox ck_Inactivo_ModificarEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_Apellido_ModificarEmpleado;
    private javax.swing.JTextField txt_DNI_ModificarEmpleado;
    private javax.swing.JTextField txt_Nombre_ModificarEmpleado;
    private javax.swing.JTextField txt_NumeroContacto_ModificarEmpleado;
    // End of variables declaration//GEN-END:variables
}

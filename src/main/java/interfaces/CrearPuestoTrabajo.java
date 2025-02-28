/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

/**
 *
 * @author JESSY
 */
public class CrearPuestoTrabajo extends javax.swing.JFrame {

    /**
     * Creates new form CrearPuestoTrabajo
     */
    public CrearPuestoTrabajo() {
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
        jLabel2 = new javax.swing.JLabel();
        txt_PuestoTrabajo_CrearPuesto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_DescripcionTrabajo_CrearPuesto = new javax.swing.JTextArea();
        btn_Cancelar_CrearPuesto = new javax.swing.JButton();
        btn_Registrar_CrearPuesto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(248, 241, 216));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel1.setText("Ingrese puesto de trabajo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jLabel2.setText("Descripción de su funcionalidad:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));
        jPanel1.add(txt_PuestoTrabajo_CrearPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 290, 30));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 110, -1, -1));

        ta_DescripcionTrabajo_CrearPuesto.setColumns(5);
        ta_DescripcionTrabajo_CrearPuesto.setLineWrap(true);
        ta_DescripcionTrabajo_CrearPuesto.setRows(8);
        ta_DescripcionTrabajo_CrearPuesto.setTabSize(2);
        ta_DescripcionTrabajo_CrearPuesto.setWrapStyleWord(true);
        ta_DescripcionTrabajo_CrearPuesto.setAutoscrolls(false);
        jScrollPane1.setViewportView(ta_DescripcionTrabajo_CrearPuesto);
        ta_DescripcionTrabajo_CrearPuesto.getAccessibleContext().setAccessibleDescription("");

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 290, 210));

        btn_Cancelar_CrearPuesto.setBackground(new java.awt.Color(250, 187, 92));
        btn_Cancelar_CrearPuesto.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        btn_Cancelar_CrearPuesto.setText("Cancelar");
        btn_Cancelar_CrearPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancelar_CrearPuestoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Cancelar_CrearPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 120, 40));

        btn_Registrar_CrearPuesto.setBackground(new java.awt.Color(250, 187, 92));
        btn_Registrar_CrearPuesto.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        btn_Registrar_CrearPuesto.setText("Registrar");
        btn_Registrar_CrearPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Registrar_CrearPuestoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Registrar_CrearPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 120, 40));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("© 2024. Creado y diseñado por Peter Son Alcoser");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Registrar_CrearPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Registrar_CrearPuestoActionPerformed
        RegistrarEmpleado re = new RegistrarEmpleado();
        re.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_Registrar_CrearPuestoActionPerformed

    private void btn_Cancelar_CrearPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cancelar_CrearPuestoActionPerformed
         RegistrarEmpleado re = new RegistrarEmpleado();
        re.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_Cancelar_CrearPuestoActionPerformed

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
            java.util.logging.Logger.getLogger(CrearPuestoTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPuestoTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPuestoTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPuestoTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearPuestoTrabajo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar_CrearPuesto;
    private javax.swing.JButton btn_Registrar_CrearPuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_DescripcionTrabajo_CrearPuesto;
    private javax.swing.JTextField txt_PuestoTrabajo_CrearPuesto;
    // End of variables declaration//GEN-END:variables
}

import javax.swing.JOptionPane;

public class TragaMonedas extends javax.swing.JFrame {

    public TragaMonedas() {
        initComponents();
        setLocationRelativeTo(null);
        a = new Proceso(Ranura1.getSize());        
        Ranura1.add(a);
        Ranura1.repaint();   
        b = new Proceso(Ranura2.getSize());        
        Ranura2.add(b);
        Ranura2.repaint(); 
        c = new Proceso(Ranura3.getSize());        
        Ranura3.add(c);
        Ranura3.repaint();   
        d = new Proceso(Ranura4.getSize());        
        Ranura4.add(d);
        Ranura4.repaint(); 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Ranura1 = new javax.swing.JLabel();
        Ranura2 = new javax.swing.JLabel();
        Ranura3 = new javax.swing.JLabel();
        Ranura4 = new javax.swing.JLabel();
        girar = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 51, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ranura1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icono1_1.JPG"))); // NOI18N
        jPanel1.add(Ranura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 184, -1, 135));

        Ranura2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icono2_1.JPG"))); // NOI18N
        jPanel1.add(Ranura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 184, -1, -1));

        Ranura3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icono3_1.JPG"))); // NOI18N
        jPanel1.add(Ranura3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 184, -1, -1));

        Ranura4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icono4_1.JPG"))); // NOI18N
        jPanel1.add(Ranura4, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 184, 100, -1));

        girar.setBackground(new java.awt.Color(255, 102, 102));
        girar.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        girar.setForeground(new java.awt.Color(255, 255, 255));
        girar.setText("DALE PLAY!!");
        girar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girarActionPerformed(evt);
            }
        });
        jPanel1.add(girar, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 383, 246, 52));

        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Titulo_2.png"))); // NOI18N
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, -50, 420, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, -7, 840, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void girarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girarActionPerformed
        // TODO add your handling code here:
        if (girar.getText().equals("GIRAR")){
            girar.setText("PARAR");
            a.startAnimation(); d.startAnimation(); b.startAnimation(); c.startAnimation();
        }
        else
        {
            a.stopAnimation(); b.stopAnimation(); c.stopAnimation(); d.stopAnimation();
            
            if (a.getIm() == b.getIm() && b.getIm() == c.getIm() && c.getIm() == d.getIm()){
                JOptionPane.showMessageDialog(null, "Ganaste!!!");
            }else{
                JOptionPane.showMessageDialog(null, "Sigue intentando");
            }
           
            
            
            
            girar.setText("GIRAR");
    }//GEN-LAST:event_girarActionPerformed
    }
    /**
     * @param args the command line arguments
     */
    Proceso a ; 
    Proceso b ;
    Proceso c ; 
    Proceso d ;
    
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
            java.util.logging.Logger.getLogger(TragaMonedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TragaMonedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TragaMonedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TragaMonedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TragaMonedas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Ranura1;
    private javax.swing.JLabel Ranura2;
    private javax.swing.JLabel Ranura3;
    private javax.swing.JLabel Ranura4;
    private javax.swing.JButton girar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

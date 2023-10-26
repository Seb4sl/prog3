
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazSemaforoInteligente extends javax.swing.JFrame {

    private int LuzVerde = 25;
    private int LuzAmarilla = 3;
    private int LuzRoja = 20;
    private boolean EnRojo = false;
    private int Cant_TiempoExtra = 0;
    private boolean PermisoAgregarTExtra = true;
    private int valorUmbralParaHoraPico = 0;
    private int Valor_Trafico = 0;
    private int TiempoExtra = 0;
    private boolean HoraPico = false;
    private int ciclo = 0;
    private Timer timer;
    
    private ImageIcon[] peatonSprites = new ImageIcon[8];
    private int spriteIndex = 0;
    private ImageIcon imgVerde = new ImageIcon(getClass().getResource("/SpritesSemaforo/SemaforoLuzVerde.png"));
    private ImageIcon imgAmarillo = new ImageIcon(getClass().getResource("/SpritesSemaforo/SemaforoLuzAmarilla.png"));
    private ImageIcon imgRojo = new ImageIcon(getClass().getResource("/SpritesSemaforo/SemaforoLuzRoja.png"));
    private ImageIcon Quieto = new ImageIcon(getClass().getResource("/SpritesPeaton/peatonQuieto.jpg"));
    private Timer peatontimer;
    
    public InterfazSemaforoInteligente() {
        initComponents();
        
        for (int i =1; i<= 8; i++){  
            peatonSprites[i-1]=new ImageIcon(getClass().getResource("/SpritesPeaton/peaton"+i+".png"));     
        }
        
         timer = new Timer(1000, (ActionEvent e) -> {
         if(ciclo ==0){
            if(LuzVerde>0){
                AnimacionSemaforo.setIcon(imgVerde);
                AnimacionSemaforo.setText(LuzVerde + "s");
                LuzVerde--;
            }else{
                 ciclo ++;
                 LuzAmarilla = 3;
                 }
         }else if(ciclo == 1){
             if(LuzAmarilla > 0){
                AnimacionSemaforo.setIcon(imgAmarillo);
                AnimacionSemaforo.setText(LuzAmarilla + "s");
                LuzAmarilla--;
             }else{
                 ciclo++;
             }
             
         }else if(ciclo ==2){ 
             if(LuzRoja >0){
                EnRojo=true;
                AnimacionSemaforo.setIcon(imgRojo);
                AnimacionSemaforo.setText(LuzRoja + "s");
                LuzRoja--;
             }else{
                ciclo = 0;
                EnRojo = false;
                TiempoExtra = 0;
                Cant_TiempoExtra = 0;
                PermisoAgregarTExtra = true;
                LuzVerde = 25;
                LuzAmarilla = 3;
                LuzRoja = 20;

                if(HoraPico){
                  
                    LuzRoja -= (int)(Valor_Trafico * 0.2);
                    LuzVerde += (int)(Valor_Trafico *0.2);
                
                    LuzRoja = Math.max(0, LuzRoja);
                    LuzVerde = Math.max(0, LuzVerde);
                }
             }    

         }

         
            if(TiempoExtra >0){
                
                LuzRoja += TiempoExtra;
                TiempoExtra = 0;
            }
        });
        timer.start();
        
                
        peatontimer = new Timer(150, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (EnRojo == true) {
                    // Mostrar el siguiente sprite en la secuencia
                    AnimacionPeaton.setIcon(peatonSprites[spriteIndex]);
                    spriteIndex = (spriteIndex + 1) % 8;
                }else if (EnRojo == false){
                AnimacionPeaton.setIcon(Quieto);
        }
            }
        });
        peatontimer.start();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AnimacionSemaforo = new javax.swing.JLabel();
        AnimacionPeaton = new javax.swing.JLabel();
        SliderTrafico = new javax.swing.JSlider();
        BotonPasoPeatonal = new javax.swing.JButton();
        Titulo_trafico = new javax.swing.JLabel();
        TITULO = new javax.swing.JLabel();
        Titulo_pasoPrioritario = new javax.swing.JLabel();
        Label_ValorTrafico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SliderTrafico.setMajorTickSpacing(15);
        SliderTrafico.setPaintLabels(true);
        SliderTrafico.setPaintTicks(true);
        SliderTrafico.setToolTipText("");
        SliderTrafico.setValue(0);
        SliderTrafico.setValueIsAdjusting(true);
        SliderTrafico.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderTraficoStateChanged(evt);
            }
        });

        BotonPasoPeatonal.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        BotonPasoPeatonal.setText("+ 5 segundos");
        BotonPasoPeatonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPasoPeatonalActionPerformed(evt);
            }
        });

        Titulo_trafico.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        Titulo_trafico.setText("TRAFICO");

        TITULO.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        TITULO.setText("SEMAFORO INTELIGENTE");

        Titulo_pasoPrioritario.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        Titulo_pasoPrioritario.setText("Preferencia Peatonal: 5seg");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AnimacionPeaton, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(AnimacionSemaforo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(BotonPasoPeatonal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Titulo_trafico)
                                    .addComponent(Titulo_pasoPrioritario))
                                .addGap(65, 65, 65))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(SliderTrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_ValorTrafico)
                    .addComponent(TITULO))
                .addGap(0, 112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(TITULO)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Titulo_trafico)
                            .addComponent(Label_ValorTrafico))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SliderTrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Titulo_pasoPrioritario))
                    .addComponent(AnimacionSemaforo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AnimacionPeaton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonPasoPeatonal, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonPasoPeatonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPasoPeatonalActionPerformed
        // TODO add your handling code here:
        if(EnRojo && PermisoAgregarTExtra && Cant_TiempoExtra < 2){
            TiempoExtra +=5;
            Cant_TiempoExtra ++;
            
            if(Cant_TiempoExtra == 2){
                PermisoAgregarTExtra = false;
            }
        }
    }//GEN-LAST:event_BotonPasoPeatonalActionPerformed

    private void SliderTraficoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderTraficoStateChanged
        // TODO add your handling code here:
        Label_ValorTrafico.setText(" "+SliderTrafico.getValue());
        Valor_Trafico = SliderTrafico.getValue();
        
        HoraPico = (Valor_Trafico > valorUmbralParaHoraPico); 

    }//GEN-LAST:event_SliderTraficoStateChanged

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
            java.util.logging.Logger.getLogger(InterfazSemaforoInteligente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazSemaforoInteligente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazSemaforoInteligente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazSemaforoInteligente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazSemaforoInteligente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnimacionPeaton;
    private javax.swing.JLabel AnimacionSemaforo;
    private javax.swing.JButton BotonPasoPeatonal;
    private javax.swing.JLabel Label_ValorTrafico;
    private javax.swing.JSlider SliderTrafico;
    private javax.swing.JLabel TITULO;
    private javax.swing.JLabel Titulo_pasoPrioritario;
    private javax.swing.JLabel Titulo_trafico;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

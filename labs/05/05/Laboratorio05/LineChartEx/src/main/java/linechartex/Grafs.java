/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package linechartex;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author julio
 */
public final class Grafs extends javax.swing.JFrame { //declarar variables

    int M = 0, F = 0, O = 0, A = 0, B = 0, AB = 0, NA = 0, nigga = 0, simp = 0, doble = 0;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    DefaultPieDataset datost = new DefaultPieDataset();
    public byte[] llenar_texto(int n){
        String texto="";
        if(n == 0)
            texto = "FILTRO;GÉNERO;;TIPO DE SANGRE;;;;MULTIPLICIDAD DE EMBARAZO;;ETNIA";
        if(n == 1)
            texto = "\nCATEGORIAS;MASCULINO;FEMENINO;A;B;AB;O;SIMPLE;DOBLE;NO PERTENECE;NEGRO(A), MULATO(A), AFRO COLOMBIANO(A) O AFRO DESCENDIENTE";
        if(n == 2)
            texto = "\nCANTIDAD;" + M + ";" + F + ";" + A + ";" + B + ";" + AB + ";" + O + ";" + simp + ";" + doble + ";" + NA + ";" + nigga;
        if(n == 3)
            texto = "\n\nTOP 3 TIPOS SANGRE;1. O; 2. A; 3. B";
        return texto.getBytes();
    }
    public void llenar_datos_bar(){
        switch(Filtro.getSelectedItem().toString()) {
            case "Etnia":
                datos.setValue(nigga, "Etnia", "Negro(a), Mulato(a), Afro Colombiano(a) O Afro Descendiente");
                datos.setValue(NA, "Etnia", "No Pertenece");
                break;
            case "Tipo de Sangre":
                datos.setValue(A, "Tipo de Sangre", "A");
                datos.setValue(AB, "Tipo de Sangre", "AB");
                datos.setValue(B, "Tipo de Sangre", "B");
                datos.setValue(O, "Tipo de Sangre", "O");
                break;
            case "Multiplicidad Embarazo":
                datos.setValue(simp, "Multiplicidad Embarazo", "Simple");
                datos.setValue(doble, "Multiplicidad Embarazo", "Doble");
                break;
            case "Género":
                datos.setValue(M, "Género", "Masculino");
                datos.setValue(F, "Género", "Femenino");
                break;
            default:
                datos.setValue(nigga, "Etnia", "Negro(a), Mulato(a), Afro Colombiano(a) O Afro Descendiente");
                datos.setValue(NA, "Etnia", "No Pertenece");
                datos.setValue(A, "Tipo de Sangre", "A");
                datos.setValue(AB, "Tipo de Sangre", "AB");
                datos.setValue(B, "Tipo de Sangre", "B");
                datos.setValue(O, "Tipo de Sangre", "O");
                datos.setValue(simp, "Multiplicidad Embarazo", "Simple");
                datos.setValue(doble, "Multiplicidad Embarazo", "Doble");
                datos.setValue(M, "Género", "Masculino");
                datos.setValue(F, "Género", "Femenino");
                break;
                
        }
    }
        public void llenar_datos_tor(){
        switch(Filtro.getSelectedItem().toString()) {
            case "Etnia":
                datost.setValue("Negro(a), Mulato(a), Afro Colombiano(a) O Afro Descendiente", nigga);
                datost.setValue("No Pertenece",NA);
                break;
            case "Tipo de Sangre":
                datost.setValue("A", A);
                datost.setValue("AB", AB);
                datost.setValue("B", B);
                datost.setValue("O", O);
                break;
            case "Multiplicidad Embarazo":
                datost.setValue("Simple", simp);
                datost.setValue("Doble", doble);
                break;
            case "Género":
                datost.setValue("Masculino", M);
                datost.setValue("Femenino",F);
                break;
            default:
                datost.setValue("Ver en graf. de barras", 100);
                break;
                
        }

    }
    public void Graf_barras(){ //metodo de grafico por barras
        datos.clear();
        Grafico.removeAll();
        llenar_datos_bar();     
        JFreeChart grafico_barras = ChartFactory.createBarChart("Nacimientos en Cali 2019-2020", Filtro.getSelectedItem().toString(), "Cantidad", datos);
        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(700,300));
        panel.setVisible(true);
        Grafico.setLayout(new BorderLayout());
        Grafico.add(panel,BorderLayout.NORTH);       
        pack();
        setLocationRelativeTo(null);
        
    }
    public void Graf_torta(){ //metodo de grafico por torta
        datost.clear();
        Grafico.removeAll();
        llenar_datos_tor();     
        JFreeChart grafico_circ = ChartFactory.createPieChart("Nacimientos en Medellin 2020-2021\n" + Filtro.getSelectedItem().toString(), datost, true, true, false);
        ChartPanel panel = new ChartPanel(grafico_circ);        
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(700,300));
        panel.setVisible(true);
        Grafico.setLayout(new BorderLayout());
        Grafico.add(panel,BorderLayout.NORTH);       
        pack();
        setLocationRelativeTo(null);
    }
    public void llenar_variables(){ 
        Map<String, Integer> dic = new HashMap<>();
            dic.put("Tipo de Sangre", 15);
            dic.put("Multiplicidad Embarazo", 12);
            dic.put("Todos los anteriores", 0);
            dic.put("Género", 3);
            dic.put("Etnia",17);
            A = 0; B = 0; AB=0; O = 0; nigga = 0; NA = 0; simp = 0; doble = 0; M = 0; F = 0;
    try {
            BufferedReader lector = new BufferedReader(new FileReader("nacimientos.csv"));

            String linea;
            String esp = Filtro.getSelectedItem().toString();
            System.out.println("Salió");
            // Lee 
            while ((linea = lector.readLine()) != null) {
                String[] valores = linea.split(",");                 
                System.out.println(valores[dic.get(esp)]);
                
                if (valores[3].equals("MASCULINO"))
                    M++;
                if (valores[3].equals("FEMENINO"))
                    F++;
                if (valores[15].equals("O"))
                    O++;
                if (valores[15].equals("A"))
                    A++;
                if (valores[15].equals("B"))
                    B++;
                if (valores[15].equals("AB"))
                    AB++;         
                if (valores[17].contains("NEGRO(A)"))
                    nigga++;
                if (valores[17].equals("NINGUNO DE LOS ANTERIORES"))
                    NA++;
                if (valores[12].equals("SIMPLE"))
                    simp++;
                if (valores[12/*dic.get(esp)*/].equals("DOBLE"))
                    doble++;
            }
            lector.close();
        } catch (IOException e) { //detecta errores al leer los archivos
            System.out.println("Error al leer el archivo, intentelo de nuevo: " + e.getMessage());
        }
}
    public Grafs() { //constructor  "initComponents()" a "llenar_variables()."
        initComponents();
        llenar_variables();
        
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
        Tipo_graf = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Filtro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Descarga = new javax.swing.JButton();
        Grafico = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Tipo_graf.setFont(new java.awt.Font("Segoe UI Light", 3, 15)); // NOI18N
        Tipo_graf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barras", "Circular" }));
        Tipo_graf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tipo_grafActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 2, 15)); // NOI18N
        jLabel1.setText("Que grafico desea?");

        jLabel2.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel2.setText("Gráfico Nacimientos en Medellin 2020-2021");

        Filtro.setFont(new java.awt.Font("Segoe UI Light", 3, 15)); // NOI18N
        Filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Género", "Tipo de Sangre", "Multiplicidad Embarazo", "Etnia", "Todos los anteriores" }));
        Filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 2, 15)); // NOI18N
        jLabel3.setText("Seleccione el filtro:");

        Descarga.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        Descarga.setText("Descargar");
        Descarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tipo_graf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(Descarga)
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tipo_graf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(Descarga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Grafico.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout GraficoLayout = new javax.swing.GroupLayout(Grafico);
        Grafico.setLayout(GraficoLayout);
        GraficoLayout.setHorizontalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        GraficoLayout.setVerticalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Grafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tipo_grafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tipo_grafActionPerformed
        if(Tipo_graf.getSelectedItem().toString().equals("Barras"))
            Graf_barras();
        if(Tipo_graf.getSelectedItem().toString().equals("Circular"))
            Graf_torta();
        //escoger metodo grafico
    }//GEN-LAST:event_Tipo_grafActionPerformed

    private void FiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroActionPerformed
        if(Tipo_graf.getSelectedItem().toString().equals("Barras"))
            Graf_barras();
        if(Tipo_graf.getSelectedItem().toString().equals("Circular"))
            Graf_torta();
          //escoger metodo grafico
    }//GEN-LAST:event_FiltroActionPerformed

    private void DescargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescargaActionPerformed
        try {
            FileOutputStream file = new FileOutputStream("data.csv");
            String datos = "dani big d\n";
            for(int c = 0; c < 4; c++){
                    byte texto[] = llenar_texto(c);
                    //datos.getBytes();            
            file.write(texto);  
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Grafs.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                Logger.getLogger(Grafs.class.getName()).log(Level.SEVERE, null, ex);
            }
        //Descargar graficas
    }//GEN-LAST:event_DescargaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) { //ES EL MAIN, configura la apariencia de la interfaz gráfica de usuario.
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
            java.util.logging.Logger.getLogger(Grafs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Descarga;
    private javax.swing.JComboBox<String> Filtro;
    private javax.swing.JPanel Grafico;
    private javax.swing.JComboBox<String> Tipo_graf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}


import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej0404 extends javax.swing.JFrame {
    Timer temporizador;
    ActionListener al;
    
    public Ej0404() {
        initComponents();
        na= new ActionListener() {
        int i=0;
        @Override
        public void actionPerformed(ActionEvent e) {
            double x = 50+10*Math.sin(2*Math.PI/10*(double)i);
            jRadioButton1.setLocation((int)x, i);

            //A*sen(wt); A es amplitud y w es 2*PI/T
            i++; 
        }
        };
        temporizador = new Timer(200, na); 

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
//Código generado por Netbeans

    }
//Código del botón para iniciar y detener el Temporizador

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){

        if (!temporizador.isRunning()) {
            temporizador.start();
            jButton1.setText("Detener");
        } else {
            temporizador.stop();
            jButton1.setText("Iniciar");
        }
    }
    public static void main(String args[]) {
        //Código generado por Netbeans

    }
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton jRadioButton1;
}
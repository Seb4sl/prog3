import java.util.Timer;
import java.util.TimerTask;

public class Ej0403 extends javax.swing.JFrame {

    Timer timer;
    TimerTask timertask;
    Boolean funcionando = false;

    public Ej0403() {

        initComponents();

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
    }
    
//iniciar y detener el Temporizador
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    if (!funcionando) {

        timer = new Timer();
        timertask = new TimerTask() {

            int i = 5;
            @Override
            public void run() {

                jLabel1.setLocation(i, 19); //Ubica el jLabel1 en las
                i++; //coordenadas (i,19)

            }

        };

        timer.scheduleAtFixedRate(timertask, 0, 200);//cada 200ms se
        funcionando = true;
        jButton1.setText("Parar");
} else {

        timer.cancel(); //Cancela el temporizador

        funcionando = false;

        jButton1.setText("Iniciar");

    }
}

public static void main(String args[]) {
}
private javax.swing.JButton jButton1;
private javax.swing.JLabel jLabel1;
}
import java.util.Timer;
import java.util.TimerTask;

public class EJ0401 {
 Timer timer;
 public EJ0401 (int segundos) {
 timer = new Timer();
 timer.schedule(new Recordatorio(),segundos*1000);//Programa la tarea
 }
 class Recordatorio extends TimerTask {
 public void run() {
 System.out.println("Tiene un recordatorio!");
 timer.cancel(); //Termina el hilo del timer
 }
 }
 public static void main(String args[]) {
        System.out.println("Inicio del programa");
        new EJ0401(5);
     }
}

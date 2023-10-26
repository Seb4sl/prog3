//|Sebastian larrota
import java.util.Timer;
import java.util.TimerTask;

public class Ej0402 {
    
    public static void main(String[] args){
        TimerTask timertask = new TimerTask() {
            int i=0;
            @Override
    public void run() {
        System.out.println("Hola! "+i);
        i++;
        }
    };
    
Timer timer = new Timer();
timer.scheduleAtFixedRate(timertask, 0, 3000);
}
};

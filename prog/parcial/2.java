//Juan Sebastian Larrota Correa y Luis alejandro zipaquira
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

class TemporizadorTarea extends TimerTask {
    private String mensaje;

    public TemporizadorTarea(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        System.out.println(mensaje);
    }
}

public class TemporizadorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        while (true) {
            System.out.println("==== Temporizador App ====");
            System.out.println("1. Crear temporizador");
            System.out.println("2. Detener temporizador");
            System.out.println("3. Reiniciar temporizador");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el mensaje del temporizador: ");
                    String mensajeTemporizador = scanner.nextLine();
                    System.out.print("Ingrese el tiempo de espera en milisegundos: ");
                    long tiempoEspera = scanner.nextLong();
                    scanner.nextLine(); // Consumir el salto de línea

                    TemporizadorTarea tarea = new TemporizadorTarea(mensajeTemporizador);
                    timer.schedule(tarea, tiempoEspera);
                    break;
                case 2:
                    System.out.print("Ingrese el mensaje del temporizador a detener: ");
                    String mensajeDetener = scanner.nextLine();
                    timer.purge(); // Limpiar tareas canceladas en el pasado
                    timer.cancel(); // Cancelar el temporizador actual

                    // Reiniciar el temporizador después de detenerlo
                    timer = new Timer();

                    System.out.println("Temporizador detenido.");
                    break;

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
                case 3:
                    System.out.print("Ingrese el mensaje del temporizador a reiniciar: ");
                    String mensajeReiniciar = scanner.nextLine();
                    timer.purge(); // Limpiar tareas canceladas en el pasado
                    timer.cancel(); // Cancelar el temporizador actual

                    // Reiniciar el temporizador después de detenerlo
                    timer = new Timer();

                    System.out.print("Ingrese el nuevo tiempo de espera en milisegundos: ");
                    long nuevoTiempoEspera = scanner.nextLong();
                    scanner.nextLine(); // Consumir el salto de línea

                    TemporizadorTarea nuevoTarea = new TemporizadorTarea(mensajeReiniciar);
                    timer.schedule(nuevoTarea, nuevoTiempoEspera);

                    System.out.println("Temporizador reiniciado.");
                    break;
                case 4:
                    timer.cancel(); // Cancelar todos los temporizadores antes de salir
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}

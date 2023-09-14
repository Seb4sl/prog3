import java.util.Random;
import java.util.Scanner;

public class OrdenadorDeNumeros {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();

        while (true) {
            System.out.println("Bienvenido a su programa de confianza");
            System.out.println("ordena un conjunto de números tipo double utilizando diferentes algoritmos de ordenamiento.");
            System.out.println(" -----Menú de Opciones------ ");
            System.out.println("1- Ordenar con Burbuja.");
            System.out.println("2- Ordenar con Inserción.");
            System.out.println("3- Ordenar con Selección.");
            System.out.println("4- Ordenar con Mergesort.");
            System.out.println("5- Salir");

            System.out.println("Seleccione una opción que quiere usar: ");
            int opcion = entrada.nextInt();

            if (opcion == 5) {
                System.out.println("adios :)");
                break;
            }

            System.out.print("Ingrese la cantidad de números a ordenar (100, 500, 1000, 5000 o 10000): ");
            int cantidad = entrada.nextInt();

            double[] arreglo = new double[cantidad];
            for (int i = 0; i < cantidad; i++) {
                arreglo[i] = aleatorio.nextDouble(); 
            }

            long tiempoInicio;
            long tiempoFinal;
            long tiempoTranscurrido;

            switch (opcion) {
                case 1:
                    tiempoInicio = System.nanoTime();
                    ordenarBurbuja(arreglo);
                    tiempoFinal = System.nanoTime();
                    tiempoTranscurrido = tiempoFinal - tiempoInicio;
                    mostrarTabla("Burbuja", cantidad, tiempoTranscurrido);
                    break;
                case 2:
                    tiempoInicio = System.nanoTime();
                    ordenarInsercion(arreglo);
                    tiempoFinal = System.nanoTime();
                    tiempoTranscurrido = tiempoFinal - tiempoInicio;
                    mostrarTabla("Inserción", cantidad, tiempoTranscurrido);
                    break;
                case 3:
                    tiempoInicio = System.nanoTime();
                    ordenarSeleccion(arreglo);
                    tiempoFinal = System.nanoTime();
                    tiempoTranscurrido = tiempoFinal - tiempoInicio;
                    mostrarTabla("Selección", cantidad, tiempoTranscurrido);
                    break;
                case 4:
                    tiempoInicio = System.nanoTime();
                    mergesort(arreglo, 0, arreglo.length - 1);
                    tiempoFinal = System.nanoTime();
                    tiempoTranscurrido = tiempoFinal - tiempoInicio;
                    mostrarTabla("Mergesort", cantidad, tiempoTranscurrido);
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    continue;
            }
        }

        entrada.close();
    }

  
    // Ordenamiento Burbuja
    public static void ordenarBurbuja(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    double valorTemporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = valorTemporal;
                }
            }
        }
    }

    // Ordenamiento por Inserción
    public static void ordenarInsercion(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            double clave = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = clave;
        }
    }

    // Ordenamiento por Selección
    public static void ordenarSeleccion(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            double valorTemporal = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = valorTemporal;
        }
    }
//Actualizacion Total de la carpeta, es por eso que esta tan avanzada

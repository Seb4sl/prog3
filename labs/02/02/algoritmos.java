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

    // Ordenamiento Mergesort
    public static void mergesort(double[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergesort(arreglo, inicio, medio);
            mergesort(arreglo, medio + 1, fin);
            merge(arreglo, inicio, medio, fin);
        }
    }

    // Método para combinar dos subarreglos ordenados
    public static void merge(double[] arreglo, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        double[] izquierda = new double[n1];
        double[] derecha = new double[n2];

        for (int i = 0; i < n1; i++) {
            izquierda[i] = arreglo[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            derecha[j] = arreglo[medio + 1 + j];
        }

        int i = 0, j = 0;
        int k = inicio;
        while (i < n1 && j < n2) {
            if (izquierda[i] <= derecha[j]) {
                arreglo[k] = izquierda[i];
                i++;
            } else {
                arreglo[k] = derecha[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arreglo[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < n2) {
            arreglo[k] = derecha[j];
            j++;
            k++;
        }
    }

    // Mostrar los resultados 
    public static void mostrarTabla(String algoritmo, int cantidad, long tiempo) {

        System.out.format("%nAlgoritmo usado: "+algoritmo+ "%n");
        System.out.format("%nCantidad de numeros: "+cantidad+ "%n");
        System.out.format("%nTiempo en ordenar los numeros: "+tiempo+ "%n");
        
    }
}

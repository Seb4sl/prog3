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

import java.util.Scanner;

class OperacionesMatriciales{   //Espacio que nos permite saber que operacion vamos a realizar
    public static double[][] sumarMatrices(double[][] matrizA, double[][] matrizB) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        double[][] matrizResultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizResultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        return matrizResultado;
    }
        public static double[][] restaMatrices(double[][] matrizA, double[][] matrizB) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        double[][] matrizResultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizResultado[i][j] = matrizA[i][j] - matrizB[i][j];
            }
        }
        return matrizResultado;
    }

    public static double[][] multiplicarMatrices(double[][] matrizA, double[][] matrizB) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;
        double[][] matrizResultado = new double[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        return matrizResultado;
    }

    public static double[][] multiplicarPorEscalar(double[][] matriz, double escalar) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[][] matrizResultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizResultado[i][j] = matriz[i][j] * escalar;
            }
        }
        return matrizResultado;
    }

    public static double[][] matrizTranspuesta(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[][] matrizResultado = new double[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizResultado[j][i] = matriz[i][j];
            }
        }
        return matrizResultado;  
    }
}

class ManejadorEntrada {    //de cuantas F y C quiere que sea la matriz
    private static final Scanner lector = new Scanner(System.in);

    public static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return lector.nextDouble();
    }

    public static double[][] leerMatriz(int filas, int columnas) {
        double[][] matrizResultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el numero en la fila [ " + (i + 1) + " ] y en la columna columna [ " + (j + 1) + " ] : ");
                matrizResultado[i][j] = lector.nextDouble();
            }
        }
        return matrizResultado;
    }
}

public class Main {  //Menu
    public static void main(String args[]) {
        try (Scanner entrada = new Scanner(System.in)) {
            while (true) {
                System.out.println("Menú de Operaciones:");
                System.out.println("Que desea realizar?");
                System.out.println("1. Suma de Matrices");
                System.out.println("2. Resta de Matrices");
                System.out.println("3. Multiplicación de Matrices");
                System.out.println("4. Multiplicación Escalar con Matriz");
                System.out.println("5. Matriz Transpuesta");
                System.out.println("6. Salir");
                
                int opcion = entrada.nextInt();
                
                if (opcion == 6) {
                    System.out.println("Saliendo del programa... ");
                    break;
                }
                
                double[][] MatrizA, MatrizB;
                
                switch (opcion) {
                    case 1:
                        MatrizA = ManejadorEntrada.leerMatriz(2, 2);
                        MatrizB = ManejadorEntrada.leerMatriz(2, 2);
                        double[][] resultadoSuma = OperacionesMatriciales.sumarMatrices(MatrizA, MatrizB);
                        System.out.println("Resultado de la Suma de Matrices:");
                        impMatriz(resultadoSuma);
                        break;
                    case 2:
                        MatrizA = ManejadorEntrada.leerMatriz(2, 2);
                        MatrizB = ManejadorEntrada.leerMatriz(2, 2);
                        double[][] resultadoresta = OperacionesMatriciales.restaMatrices(MatrizA, MatrizB);
                        System.out.println("Resultado de la resta de Matrices:");
                        impMatriz(resultadoresta);
                        break;
                    case 3:
                         MatrizA = ManejadorEntrada.leerMatriz(2, 2);
                         MatrizB = ManejadorEntrada.leerMatriz(2, 2);
                        double[][] resultadoMultiplicacion = OperacionesMatriciales.multiplicarMatrices(MatrizA, MatrizB);
                        System.out.println("Resultado de la Multiplicación de Matrices:");
                        impMatriz(resultadoMultiplicacion);
                        break;
                    case 4:
                        MatrizA = ManejadorEntrada.leerMatriz(2, 2);
                        double escalar = ManejadorEntrada.leerDouble("Ingrese el escalar: ");
                        double[][] resultadoMultiplicacionEscalar = OperacionesMatriciales.multiplicarPorEscalar(MatrizA, escalar);
                        System.out.println("Resultado de la Multiplicación Escalar con Matriz:");
                        impMatriz(resultadoMultiplicacionEscalar);
                        break;
                    case 5:
                        MatrizA = ManejadorEntrada.leerMatriz(2, 2);
                        double[][] resultadoTranspuesta = OperacionesMatriciales.matrizTranspuesta(MatrizA);
                        System.out.println("Matriz Transpuesta:");
                        impMatriz(resultadoTranspuesta);
                        break;
                    default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    continue;
                }
            }
        }
    }

    public static void impMatriz(double[][] matriz) { //Imprimir resultados de la matriz
        for (double[] matriz1 : matriz) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz1[j] + " ");
            }
            System.out.println();
        }
    }
}

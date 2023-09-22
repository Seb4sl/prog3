//Juan Sebastian Larrota (7004169)
public class Lab0301 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido");
        System.out.println("- Univec 2.0 -");

        System.out.print("Ingrese su codigo de estudiante: ");
        String Codigo = scanner.nextLine();

        System.out.print("Ingrese su nombre: ");
        String Nombre = scanner.nextLine();

        System.out.print("Ingrese su correo electronico (institucional): ");
        String Correo = scanner.nextLine();

        System.out.print("Ingrese el semestre a cursar: ");
        int Semestre = scanner.nextInt();

        Estudiante estudiante = new Estudiante(Codigo, Nombre, Correo, Semestre);

       
        List<Asignatura> asignaturasDisponibles = CargarAsignaturasDesdeArchivo("Asignaturas.txt");

        
        while (true) 
        {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Registrar asignatura");
            System.out.println("2. Mostrar reporte de asignaturas");
            System.out.println("3. Generar reporte en archivo");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");

            int Opcion = scanner.nextInt();

            switch (Opcion) 
            {
                case 1:
                    System.out.println("Asignaturas disponibles:");
                    for (int i = 0; i < asignaturasDisponibles.size(); i++) 
                    {
                        System.out.println(i + 1 + ". " + asignaturasDisponibles.get(i));
                    }
                    System.out.print("Seleccione el numero de asignatura que va a cursar: ");
                    int NumeroAsignatura = scanner.nextInt();

                    if (NumeroAsignatura >= 1 && NumeroAsignatura <= asignaturasDisponibles.size()) 
                    {
                        Asignatura asignaturaSeleccionada = asignaturasDisponibles.get(NumeroAsignatura - 1);
                        estudiante.registrarAsignatura(asignaturaSeleccionada);
                    } else 
                    {
                        System.out.println("Numero de asignatura no válido.");
                    }
                    break;
                case 2:
                    estudiante.MostrarReporte();
                    break;
                case 3:
                    estudiante.GenerarReporteArchivo("reporte_asignaturas.txt");
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el Sistema de Registro de Asignaturas!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    private static List<Asignatura> CargarAsignaturasDesdeArchivo(String nombreArchivo) 
    {
        List<Asignatura> asignaturas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) 
        {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String Codigo = parts[0].trim();
                    String Nombre = parts[1].trim();
                    int Semestre = Integer.parseInt(parts[2].trim());
                    int Creditos = Integer.parseInt(parts[3].trim());
                    List<String> horario = Arrays.asList(parts[4].trim().split(";"));
                    Asignatura asignatura = new Asignatura(Codigo, Nombre, Semestre, Creditos, horario);
                    asignaturas.add(asignatura);
                }
            }
        } catch (IOException e) 
        {
            System.err.println("Error al cargar las asignaturas desde el archivo.");
        }
        return asignaturas;
    }
}

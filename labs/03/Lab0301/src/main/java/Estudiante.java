    import java.io.*;
import java.util.*;

class Estudiante 
{
    private String Codigo;
    private String Nombre;
    private String Correo;
    private int Semestre;
    private List<Asignatura> AsignaturasRegistradas;
    private int TotalCreditosRegistrados;

    public Estudiante(String Codigo, String Nombre, String Correo, int Semestre)
     {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Semestre = Semestre;
        this.AsignaturasRegistradas = new ArrayList<>();
        this.TotalCreditosRegistrados = 0;
    }

    public void registrarAsignatura(Asignatura asignatura) 
    {
        if (TotalCreditosRegistrados + asignatura.getCreditos() <= 16) 
        {
            if (!VerificarCruceHorario(asignatura)) 
            {
                AsignaturasRegistradas.add(asignatura);
                TotalCreditosRegistrados += asignatura.getCreditos();
                System.out.println("Asignatura registrada con exito.");
            } else 
            {
                System.out.println("La asignatura seleccionada tiene un cruce de horario.");
            }
        } else 
        {
            System.out.println("No puedes registrar mas asignaturas debido al limite de creditos.");
        }
    }

    private boolean VerificarCruceHorario(Asignatura nuevaAsignatura) 
    {
        for (Asignatura asignatura : AsignaturasRegistradas) 
        {
            if (asignatura.CruceHorario(nuevaAsignatura)) 
            {
                return true; // Hay un cruce de horario
            }
        }
        return false; // No hay cruces de horario
    }

    public void MostrarReporte() 
    {
        System.out.println("-------- Reporte de Asignaturas Registradas --------");
        System.out.println("Codigo: " + Codigo);
        System.out.println("Nombre: " + Nombre);
        System.out.println("Correo: " + Correo);
        System.out.println("Semestre: " + Semestre);
        System.out.println("Total de creditos registrados: " + TotalCreditosRegistrados);
        System.out.println("Asignaturas registradas:");

        for (Asignatura asignatura : AsignaturasRegistradas) 
        {
            System.out.println(asignatura);
        }
    }

    public void GenerarReporteArchivo(String NombreArchivo) 
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(NombreArchivo))) 
        {
            writer.println("=== Reporte de Asignaturas Registradas ===");
            writer.println("Codigo: " + Codigo);
            writer.println("Nombre: " + Nombre);
            writer.println("Correo: " + Correo);
            writer.println("Semestre: " + Semestre);
            writer.println("Total de creditos registrados: " + TotalCreditosRegistrados);
            writer.println("Asignaturas registradas:");

            for (Asignatura asignatura : AsignaturasRegistradas) 
            {
                writer.println(asignatura);
            }
            System.out.println("Reporte generado con exito en el archivo " + NombreArchivo);
        } catch (IOException e) 
        {
            System.err.println("Error al generar el archivo de reporte.");
        }
    }
}

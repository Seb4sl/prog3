class Asignatura 
{
    private String Codigo;
    private String Nombre;
    private int Semestre;
    private int Creditos;
    private List<String> Horario;

    public Asignatura(String Codigo, String Nombre, int Semestre, int Creditos, List<String> Horario) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Semestre = Semestre;
        this.Creditos = Creditos;
        this.Horario = Horario;
    }

    public int getCreditos() 
    {
        return Creditos;
    }

    public boolean CruceHorario(Asignatura otraAsignatura) 
    {
        for (String diaHora : Horario) 
        {
            if (otraAsignatura.Horario.contains(diaHora)) 
            {
                return true; 
            }
        }
        return false; 
    }

    @Override
    public String toString() {
        return "Codigo: " + Codigo + ", Nombre: " + Nombre + ", Semestre: " + Semestre + ", Creditos: " + Creditos;
    }
}

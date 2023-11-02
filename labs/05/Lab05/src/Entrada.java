import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Entrada {

    private List<Muertes> muertes;

    public Entrada() {
        muertes = new ArrayList<>();
        cargarDesdeArchivo();
    }

    private void cargarDesdeArchivo() {
        try (Scanner scanner = new Scanner(new File("muertes.csv"))) {
            while (scanner.hasNextLine()) {
                String[] datosMuertes = scanner.nextLine().split(",");
                Muertes temp = new Muertes(datosMuertes[0].charAt(0), datosMuertes[1], datosMuertes[2], datosMuertes[3], datosMuertes[4], datosMuertes[5], datosMuertes[6]);
                muertes.add(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo de generos: " + e.getMessage());
        }
    }
    
    public int[] difuntosPorGenero(){
        int difuntosPorGenero[] = new int [2];
        int i=0;
        while (i<muertes.size()){
            Muertes temp = muertes.get(i);
            
            switch (temp.genero){
                case 'M':   difuntosPorGenero[0]+=1;
                            break;
                case 'F':   difuntosPorGenero[1]+=1;
                            break;
                default:    System.out.println("Error: El sexo "+temp.genero+" no esta dentro de los posibles.");
                            break;
            }
            i++;
        }
        return difuntosPorGenero;
    }
    

   
}

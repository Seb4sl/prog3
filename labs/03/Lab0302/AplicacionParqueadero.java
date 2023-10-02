//JUAN SEBASTIAN LARROTA CORREA [7004169(AplicacionParqueadero)]
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class AplicacionParqueadero extends JFrame {
    private JTextField campoPlaca, campoTipo;
    private JTextArea areaRegistro;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm:ss");
    private int numeroVehiculo = 1;

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

    public AplicacionParqueadero() {
        setTitle("Parqueadero UMNG");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("Menú");
        JMenuItem itemEntrada = new JMenuItem("Entrada del vehículo");
        JMenuItem itemSalida = new JMenuItem("Salida del vehículo");
        JMenuItem itemListaDosRuedas = new JMenuItem("Lista de vehículos con 2 ruedas");
        JMenuItem itemListaCuatroRuedas = new JMenuItem("Lista de Vehículos de 4 ruedas");
        JMenuItem itemTotalVehiculos = new JMenuItem("Número de vehículos totales");

        itemEntrada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarEntradaVehiculo();
            }
        });

        itemSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarSalidaVehiculo();
            }
        });

        itemListaDosRuedas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarListaDosRuedas();
            }
        });

        itemListaCuatroRuedas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarListaCuatroRuedas();
            }
        });

        itemTotalVehiculos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarTotalVehiculos();
            }
        });

        menu.add(itemEntrada);
        menu.add(itemSalida);
        menu.add(itemListaDosRuedas);
        menu.add(itemListaCuatroRuedas);
        menu.add(itemTotalVehiculos);
        barraMenu.add(menu);
        setJMenuBar(barraMenu);

        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(3, 2));
        campoPlaca = new JTextField();
        campoTipo = new JTextField();
        JButton botonEntrada = new JButton("Entrada");

        botonEntrada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarEntradaVehiculo();
            }
        });

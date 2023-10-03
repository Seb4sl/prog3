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

        panelEntrada.add(new JLabel("Placa:"));
        panelEntrada.add(campoPlaca);
        panelEntrada.add(new JLabel("Tipo de vehículo:"));
        panelEntrada.add(campoTipo);
        panelEntrada.add(new JLabel(""));
        panelEntrada.add(botonEntrada);

        areaRegistro = new JTextArea();
        areaRegistro.setEditable(false);
        areaRegistro.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaRegistro.setBackground(Color.LIGHT_GRAY);
        JScrollPane panelDesplazamiento = new JScrollPane(areaRegistro);

        add(panelEntrada, BorderLayout.NORTH);
        add(panelDesplazamiento, BorderLayout.CENTER);
    }

    private void registrarEntradaVehiculo() {
        String placa = campoPlaca.getText();
        String tipo = campoTipo.getText();
        Date horaEntrada = new Date();
        int numero = numeroVehiculo++;

        Vehiculo vehiculo = new Vehiculo(placa, tipo, horaEntrada, numero);
        vehiculos.add(vehiculo);

        registrarMensaje("Entrada del vehículo: " + vehiculo);

        campoPlaca.setText("");
        campoTipo.setText("");
    }

    private void registrarSalidaVehiculo() {
        JDialog dialogo = new JDialog(this, "Salida del vehículo: ", true);
        dialogo.setLayout(new GridLayout(3, 2));
        JTextField campoPlacaSalida = new JTextField();
        JButton botonSalida = new JButton("Salir");

        botonSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialogo.dispose();
            }
        });

        dialogo.add(new JLabel("Placa del vehículo retirado:"));
        dialogo.add(campoPlacaSalida);
        dialogo.add(new JLabel(""));
        dialogo.add(botonSalida);

        dialogo.setSize(300, 100);
        dialogo.setVisible(true);

        String placa = campoPlacaSalida.getText();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                Date horaSalida = new Date();
                double costo = vehiculo.calcularCosto(horaSalida);
                long minutosTotales = vehiculo.calcularTiempoTotal(horaSalida);

                registrarMensaje("Salida del vehículo: " + vehiculo);
                registrarMensaje("Entrada (Fecha ; Hora): " + vehiculo.getHoraEntrada());
                registrarMensaje("Salida (Fecha ; Hora) " + horaSalida);
                registrarMensaje("Tiempo total del vehículo estacionado: " + minutosTotales + " minutos");
                registrarMensaje("Total a pagar $$: " + costo);

                vehiculos.remove(vehiculo);
                return;
            }
        }
        registrarMensaje("Vehículo No Encontrado.");
    }

    private void mostrarListaDosRuedas() {
        registrarMensaje("Lista de vehículos con 2 ruedas:");
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getTipo().equalsIgnoreCase("Bicicleta") || vehiculo.getTipo().equalsIgnoreCase("Motocicleta")) {
                registrarMensaje(vehiculo.toString());
            }
        }
    }

    private void mostrarListaCuatroRuedas() {
        registrarMensaje("Lista de vehículos con 4 ruedas:");
        double costoTotal = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (!vehiculo.getTipo().equalsIgnoreCase("Bicicleta") && !vehiculo.getTipo().equalsIgnoreCase("Monopatín")) {
                double costo = vehiculo.calcularCosto(new Date());
                registrarMensaje(vehiculo.toString() + ", Total a pagar: $" + costo);
                costoTotal += costo;
            }
        }
        registrarMensaje("Total a pagar (Vehículos de 4 ruedas): $" + costoTotal);
    }

    private void mostrarTotalVehiculos() {
        registrarMensaje("Número de vehículos ingresados en el parqueadero : " + vehiculos.size());
    }

    private void registrarMensaje(String mensaje) {
        Date ahora = new Date();
        String marcaTiempo = formatoFecha.format(ahora);
        areaRegistro.append(marcaTiempo + " - " + mensaje + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AplicacionParqueadero aplicacion = new AplicacionParqueadero();
                aplicacion.setVisible(true);
            }
        });
    }
}

class Vehiculo {
    private String placa;
    private String tipo;
    private Date horaEntrada;
    private int numero;

    public Vehiculo(String placa, String tipo, Date horaEntrada, int numero) {
        this.placa = placa;
        this.tipo = tipo;
        this.horaEntrada = horaEntrada;
        this.numero = numero;
    }

    public double calcularCosto(Date horaSalida) {
        long minutos = (horaSalida.getTime() - horaEntrada.getTime()) / (1000 * 60);
        if (minutos >= 720) {
            return 60 * 720;
        } else {
            return minutos * 1.0;
        }
    }

    public long calcularTiempoTotal(Date horaSalida) {
        return (horaSalida.getTime() - horaEntrada.getTime()) / (1000 * 60);
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    @Override
    public String toString() {
        return "Número: " + numero + ", Placa: " + placa + ", Tipo: " + tipo;
    }
}

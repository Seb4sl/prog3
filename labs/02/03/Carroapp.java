//Venta de autos Juan Sebastian Larrota Correa (7004169)
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
public class CarrosApp extends javax.swing.JFrame {
    
    int i = 0; // Contador de carros agregados
    DefaultTableModel modelo;
    

    public class Carro { // Declaración de la clase "Carro" para almacenar información sobre los autos.
        String marca;
        int modelo;
        String color;
        int kilometraje;

        public Carro(String marca, int modelo, String color, int kilometraje) { // Constructor de la clase Carro para inicializar sus atributos.
            this.marca = marca;
            this.modelo = modelo;
            this.color = color;
            this.kilometraje = kilometraje;
        }
    }

    Carro[] carros = new Carro[10]; // Arreglo de objetos Carro para almacenar los autos.

public CarrosApp() {
    initComponents(); //Inicializacion para la tabña y sus caracteristicas
    modelo = new DefaultTableModel();
    modelo.addColumn("Marca");
    modelo.addColumn("Modelo");
    modelo.addColumn("Color");
    modelo.addColumn("Kilometraje");
    this.tablaCarros.setModel(modelo);
    
    this.setLocationRelativeTo(null); // Centra la ventana en la pantalla
    this.setVisible(true); // Hacer visible la ventana después de centrarla
}


    public static void mergeSort(Carro[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(Carro[] arr, int left, int middle, int right) { //Se encarga de combinar dos subarreglos ordenados en uno solo, manteniendo la propiedad de orden.
        int n1 = middle - left + 1;
        int n2 = right - middle; //calculan las longitudes de los dos subarreglos que se van a combinar.

        Carro[] leftArr = new Carro[n1];
        Carro[] rightArr = new Carro[n2]; //Se crean dos nuevos arreglos de objetos para almacenar temporalmente los subarreglos izquierdo y derecho.

        for (int i = 0; i < n1; ++i) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) { // comparar los elementos y combinarlos en el arreglo "arr"
            if (leftArr[i].modelo <= rightArr[j].modelo) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        } //  copiar cualquier elemento restante si alguno de los subarreglos tenga elementos sin procesar.
    }

    private void initComponents() { //Componentes de GUI
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCarros = new javax.swing.JTable();
        marcaField = new javax.swing.JTextField();
        modeloField = new javax.swing.JTextField();
        colorField = new javax.swing.JTextField();
        kilometrajeField = new javax.swing.JTextField();
        getContentPane().setBackground(new java.awt.Color(4, 180, 174)); // Cambia el color de fondo
        agregarButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();
        eliminarTodoButton = new javax.swing.JButton();
        ordenarModeloButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        agregarButton.setBackground(new java.awt.Color(255, 255, 255));
        agregarButton.setForeground(new java.awt.Color(33, 11, 97));
        limpiarButton.setBackground(new java.awt.Color(255, 255, 255));
        limpiarButton.setForeground(new java.awt.Color(33, 11, 97));
        eliminarTodoButton.setBackground(new java.awt.Color(255, 255, 255));
        eliminarTodoButton.setForeground(new java.awt.Color(33, 11, 97));
        ordenarModeloButton.setBackground(new java.awt.Color(255, 255, 255));
        ordenarModeloButton.setForeground(new java.awt.Color(33, 11, 97));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaCarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Marca", "Modelo", "Color", "Kilometraje"
            }
        ));
        jScrollPane1.setViewportView(tablaCarros);

        agregarButton.setText("Agregar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        limpiarButton.setText("Limpiar");
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });

        eliminarTodoButton.setText("Eliminar Todo");
        eliminarTodoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTodoButtonActionPerformed(evt);
            }
        });

        ordenarModeloButton.setText("Ordenar por Modelo");
        ordenarModeloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenarModeloButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 22));
        jLabel1.setText("Concesionario Larrota-911"); // Cambiar el texto aquí


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(marcaField)
                            .addComponent(modeloField)
                            .addComponent(colorField)
                            .addComponent(kilometrajeField, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregarButton)
                            .addComponent(limpiarButton)
                            .addComponent(eliminarTodoButton)
                            .addComponent(ordenarModeloButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modeloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarTodoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kilometrajeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ordenarModeloButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {  //Agregar datos a la tabla
        String[] info = new String[4];
        info[0] = marcaField.getText();
        info[1] = modeloField.getText();
        info[2] = colorField.getText();
        info[3] = kilometrajeField.getText();
        modelo.addRow(info);

        carros[i] = new Carro(marcaField.getText(), Integer.parseInt(modeloField.getText()), colorField.getText(), Integer.parseInt(kilometrajeField.getText())); // Ir agregando mas datos a la tabla
        i++;

        marcaField.setText("");
        modeloField.setText("");
        colorField.setText("");
        kilometrajeField.setText("");
    }

    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) { //Quitar datos
        marcaField.setText("");
        modeloField.setText("");
        colorField.setText("");
        kilometrajeField.setText("");
    }

    private void eliminarTodoButtonActionPerformed(java.awt.event.ActionEvent evt) { //Eliminar todo
        int fila = tablaCarros.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void ordenarModeloButtonActionPerformed(java.awt.event.ActionEvent evt) { //Organizarde menor a mayor para el modelo y para el kilometraje.
        mergeSort(carros, 0, carros.length - 1);

        int rowCount = modelo.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }

        for (Carro carro : carros) {
            if (carro != null) {
                String[] info = new String[4];
                info[0] = carro.marca;
                info[1] = String.valueOf(carro.modelo);
                info[2] = carro.color;
                info[3] = String.valueOf(carro.kilometraje);
                modelo.addRow(info);
            }
        }
    }

    public static void main(String args[]) { //Muestra
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarrosApp().setVisible(true);
            }
        });
    }

    private javax.swing.JButton agregarButton;
    private javax.swing.JTextField colorField;
    private javax.swing.JButton eliminarTodoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kilometrajeField;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JTextField marcaField;
    private javax.swing.JTextField modeloField;
    private javax.swing.JButton ordenarModeloButton;
    private javax.swing.JTable tablaCarros;
}

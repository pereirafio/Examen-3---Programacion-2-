/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Logica.ParqueoService;
import Entidades.Registro;

import javax.swing.*;
import java.awt.*;
import java.util.List;
/**
 *
 * @author katherinepereira
 */
public class VentanaPrincipal extends JFrame {

    private JTextField txtPlaca;
    private JComboBox<String> cmbTipo;

    private JTable tabla;

    private ParqueoService servicio;

    public VentanaPrincipal() {

        servicio = new ParqueoService();

        setTitle("Sistema Parqueo Publico");

        setSize(700, 400);

        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel();

        txtPlaca = new JTextField(10);

        cmbTipo = new JComboBox<>();

        cmbTipo.addItem("Carro");
        cmbTipo.addItem("Moto");

        JButton btnIngreso = new JButton("Registrar Ingreso");

        JButton btnSalida = new JButton("Registrar Salida");

        panelForm.add(new JLabel("Placa"));
        panelForm.add(txtPlaca);

        panelForm.add(new JLabel("Tipo"));
        panelForm.add(cmbTipo);

        panelForm.add(btnIngreso);
        panelForm.add(btnSalida);

        add(panelForm, BorderLayout.NORTH);

        tabla = new JTable();

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnIngreso.addActionListener(e -> registrarIngreso());

        btnSalida.addActionListener(e -> registrarSalida());

        actualizarTabla();

    }

    private void registrarIngreso() {

        String placa = txtPlaca.getText();

        String tipo = cmbTipo.getSelectedItem().toString();

        servicio.registrarIngreso(placa, tipo);

        actualizarTabla();

    }

    private void registrarSalida() {

        String placa = txtPlaca.getText();

        servicio.registrarSalida(placa);

        actualizarTabla();

    }

    private void actualizarTabla() {

        List<Registro> lista = servicio.obtenerHistorial();

        ModeloTablaRegistro modelo = new ModeloTablaRegistro(lista);

        tabla.setModel(modelo);

    }

}
   

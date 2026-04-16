/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.RegistroDAO;
import Entidades.Registro;
import Entidades.Vehiculo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.List;

public class ParqueoService {

    private RegistroDAO dao = new RegistroDAO();

    private DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");

    public Registro ingresar(String placa, String tipo) {

        if (placa == null || placa.trim().isEmpty()) {
            return null;
        }

        if (dao.existeActivo(placa)) {
            return null;
        }

        Vehiculo v = new Vehiculo(placa, tipo);
        LocalDateTime entrada = LocalDateTime.now();

        Registro r = new Registro(v, entrada);
        r.setEntrada(entrada.format(formatter));

        dao.guardarActivo(r);

        return r;
    }

    public Registro salida(String placa) {

        Registro r = dao.buscarActivo(placa);

        if (r == null) {
            return null;
        }

        LocalDateTime salida = LocalDateTime.now();
        r.setSalida(salida.format(formatter));
        r.setSalidaReal(salida);

        long minutos = Duration.between(r.getEntradaReal(), salida).toMinutes();
        long horas = minutos / 60;

        if (minutos % 60 != 0) {
            horas++;
        }

        if (horas < 1) {
            horas = 1;
        }

        double monto = horas * 500;
        r.setMonto(monto);

        dao.moverAHistorial(r);
        dao.eliminarActivo(placa);

        return r;
    }

    public RegistroDAO getDao() {
        return dao;
    }

    public List<Registro> obtenerHistorial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void registrarSalida(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void registrarIngreso(String placa, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
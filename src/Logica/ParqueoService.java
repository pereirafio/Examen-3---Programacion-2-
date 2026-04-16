/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.RegistroDAO;
import Entidades.Registro;
import Entidades.Vehiculo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author katherinepereira
 */
public class ParqueoService {
    
    private RegistroDAO dao = new RegistroDAO();

    private List<Registro> registros = new ArrayList<>();

    private double TARIFA = 500;

    public ParqueoService() {
        registros = dao.leerRegistros();
    }

    public boolean registrarIngreso(String placa, String tipo) {

        if (placa == null || placa.isEmpty()) {
            return false;
        }

        if (tipo == null || tipo.isEmpty()) {
            return false;
        }

        for (Registro r : registros) {

            if (r.getVehiculo().getPlaca().equals(placa) && r.getHoraSalida() == null) {
                return false;
            }

        }

        Vehiculo v = new Vehiculo(placa, tipo);

        Registro r = new Registro(v, LocalDateTime.now());

        registros.add(r);

        dao.guardarRegistro(r);

        return true;

    }

    public boolean registrarSalida(String placa) {

        for (Registro r : registros) {

            if (r.getVehiculo().getPlaca().equals(placa) && r.getHoraSalida() == null) {

                LocalDateTime salida = LocalDateTime.now();

                r.setHoraSalida(salida);

                long minutos = Duration.between(r.getHoraEntrada(), salida).toMinutes();

                double horas = Math.ceil(minutos / 60.0);

                double monto = horas * TARIFA;

                r.setMonto(monto);

                dao.guardarRegistro(r);

                return true;

            }

        }

        return false;

    }

    public List<Registro> obtenerActivos() {

        List<Registro> activos = new ArrayList<>();

        for (Registro r : registros) {

            if (r.getHoraSalida() == null) {
                activos.add(r);
            }

        }

        return activos;

    }

    public List<Registro> obtenerHistorial() {
        return registros;
    }

}
    


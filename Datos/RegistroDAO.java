/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Entidades.Registro;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAO {

    private List<Registro> activos = new ArrayList<>();
    private List<Registro> historial = new ArrayList<>();

    public boolean existeActivo(String placa) {
        for (Registro r : activos) {
            if (r.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }

    public void guardarActivo(Registro r) {
        activos.add(r);
    }

    public Registro buscarActivo(String placa) {
        for (Registro r : activos) {
            if (r.getPlaca().equalsIgnoreCase(placa)) {
                return r;
            }
        }
        return null;
    }

    public void eliminarActivo(String placa) {
        activos.removeIf(r -> r.getPlaca().equalsIgnoreCase(placa));
    }

    public void moverAHistorial(Registro r) {
        historial.add(r);
    }

    public List<Registro> getActivos() {
        return activos;
    }

    public List<Registro> getHistorial() {
        return historial;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDateTime;

public class Registro {

    private Vehiculo vehiculo;

    private LocalDateTime entradaReal;
    private LocalDateTime salidaReal;

    private String entrada;
    private String salida;

    private double monto;

    public Registro() {
    }

    public Registro(Vehiculo vehiculo, LocalDateTime entradaReal) {
        this.vehiculo = vehiculo;
        this.entradaReal = entradaReal;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getPlaca() {
        return vehiculo.getPlaca();
    }

    public String getTipo() {
        return vehiculo.getTipo();
    }

    public LocalDateTime getEntradaReal() {
        return entradaReal;
    }

    public void setEntradaReal(LocalDateTime entradaReal) {
        this.entradaReal = entradaReal;
    }

    public LocalDateTime getSalidaReal() {
        return salidaReal;
    }

    public void setSalidaReal(LocalDateTime salidaReal) {
        this.salidaReal = salidaReal;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
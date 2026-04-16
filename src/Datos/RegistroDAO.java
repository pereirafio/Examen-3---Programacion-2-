/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Entidades.Registro;
import Entidades.Vehiculo;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author katherinepereira
 */
public class RegistroDAO {

    private String archivo = "registros.txt";

    public void guardarRegistro(Registro r) {

        try {

            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(
                    r.getVehiculo().getPlaca() + ";" +
                    r.getVehiculo().getTipo() + ";" +
                    r.getHoraEntrada() + ";" +
                    r.getHoraSalida() + ";" +
                    r.getMonto()
            );

            bw.newLine();
            bw.close();

        } catch (Exception e) {

        }

    }

    public List<Registro> leerRegistros() {

        List<Registro> lista = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                Vehiculo v = new Vehiculo(datos[0], datos[1]);

                Registro r = new Registro(v, LocalDateTime.parse(datos[2]));

                if (!datos[3].equals("null")) {
                    r.setHoraSalida(LocalDateTime.parse(datos[3]));
                }

                r.setMonto(Double.parseDouble(datos[4]));

                lista.add(r);
            }

            br.close();

        } catch (Exception e) {

        }

        return lista;
    }

}
    


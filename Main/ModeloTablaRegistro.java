/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Entidades.Registro;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author katherinepereira
 */
public class ModeloTablaRegistro extends AbstractTableModel {

    private List<Registro> lista;

    private String[] columnas = {
        "Placa", "Tipo", "Entrada", "Salida", "Monto"
    };

    public ModeloTablaRegistro(List<Registro> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Registro r = lista.get(rowIndex);

        switch (columnIndex) {

            case 0:
                return r.getVehiculo().getPlaca();

            case 1:
                return r.getVehiculo().getTipo();

            case 2:
                return r.getHoraEntrada();

            case 3:
                return r.getHoraSalida();

            case 4:
                return r.getMonto();
        }

        return null;
    }

}
    


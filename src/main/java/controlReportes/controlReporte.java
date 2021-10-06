/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlReportes;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import token.error;
import token.identificadores;
import token.token;

/**
 *
 * @author AndaryuS
 */
public class controlReporte {

    ArrayList<token> tokens;
    ArrayList<error> errores;
    ArrayList<String> bitacora;

    int ID = 0;
    int Decima = 0;
    int Numero = 0;
    int Agrupacion = 0;
    int Puntuacion = 0;
    int Operador = 0;

    public void recibirTokens(ArrayList tokensR) {
        tokens = tokensR;
    }

    public void recibirErrores(ArrayList erroresR) {
        errores = erroresR;
    }

    public void recibirBitacora(ArrayList bitacoraR) {
        this.bitacora = bitacoraR;
    }

    public void reporteTokens(JTable tabla) {

        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);

        modelo.addColumn("ID");
        modelo.addColumn("CADENA");
        modelo.addColumn("FILA");
        modelo.addColumn("COLUMNA");

        for (token token : tokens) {
            modelo.addRow(new Object[]{token.getId(), token.getCadena(), token.getFila(), token.getColumna()});
        }

    }

    public void recuentoTokens() {
        for (token token : tokens) {
            if (token.getId() == identificadores.AGRUPACION) {
                Agrupacion++;
            } else if (token.getId() == identificadores.DECIMAL) {
                Decima++;
            } else if (token.getId() == identificadores.IDENTIFICADOR) {
                ID++;
            } else if (token.getId() == identificadores.NUMERO) {
                Numero++;
            } else if (token.getId() == identificadores.OPERADOR) {
                Operador++;
            } else if (token.getId() == identificadores.PUNTUACION) {
                Puntuacion++;
            }
        }
    }

    public void reporteRecuento(JTable tabla) {
        recuentoTokens();
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);

        modelo.addColumn("Nombre Token");
        modelo.addColumn("Cantidad de repeticiones");

        modelo.addRow(new Object[]{"Identificador", ID});
        modelo.addRow(new Object[]{"Numero", Numero});
        modelo.addRow(new Object[]{"Decimales", Decima});
        modelo.addRow(new Object[]{"Agrupacion", Agrupacion});
        modelo.addRow(new Object[]{"Puntuacion",Puntuacion});
        modelo.addRow(new Object[]{"Operador",Operador});

    }

    public void reporteErrores(JTable tabla) {

        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);

        modelo.addColumn("CADENA");
        modelo.addColumn("CARACTER");
        modelo.addColumn("FILA");
        modelo.addColumn("COLUMNA");

        for (error error : errores) {
            modelo.addRow(new Object[]{error.getCadena(), error.getCaracter(), error.getFila(), error.getColumna()});
        }

    }

    public void cambioEstados(JTextArea panel) {
        String newline = "\n";
        for (int i = 0; i < tokens.size(); i++) {
            token tokenTmp = tokens.get(i);
            String cadena = "Cadena : " + tokenTmp.getCadena();
            String cambioE = bitacora.get(i);
            panel.append(cadena + newline);
            panel.append(cambioE + newline);

        }

    }

}

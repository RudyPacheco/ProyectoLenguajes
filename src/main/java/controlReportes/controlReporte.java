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
import token.token;

/**
 *
 * @author AndaryuS
 */
public class controlReporte {

    ArrayList<token> tokens;
    ArrayList<error> errores;
    ArrayList<String> bitacora;

    public void recibirTokens(ArrayList tokensR) {
        tokens = tokensR;
    }

    public void recibirErrores(ArrayList erroresR) {
        errores = erroresR;
    }

    public void recibirBitacora(ArrayList bitacoraR){
        this.bitacora=bitacoraR;
    }
    
    public void reporteTokens(JTable tabla) {

        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);

        modelo.addColumn("ID");
        modelo.addColumn("CADENA");
        modelo.addColumn("FILA");
        modelo.addColumn("COLUMNA");

        for (token token : tokens) {
            modelo.addRow(new Object[]{token.getId(), token.getCadena(),token.getFila(),token.getColumna()});
        }

    }

    public void reporteErrores(JTable tabla) {

        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);

        modelo.addColumn("CADENA");
        modelo.addColumn("CARACTER");
        modelo.addColumn("FILA");
        modelo.addColumn("COLUMNA");

        for (error error : errores) {
            modelo.addRow(new Object[]{error.getCadena(),error.getCaracter(),error.getFila(),error.getColumna()});
        }

    }
    
    public void cambioEstados(JTextArea panel){
        String newline = "\n";
        for (int i = 0; i < tokens.size(); i++) {
            token tokenTmp =tokens.get(i);
            String cadena="Cadena : "+tokenTmp.getCadena();
            String cambioE =bitacora.get(i);
            panel.append(cadena+newline);
            panel.append(cambioE+newline);
       
        }
        
        
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package token;

/**
 *
 * @author AndaryuS
 */
public class token {

    private String cadena;
    private identificadores id;
    private int fila;
    private int columna;

    public token() {

    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public identificadores getId() {
        return id;
    }

    public void setId(identificadores id) {
        this.id = id;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    
    
    
}

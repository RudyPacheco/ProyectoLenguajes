/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.util.ArrayList;

/**
 *
 * @author AndaryuS
 */
public class alfabeto {

    private ArrayList<Character> puntuacion;
    private ArrayList<Character> operador;
    private ArrayList<Character> agrupacion;

    public alfabeto() {
        iniciarAlfabeto();
    }

    private void iniciarAlfabeto() {
        puntuacion();
        operador();
        agrupacion();
    }

    public void puntuacion() {
        puntuacion = new ArrayList<>();
        puntuacion.add('.');
        puntuacion.add(',');
        puntuacion.add(':');
        puntuacion.add(';');
    }

    public void operador() {
        operador = new ArrayList<>();
        operador.add('+');
        operador.add('-');
        operador.add('*');
        operador.add('/');
        operador.add('%');
    }

    public void agrupacion() {
        agrupacion = new ArrayList<>();
        agrupacion.add('(');
        agrupacion.add(')');
        agrupacion.add('{');
        agrupacion.add('}');
        agrupacion.add('[');
        agrupacion.add(']');
    }

    /*
    letra-->0
    digito-->1
    punto-->2
    puntuacion-->3
    operador-->4
    agrupacion-->5
    
     */
    public int convertirAlfabeto(char caracter) {
        int valor = -1;

        if (Character.isLetter(caracter)) {
            valor = 0;
        } else if (Character.isDigit(caracter)) {
            valor = 1;
        } else if (Character.compare(caracter, puntuacion.get(0)) == 0) {
            valor = 2;
        } else if (puntuacion.contains(caracter)) {
            valor = 3;
        } else if (operador.contains(caracter)) {
            valor = 4;
        } else if (agrupacion.contains(caracter)) {
            valor = 5;
        } else if (Character.isSpaceChar(caracter)) {
            valor = -2;
        }else if (caracter=='\n') {
            valor =-3;
        }

        return valor;
    }

    public int alfabetoValueOf(char caracter) {
        int valor = -1;
        if (Character.isLetter(caracter)) {
            valor = 0;
        } else if (Character.isDigit(caracter)) {
            valor = 1;
        } else if (Character.compare(caracter, puntuacion.get(0)) == 0) {
            valor = 2;
        } else if (agrupacion.contains(caracter)) {
            valor = 4;
        } else if (operador.contains(caracter)) {
            valor = 5;
        } else if (puntuacion.contains(caracter)) {
            valor = 3;
        } else if (Character.isSpaceChar(caracter)) {
            valor = -2;
            
//        } else if (Character.isSpaceChar(caracter) || caracter == '\n') {
//            valor = -2;
        }else if (caracter=='\n') {
          valor=-3;  
        }

        return valor;
    }

}

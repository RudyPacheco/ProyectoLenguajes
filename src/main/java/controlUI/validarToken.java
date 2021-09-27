/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlUI;

import funciones.alfabeto;
import funciones.matrizTransicion;
import funciones.recolector;
import java.util.ArrayList;
import javax.swing.JFrame;
import ui.pantallaReportes;

/**
 *
 * @author AndaryuS
 */
public class validarToken {

    private final alfabeto alfabeto = new alfabeto();
    private final matrizTransicion matrizTransicion = new matrizTransicion();
    recolector recolector = new recolector();
    private String cadena;
    char caracter;
    private int fila = 1;
    private int columna;
    ArrayList<String> tokens = new ArrayList<>();
    private int estadoActual;

    // \| -->0 
    // \d -->1
    int transicion[][] = new int[8][6];

    {
        transicion[0][0] = 4;
        transicion[4][0] = 4;
        transicion[4][1] = 4;
    }

    public void recibiriCadena(String cadenaRecibidia, JFrame home) {
        this.cadena = cadenaRecibidia;
        cadena += " ";
        System.out.println("Cadena recibida  " + cadena);
        System.out.println("****Cadena desglosada****");
        prueba();
        recolector.imprimirTokens();
        pantallaReportes(home);
//        leerCadena();
        //   leerCadena();
//        for (int i = 0; i < tokens.size(); i++) {
//            String tmp = tokens.get(i);
//            System.out.println(tmp);
//        }
    }

    public void leerCadena() {
        String resultado = "";
        String tokenTMP = "";

        for (int i = 0; i < cadena.length(); i++) {
            caracter = cadena.charAt(i);
            if (Character.isSpaceChar(caracter) || caracter == '\n') {
                if (caracter == '\n') {
                    fila++;
                    columna = 0;
                    resultado += "\n";
                    if (!tokenTMP.equals("")) {
                        tokens.add(tokenTMP);
                        tokenTMP = "";
                    }

                } else {
                    columna++;
                    resultado += " ";

                    if (!tokenTMP.equals("")) {
                        tokens.add(tokenTMP);
                        tokenTMP = "";
                    }
                }
            } else {
                columna++;
                //  System.out.println("El caracter " + caracter + " Esta en la fila " + fila + " Columna " + columna);
                resultado += caracter;
                tokenTMP += caracter;

            }
            System.out.println("Token : " + tokenTMP);
        }
        // System.out.println(resultado);
    }

    public void prueba() {
        char temp;
        estadoActual = 0;
        for (int i = 0; i < cadena.length(); i++) {
            temp = cadena.charAt(i);
            int tempC = alfabeto.convertirAlfabeto(temp);
            System.out.println("caracter  " + temp + "  caracter int  " + tempC);
            int estadoTMP = siguienteEstado(estadoActual, alfabeto.convertirAlfabeto(temp));
            System.out.println(estadoTMP);
     //       String cambioEstado="Me movi del estado :"+estadoActual+" Al estado : "+estadoTMP+" con el careacter "+temp;
        //    System.out.println(cambioEstado);
            //  recolector.recolectar(temp, tempC);
            recolector.recolectar2(temp, estadoTMP);
            this.estadoActual = estadoTMP;
            if (!continuarLeyendo(caracter) || reiniciar(estadoActual)) {
                estadoActual = 0;
                System.out.println("reiniciando");
            }

        }
        // recolector.imprimirTokens();
    }

    public boolean continuarLeyendo(char caracterRecibido) {
        boolean seguir = true;
        if (Character.isSpaceChar(caracterRecibido) || caracterRecibido == '\n') {
            seguir = false;
        }

        return seguir;
    }

    private boolean reiniciar(int estado) {
        boolean reiniciar = false;
        if (estado == -1 || estado == -2) {
            reiniciar = true;
        }
        return reiniciar;
    }

    public void leerCadena2() {
        boolean termino = false;
        char tmp;

        for (int i = 0; i < cadena.length(); i++) {
            tmp = cadena.charAt(i);
            if (Character.isSpaceChar(tmp)) {
                termino = true;
//                if (tmp==' ' || tmp=='\n') {
//                    
//                }else{
//                System.out.println("");      
//                }
                //    System.out.println("");

            } else {
                System.out.print(tmp);
            }
        }

    }

    public int convertirCaracter(char caracter) {
        int caracterInt = -1;

        if (Character.isLetter(caracter)) {
            caracterInt = 0;
        }

        if (Character.isDigit(caracter)) {
            caracterInt = 1;
        }

        return caracterInt;
    }

    public int siguienteEstado(int estadoActual, int caracter) {
        int estado = -1;
        if (caracter >= 0 && caracter <= 5) {
            estado = matrizTransicion.getMatriz()[estadoActual][caracter];

        } else if (caracter == -2) {
            estado = -2;
        }

        return estado;
    }

    public void pantallaReportes(JFrame home) {
        pantallaReportes pantalla = new pantallaReportes(home, recolector.getTokensLimpios(), recolector.getErrores(),recolector.getBitacora());
        pantalla.setVisible(true);
    }

}

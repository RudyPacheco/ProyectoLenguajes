/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.util.ArrayList;
import token.error;
import token.identificadores;
import token.token;

/**
 *
 * @author AndaryuS
 */
public class recolector {

    ArrayList<String> tokens = new ArrayList<>();
    //ArrayList<String> errores = new ArrayList<>();
    ArrayList<token> tokensLimpios = new ArrayList<>();
    ArrayList<error> errores = new ArrayList<>();
    ArrayList<String> bitacora = new ArrayList<>();
    matrizTransicion matriz = new matrizTransicion();
    int estadosFinalizacion[] = matriz.getEstadosFinalizacion();
    private String tokenActual = "";
    String cambioEstados="";
    int estadoActua = 0;
    int fila = 1;
    int columna = 1;
   

    public recolector() {

    }

    public void recolectar(char caracter, int estado) {
   
        if (estado >= 0 && estado <= 7) {

            tokenActual += caracter;
            cambioEstados += "Me movi del estado " + estadoActua + " al estado " +estado +" con el caracter "+ caracter+"\n";
          
            // System.out.println(cambioEstados);
            estadoActua = estado;
            columna++;

            //  System.out.println("token actual " +tokenActual);
        } else {
            if (!tokenActual.equals("")) {
                tokenActual += caracter;
                //validar(tokenActual, caracter, estado);
                if (estado == -1) {
                    columna++;
                    agregarError(tokenActual, caracter, fila, columna);
                }
                if (estado == -2) {
                    columna++;

                    validar(tokenActual, caracter, estadoActua, fila, columna);
                }
                if (estado == -3) {
                     columna++;
                     validar(tokenActual, caracter, estadoActua, fila, columna);
                    fila++;
                    columna = 1;
                   
                }
                  bitacora.add(cambioEstados);
                //  tokens.add(tokenActual);
                //System.out.println("añadio "+tokenActual);
                cambioEstados="";
                tokenActual = "";
                estadoActua=0;
            }
        }
    }

//    public void recolectar(char caracter, int estado) {
//        // System.out.println("recolecor");
//
//        if (estado == -1) {
//            if (!tokenActual.equals("")) {
//                tokenActual += caracter;
//                tokens.add(tokenActual);
//                System.out.println("añadio " + tokenActual);
//                tokenActual = "";
//            }
//        } else {
//            if (estado == -2) {
//                tokenActual = "";
//            } else {
//                tokenActual += caracter;
//            }
//
//        }

//        if (estado >= 0 && estado <= 5) {
//            tokenActual += caracter;
//            //  System.out.println("token actual " +tokenActual);
//        } else {
//            if (!tokenActual.equals("")) {
//                tokens.add(tokenActual);
//                //System.out.println("añadio "+tokenActual);
//                tokenActual = "";
//            }
//        }
    //}

    public void agregarError(String cadena, char caracter, int fila, int columna) {
        error errorTMP = new error();
        errorTMP.setCadena(cadena);
        errorTMP.setCaracter(caracter);
        errorTMP.setFila(fila);
        errorTMP.setColumna(columna);
        errorTMP.setId(identificadores.ERROR);
        errores.add(errorTMP);
    }

    public void agregarToken(String cadena, int estado, int fila, int columna) {
        int columnaTMP = columna - cadena.length();
        
        System.out.println("Columna nueva "+columnaTMP);
        token tokenTMP = new token();
        tokenTMP.setCadena(cadena);
        tokenTMP.setId(matriz.id(estado));
        tokenTMP.setFila(fila);
        tokenTMP.setColumna(columnaTMP);
        tokensLimpios.add(tokenTMP);
    }

    public boolean comprobarEstado(int estado) {
        boolean estadoAceptado = false;
        for (int estadoF : estadosFinalizacion) {
            if (estadoF == estado) {
                estadoAceptado = true;
            }
        }

        return estadoAceptado;
    }

    public void validar(String cadena, char caracter, int estado, int fila, int columna) {
//
//        System.out.println("estado recibido " + estado);
//        System.out.println("caracer recibido "+caracter);
//        
        System.out.println(fila +" "+columna);
        System.out.println(cadena);
        char tmp = cadena.charAt(cadena.length() - 2);
        // System.out.println("tmp "+tmp);
        if (comprobarEstado(estado)) {
            agregarToken(cadena, estado, fila, columna);
        } else {
            agregarError(cadena, tmp, fila, columna);
        }

//        for (int estadoF : estadosFinalizacion) {
//            if (estadoF == estado) {
//                token tokenTMP = new token();
//                tokenTMP.setCadena(cadena);
//
//                tokenTMP.setId(matriz.id(estado));
//                tokensLimpios.add(tokenTMP);
//            }
//        }
    }

    public ArrayList<String> getTokens() {
        return tokens;
    }

    public ArrayList<token> getTokensLimpios() {
        return tokensLimpios;
    }

    public ArrayList<error> getErrores() {
        return errores;
    }

    public ArrayList<String> getBitacora() {
        return bitacora;
    }

    
    
    
    public void imprimirTokens() {
        System.out.println("Tokens almacenados");
//        for (int i = 0; i < tokens.size(); i++) {
//            String temp = tokens.get(i);
//            System.out.println(temp);
//        }
        for (int i = 0; i < tokensLimpios.size(); i++) {
            token temp = tokensLimpios.get(i);
            System.out.println("TOKEN : " + temp.getCadena() + " ID : " + temp.getId());
        }

        System.out.println("Errores");
        for (int i = 0; i < errores.size(); i++) {
            error temp = errores.get(i);
            System.out.println("ERROR : " + temp.getCadena() + " CARACTER : " + temp.getCaracter());
        }
    }

}

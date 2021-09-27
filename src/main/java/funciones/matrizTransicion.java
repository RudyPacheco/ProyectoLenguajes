/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import token.identificadores;

/**
 *
 * @author AndaryuS
 */

/*
    letra-->0
    digito-->1
    punto-->2
    puntuacion-->3
    operador-->4
    agrupacion-->5
    
 */
public class matrizTransicion {

    private int matriz[][] = new int[8][6];
    private int estadosFinalizacion[] = new int[6];

    public matrizTransicion() {
        estadosTransicion();
        estadosFinalizacion();
    }

    private void estadosTransicion() {
        this.matriz[0][0] = 4;
        this.matriz[0][1] = 1;
        this.matriz[0][2] = -1;
        this.matriz[0][3] = 5;
        this.matriz[0][4] = 6;
        this.matriz[0][5] = 7;

        this.matriz[1][0] = -1;
        this.matriz[1][1] = 1;
        this.matriz[1][2] = 2;
        this.matriz[1][3] = -1;
        this.matriz[1][4] = -1;
        this.matriz[1][5] = -1;

        this.matriz[2][0] = -1;
        this.matriz[2][1] = 3;
        this.matriz[2][2] = -1;
        this.matriz[2][3] = -1;
        this.matriz[2][4] = -1;
        this.matriz[2][5] = -1;

        this.matriz[3][0] = -1;
        this.matriz[3][1] = 3;
        this.matriz[3][2] = -1;
        this.matriz[3][3] = -1;
        this.matriz[3][4] = -1;
        this.matriz[3][5] = -1;

        this.matriz[4][0] = 4;
        this.matriz[4][1] = 4;
        this.matriz[4][2] = -1;
        this.matriz[4][3] = -1;
        this.matriz[4][4] = -1;
        this.matriz[4][5] = -1;

        this.matriz[5][0] = -1;
        this.matriz[5][1] = -1;
        this.matriz[5][2] = -1;
        this.matriz[5][3] = -1;
        this.matriz[5][4] = -1;
        this.matriz[5][5] = -1;

        this.matriz[6][0] = -1;
        this.matriz[6][1] = -1;
        this.matriz[6][2] = -1;
        this.matriz[6][3] = -1;
        this.matriz[6][4] = -1;
        this.matriz[6][5] = -1;

        this.matriz[7][0] = -1;
        this.matriz[7][1] = -1;
        this.matriz[7][2] = -1;
        this.matriz[7][3] = -1;
        this.matriz[7][4] = -1;
        this.matriz[7][5] = -1;

    }

    private void estadosFinalizacion() {
        this.estadosFinalizacion[0] = 1;
        this.estadosFinalizacion[1] = 3;
        this.estadosFinalizacion[2] = 4;
        this.estadosFinalizacion[3] = 5;
        this.estadosFinalizacion[4] = 6;
        this.estadosFinalizacion[5] = 7;

    }

    public identificadores id(int estadoF) {
        identificadores idT = null;

        if (estadoF == 1) {
            idT = identificadores.NUMERO;
        } else if (estadoF == 3) {
            idT = identificadores.DECIMAL;
        } else if (estadoF == 4) {
            idT = identificadores.IDENTIFICADOR;

        } else if (estadoF == 5) {
            idT = identificadores.PUNTUACION;
        } else if (estadoF == 6) {
            idT = identificadores.OPERADOR;
        } else if (estadoF == 7) {
            idT = identificadores.AGRUPACION;
        }

        return  idT;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int[] getEstadosFinalizacion() {
        return estadosFinalizacion;
    }

}

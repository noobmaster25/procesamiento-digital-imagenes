/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modelo;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

/**
 *
 * @author pedro pinguino
 */
public class OperacionesMorfologicas {

    public short[][] estructural = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};

    public short[][] pasarBinario(short[][] umbral) {

        short[][] matrizUmbralizacion = new short[umbral.length][umbral[0].length];
        for (int i = 0; i < umbral.length; ++i) {
            for (int j = 0; j < umbral[0].length; ++j) {
                if (umbral[i][j] <= 120) {
                    matrizUmbralizacion[i][j] = 0;
                } else {
                    matrizUmbralizacion[i][j] = 255;
                }
            }
        }
        return matrizUmbralizacion;
    }

   public  short[][] dilatacion(short matriz[][]) {
        short matrizResult[][] = new short[matriz.length][matriz[0].length];
        short mascara[][] = new short[3][3];
        
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matrizResult[i][j] = matriz[i][j];
            }
        }

        for (int x = 1; x < matriz.length - 1; x++) {
            for (int y = 1; y < matriz[0].length - 1; y++) {
                double aux = 0;
//recorriendo matriz con un modelo estructural de 3x3
                if (matriz[x - 1][y - 1] == 255) aux++;

                if (matriz[x][y - 1] == 255) aux++;

                if (matriz[x + 1][y - 1] == 255)  aux++;

                if (matriz[x - 1][y] == 255)  aux++;

                if (matriz[x][y] == 255) aux++;

                if (matriz[x + 1][y] == 255) aux++;

                if (matriz[x - 1][y + 1] == 255) aux++;

                if (matriz[x][y + 1] == 255)  aux++;

                if (matriz[x + 1][y + 1] == 255)  aux++;


                double nuevoC = aux;

                if (nuevoC <= 4.5) {

                    matrizResult[x][y] = 0;

                } else {
                    matrizResult[x][y] = matriz[x][y];
                }

                if (nuevoC <= 2.25) {

                    matrizResult[x][y] = 0;

                } else {
                    matrizResult[x][y] = matriz[x][y];
                }

                if (nuevoC <= 6.75) {

                    matrizResult[x][y] = 0;

                } else {
                    matrizResult[x][y] = matriz[x][y];
                }

            }

        }
        return matrizResult;

    }
     public short[][] erosion(short matriz[][]) {
        short matrizResult[][] = new short[matriz.length][matriz[0].length];
        short mascara[][] = new short[3][3];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matrizResult[i][j] = matriz[i][j];
            }
        }

        for (int x = 1; x < matriz.length - 1; x++) {
            for (int y = 1; y < matriz[0].length - 1; y++) {
                double aux = 0;
                //recorriendo con un modelo estructural de 3 x3
                if (matriz[x - 1][y - 1] == 0)aux++;
                if (matriz[x][y - 1] == 0)aux++;
                if (matriz[x + 1][ y - 1] == 0) aux++;
               if (matriz[x - 1][y] == 0)  aux++;
                if (matriz[x][y] == 0)  aux++;
                if (matriz[x + 1][y] == 0) aux++;
                if (matriz[x - 1][y + 1] == 0)  aux++;
                if (matriz[x][y + 1] == 0) aux++;
                if (matriz[x + 1][y + 1] == 0)  aux++;


                double nuevoC = aux;

                if (nuevoC <= 4.5) {

                    matrizResult[x][y] = 255;

                } else {
                    matrizResult[x][y] = matriz[x][y];
                }

                if (nuevoC <= 2.25) {

                    matrizResult[x][y] = 255;

                } else {
                    matrizResult[x][y] = matriz[x][y];
                }

                if (nuevoC <= 6.75) {

                    matrizResult[x][y] = 255;

                } else {
                    matrizResult[x][y] = matriz[x][y];
                }

            }

        }
        return matrizResult;

    }


}

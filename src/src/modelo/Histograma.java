/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modelo;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author pedro pinguino
 */
public class Histograma {

    private int calcularMedia(Color color) {
        int mediaColor;
        mediaColor = (int) ((color.getRed() + color.getGreen() + color.getBlue()) / 3);
        return mediaColor;
    }

    /**
     * Devuelve el histograma de la imagen.
     *
     * @param imagen BufferedImagen de la cual se quiere obtener el histograma
     * @return Devuelve una variable int[5][256], donde el primer campo[0]
     * corresponde al canal Rojo, [1]=verde [2]=azul [3]=alfa [4]=escala grises
     */
    public int[][] histograma(BufferedImage imagen) {
        Color colorAuxiliar;
        /*Creamos la variable que contendrá el histograma
        El primer campo [0], almacenará el histograma Rojo
        [1]=verde [2]=azul [3]=alfa [4]=escala grises*/
        int histogramaReturn[][] = new int[5][256];
        //Recorremos la imagen
        for (int i = 0; i < imagen.getWidth(); i++) {
            for (int j = 0; j < imagen.getHeight(); j++) {
                //Obtenemos color del píxel actual
                colorAuxiliar = new Color(imagen.getRGB(i, j));
                //Sumamos una unidad en la fila roja [0], 
                //en la columna del color rojo obtenido
                histogramaReturn[0][colorAuxiliar.getRed()] += 1;
                histogramaReturn[1][colorAuxiliar.getGreen()] += 1;
                histogramaReturn[2][colorAuxiliar.getBlue()] += 1;
                histogramaReturn[3][colorAuxiliar.getAlpha()] += 1;
                histogramaReturn[4][calcularMedia(colorAuxiliar)] += 1;
            }
        }
        return histogramaReturn;
    }

    private Imagen imagen;
    private int histogramaGris[];
    private int maxNumPixelesGris;
    private int nivelDominanteGris;

    public int[] calcularHistogramaGris(int[][] matrizGris) {
        int tamanio = matrizGris.length * matrizGris.length;
        for (int i = 0; i < matrizGris.length; i++) {
            int repeticion = 0;

            for (int j = 0; j < matrizGris[0].length; j++) {
                int elemento = matrizGris[i][j];
                repeticion = repeticion(matrizGris, elemento);
                double probabilidad = repeticion / tamanio;

            }
        }

        return histogramaGris;
    }

    public int repeticion(int[][] matriz, int elemento) {
        int repeticion = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (elemento == matriz[i][j]) {
                    repeticion++;
                }
            }
        }
        return repeticion;
    }

    public int[] histogramaGris(short[][] gris) {
        histogramaGris = new int[256];
        //realiza el conteo de numero de pixeles por nivel de intensidad
        for (int i = 0; i < gris.length; i++) {
            for (int j = 0; j < gris[0].length; j++) {
                int nivelGris = gris[i][j];
                if (nivelGris < 256) {
                    histogramaGris[nivelGris]++;
                }
            }
        }
        //busca el maximo numero de pixeles para el nivel de intensidad dominante
        nivelDominanteGris = 0;
        maxNumPixelesGris = 0;
        for (int i = 0; i < histogramaGris.length; i++) {
            if (histogramaGris[i] > maxNumPixelesGris) {
                maxNumPixelesGris = histogramaGris[i];
                nivelDominanteGris = i;
            }
        }
        return histogramaGris;
    }

    public int[] ecualizarHistograma(int[] histo, short[][] gris) {

        int histogramaGris[] = histo;
        int ancho = gris[0].length;
        int alto = gris.length;
        int L = 255;

        int histogramaNormal[] = new int[L + 1];

        for (int i = 1; i < L + 1; i++) {
            histogramaNormal[i] = histogramaNormal[i - 1] + histogramaGris[i];
        }

        int LUT[] = new int[L + 1];
        for (int i = 0; i < L; i++) {
            LUT[i] = (int) Math.floor(((L - 1) * histogramaNormal[i]) / (ancho * alto));
            
        }

        return LUT;
    }

}

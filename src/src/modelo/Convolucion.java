/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modelo;

public class Convolucion {

    public short[][] mascara = new short[3][3];
    public Convolucion(short[][] mascara) {
        this.mascara = mascara;
    }

    public short[][] aplicarConvolucion(short[][] matriz) {
       
        short[][] nuevaMatriz = new short[matriz.length][matriz[0].length];
        

        for (int i = 1; i < matriz.length - 1; i++) {
            for (int j = 1; j < matriz[0].length - 1; j++) {
                int aux = 0;
                aux = (int) (
                        (matriz[i - 1][j - 1] * mascara[0][0])
                        + (matriz[i - 1][j] * mascara[0][1])
                        + (matriz[i - 1][j + 1] * mascara[0][2])
                        + (matriz[i][j - 1] * mascara[1][0])
                        + (matriz[i][j] * mascara[1][1])
                        + (matriz[i][j + 1] * mascara[1][2])
                        + (matriz[i + 1][j - 1] * mascara[2][0])
                        + (matriz[i + 1][j] * mascara[2][1])
                        + (matriz[i + 1][j + 1] * mascara[2][2]));
                nuevaMatriz[i][j] = (short) Math.abs(aux);
            }
        }
        return nuevaMatriz;
    }
}

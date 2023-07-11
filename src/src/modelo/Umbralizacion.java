/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modelo;


/**
 *
 * @author pedro pinguino
 */
public class Umbralizacion {
    private int u1;
private int u2;
    
    public Umbralizacion(){
        
    }
    public short [][] umbralizacionNegativo(short [][] matrizOriginal){
        short [][]matrizNueva = new short[matrizOriginal.length][matrizOriginal[0].length];
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                matrizNueva[i][j] = (short) (255 - matrizOriginal[i][j]);
            }
        }
        return matrizNueva; 
    }
    public short [][] umbralInverso(short [][]matrizOriginal){
         short [][]matrizNueva = new short[matrizOriginal.length][matrizOriginal[0].length];
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j]<u1) {
                    matrizNueva[i][j] = 0;
                }else{
                    matrizNueva[i][j] = 255;
                }
            }
        }
        return matrizNueva; 
    }
    public short[][] umbralBinario(short[][]matrizOriginal){
         short [][]matrizNueva = new short[matrizOriginal.length][matrizOriginal[0].length];
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] <= u1 || matrizOriginal[i][j] > u2 ) {
                    matrizNueva[i][j]=0;
                }else{
                    matrizNueva[i][j]= 255;
                }
            }
        }
        return matrizNueva; 
    }
    public short[][] umbralGris(short[][]matrizOriginal){
        short [][]matrizNueva = new short[matrizOriginal.length][matrizOriginal[0].length];
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] <= u1 || matrizOriginal[i][j] > u2 ) {
                    matrizNueva[i][j]=255;
                }else{
                    matrizNueva[i][j]= matrizOriginal[i][j];
                }
            }
        }
        return matrizNueva; 
    }
     public short[][] operadorExtension(short[][]matrizOriginal){
        short [][]matrizNueva = new short[matrizOriginal.length][matrizOriginal[0].length];
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] <= u1 || matrizOriginal[i][j] > u2 ) {
                    matrizNueva[i][j]=255;
                }else{
                    matrizNueva[i][j]= (short) (255*(matrizOriginal[i][j] - u1)/(u2-u1));
                }
            }
        }
        return matrizNueva; 
    }

    public int getU1() {
        return u1;
    }

    public void setU1(String u1) {
        this.u1 = Integer.valueOf(u1);
    }

    public int getU2() {
        return u2;
    }

    public void setU2(String u2) {
        this.u2 = Integer.valueOf(u2);
    }
    
}

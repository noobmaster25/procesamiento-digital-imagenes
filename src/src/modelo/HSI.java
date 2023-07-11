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
public class HSI {
     public short[][] matiz (short [][] matrizRed, short [][] matrizGreen, short [][] matrizBlue) {
        short[][] matrizHSI = new short[matrizRed.length][matrizRed[0].length]; 
        for (int i = 0; i < matrizRed.length; ++i) {
            for (int j = 0; j < matrizRed[0].length; ++j) {
                
                short r = matrizRed[i][j];
                short g = matrizGreen[i][j];
                short b = matrizBlue[i][j];
                
                double numerador = ((r-g)+(r-b))*.5;
                double cuadrado = Math.pow((r-g),2);
                
                double dentroRaiz = ((r-b)*(g-b))+cuadrado;
                double denominador = Math.sqrt(dentroRaiz);
                double corchetes = numerador/denominador;
                //convertir a grados el resultado 
                double res = Math.toDegrees(Math.acos(corchetes));
                
                if (b>g) 
                    {res = 360 - res;}
                matrizHSI[i][j] = (short) (res);
            }  
        }
        return matrizHSI; 
    }
    
    public short[][] saturacion (short [][] matrizRed, short [][] matrizGreen, short [][] matrizBlue) {
        
        short[][] matrizHSI = new short[matrizRed.length][matrizRed[0].length];
        
        for (int i = 0; i < matrizRed.length; ++i) {
            for (int j = 0; j < matrizRed[0].length; ++j) {
                
                double r = matrizRed[i][j];
                double g = matrizGreen[i][j];
                double b = matrizBlue[i][j];
                double primeMinimo = Math.min(r, g);
                double minimoFinal = Math.min(primeMinimo, b);
               
                short intensidad = (short) ((matrizRed[i][j] + matrizGreen[i][j] + 
                       matrizBlue[i][j])/3);
//                System.out.println(r+"-"+g+"-"+b);
//                System.out.println(minimoFinal);
                matrizHSI[i][j] = (short)((1- minimoFinal)/(intensidad));
                
//                System.out.println(matrizHSI[i][j]);
           
            }
          
        }
        return matrizHSI; 
    }
    
    
    
    public short[][] intensidad (short [][] matrizRed, short [][] matrizGreen, 
            short [][] matrizBlue) {
        
        short[][] matrizHSI = new short[matrizRed.length][matrizRed[0].length];
        for (int i = 0; i < matrizRed.length; ++i) {
            for (int j = 0; j < matrizRed[0].length; ++j) {
               matrizHSI[i][j] = (short) ((matrizRed[i][j] + matrizGreen[i][j] + 
                       matrizBlue[i][j])/3);
            }
        }
        return matrizHSI; 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modelo;


import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro pinguino
 */
public class FiltroRuido {


    public short[][] mediaAritmetica(short[][] original) {
        short[][] nueva = new short[original.length][original[0].length];

        for (int i = 1; i < original.length - 1; i++) {
            for (int j = 1; j < original[0].length - 1; j++) {
                short suma = 0;
                suma = (short) (original[i - 1][j - 1] + original[i - 1][j]
                        + original[i - 1][j + 1] + original[i][j - 1] + original[i][j + 1]
                        + original[i + 1][j - 1] + original[i + 1][j] + original[i + 1][j + 1]);
                nueva[i][j] = (short) Math.round(suma / 8);
            }

        }

        return nueva;
    }

    public short[][] mediaGeometrica(short[][] original) {
        short[][] nueva = new short[original.length][original[0].length];

        for (int i = 1; i < original.length - 1; i++) {
            for (int j = 1; j < original[0].length - 1; j++) {
                long multiplicacion = 0;
                multiplicacion = original[i - 1][j - 1] * original[i - 1][j];
                multiplicacion *= original[i - 1][j + 1];
                multiplicacion *= original[i][j - 1];
                multiplicacion *= original[i][j + 1];
                multiplicacion *= original[i + 1][j - 1];
                multiplicacion *= original[i + 1][j];
                multiplicacion *= original[i + 1][j + 1];
                nueva[i][j] = (short) Math.round(Math.pow(multiplicacion, 0.125));
            }

        }

        return nueva;
    }

    public short[][] mediaContraarmonica(short[][] original) {
        short[][] nueva = new short[original.length][original[0].length];
        double q = Double.parseDouble(JOptionPane.showInputDialog("inserte el valor de q"));

        for (int i = 1; i < original.length - 1; i++) {
            for (int j = 1; j < original[0].length - 1; j++) {
                double suma = 0;
                suma = (short) (original[i - 1][j - 1] + original[i - 1][j]
                        + original[i - 1][j + 1] + original[i][j - 1] + original[i][j + 1]
                        + original[i + 1][j - 1] + original[i + 1][j] + original[i + 1][j + 1]);
                double media = Math.round(suma / 8);
                double numerador = Math.pow(media, q + 1);
                double denominador = Math.pow(media, q);
                nueva[i][j] = (short) Math.round(numerador / denominador);
            }

        }

        return nueva;
    }
//filtros estadisticos
    //media
    public short[][] media(short[][] original) {
        short[][] nueva = new short[original.length][original[0].length];
        
        for (int i = 1; i < original.length - 1; i++) {
            for (int j = 1; j < original[0].length - 1; j++) {
                ArrayList<Short> lista = new ArrayList<>();
                lista.add(original[i - 1][j - 1]);
                lista.add(original[i - 1][j]);
                lista.add(original[i][j]);
                lista.add(original[i - 1][j + 1]);
                lista.add(original[i][j - 1]);
                lista.add(original[i][j + 1]);
                lista.add(original[i + 1][j - 1]);
                lista.add(original[i + 1][j]);
                lista.add(original[i + 1][j + 1]);
                Collections.sort(lista);
                nueva[i][j]=lista.get(4);

            }

        }

        return nueva;
    }
    //maximo
    public short[][] maximo(short[][] original) {
        short[][] nueva = new short[original.length][original[0].length];
        
        for (int i = 1; i < original.length - 1; i++) {
            for (int j = 1; j < original[0].length - 1; j++) {
                ArrayList<Short> lista = new ArrayList<>();
                lista.add(original[i - 1][j - 1]);
                lista.add(original[i - 1][j]);
                lista.add(original[i][j]);
                lista.add(original[i - 1][j + 1]);
                lista.add(original[i][j - 1]);
                lista.add(original[i][j + 1]);
                lista.add(original[i + 1][j - 1]);
                lista.add(original[i + 1][j]);
                lista.add(original[i + 1][j + 1]);
                Collections.sort(lista);
                nueva[i][j]=lista.get(lista.size()-1);

            }

        }

        return nueva;
    }
     //minimo
    public short[][] minimo(short[][] original) {
        short[][] nueva = new short[original.length][original[0].length];
        
        for (int i = 1; i < original.length - 1; i++) {
            for (int j = 1; j < original[0].length - 1; j++) {
                ArrayList<Short> lista = new ArrayList<>();
                lista.add(original[i - 1][j - 1]);
                lista.add(original[i - 1][j]);
                lista.add(original[i][j]);
                lista.add(original[i - 1][j + 1]);
                lista.add(original[i][j - 1]);
                lista.add(original[i][j + 1]);
                lista.add(original[i + 1][j - 1]);
                lista.add(original[i + 1][j]);
                lista.add(original[i + 1][j + 1]);
                Collections.sort(lista);
                nueva[i][j]=lista.get(0);

            }

        }

        return nueva;
    }
    //punto medio 
     public short[][] puntoMedio(short[][] original) {
        short[][] nueva = new short[original.length][original[0].length];
        
        for (int i = 1; i < original.length - 1; i++) {
            for (int j = 1; j < original[0].length - 1; j++) {
                ArrayList<Short> lista = new ArrayList<>();
                lista.add(original[i - 1][j - 1]);
                lista.add(original[i - 1][j]);
                lista.add(original[i][j]);
                lista.add(original[i - 1][j + 1]);
                lista.add(original[i][j - 1]);
                lista.add(original[i][j + 1]);
                lista.add(original[i + 1][j - 1]);
                lista.add(original[i + 1][j]);
                lista.add(original[i + 1][j + 1]);
                Collections.sort(lista);
                nueva[i][j]=(short)Math.round(((lista.get(lista.size()-1)+lista.get(0))*.5));

            }

        }

        return nueva;
    }
     public short[][] mediaSeccion(short[][] original) {
        short[][] nueva = new short[original.length][original[0].length];
        
        for (int i = 1; i < original.length - 1; i++) {
            for (int j = 1; j < original[0].length - 1; j++) {
                ArrayList<Short> lista = new ArrayList<>();
                lista.add(original[i - 1][j - 1]);
                lista.add(original[i - 1][j]);
                lista.add(original[i][j]);
                lista.add(original[i - 1][j + 1]);
                lista.add(original[i][j - 1]);
                lista.add(original[i][j + 1]);
                lista.add(original[i + 1][j - 1]);
                lista.add(original[i + 1][j]);
                lista.add(original[i + 1][j + 1]);
                Collections.sort(lista);
                lista.remove(0);
                lista.remove(1);
                lista.remove(lista.size()-1);
                lista.remove(lista.size()-2);
                short suma=0;
                for (Short short1 : lista) {
                    suma+=short1;
                }
                nueva[i][j] = (short)Math.round(suma/5);
                
            }

        }

        return nueva;
    }
    
}

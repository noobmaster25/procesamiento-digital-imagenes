package src.modelo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import java.util.logging.*;
import src.vista.Principal;

public class Imagen {

    //Atributos de la clase
    private short alto;
    private short ancho;
    private String nombre;
    private int peso;
    private final int nivelIntensidad = 255;
    private short[][] matrizRojo;
    private short[][] matrizAzul;
    private short[][] matrizVerde;
    private short[][] matrizGris;
    private short[][] segundaMatrizGris;
    private BufferedImage segundaImagenBuffer;
    private BufferedImage imagenBuffer;

    public void setImagenBuffer(BufferedImage imagenBuffer) {
        this.imagenBuffer = imagenBuffer;
    }

    //FACTORES DE CONVERSION A ESCALA DE GRISES
    private final float alfa = 0.299f;
    private final float beta = 0.587f;
    private final float gama = 0.114f;

    //instancias
    public Principal objVentanaPrincipal;

    public String getNombre() {
        return nombre;
    }

    public BufferedImage getImagenBuffer() {
        return imagenBuffer;
    }

    public BufferedImage getSegundaImagenBuffer() {
        return segundaImagenBuffer;
    }

    public void setSegundaImagenBuffer(BufferedImage segundaImagenBuffer) {
        this.segundaImagenBuffer = segundaImagenBuffer;
    }

    public File getArchivoImagen() {
        return archivoImagen;
    }
    private File archivoImagen;
    //= new File ("C:\\Users\\CU NEZA\\Documents\\poo.png");

    public Imagen(File rutaImagen) {
        imagenBuffer = null;

        try {
            this.imagenBuffer = ImageIO.read(rutaImagen);
            this.alto = (short) imagenBuffer.getHeight();
            this.ancho = (short) imagenBuffer.getWidth();
            this.archivoImagen = rutaImagen;
            this.nombre = rutaImagen.getName();
            cargarMatrices(this.imagenBuffer);//rellena las 4 matrices
            this.peso = (this.alto * this.ancho) * 3;
        } catch (IOException ex) {

            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, nombre);
        }
    }

    public void cargarSegundaImagen(File rutaImagen) {
        segundaImagenBuffer = null;
        try {
            this.segundaImagenBuffer = ImageIO.read(rutaImagen);
            cargarSegundaMatriz(this.segundaImagenBuffer);
        } catch (Exception e) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, nombre);
        }
    }

    public void cargarSegundaMatriz(BufferedImage segundaImagen) {
        short[][] nuevaMatrizGris = new short[segundaImagen.getWidth()][segundaImagen.getHeight()];
        for (int i = 0; i < segundaImagen.getWidth(); i++) {
            for (int j = 0; j < segundaImagen.getHeight(); j++) {
                Color auxiliar = new Color(segundaImagen.getRGB(i, j));
                short pixelGris = (short) Math.ceil((alfa * (auxiliar.getRed())) + (beta * (auxiliar.getGreen())) + (gama * (auxiliar.getBlue())));
                nuevaMatrizGris[i][j] = pixelGris;

            }
        }
        setSegundaMatrizGris(nuevaMatrizGris);

    }

    public void cargarMatrices(BufferedImage imagenOriginal) {
        short[][] nuevaMatrizRojo = new short[imagenOriginal.getWidth()][imagenOriginal.getHeight()];
        short[][] nuevaMatrizVerde = new short[imagenOriginal.getWidth()][imagenOriginal.getHeight()];
        short[][] nuevaMatrizAzul = new short[imagenOriginal.getWidth()][imagenOriginal.getHeight()];
        short[][] nuevaMatrizGris = new short[imagenOriginal.getWidth()][imagenOriginal.getHeight()];

        for (int i = 0; i < imagenOriginal.getWidth(); i++) {
            for (int j = 0; j < imagenOriginal.getHeight(); j++) {
                Color auxiliar = new Color(imagenOriginal.getRGB(i, j));
                nuevaMatrizRojo[i][j] = (short) auxiliar.getRed();
                nuevaMatrizVerde[i][j] = (short) auxiliar.getGreen();
                nuevaMatrizAzul[i][j] = (short) auxiliar.getBlue();
                short pixelGris = (short) Math.ceil((alfa * (auxiliar.getRed())) + (beta * (auxiliar.getGreen())) + (gama * (auxiliar.getBlue())));
                nuevaMatrizGris[i][j] = pixelGris;

            }
        }
        setMatrizRojo(nuevaMatrizRojo);
        setMatrizVerde(nuevaMatrizVerde);
        setMatrizAzul(nuevaMatrizAzul);
        setMatrizGris(nuevaMatrizGris);

    }

    public BufferedImage convierteMatrizenBufferd(short[][] Matrizimagen) {
        short pixel;
        int pixelSRGB;
        BufferedImage imagenNueva = new BufferedImage(imagenBuffer.getWidth(), imagenBuffer.getHeight(), imagenBuffer.getType());

        for (int i = 0; i < imagenBuffer.getWidth(); i++) {
            for (int j = 0; j < imagenBuffer.getHeight(); j++) {
                pixel = Matrizimagen[i][j];
                pixelSRGB = pixel << 16 | pixel << 8 | pixel;
                imagenNueva.setRGB(i, j, pixelSRGB);

            }
        }

        return imagenNueva;

    }

    public BufferedImage convierteMatrizenBufferd(short[][] Matrizimagen, int altura, int anchura) {
        short pixel;
        int pixelSRGB;
        System.out.println(anchura);
        BufferedImage imagenNueva = new BufferedImage(altura, anchura, imagenBuffer.getType());

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                pixel = Matrizimagen[i][j];
                pixelSRGB = pixel << 16 | pixel << 8 | pixel;
                imagenNueva.setRGB(i, j, pixelSRGB);

            }
        }
        System.out.println("altura" + altura + "anchura" + anchura);
        return imagenNueva;

    }

    public short[][] sumarImagenes(short[][] imagen1, short[][] imagen2) {

        short[][] matrizNueva = new short[imagen1.length][imagen1[0].length];
        if (imagen1.length == imagen2.length) {
            for (int i = 0; i < imagen1.length; i++) {
                for (int j = 0; j < imagen1[0].length; j++) {
                    matrizNueva[i][j] = (short) ((imagen1[i][j] + imagen2[i][j]) / 2);
                }
            }

        }

        return matrizNueva;
    }

    public short[][] restaImagenes(short[][] imagen1, short[][] imagen2) {
        short[][] matrizNueva = new short[imagen1.length][imagen1[0].length];
        if (imagen1.length == imagen2.length) {
            for (int i = 0; i < imagen1.length; i++) {
                for (int j = 0; j < imagen1[0].length; j++) {
                    matrizNueva[i][j] = (short) Math.abs(imagen1[i][j] - imagen2[i][j]);
                }
            }

        }

        return matrizNueva;
    }

    public short[][] operacionAnd(short[][] imagen1, short[][] imagen2) {
        short[][] matrizNueva = new short[imagen1.length][imagen1[0].length];
        if (imagen1.length == imagen2.length) {
            for (int i = 0; i < imagen1.length; i++) {
                for (int j = 0; j < imagen1[0].length; j++) {

                    if (imagen1[i][j] == 255 && imagen2[i][j] == 255) {
                        matrizNueva[i][j] = 255;
                    } else {
                        matrizNueva[i][j] = 0;
                    }
                }
            }

        }
        return matrizNueva;
    }

    public short[][] operacionOr(short[][] imagen1, short[][] imagen2) {
        short[][] matrizNueva = new short[imagen1.length][imagen1[0].length];
        if (imagen1.length == imagen2.length) {
            for (int i = 0; i < imagen1.length; i++) {
                for (int j = 0; j < imagen1[0].length; j++) {

                    if (imagen1[i][j] == 0 && imagen2[i][j] == 0) {
                        matrizNueva[i][j] = 0;
                    } else {
                        matrizNueva[i][j] = 255;
                    }
                }
            }

        }
        return matrizNueva;
    }

    public short[][] operacionXor(short[][] imagen1, short[][] imagen2) {
        short[][] matrizNueva = new short[imagen1.length][imagen1[0].length];
        if (imagen1.length == imagen2.length) {
            for (int i = 0; i < imagen1.length; i++) {
                for (int j = 0; j < imagen1[0].length; j++) {

                    if (imagen1[i][j] == 0 && imagen2[i][j] == 0) {
                        matrizNueva[i][j] = 0;

                    } else if (imagen1[i][j] == 255 && imagen2[i][j] == 255) {
                        matrizNueva[i][j] = 0;
                    } else {
                        matrizNueva[i][j] = 255;
                    }
                }
            }

        }
        return matrizNueva;
    }

    public short[][] operacionNot(short[][] imagen1) {
        short[][] matrizNueva = new short[imagen1.length][imagen1[0].length];

        for (int i = 0; i < imagen1.length; i++) {
            for (int j = 0; j < imagen1[0].length; j++) {

                if (imagen1[i][j] == 0) {
                    matrizNueva[i][j] = 255;
                } else {
                    matrizNueva[i][j] = 0;
                }

            }
        }

        return matrizNueva;
    }

    public short[][] aumetarTamanio(short matriz[][], int aumento) {
        short[][] nueva = new short[matriz.length * aumento][matriz[0].length * aumento];
        int contador = 0;
        int contador2 = 0;
        for (int i = 0; i < nueva.length; i += aumento) {
            contador2 = 0;
            for (int j = 0; j < nueva[i].length; j += aumento) {
                nueva[i][j] = matriz[contador][contador2];

                for (int k = 0; k < aumento; k++) {
                    for (int n = 0; n < aumento; n++) {
                        nueva[i + k][j + n] = matriz[contador][contador2];
                    }

                }

                contador2++;
            }

            contador++;
        }

        return nueva;
    }
public short [][] rotar90pmd(short [][]matriz){
    int alto = matriz.length, ancho = matriz[0].length, nuevacolumna = alto - 1;
        short[][] novaMatrix = new short[ancho][alto];
        for (int i = 0; i < alto; i++, nuevacolumna--) {
            for (int j = 0; j < ancho; j++) {
                novaMatrix[j][nuevacolumna] = matriz[i][j];
            }
        }
        return novaMatrix;
}
    public short[][] rotarImagen90(short[][] matriz) {
        short[][] nueva = new short[matriz[0].length][matriz.length];
        for (int i = 0; i < nueva.length; i++) {
          int contador = matriz.length-1;
            for (int j = 0; j < nueva[0].length; j++) {
                nueva[i][j]=matriz[contador][i];
                 contador--;
            }
        }
        return nueva;

    }

    public short getAlto() {
        return alto;
    }

    public short[][] rotarImagen180(short[][] matriz) {
        short[][] nueva = rotarImagen90(matriz);
        return rotarImagen90(nueva);
    }

    public short[][] rotarImagen270(short[][] matriz) {
        short[][] nueva90 = rotarImagen90(matriz);
        short[][] nueva180 = rotarImagen90(nueva90);
        return rotarImagen90(nueva180);
    }

    public BufferedImage convertRGBaCMY(short[][] matrizC,
            short[][] matrizM, short[][] matrizY) {
        int pixelSRGB;

        BufferedImage imagenBuffered = new BufferedImage(matrizC[0].length,
                matrizC.length, imagenBuffer.getType());

        for (int filas = 0; filas < matrizC.length; filas++) {
            for (int columnas = 0; columnas < matrizC[0].length; columnas++) {
                pixelSRGB = 255 - matrizM[filas][columnas] << 16
                        | 255 - matrizY[filas][columnas] << 8 | 255 - matrizC[filas][columnas];
                imagenBuffered.setRGB(filas, columnas, pixelSRGB);
            }
        }
        return imagenBuffered;

    }

    public void setAlto(short alto) {
        this.alto = alto;
    }

    public short getAncho() {
        return ancho;
    }

    public void setAncho(short ancho) {
        this.ancho = ancho;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public short[][] getMatrizRojo() {
        return matrizRojo;
    }

    public void setMatrizRojo(short[][] matrizRojo) {
        this.matrizRojo = matrizRojo;
    }

    public short[][] getMatrizAzul() {
        return matrizAzul;
    }

    public void setMatrizAzul(short[][] matrizAzul) {
        this.matrizAzul = matrizAzul;
    }

    public short[][] getMatrizVerde() {
        return matrizVerde;
    }

    public void setMatrizVerde(short[][] matrizVerde) {
        this.matrizVerde = matrizVerde;
    }

    public void setMatrizGris(short[][] matrizGris) {
        this.matrizGris = matrizGris;
    }

    public short[][] getMatrizGris() {
        return matrizGris;
    }

    public short[][] getSegundaMatrizGris() {
        return segundaMatrizGris;
    }

    public void setSegundaMatrizGris(short[][] segundaMatrizGris) {
        this.segundaMatrizGris = segundaMatrizGris;
    }

    public int getNivelIntensidad() {
        return nivelIntensidad;
    }
}

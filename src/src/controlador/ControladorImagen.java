package src.controlador;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import src.vista.*;
import src.modelo.*;

public class ControladorImagen implements ActionListener, ChangeListener {

    public Principal objVentanaPrincipal;
    public Imagen objimagenOriginal;
    public File archivoImagen;
    public Umbralizacion objUmbralizacion;
    public PanelFrecuencia objPanelFrecuencia;
    public PanelUmbralizacion objpanelUmbralizacion;
    public PanelConvolucion objPanelConvolucion;
    public VentanaHistogramas objVentanaHistograma;
    public VentanaHSI ventanaHSI;
    public HSI objHsi;
    public FiltroRuido objFiltroRuido;
    public int casoUmbralizacion = 0;
    int opcionFrecuencia =0; 
    public ImageFFT objImageFFT;
    public Convolucion objConvolucion;

    public ControladorImagen(Principal objVentana) {
        this.objVentanaPrincipal = objVentana;
        this.objVentanaPrincipal.menuAbrir.addActionListener(this);
        this.objVentanaPrincipal.menuSalir.addActionListener(this);
        this.objVentanaPrincipal.MenuCovertirGris.addActionListener(this);
        //addActionListenr para reiniciar la imagen
        this.objVentanaPrincipal.reiniciarImage.addActionListener(this);
        //addActionListener para los menu item de umbralizacion
        this.objVentanaPrincipal.umbralizacionNegativo.addActionListener(this);
        this.objVentanaPrincipal.umbralInverso.addActionListener(this);
        this.objVentanaPrincipal.umbralBinario.addActionListener(this);
        this.objVentanaPrincipal.umbralGris.addActionListener(this);
        this.objVentanaPrincipal.operadorExtension.addActionListener(this);
        //addActionListener para los menu item de las operaciones
        this.objVentanaPrincipal.opSuma.addActionListener(this);
        this.objVentanaPrincipal.opResta.addActionListener(this);
        this.objVentanaPrincipal.opAnd.addActionListener(this);
        this.objVentanaPrincipal.opOr.addActionListener(this);
        this.objVentanaPrincipal.opXor.addActionListener(this);
        this.objVentanaPrincipal.opNot.addActionListener(this);
        //addActionListener para los menu item de las operacion de menu practica 5
        this.objVentanaPrincipal.AumentarTamanio.addActionListener(this);
        this.objVentanaPrincipal.rotar90.addActionListener(this);
        this.objVentanaPrincipal.rotar180.addActionListener(this);
        this.objVentanaPrincipal.rotar270.addActionListener(this);
        //addActionListener para los menu item de las operaciones para quitar el ruido
        objFiltroRuido = new FiltroRuido();
        this.objVentanaPrincipal.mediaAritmetica.addActionListener(this);
        this.objVentanaPrincipal.mediaGeometrica.addActionListener(this);
        this.objVentanaPrincipal.mediaContraarmonico.addActionListener(this);
        this.objVentanaPrincipal.media.addActionListener(this);
        this.objVentanaPrincipal.maximo.addActionListener(this);
        this.objVentanaPrincipal.minimo.addActionListener(this);
        this.objVentanaPrincipal.puntoMedio.addActionListener(this);
        this.objVentanaPrincipal.mediaSeccion.addActionListener(this);
        //addActionListener para los menu item de las operaciones de frecuencia
this.objVentanaPrincipal.menuEspectro.addActionListener(this);
        this.objVentanaPrincipal.idealLowpassFilters.addActionListener(this);
        this.objVentanaPrincipal.butterworthLowpassFilters.addActionListener(this);
        this.objVentanaPrincipal.idealHighpassFilters.addActionListener(this);
        this.objVentanaPrincipal.butterworthHighpassFilters.addActionListener(this);

        //addActionListener para los menu item de convolucion
        this.objVentanaPrincipal.menuConvolucion.addActionListener(this);
        //panel umbralizacion

        objVentanaHistograma = new VentanaHistogramas();
        objpanelUmbralizacion = new PanelUmbralizacion();
        objpanelUmbralizacion.botonAplicar.addActionListener(this);
        //panel convolucion 
        objPanelConvolucion = new PanelConvolucion();
        objPanelConvolucion.botonAplicarConvolucionAplicar.addActionListener(this);
        //panel frecuencia 
        objPanelFrecuencia = new PanelFrecuencia();
        objPanelFrecuencia.botonAplicarFrecuencia.addActionListener(this);
       
        //addActionListener para el menu item de histograma

        this.objVentanaPrincipal.generarHistograma.addActionListener(this);
        this.objVentanaPrincipal.ecualizarHistograma.addActionListener(this);
        // addActionListener para el menu item de convertir CMY
        this.objVentanaPrincipal.transformarCMY.addActionListener(this);
        //addActionsListener para el menu intem de ocnvertir el modelo HSI
        objHsi = new HSI();
        this.objVentanaPrincipal.menuSaturacion.addActionListener(this);
        this.objVentanaPrincipal.menuIntensidad.addActionListener(this);
        this.objVentanaPrincipal.menuMatiz.addActionListener(this);
//Dilatacion
this.objVentanaPrincipal.menuDilatacion.addActionListener(this);
this.objVentanaPrincipal.menuErosion.addActionListener(this);
this.objVentanaPrincipal.menuOpen.addActionListener(this);
this.objVentanaPrincipal.menuClose.addActionListener(this);
        
        objUmbralizacion = new Umbralizacion();

        this.objVentanaPrincipal.addWindowListener(new WindowAdapter() {

            public void WindowClosing(WindowEvent e) {
                System.out.println("CIERRA VENTANA");
                System.exit(0);
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Abrir")) {
            System.out.println("Diste click en el menu ABRIR");
            abrirArchivoImagen();
            verAtributosImagen();
        }
        if (e.getActionCommand().equals("Salir")) {
            System.out.println("Diste click en el menu SALIR");
        }
        if (e.getActionCommand().equals("ConvertirGris")) {
            convertirImagenGris();
        }
        if (e.getActionCommand().equals("Umbralizacion negativo")) {
            casoUmbralizacion = 1;
            crearPanel(objpanelUmbralizacion);

        }
        if (e.getActionCommand().equals("umbral inverso")) {
            casoUmbralizacion = 2;
            crearPanel(objpanelUmbralizacion);

        }
        if (e.getActionCommand().equals("umbral binario")) {
            casoUmbralizacion = 3;
            crearPanel(objpanelUmbralizacion);

        }
        if (e.getActionCommand().equals("umbral en gris")) {
            casoUmbralizacion = 4;
            crearPanel(objpanelUmbralizacion);

        }
        if (e.getActionCommand().equals("operador extension")) {
            casoUmbralizacion = 5;
            crearPanel(objpanelUmbralizacion);

        }
        if (e.getActionCommand().equals("Suma")) {
            System.out.println("suma");
            sumarImagenes();

        }
        if (e.getActionCommand().equals("Resta")) {
            System.out.println("resta");
            restaImagenes();

        }
        if (e.getActionCommand().equals("And")) {
            System.out.println("ana");
            operadorAnd();

        }
        if (e.getActionCommand().equals("Or")) {
            System.out.println("or");
            operadorOr();
        }
        if (e.getActionCommand().equals("Xor")) {
            System.out.println("xor");
            operadorXor();
        }
        if (e.getActionCommand().equals("Not")) {
            System.out.println("not");
            operadorNot();
        }
        //evento del boton junto a la accion que debe ejecutar dependiento la umbralizacion que se haya elegido
        if (e.getSource() == objpanelUmbralizacion.botonAplicar) {
            System.out.println(casoUmbralizacion);
            switch (casoUmbralizacion) {
                case 1:
                    objUmbralizacion.setU1(objpanelUmbralizacion.inputU1.getText());
                    crearImagenNegativa();
                    break;
                case 2:
                    objUmbralizacion.setU1(objpanelUmbralizacion.inputU1.getText());
                    crearImagenUmbralInverso();
                    break;
                case 3:
                    objUmbralizacion.setU1(objpanelUmbralizacion.inputU1.getText());
                    objUmbralizacion.setU2(objpanelUmbralizacion.inputU2.getText());
                    crearImagenBinario();
                    break;
                case 4:
                    objUmbralizacion.setU1(objpanelUmbralizacion.inputU1.getText());
                    objUmbralizacion.setU2(objpanelUmbralizacion.inputU2.getText());
                    crearImagenUmbralGris();
                    break;
                case 5:
                    objUmbralizacion.setU1(objpanelUmbralizacion.inputU1.getText());
                    objUmbralizacion.setU2(objpanelUmbralizacion.inputU2.getText());
                    crearImagenOperadorExtension();
                    break;
                default:
                    System.out.println("option no encontrada");
                    break;
            }

        }
        //para las opciones del menu practica 5\
        if (e.getActionCommand().equals("Aumentar tamanio")) {
            aumentarTamanio();

        }
        if (e.getActionCommand().equals("Rotar 90°")) {
            rotar90();

        }
        if (e.getActionCommand().equals("Rotar 180°")) {
            rotar180();

        }
        if (e.getActionCommand().equals("Rotar 270°")) {
            System.out.println("rotar 270");
            rotar270();

        }
        //para las opciones de los filtros que quitan el ruido
        if (e.getActionCommand().equals("media aritmetica")) {
            mediaAritmetica();
        }
        if (e.getActionCommand().equals("media geometrica")) {
            mediaGeometrica();
        }
        if (e.getActionCommand().equals("media contraarmonico")) {
            mediaContraarmonica();
        }
        if (e.getActionCommand().equals("media")) {
            media();
        }
        if (e.getActionCommand().equals("maximo")) {
            maximo();
        }
        if (e.getActionCommand().equals("minimo")) {
            minimo();
        }
        if (e.getActionCommand().equals("punto medio")) {
            puntoMedio();
        }
        if (e.getActionCommand().equals("media seccion")) {
            mediaSeccion();
        }
        //menu item de espectros
         
        if (e.getActionCommand().equals("espectro")) {
            System.out.println("espectro");
           espectro();
        
        }
        
        if (e.getActionCommand().equals("Ideal Lowpass Filters")) {
            System.out.println("(Ideal Lowpass Filters");
           
            opcionFrecuencia =1;
           crearPanel(objPanelFrecuencia);
        }
        if (e.getActionCommand().equals("Butterworth Lowpass Filters")) {
            System.out.println("Butterworth Lowpass Filters");  
            opcionFrecuencia =2;
            crearPanel(objPanelFrecuencia);
        }
        if (e.getActionCommand().equals("Ideal Highpass Filters")) {
            System.out.println("Ideal Highpass Filters");
            
            opcionFrecuencia =3;
            crearPanel(objPanelFrecuencia);
        }
        if (e.getActionCommand().equals("Butterworth Highpass Filters")) {
            System.out.println("Butterworth Highpass Filters");
           
            opcionFrecuencia =4;
            crearPanel(objPanelFrecuencia);
        }
          if (e.getSource() == objPanelFrecuencia.botonAplicarFrecuencia) {
              System.out.println(opcionFrecuencia);
           switch(opcionFrecuencia){
               case 1:
                  idealLowpassFilters();
                  break;
                 case 2:
                  butterworthLowpassFilters();
                  break;
                  case 3:
                  idealHighpassFilters();
                  break;
                  case 4:
               butterworthHigtpassFilters();
                  break;
                  default:
                      System.out.println("ninguna de las anteriores");
              
           }
        }
        //menu item de convolucion

        if (e.getActionCommand().equals("Aplicar Convolucion")) {
            System.out.println("convolucion");
            crearPanelConvolucion(objPanelConvolucion);
        }
        if (e.getActionCommand().equals("aplicar convolucion")) {
            System.out.println("boton ");
            aplicarConvolucion();
        }

        //menu item de histograma
        if (e.getActionCommand().equals("generar histograma")) {
            System.out.println("histograma");
            mostrarHistorgrama();
        }

        if (e.getActionCommand().equals("ecualizar histograma")) {
            System.out.println("histograma ecualizar");
            ecualizarHistogramas();
        }
        if (e.getActionCommand().equals("pasar a CMY")) {
            System.out.println("tranformacion cmy");
            convertirRGBaCMY();
        }
        if (e.getActionCommand().equals("Matiz")) {
            System.out.println("matiz ");
            matiz();
        }
        if (e.getActionCommand().equals("Saturacion")) {
            System.out.println("saturacion");
            saturacion();
        }
        if (e.getActionCommand().equals("Intensidad")) {
            System.out.println("intensidad");
            intensidad();
        }
        //dilatacion
         if (e.getActionCommand().equals("dilatacion")) {
            System.out.println("dilatacion");
            dilatacion();
           
        }
         //erocion 
          if (e.getActionCommand().equals("erosion")) {
            System.out.println("erosion");
            erocion();
            
        }
          //open 
          if (e.getActionCommand().equals("open")) {
            System.out.println("dilatacion");
            erocion();
            dilatacion();
            
        }
          //close
          if (e.getActionCommand().equals("close")) {
            System.out.println("close");
            dilatacion();
            erocion();
            
        }
        //reiniciar imagen
         if (e.getActionCommand().equals("reiniciar imagen")) {
            System.out.println("reiniciar imagen");
            reiniciarImagen();
            
        }

    }
    //operacoin morfologicas 
    public void dilatacion(){
        OperacionesMorfologicas morfo = new OperacionesMorfologicas();
           short [][] imagenBianria = morfo.pasarBinario(objimagenOriginal.getMatrizGris());
           short [][] imagen =  morfo.dilatacion(imagenBianria);
           //cambios 
        objimagenOriginal.setImagenBuffer(objimagenOriginal.convierteMatrizenBufferd(imagen));
       objimagenOriginal.setMatrizGris(imagen);        
            //
           objVentanaPrincipal.labelImagenGris.setIcon(new ImageIcon(objimagenOriginal.convierteMatrizenBufferd(imagen)));
    }
    public void erocion(){
        OperacionesMorfologicas morfo = new OperacionesMorfologicas();
           short [][] imagenBianria = morfo.pasarBinario(objimagenOriginal.getMatrizGris());
           short [][] imagen =  morfo.erosion(imagenBianria);
                //cambios 
        objimagenOriginal.setImagenBuffer(objimagenOriginal.convierteMatrizenBufferd(imagen));
       objimagenOriginal.setMatrizGris(imagen);        
            //
           objVentanaPrincipal.labelImagenGris.setIcon(new ImageIcon(objimagenOriginal.convierteMatrizenBufferd(imagen)));
    }
//metodo para reiniciar la imagen
    public void reiniciarImagen(){
        objimagenOriginal = new Imagen(archivoImagen);
        objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(objimagenOriginal.getImagenBuffer()));
      
    }
    //meotodo para pasar el modelo HSI
    public void saturacion() {

        short[][] saturacion = objHsi.saturacion(objimagenOriginal.getMatrizRojo(), objimagenOriginal.getMatrizVerde(), objimagenOriginal.getMatrizAzul());
        objVentanaPrincipal.labelImagenGris.setIcon(new ImageIcon(objimagenOriginal.convierteMatrizenBufferd(saturacion)));

    }

    public void intensidad() {

        short[][] intensidad = objHsi.intensidad(objimagenOriginal.getMatrizRojo(), objimagenOriginal.getMatrizVerde(), objimagenOriginal.getMatrizAzul());
        objVentanaPrincipal.labelImagenGris.setIcon(new ImageIcon(objimagenOriginal.convierteMatrizenBufferd(intensidad)));

    }

    public void matiz() {

        short[][] matiz = objHsi.matiz(objimagenOriginal.getMatrizRojo(), objimagenOriginal.getMatrizVerde(), objimagenOriginal.getMatrizAzul());
        objVentanaPrincipal.labelImagenGris.setIcon(new ImageIcon(objimagenOriginal.convierteMatrizenBufferd(matiz)));

    }

    //meotdo para ecualizar histograma
  
    public void ecualizarHistogramas(){
         try {

            //LEEMOS LA IMAGEN
            Image imagen = objimagenOriginal.getImagenBuffer();

            //CREAMOS EL HISTOGRAMA
            Histograma ObjHistograma = new Histograma();
            int[][] histograma = ObjHistograma.histograma((BufferedImage) imagen);
            //DIBUJAMOS EL HISTOGRAMA
            DibujarGrafico ObjDibujaHisto = new DibujarGrafico();
            int []histogramaRojo = histograma[0];
            int []histogramaVerde = histograma[1];
            int []histogramaAzul = histograma[2];
            
            int []rojoEcualizado = ObjHistograma.ecualizarHistograma(histogramaRojo, objimagenOriginal.getMatrizGris());
            int []verdeEcualizado = ObjHistograma.ecualizarHistograma(histogramaVerde, objimagenOriginal.getMatrizGris());
            int []azulEcualizado = ObjHistograma.ecualizarHistograma(histogramaAzul, objimagenOriginal.getMatrizGris());
            
            ObjDibujaHisto.crearHistograma(rojoEcualizado, objVentanaHistograma.histogramaRojo, Color.RED);
            ObjDibujaHisto.crearHistograma(verdeEcualizado, objVentanaHistograma.histogramaVerde, Color.GREEN);
            ObjDibujaHisto.crearHistograma(azulEcualizado, objVentanaHistograma.histogramaAzul, Color.BLUE);
            
            objVentanaHistograma.labelImagen.setIcon(new ImageIcon(objimagenOriginal.getImagenBuffer()));
            objVentanaHistograma.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodo para pasar de RGB a CMY 
    public void convertirRGBaCMY() {
        BufferedImage imagenCMY = objimagenOriginal.convertRGBaCMY(objimagenOriginal.getMatrizAzul(), objimagenOriginal.getMatrizRojo(), objimagenOriginal.getMatrizVerde());
        objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(imagenCMY));
    }

    //metodo para mostrar el histograma
    public void mostrarHistorgrama() {
        try {

            //LEEMOS LA IMAGEN
            Image imagen = objimagenOriginal.getImagenBuffer();
            //establecemos la imagen como imagen en el jLabel

            //CREAMOS EL HISTOGRAMA
            Histograma ObjHistograma = new Histograma();
            int[][] histograma = ObjHistograma.histograma((BufferedImage) imagen);
            //DIBUJAMOS EL HISTOGRAMA
            DibujarGrafico ObjDibujaHisto = new DibujarGrafico();
            for (int i = 0; i < 5; i++) {
                //extraemos un canal del histograma 
                int[] histogramaCanal = new int[256];
                System.arraycopy(histograma[i], 0, histogramaCanal, 0, histograma[i].length);
                //Dibujamos en el panel
                switch (i) {
                    case 0:
                        ObjDibujaHisto.crearHistograma(histogramaCanal, objVentanaHistograma.histogramaRojo, Color.red);
                        break;
                    case 1:
                        ObjDibujaHisto.crearHistograma(histogramaCanal, objVentanaHistograma.histogramaVerde, Color.green);
                        break;
                    case 2:
                        ObjDibujaHisto.crearHistograma(histogramaCanal, objVentanaHistograma.histogramaAzul, Color.blue);
                        break;

                }
            }
            objVentanaHistograma.labelImagen.setIcon(new ImageIcon(objimagenOriginal.getImagenBuffer()));
            objVentanaHistograma.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodo para la operacion de convolucion
    public void aplicarConvolucion() {
        short[][] mascara = new short[3][3];
        mascara[0][0] = Short.valueOf(objPanelConvolucion.jTextFieldConvo1.getText());
        mascara[0][1] = Short.valueOf(objPanelConvolucion.jTextFieldConvo2.getText());
        mascara[0][2] = Short.valueOf(objPanelConvolucion.jTextFieldConvo3.getText());
        mascara[1][0] = Short.valueOf(objPanelConvolucion.jTextFieldConvo4.getText());
        mascara[1][1] = Short.valueOf(objPanelConvolucion.jTextFieldConvo5.getText());
        mascara[1][2] = Short.valueOf(objPanelConvolucion.jTextFieldConvo6.getText());
        mascara[2][0] = Short.valueOf(objPanelConvolucion.jTextFieldConvo7.getText());
        mascara[2][1] = Short.valueOf(objPanelConvolucion.jTextFieldConvo8.getText());
        mascara[2][2] = Short.valueOf(objPanelConvolucion.jTextFieldConvo9.getText());

        objConvolucion = new Convolucion(mascara);
        short [][]matrizGris = objimagenOriginal.getMatrizGris();
        short[][] matrizConvolucion = objConvolucion.aplicarConvolucion(matrizGris);
         
        BufferedImage imagenConvolucion = objimagenOriginal.convierteMatrizenBufferd(matrizConvolucion);
         //cambios 
                 objimagenOriginal.setImagenBuffer(imagenConvolucion);
        objimagenOriginal.setMatrizGris(matrizConvolucion);        
            //
        objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(imagenConvolucion));

    }

    //metoods para las opciones de espectros
    
    public void espectro(){
        try {
       ImageFFT ima = new ImageFFT(objimagenOriginal.getImagenBuffer());
       ima.transform();
        
        BufferedImage imagenEspectro = ima.getSpectrum();
        objimagenOriginal.setImagenBuffer(imagenEspectro);
        objVentanaPrincipal.labelImagenGris.setIcon(new ImageIcon(imagenEspectro));
        } catch (Exception e) {
        }
    }
    public void idealLowpassFilters() {
        try {
            
            instanciar();
            double radio = objImageFFT.transpolarRapio(objPanelFrecuencia.valorRadio.getText());
            objImageFFT.transform();
            objImageFFT.idealLowPassFilter(radio);
            objImageFFT.transform();
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(objImageFFT.toImage(null)));
        } catch (FFTException e) {
            System.out.println("ocurrio un error");
        }
    }

    public void butterworthLowpassFilters() {
        try {
         
            String stringOrden = JOptionPane.showInputDialog("introduce orden (opcional)");

            if (stringOrden == null || stringOrden.equals("")) {
                instanciar();
                double radio = objImageFFT.transpolarRapio(objPanelFrecuencia.valorRadio.getText());
                objImageFFT.transform();
                objImageFFT.butterworthLowPassFilter(radio);
                objImageFFT.transform();
                objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(objImageFFT.toImage(null)));
            } else {
                int orden = Integer.valueOf(stringOrden);
                instanciar();
                double radio = objImageFFT.transpolarRapio(objPanelFrecuencia.valorRadio.getText());
                objImageFFT.transform();
                objImageFFT.butterworthLowPassFilter(orden, radio);
                objImageFFT.transform();
                objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(objImageFFT.toImage(null)));
            }

        } catch (FFTException e) {
            System.out.println("ocurrio un error");
        }

    }

    public void idealHighpassFilters() {
        try {
            

            instanciar();
            double radio = objImageFFT.transpolarRapio(objPanelFrecuencia.valorRadio.getText());
            objImageFFT.transform();
            objImageFFT.idealHighPassFilter(radio);
            objImageFFT.transform();
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(objImageFFT.toImage(null)));
        } catch (FFTException e) {
            System.out.println("ocurrio un error");
        }
    }

    public void butterworthHigtpassFilters() {
        try {
                       String stringOrden = JOptionPane.showInputDialog("introduce orden (opcional)");

            if (stringOrden == null || stringOrden.equals("")) {
                instanciar();
                double radio = objImageFFT.transpolarRapio(objPanelFrecuencia.valorRadio.getText());
                objImageFFT.transform();
                objImageFFT.butterworthHighPassFilter(radio);
                objImageFFT.transform();
                objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(objImageFFT.toImage(null)));
            } else {
                int orden = Integer.valueOf(stringOrden);
                instanciar();
                double radio = objImageFFT.transpolarRapio(objPanelFrecuencia.valorRadio.getText());
                objImageFFT.transform();
                objImageFFT.butterworthHighPassFilter(orden, radio);
                objImageFFT.transform();
                objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(objImageFFT.toImage(null)));
            }

        } catch (FFTException e) {
            System.out.println("ocurrio un error");
        }
    }

    public void instanciar() {
        try {
            System.out.println("instanciar ");
            objImageFFT = new ImageFFT(objimagenOriginal.convierteMatrizenBufferd(objimagenOriginal.getMatrizGris()));
        } catch (FFTException ex) {
            ex.printStackTrace();
        }
    }
    //metodos para las operacioens de quitar el ruido 
    //media seccion 

    public void mediaSeccion() {
        try {
            short[][] matrizGris = objimagenOriginal.getMatrizGris();
            short[][] matrizFiltro = objFiltroRuido.mediaSeccion(matrizGris);
            BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matrizFiltro);
              //cambios 
              objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matrizFiltro);     
            //
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "imagen no cargada");
        }
    }

    //punto medio
    public void puntoMedio() {
        try {
            short[][] matrizGris = objimagenOriginal.getMatrizGris();
            short[][] matrizFiltro = objFiltroRuido.puntoMedio(matrizGris);
            BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matrizFiltro);
              //cambios 
                 objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matrizFiltro);     
            //
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "imagen no cargada");
        }
    }

    //filtros estadisticos
    //minimo
    public void minimo() {
        try {
            short[][] matrizGris = objimagenOriginal.getMatrizGris();
            short[][] matrizFiltro = objFiltroRuido.minimo(matrizGris);
            BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matrizFiltro);
              //cambios 
                  objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matrizFiltro);        
            //
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "imagen no cargada");
        }
    }

    //maximo
    public void maximo() {
        try {
            short[][] matrizGris = objimagenOriginal.getMatrizGris();
            short[][] matrizFiltro = objFiltroRuido.maximo(matrizGris);
            BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matrizFiltro);
              //cambios 
                 objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matrizFiltro);  
            //
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "imagen no cargada");
        }
    }

    //media
    public void media() {
        try {
            short[][] matrizGris = objimagenOriginal.getMatrizGris();
            short[][] matrizFiltro = objFiltroRuido.media(matrizGris);
            BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matrizFiltro);
              //cambios 
              objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matrizFiltro);        
            //
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "imagen no cargada");
        }
    }

    //media aritmetica
    public void mediaAritmetica() {
        try {
            short[][] matrizGris = objimagenOriginal.getMatrizGris();
            short[][] matrizFiltro = objFiltroRuido.mediaAritmetica(matrizGris);
            BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matrizFiltro);
            //cambios 
                 objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matrizFiltro);       
            //
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "imagen no cargada");
        }
    }

    //media geometrica
    public void mediaGeometrica() {
        try {
            short[][] matrizGris = objimagenOriginal.getMatrizGris();
            short[][] matrizFiltro = objFiltroRuido.mediaGeometrica(matrizGris);
            BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matrizFiltro);
            //cambios 
             objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matrizFiltro);        
            //
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "imagen no cargada");
        }
    }

    //media contraarmonica
    public void mediaContraarmonica() {
        try {
            short[][] matrizGris = objimagenOriginal.getMatrizGris();
            short[][] matrizFiltro = objFiltroRuido.mediaContraarmonica(matrizGris);
            BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matrizFiltro);
            //cambios 
            objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matrizFiltro);  
            //
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "imagen no cargada");
        }
    }

    //metodos para las operaciones del menu(practica 5)-> aumento tamanio y rotar
    public void aumentarTamanio() {
        try {
            objVentanaPrincipal.labelImagenGris.setIcon(new ImageIcon(objimagenOriginal.getImagenBuffer()));
            short[][] matrizGris = objimagenOriginal.getMatrizGris();
            short[][] matrizAumentada = objimagenOriginal.aumetarTamanio(matrizGris, 2);
            BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matrizAumentada, matrizAumentada.length, matrizAumentada[0].length);
             //cambios
        objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matrizAumentada);
        //
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error");
        }
    }

    //rotar 90
    public void rotar90() {
        System.out.println("rotando");
        short[][] matrizGris = objimagenOriginal.getMatrizGris();
        short[][] matriz90 = objimagenOriginal.rotar90pmd(matrizGris);
        BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matriz90);
        //cambios
        objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matriz90);
        //
        objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
    }

    //rotar 180
    public void rotar180() {
        short[][] matrizGris = objimagenOriginal.getMatrizGris();
        short[][] matriz180 = objimagenOriginal.rotarImagen180(matrizGris);
        BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matriz180);
        //cambios
        objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matriz180);
        //
        objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
    }

    //rotar 270
    public void rotar270() {
        short[][] matrizGris = objimagenOriginal.getMatrizGris();
        short[][] matriz270 = objimagenOriginal.rotarImagen270(matrizGris);
        BufferedImage nuevaImagen = objimagenOriginal.convierteMatrizenBufferd(matriz270);
         //cambios
        objimagenOriginal.setImagenBuffer(nuevaImagen);
        objimagenOriginal.setMatrizGris(matriz270);
        //
        objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nuevaImagen));
    }

    //metodos para operaicones
    public void sumarImagenes() {
        try {
            abrirSegundaImagen();
            short[][] primeraMatriz = objimagenOriginal.getMatrizGris();
            short[][] segundfaMatriz = objimagenOriginal.getSegundaMatrizGris();
            if (primeraMatriz.length == segundfaMatriz.length) {
                short[][] suma = objimagenOriginal.sumarImagenes(primeraMatriz, segundfaMatriz);
                BufferedImage imagenSuma = objimagenOriginal.convierteMatrizenBufferd(suma);
                  //cambios
               objimagenOriginal.setMatrizGris(segundfaMatriz);
                objimagenOriginal.setImagenBuffer(imagenSuma);
        //
                
                objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(imagenSuma));
            } else {
                JOptionPane.showMessageDialog(null, "las matrices no son del mismo tamanio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado la primera imagen");
        }

    }

    public void restaImagenes() {
        try {
            abrirSegundaImagen();
            short[][] primeraMatriz = objimagenOriginal.getMatrizGris();
            short[][] segundfaMatriz = objimagenOriginal.getSegundaMatrizGris();
            if (primeraMatriz.length == segundfaMatriz.length) {
                short[][] resta = objimagenOriginal.restaImagenes(primeraMatriz, segundfaMatriz);
                BufferedImage imagenSuma = objimagenOriginal.convierteMatrizenBufferd(resta);
                objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(imagenSuma));
            } else {
                JOptionPane.showMessageDialog(null, "las matrices no son del mismo tamanio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado la primera imagen");
        }

    }

    public void operadorAnd() {
        try {
            abrirSegundaImagen();
            short[][] primeraMatriz = objimagenOriginal.getMatrizGris();
            short[][] segundfaMatriz = objimagenOriginal.getSegundaMatrizGris();
            //definir u 
            objUmbralizacion.setU1("120");
            objUmbralizacion.setU2("180");
            //pasar las dos imagenes a binario
            short[][] binario = objUmbralizacion.umbralBinario(primeraMatriz);
            short[][] binario2 = objUmbralizacion.umbralBinario(segundfaMatriz);

            if (primeraMatriz.length == segundfaMatriz.length) {
                short[][] and = objimagenOriginal.operacionAnd(binario, binario2);
                BufferedImage imagenSuma = objimagenOriginal.convierteMatrizenBufferd(and);
                objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(imagenSuma));
            } else {
                JOptionPane.showMessageDialog(null, "las matrices no son del mismo tamanio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado la primera imagen");
        }

    }

    public void operadorOr() {
        try {
            abrirSegundaImagen();
            short[][] primeraMatriz = objimagenOriginal.getMatrizGris();
            short[][] segundfaMatriz = objimagenOriginal.getSegundaMatrizGris();
            //definir u 
            objUmbralizacion.setU1("120");
            objUmbralizacion.setU2("180");
            //pasar las dos imagenes a binario
            short[][] binario = objUmbralizacion.umbralBinario(primeraMatriz);
            short[][] binario2 = objUmbralizacion.umbralBinario(segundfaMatriz);

            if (primeraMatriz.length == segundfaMatriz.length) {
                short[][] or = objimagenOriginal.operacionOr(binario, binario2);
                BufferedImage imagenSuma = objimagenOriginal.convierteMatrizenBufferd(or);
                
                //cambios
                
                //
                
                
                objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(imagenSuma));
            } else {
                JOptionPane.showMessageDialog(null, "las matrices no son del mismo tamanio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado la primera imagen");
        }

    }

    public void operadorXor() {
        try {
            abrirSegundaImagen();
            short[][] primeraMatriz = objimagenOriginal.getMatrizGris();
            short[][] segundfaMatriz = objimagenOriginal.getSegundaMatrizGris();
            //definir u 
            objUmbralizacion.setU1("120");
            objUmbralizacion.setU2("180");
            //pasar las dos imagenes a binario
            short[][] binario = objUmbralizacion.umbralBinario(primeraMatriz);
            short[][] binario2 = objUmbralizacion.umbralBinario(segundfaMatriz);

            if (primeraMatriz.length == segundfaMatriz.length) {
                short[][] xor = objimagenOriginal.operacionXor(binario, binario2);
                BufferedImage imagenXor = objimagenOriginal.convierteMatrizenBufferd(xor);
                objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(imagenXor));
            } else {
                JOptionPane.showMessageDialog(null, "las matrices no son del mismo tamanio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado la primera imagen");
        }

    }

    public void operadorNot() {
        try {
            short[][] primeraMatriz = objimagenOriginal.getMatrizGris();
            //definir u 
            objUmbralizacion.setU1("120");
            objUmbralizacion.setU2("180");
            //pasar la imagen a binario
            short[][] binario = objUmbralizacion.umbralBinario(primeraMatriz);
            short[][] not = objimagenOriginal.operacionNot(binario);
            BufferedImage imagenNot = objimagenOriginal.convierteMatrizenBufferd(not);
             //cambios
        objimagenOriginal.setImagenBuffer(imagenNot);
        objimagenOriginal.setMatrizGris(not);
        //
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(imagenNot));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void crearImagenNegativa() {
        short[][] matrizGris = objimagenOriginal.getMatrizGris();
        short[][] filtro = objUmbralizacion.umbralizacionNegativo(matrizGris);
        BufferedImage nueva = objimagenOriginal.convierteMatrizenBufferd(filtro);
        //cambios
        objimagenOriginal.setImagenBuffer(nueva);
        objimagenOriginal.setMatrizGris(filtro);
        //
        objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nueva));
    }

    public void crearImagenUmbralInverso() {
        short[][] matrizGris = objimagenOriginal.getMatrizGris();
        short[][] filtro = objUmbralizacion.umbralInverso(matrizGris);
        BufferedImage nueva = objimagenOriginal.convierteMatrizenBufferd(filtro);
                //cambios
        objimagenOriginal.setImagenBuffer(nueva);
        objimagenOriginal.setMatrizGris(filtro);
        //
        objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nueva));
    }

    public void crearImagenBinario() {
        short[][] matrizGris = objimagenOriginal.getMatrizGris();
        short[][] filtro = objUmbralizacion.umbralBinario(matrizGris);
        BufferedImage nueva = objimagenOriginal.convierteMatrizenBufferd(filtro);
        //cambios
        objimagenOriginal.setImagenBuffer(nueva);
        objimagenOriginal.setMatrizGris(filtro);
        //
        objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nueva));
    }

    public void crearImagenUmbralGris() {
        short[][] matrizGris = objimagenOriginal.getMatrizGris();
        short[][] filtro = objUmbralizacion.umbralGris(matrizGris);
        BufferedImage nueva = objimagenOriginal.convierteMatrizenBufferd(filtro);
                //cambios
        objimagenOriginal.setImagenBuffer(nueva);
        objimagenOriginal.setMatrizGris(filtro);
        //
        objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nueva));
    }

    public void crearImagenOperadorExtension() {
        short[][] matrizGris = objimagenOriginal.getMatrizGris();
        short[][] filtro = objUmbralizacion.operadorExtension(matrizGris);
        BufferedImage nueva = objimagenOriginal.convierteMatrizenBufferd(filtro);
               //cambios
        objimagenOriginal.setImagenBuffer(nueva);
        objimagenOriginal.setMatrizGris(filtro);
        //
        objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(nueva));
    }

    public void crearPanel(JPanel panel) {
        panel.setSize(objVentanaPrincipal.panelEntradaDatos.size().width, objVentanaPrincipal.panelEntradaDatos.size().height);
        objVentanaPrincipal.panelEntradaDatos.removeAll();
        objVentanaPrincipal.panelEntradaDatos.add(panel);
        objVentanaPrincipal.panelEntradaDatos.revalidate();
        objVentanaPrincipal.panelEntradaDatos.repaint();
        objVentanaPrincipal.pack();
    }

    public void crearPanelConvolucion(JPanel panel) {
        panel.setSize(objVentanaPrincipal.panelEntradaDatos.size().width, objVentanaPrincipal.panelEntradaDatos.size().height);
        objVentanaPrincipal.panelEntradaDatos.removeAll();
        objVentanaPrincipal.panelEntradaDatos.add(panel);
        objVentanaPrincipal.panelEntradaDatos.revalidate();
        objVentanaPrincipal.panelEntradaDatos.repaint();
        objVentanaPrincipal.pack();
    }

    public void abrirArchivoImagen() {
        JFileChooser exploradorArchivos = new JFileChooser();

        int respuesta = exploradorArchivos.showOpenDialog(objVentanaPrincipal);
        if (respuesta == JFileChooser.APPROVE_OPTION && exploradorArchivos.getSelectedFile().exists()) {
            archivoImagen = exploradorArchivos.getSelectedFile();
            //CONSTRUIR EL OBJ IMAGEN
            objimagenOriginal = new Imagen(archivoImagen);
            objVentanaPrincipal.labelimagen.setIcon(new ImageIcon(objimagenOriginal.getImagenBuffer()));
        }

    }

    public void abrirSegundaImagen() {
        JFileChooser exploradorArchivos = new JFileChooser();
//                FileNameExtensionFilter filtroArchivos = new FileNameExtensionFilter("PNG", "BMP", "png", "bmp");
//        exploradorArchivos.setFileFilter(filtroArchivos);
        exploradorArchivos.setAcceptAllFileFilterUsed(true);
        int respuesta = exploradorArchivos.showOpenDialog(objVentanaPrincipal);
        if (respuesta == JFileChooser.APPROVE_OPTION && exploradorArchivos.getSelectedFile().exists()) {
            archivoImagen = exploradorArchivos.getSelectedFile();
            //CONSTRUIR EL OBJ IMAGEN
            objimagenOriginal.cargarSegundaImagen(archivoImagen);

        }

    }

    public void convertirImagenGris() {
        short[][] matrizGris = objimagenOriginal.getMatrizGris();
        BufferedImage imagenGris = objimagenOriginal.convierteMatrizenBufferd(matrizGris);
        objVentanaPrincipal.labelImagenGris.setIcon(new ImageIcon(imagenGris));
    }

    public void verAtributosImagen() {
        objVentanaPrincipal.labelNombre.setText(objimagenOriginal.getNombre());
        objVentanaPrincipal.labelPeso.setText(objimagenOriginal.getPeso() + " bytes");
        objVentanaPrincipal.labelAncho.setText(objimagenOriginal.getAncho() + "px");
        objVentanaPrincipal.labelIntensidad.setText(objimagenOriginal.getNivelIntensidad() + "");
        objVentanaPrincipal.labelAlto.setText(objimagenOriginal.getAlto() + "px");

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

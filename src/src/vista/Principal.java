/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.vista;

import src.controlador.ControladorImagen;

/**
 *
 * @author CU NEZA
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        new ControladorImagen(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        panelIzquierdo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelImagenGris = new javax.swing.JLabel();
        panelDerecho = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        labelimagen = new javax.swing.JLabel();
        panelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelPeso = new javax.swing.JLabel();
        labelAncho = new javax.swing.JLabel();
        labelIntensidad = new javax.swing.JLabel();
        labelAlto = new javax.swing.JLabel();
        panelEntradaDatos = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuAbrir = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        reiniciarImage = new javax.swing.JMenuItem();
        menuEscalaGrises = new javax.swing.JMenu();
        MenuCovertirGris = new javax.swing.JMenuItem();
        menuUmbralizacion = new javax.swing.JMenu();
        umbralizacionNegativo = new javax.swing.JMenuItem();
        umbralInverso = new javax.swing.JMenuItem();
        umbralBinario = new javax.swing.JMenuItem();
        umbralGris = new javax.swing.JMenuItem();
        operadorExtension = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        opSuma = new javax.swing.JMenuItem();
        opResta = new javax.swing.JMenuItem();
        opAnd = new javax.swing.JMenuItem();
        opOr = new javax.swing.JMenuItem();
        opXor = new javax.swing.JMenuItem();
        opNot = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        AumentarTamanio = new javax.swing.JMenuItem();
        rotar90 = new javax.swing.JMenuItem();
        rotar180 = new javax.swing.JMenuItem();
        rotar270 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mediaAritmetica = new javax.swing.JMenuItem();
        mediaGeometrica = new javax.swing.JMenuItem();
        mediaContraarmonico = new javax.swing.JMenuItem();
        media = new javax.swing.JMenuItem();
        maximo = new javax.swing.JMenuItem();
        minimo = new javax.swing.JMenuItem();
        puntoMedio = new javax.swing.JMenuItem();
        mediaSeccion = new javax.swing.JMenuItem();
        menuEspectros = new javax.swing.JMenu();
        menuEspectro = new javax.swing.JMenuItem();
        idealLowpassFilters = new javax.swing.JMenuItem();
        butterworthLowpassFilters = new javax.swing.JMenuItem();
        idealHighpassFilters = new javax.swing.JMenuItem();
        butterworthHighpassFilters = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuConvolucion = new javax.swing.JMenuItem();
        menuHistograma = new javax.swing.JMenu();
        generarHistograma = new javax.swing.JMenuItem();
        ecualizarHistograma = new javax.swing.JMenuItem();
        convetirCmy = new javax.swing.JMenu();
        transformarCMY = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuSaturacion = new javax.swing.JMenuItem();
        menuIntensidad = new javax.swing.JMenuItem();
        menuMatiz = new javax.swing.JMenuItem();
        dilatacion = new javax.swing.JMenu();
        menuDilatacion = new javax.swing.JMenuItem();
        menuErosion = new javax.swing.JMenuItem();
        menuOpen = new javax.swing.JMenuItem();
        menuClose = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(labelImagenGris);

        javax.swing.GroupLayout panelIzquierdoLayout = new javax.swing.GroupLayout(panelIzquierdo);
        panelIzquierdo.setLayout(panelIzquierdoLayout);
        panelIzquierdoLayout.setHorizontalGroup(
            panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        panelIzquierdoLayout.setVerticalGroup(
            panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );

        labelimagen.setAutoscrolls(true);
        jScrollPane2.setViewportView(labelimagen);

        javax.swing.GroupLayout panelDerechoLayout = new javax.swing.GroupLayout(panelDerecho);
        panelDerecho.setLayout(panelDerechoLayout);
        panelDerechoLayout.setHorizontalGroup(
            panelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );
        panelDerechoLayout.setVerticalGroup(
            panelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        jLabel1.setText("Nombre:");

        jLabel2.setText("Peso");

        jLabel4.setText("Ancho");

        jLabel5.setText("Alto");

        jLabel3.setText("Intensidad");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(118, 118, 118)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAlto)
                    .addComponent(labelIntensidad)
                    .addComponent(labelAncho)
                    .addComponent(labelPeso)
                    .addComponent(labelNombre))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelPeso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelAncho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelIntensidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelAlto))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelEntradaDatosLayout = new javax.swing.GroupLayout(panelEntradaDatos);
        panelEntradaDatos.setLayout(panelEntradaDatosLayout);
        panelEntradaDatosLayout.setHorizontalGroup(
            panelEntradaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelEntradaDatosLayout.setVerticalGroup(
            panelEntradaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
        );

        menuArchivo.setText("Archivo                            ");

        menuAbrir.setText("Abrir");
        menuArchivo.add(menuAbrir);

        menuSalir.setText("Salir");
        menuArchivo.add(menuSalir);

        reiniciarImage.setText("reiniciar imagen");
        menuArchivo.add(reiniciarImage);

        jMenuBar1.add(menuArchivo);

        menuEscalaGrises.setText("Escala Grises");

        MenuCovertirGris.setText("ConvertirGris");
        menuEscalaGrises.add(MenuCovertirGris);

        jMenuBar1.add(menuEscalaGrises);

        menuUmbralizacion.setText("Umbralizacion");

        umbralizacionNegativo.setText("Umbralizacion negativo");
        menuUmbralizacion.add(umbralizacionNegativo);

        umbralInverso.setText("umbral inverso");
        menuUmbralizacion.add(umbralInverso);

        umbralBinario.setText("umbral binario");
        menuUmbralizacion.add(umbralBinario);

        umbralGris.setText("umbral en gris");
        menuUmbralizacion.add(umbralGris);

        operadorExtension.setText("operador extension");
        menuUmbralizacion.add(operadorExtension);

        jMenuBar1.add(menuUmbralizacion);

        jMenu1.setText("Operaciones");

        opSuma.setText("Suma");
        jMenu1.add(opSuma);

        opResta.setText("Resta");
        opResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opRestaActionPerformed(evt);
            }
        });
        jMenu1.add(opResta);

        opAnd.setText("And");
        jMenu1.add(opAnd);

        opOr.setText("Or");
        jMenu1.add(opOr);

        opXor.setText("Xor");
        jMenu1.add(opXor);

        opNot.setText("Not");
        jMenu1.add(opNot);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Filtros basicos");

        AumentarTamanio.setText("Aumentar tamanio");
        jMenu2.add(AumentarTamanio);

        rotar90.setText("Rotar 90°");
        rotar90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotar90ActionPerformed(evt);
            }
        });
        jMenu2.add(rotar90);

        rotar180.setText("Rotar 180°");
        rotar180.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotar180ActionPerformed(evt);
            }
        });
        jMenu2.add(rotar180);

        rotar270.setText("Rotar 270°");
        jMenu2.add(rotar270);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Filtros ruidos");

        mediaAritmetica.setText("media aritmetica");
        jMenu3.add(mediaAritmetica);

        mediaGeometrica.setText("media geometrica");
        jMenu3.add(mediaGeometrica);

        mediaContraarmonico.setText("media contraarmonico");
        jMenu3.add(mediaContraarmonico);

        media.setText("media");
        jMenu3.add(media);

        maximo.setText("maximo");
        jMenu3.add(maximo);

        minimo.setText("minimo");
        jMenu3.add(minimo);

        puntoMedio.setText("punto medio");
        puntoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntoMedioActionPerformed(evt);
            }
        });
        jMenu3.add(puntoMedio);

        mediaSeccion.setText("media seccion");
        jMenu3.add(mediaSeccion);

        jMenuBar1.add(jMenu3);

        menuEspectros.setText("Frecuencia");

        menuEspectro.setText("espectro");
        menuEspectros.add(menuEspectro);

        idealLowpassFilters.setText("Ideal Lowpass Filters");
        menuEspectros.add(idealLowpassFilters);

        butterworthLowpassFilters.setText("Butterworth Lowpass Filters");
        menuEspectros.add(butterworthLowpassFilters);

        idealHighpassFilters.setText("Ideal Highpass Filters");
        menuEspectros.add(idealHighpassFilters);

        butterworthHighpassFilters.setText("Butterworth Highpass Filters");
        menuEspectros.add(butterworthHighpassFilters);

        jMenuBar1.add(menuEspectros);

        jMenu4.setText("Convolucion");

        menuConvolucion.setText("Aplicar Convolucion");
        menuConvolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConvolucionActionPerformed(evt);
            }
        });
        jMenu4.add(menuConvolucion);

        jMenuBar1.add(jMenu4);

        menuHistograma.setText("Histograma");

        generarHistograma.setText("generar histograma");
        generarHistograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarHistogramaActionPerformed(evt);
            }
        });
        menuHistograma.add(generarHistograma);

        ecualizarHistograma.setText("ecualizar histograma");
        ecualizarHistograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecualizarHistogramaActionPerformed(evt);
            }
        });
        menuHistograma.add(ecualizarHistograma);

        jMenuBar1.add(menuHistograma);

        convetirCmy.setText("Convertir CMY");

        transformarCMY.setText("pasar a CMY");
        convetirCmy.add(transformarCMY);

        jMenuBar1.add(convetirCmy);

        jMenu5.setText("HSI");

        menuSaturacion.setText("Saturacion");
        jMenu5.add(menuSaturacion);

        menuIntensidad.setText("Intensidad");
        jMenu5.add(menuIntensidad);

        menuMatiz.setText("Matiz");
        jMenu5.add(menuMatiz);

        jMenuBar1.add(jMenu5);

        dilatacion.setText("Morfologicos");

        menuDilatacion.setText("dilatacion");
        dilatacion.add(menuDilatacion);

        menuErosion.setText("erosion");
        dilatacion.add(menuErosion);

        menuOpen.setText("open");
        dilatacion.add(menuOpen);

        menuClose.setText("close");
        dilatacion.add(menuClose);

        jMenuBar1.add(dilatacion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelEntradaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelEntradaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDerecho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opRestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opRestaActionPerformed

    private void rotar90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotar90ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotar90ActionPerformed

    private void rotar180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotar180ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rotar180ActionPerformed

    private void puntoMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntoMedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puntoMedioActionPerformed

    private void menuConvolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConvolucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuConvolucionActionPerformed

    private void ecualizarHistogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecualizarHistogramaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ecualizarHistogramaActionPerformed

    private void generarHistogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarHistogramaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generarHistogramaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem AumentarTamanio;
    public javax.swing.JMenuItem MenuCovertirGris;
    public javax.swing.JMenuItem butterworthHighpassFilters;
    public javax.swing.JMenuItem butterworthLowpassFilters;
    public javax.swing.JMenu convetirCmy;
    public javax.swing.JMenu dilatacion;
    public javax.swing.JMenuItem ecualizarHistograma;
    public javax.swing.JMenuItem generarHistograma;
    public javax.swing.JMenuItem idealHighpassFilters;
    public javax.swing.JMenuItem idealLowpassFilters;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    public javax.swing.JMenu jMenu4;
    public javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel labelAlto;
    public javax.swing.JLabel labelAncho;
    public javax.swing.JLabel labelImagenGris;
    public javax.swing.JLabel labelIntensidad;
    public javax.swing.JLabel labelNombre;
    public javax.swing.JLabel labelPeso;
    public javax.swing.JLabel labelimagen;
    public javax.swing.JMenuItem maximo;
    public javax.swing.JMenuItem media;
    public javax.swing.JMenuItem mediaAritmetica;
    public javax.swing.JMenuItem mediaContraarmonico;
    public javax.swing.JMenuItem mediaGeometrica;
    public javax.swing.JMenuItem mediaSeccion;
    public javax.swing.JMenuItem menuAbrir;
    public javax.swing.JMenu menuArchivo;
    public javax.swing.JMenuItem menuClose;
    public javax.swing.JMenuItem menuConvolucion;
    public javax.swing.JMenuItem menuDilatacion;
    public javax.swing.JMenuItem menuErosion;
    public javax.swing.JMenu menuEscalaGrises;
    public javax.swing.JMenuItem menuEspectro;
    public javax.swing.JMenu menuEspectros;
    public javax.swing.JMenu menuHistograma;
    public javax.swing.JMenuItem menuIntensidad;
    public javax.swing.JMenuItem menuMatiz;
    public javax.swing.JMenuItem menuOpen;
    public javax.swing.JMenuItem menuSalir;
    public javax.swing.JMenuItem menuSaturacion;
    public javax.swing.JMenu menuUmbralizacion;
    public javax.swing.JMenuItem minimo;
    public javax.swing.JMenuItem opAnd;
    public javax.swing.JMenuItem opNot;
    public javax.swing.JMenuItem opOr;
    public javax.swing.JMenuItem opResta;
    public javax.swing.JMenuItem opSuma;
    public javax.swing.JMenuItem opXor;
    public javax.swing.JMenuItem operadorExtension;
    public javax.swing.JPanel panelDatos;
    public javax.swing.JPanel panelDerecho;
    public javax.swing.JPanel panelEntradaDatos;
    public javax.swing.JPanel panelIzquierdo;
    public javax.swing.JMenuItem puntoMedio;
    public javax.swing.JMenuItem reiniciarImage;
    public javax.swing.JMenuItem rotar180;
    public javax.swing.JMenuItem rotar270;
    public javax.swing.JMenuItem rotar90;
    public javax.swing.JMenuItem transformarCMY;
    public javax.swing.JMenuItem umbralBinario;
    public javax.swing.JMenuItem umbralGris;
    public javax.swing.JMenuItem umbralInverso;
    public javax.swing.JMenuItem umbralizacionNegativo;
    // End of variables declaration//GEN-END:variables
}

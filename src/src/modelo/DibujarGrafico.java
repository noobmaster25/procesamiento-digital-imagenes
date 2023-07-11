/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modelo;


import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author pedro pinguino
 */
public class DibujarGrafico {
    public void crearHistograma(int[] histograma,JPanel jPanelHistograma,Color colorBarras) {
        //Creamos el dataSet y añadimos el histograma
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String serie = "Number of píxels";
        for (int i = 0; i < histograma.length; i++){
            dataset.addValue(histograma[i], serie, "" + i);
        }
        //Creamos el chart
        JFreeChart chart = ChartFactory.createBarChart("Frequency Histogram", null, null,
                                    dataset, PlotOrientation.VERTICAL, true, true, false);
        //Modificamos el diseño del chart
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, colorBarras);
        chart.setAntiAlias(true);
        chart.setBackgroundPaint(new Color(214, 217, 223)); 
        jPanelHistograma.removeAll();
        jPanelHistograma.repaint();
        jPanelHistograma.setLayout(new java.awt.BorderLayout());
        jPanelHistograma.add(new ChartPanel(chart));
        jPanelHistograma.validate();    
    }
}

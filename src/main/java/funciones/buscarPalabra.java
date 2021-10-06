/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package funciones;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 * 
 * @author AndaryuS
 */
public class buscarPalabra {
   private String text;
    private int contadorTexto = 0;
    private int contadorPalabra = 0;
    private int p0 = -1;
    private int p1 = -1;

    private void buscarPatron(char caracterTexto, char caracterPalabra) {
        if (Character.compare(caracterTexto, caracterPalabra) == 0) {
            if ((p0 == -1)) {
                p0 = contadorTexto;
            }
            contadorPalabra++;
        } else {
            p0 = -1;
            p1 = -1;
            contadorPalabra = 0;
        }
        contadorTexto++;
    }

    /**
     * encargado de buscar y pintar las palabras que encuentra en el texto
     *
     * @param areaTexto
     * @param texto
     */
    public void buscarpalabra(JTextPane areaTexto, String texto) {
        if (texto.length() >= 1) {
            DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
            Highlighter h = areaTexto.getHighlighter();
            h.removeAllHighlights();
            text = areaTexto.getText();          
            while (contadorTexto < text.length()) {
                buscarPatron(text.charAt(contadorTexto), texto.charAt(contadorPalabra));
                if (contadorPalabra == texto.length() - 1) {
                    p1 = contadorTexto+1;
                    try {
                        h.addHighlight(p0, p1, highlightPainter);
                    } catch (BadLocationException ex) {
                        JOptionPane.showMessageDialog(null, "color inexistente");
                    }
                    p0 = -1;
                    p1 = -1;
                    contadorPalabra = 0;
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "debe escribir primero");
        }
    }
    
    
       public void buscarpalabra1(JTextPane area1, String texto) {
        if (texto.length() >= 1) {
            DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
            Highlighter h = area1.getHighlighter();
            h.removeAllHighlights();
            String text = area1.getText();
            String caracteres = texto;
            Pattern p = Pattern.compile("(?i)" + caracteres);
            Matcher m = p.matcher(text);
            while (m.find()) {
                try {
                    h.addHighlight(m.start(), m.end(), highlightPainter);
                } catch (BadLocationException ex) {
                   // Logger.getLogger(color.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
             Highlighter h = area1.getHighlighter();
            h.removeAllHighlights();
         //   JOptionPane.showMessageDialog(area1, "la palabra a buscar no puede ser vacia");
        }
    
    }
    
}

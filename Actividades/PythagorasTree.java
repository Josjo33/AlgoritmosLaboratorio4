package Actividades;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class PythagorasTree extends JPanel {
    private int profundidad;
    private Color[] colores = {Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW, Color.CYAN, Color.MAGENTA};

    public PythagorasTree(int profundidad) {
        this.profundidad = profundidad;
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Llamada inicial para la recursión (posición inicial: centro inferior)
        trazaArbol(g2d, 400, 700, 150, -90, profundidad);
    }

    private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel) {
        if (nivel == 0 || lado < 2) return;

        // Color basado en el nivel de recursión
        g.setColor(colores[nivel % colores.length]);

        // Calcular extremo del cuadrado actual
        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));

        // Dibujar cuadrado (como línea para simplificar)
        g.drawLine(x, y, x2, y2);

        // Llamadas recursivas para los dos nuevos cuadrados
        int nuevoLado = (int) (lado * 0.7);
        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1); // Rama izquierda
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1); // Rama derecha
    }

    public static void main(String[] args) {
        // Crear y mostrar ventanas para diferentes profundidades
        mostrarArbol(6, "Árbol de Pitágoras - 6 niveles");
        mostrarArbol(8, "Árbol de Pitágoras - 8 niveles");
        mostrarArbol(10, "Árbol de Pitágoras - 10 niveles");
    }

    private static void mostrarArbol(int profundidad, String titulo) {
        JFrame frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PythagorasTree(profundidad));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
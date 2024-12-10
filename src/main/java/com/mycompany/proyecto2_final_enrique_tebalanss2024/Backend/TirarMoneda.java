/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
/**
 *
 * @author DELL
 */
public class TirarMoneda extends JPanel {
 /* private boolean esAzul = false;
    private boolean girando = false;
    private int resultado; // 1 para Jugador, 2 para IA
    private boolean resultadoVisible = false;

    public MonedaJuego(Partida partida) {
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.WHITE);

        // Evento al hacer clic en la moneda
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!girando) {
                    lanzarMoneda(partida);
                }
            }
        });
    }

    // Lógica del lanzamiento de la moneda
    private void lanzarMoneda(Partida partida) {
        Thread hiloGiro = new Thread(() -> {
            girando = true;

            try {
                // Animación de giro
                for (int i = 0; i < 10; i++) {
                    esAzul = !esAzul; // Alternar entre azul y rojo
                    repaint();
                    Thread.sleep(100); // Esperar 100ms
                }

                // Determinar el resultado final
                Random rand = new Random();
                esAzul = rand.nextBoolean(); // Azul o Rojo
                repaint();

                // Mostrar resultado y decidir quién empieza
                if (esAzul) {
                    elegirInicio(partida); // Jugador decide
                } else {
                    JOptionPane.showMessageDialog(null, "La moneda cayó en rojo. La IA comenzará.");
                    resultado = 2; // La IA comienza
                    partida.recibirResultadoMoneda(resultado);
                    cerrarVentanaYProceder();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            girando = false;
        });
        hiloGiro.start();
    }

    // Mostrar opciones para elegir quién empieza
    private void elegirInicio(Partida partida) {
        String[] opciones = {"Jugador", "IA"};
        int seleccion = JOptionPane.showOptionDialog(null, "La moneda cayó en azul. Elige quién comienza:",
                "Resultado de Moneda", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, opciones, opciones[0]);

        resultado = (seleccion == 0) ? 1 : 2;
        partida.recibirResultadoMoneda(resultado);

        cerrarVentanaYProceder();
    }

    // Cerrar la ventana y proceder al menú de la partida
    private void cerrarVentanaYProceder() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();

        // Proceder al menú de la partida
        SwingUtilities.invokeLater(() -> {
            PartidaMenu menu = new PartidaMenu();
            menu.setTitle("MENU JUGAR PARTIDA");
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);
        });
    }

    // Dibujar la moneda
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Color de la moneda según el estado
        g.setColor(esAzul ? Color.BLUE : Color.RED);

        // Dibujar moneda
        g.fillOval(50, 50, 200, 200);
    }*/
}

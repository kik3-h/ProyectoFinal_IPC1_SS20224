/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Fronted;

import javax.swing.JOptionPane;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.Carta;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.Mazo;
import java.io.*;
import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/**
 *
 * @author DELL
 */
public class EditarMazoJugador1 extends javax.swing.JFrame {
     private Mazo mazoCargado; // Mazo actualmente cargado
    private String archivoMazo; // Nombre del archivo cargado
    
    /**
     * Creates new form EditarMazoJugador1
     */
    public EditarMazoJugador1() {
        initComponents();
    }
    public void cargarMazoXD()
    {
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cerrar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonAccionCargarMazoYaCreado = new javax.swing.JButton();
        jButtonGuardarMazoYaEditado = new javax.swing.JButton();
        jScrollPaneMostrarCartasAEditar = new javax.swing.JScrollPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelMostrarCartasDisponibles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAreaDeDatosEditar = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        cerrar.setBackground(new java.awt.Color(255, 0, 0));
        cerrar.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        cerrar.setForeground(new java.awt.Color(0, 0, 0));
        cerrar.setText("CERRAR");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        regresar.setBackground(new java.awt.Color(255, 204, 51));
        regresar.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        regresar.setForeground(new java.awt.Color(0, 0, 0));
        regresar.setText("REGRESAR");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("EDITAR MAZO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regresar)
                .addGap(237, 237, 237)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrar)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresar)
                    .addComponent(cerrar))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));

        jButtonAccionCargarMazoYaCreado.setBackground(new java.awt.Color(51, 255, 255));
        jButtonAccionCargarMazoYaCreado.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButtonAccionCargarMazoYaCreado.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAccionCargarMazoYaCreado.setText("CARGAR MAZO CREADO");
        jButtonAccionCargarMazoYaCreado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccionCargarMazoYaCreadoActionPerformed(evt);
            }
        });

        jButtonGuardarMazoYaEditado.setBackground(new java.awt.Color(51, 255, 51));
        jButtonGuardarMazoYaEditado.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButtonGuardarMazoYaEditado.setForeground(new java.awt.Color(0, 0, 0));
        jButtonGuardarMazoYaEditado.setText("GUARDAR MAZO EDITADO");
        jButtonGuardarMazoYaEditado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarMazoYaEditadoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("1. CARGA TU MAZO A EDITAR                   2. DA CLICK SOBRE ALGUNA CARTA Y ELIGE LA OPCION QUE DESEES");

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("3. LUEGO DA GUARDA TUS EDICIONES");

        jLabelMostrarCartasDisponibles.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabelMostrarCartasDisponibles.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMostrarCartasDisponibles.setText("CANTIDAD DE CARTAS DISPONIBLES:");

        jTextAreaAreaDeDatosEditar.setColumns(20);
        jTextAreaAreaDeDatosEditar.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jTextAreaAreaDeDatosEditar.setForeground(new java.awt.Color(0, 0, 0));
        jTextAreaAreaDeDatosEditar.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAreaDeDatosEditar);

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("INFORMACION DE CARTA ELEGIDA:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(110, 110, 110)
                        .addComponent(jLabelMostrarCartasDisponibles))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1))))
                .addGap(113, 113, 113))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAccionCargarMazoYaCreado)
                        .addGap(99, 99, 99)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGuardarMazoYaEditado)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPaneMostrarCartasAEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAccionCargarMazoYaCreado)
                            .addComponent(jButtonGuardarMazoYaEditado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelMostrarCartasDisponibles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneMostrarCartasAEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
     this.dispose();
     MenuJugadorVsJugador menu1 = new MenuJugadorVsJugador();
     menu1.setTitle("MENU JUGADOR");
     menu1.setLocationRelativeTo(null);
     menu1.setVisible(true);
    }//GEN-LAST:event_regresarActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el juego?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION)
            {
            this.dispose();
            System.exit(0);
            }
    }//GEN-LAST:event_cerrarActionPerformed
    
    
    private void jButtonGuardarMazoYaEditadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarMazoYaEditadoActionPerformed
     try {
            if (archivoMazo == null || mazoCargado == null) {
                JOptionPane.showMessageDialog(this, "No hay un mazo cargado para guardar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoMazo))) {
                oos.writeObject(mazoCargado);
                JOptionPane.showMessageDialog(this, "Mazo guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el mazo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
               
    }//GEN-LAST:event_jButtonGuardarMazoYaEditadoActionPerformed
    private void mostrarCartas() {
        JPanel panelCartas = new JPanel();
        panelCartas.setLayout(new GridLayout(5, 8, 10, 10)); // Configuración de la cuadrícula
        jScrollPaneMostrarCartasAEditar.setViewportView(panelCartas);
            int cantDisponibles =0; //CONTEO DE CANTIDAD DE CARTAS DISPONIBLES A ELEGIR
            // Usar un array para almacenar el conteo
             final int[] conteo = {0};
        for (int i = 0; i < mazoCargado.getCartas().obtenerTamanio(); i++) {
            
             
            Carta carta = mazoCargado.getCartas().obtenerNodo(i);
            JButton botonCarta = new JButton();
          //  Carta carta = cartaElegida
            // Configurar imagen de la carta
            try {
                URL urlImagen = getClass().getResource(carta.getRutaDeImagen());
                if (urlImagen != null) {
                    botonCarta.setIcon(new ImageIcon(urlImagen));
                }
            } catch (Exception e) {
                botonCarta.setText(carta.getNombre());
            }
            cantDisponibles++;
            int indiceCarta = i;
             // Incrementar conteo y actualizar JLabel
                conteo[0]++; // Incrementar conteo y actualizar JLabel
                jLabelMostrarCartasDisponibles.setText("CANTIDAD DE CARTAS DISPONIBLES: " + conteo[0]); //MUESTRA INFO  EN EL LABEL
            // Acción al hacer clic en la carta
            botonCarta.addActionListener((ActionEvent e) -> {
                 // Incrementar conteo y actualizar JLabel
                //conteo[0]++;
                //jTextAreaAreaDeDatosEditar.setText("HA ELEGIDO: "+mazoCargado[indiceCarta].getObtenerInfo()); //mostar la info de la carta seleccionada a editar
                jTextAreaAreaDeDatosEditar.setText("HA ELEGIDO: " + mazoCargado.getCartas().obtenerNodo(indiceCarta).getInfo());
                //solicita la opcion que elegira para hacer con su carta lo que 
                
                int opcion = JOptionPane.showOptionDialog(this, "¿Qué desea hacer con esta carta?",
                        "Opciones de edición", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, new String[]{"Eliminar", "Editar", "Duplicar", "Cancelar"}, "Cancelar");

                switch (opcion) {
                    case JOptionPane.YES_OPTION: // Eliminar
                        mazoCargado.getCartas().eliminarNodo(carta);
                        mostrarCartas();
                        JOptionPane.showMessageDialog(this, "Carta eliminada correctamente.");
                        break;

                    case JOptionPane.NO_OPTION: // Editar
                        // Editar la carta
                        String nuevoNombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre:", carta.getNombre());
                        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                            carta.setNombre(nuevoNombre);
                        }
                        JOptionPane.showMessageDialog(this, "Carta editada correctamente.");
                        mostrarCartas();
                        break;
                        
                    case 2: // Duplicar
                            String mensaje = mazoCargado.duplicarCarta(carta);
                            JOptionPane.showMessageDialog(this, mensaje);
                            mostrarCartas();
                    break;

                    default: // Cancelar
                        break;
                }
            });

            panelCartas.add(botonCarta);
        }

        panelCartas.revalidate();
        panelCartas.repaint();
    }
    
    private void jButtonAccionCargarMazoYaCreadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccionCargarMazoYaCreadoActionPerformed
        try {
            // Mostrar lista de archivos disponibles
            File carpeta = new File(".");
            File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".dat"));
            if (archivos == null || archivos.length == 0) {
                JOptionPane.showMessageDialog(this, "No hay mazos disponibles para cargar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            StringBuilder listaArchivos = new StringBuilder("Mazos disponibles:\n");
            for (File archivo : archivos) {
                listaArchivos.append(archivo.getName()).append("\n");
            }

            String seleccion = JOptionPane.showInputDialog(this, listaArchivos.toString() + "\nIngrese el nombre del mazo a cargar (sin .dat):");
            if (seleccion == null || seleccion.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cargar el archivo seleccionado
            archivoMazo = seleccion.trim() + ".dat";
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoMazo))) {
                mazoCargado = (Mazo) ois.readObject();
                mostrarCartas();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar archivos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAccionCargarMazoYaCreadoActionPerformed

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
            java.util.logging.Logger.getLogger(EditarMazoJugador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarMazoJugador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarMazoJugador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarMazoJugador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarMazoJugador1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JButton jButtonAccionCargarMazoYaCreado;
    private javax.swing.JButton jButtonGuardarMazoYaEditado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelMostrarCartasDisponibles;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneMostrarCartasAEditar;
    private javax.swing.JTextArea jTextAreaAreaDeDatosEditar;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}

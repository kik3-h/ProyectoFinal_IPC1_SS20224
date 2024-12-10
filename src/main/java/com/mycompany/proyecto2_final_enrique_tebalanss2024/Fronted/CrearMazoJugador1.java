/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Fronted;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.Carta;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.CrearCartas;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.Jugador;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.NombreJugador;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class CrearMazoJugador1 extends javax.swing.JFrame {
   private Carta carta;
   private CrearCartas crearCartasGeneral;
   private NombreJugador name;
   private Jugador jugador; //aca si funciona
   private int conteo =0; //conteo de clicks y cartas elegidas
    /**
     * Creates new form CrearMazoJugador1
     */
   
    public CrearMazoJugador1(CrearCartas crearCartas) {
        initComponents();
        this.jugador = new Jugador(" XXXX "); // Inicializa el jugador con un nombre
        this.crearCartasGeneral = crearCartas; // Asignar la instancia existente
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        GuardarMazo = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        PanelMostrar = new javax.swing.JScrollPane();
        CrearCartaNuevaAccionMenu = new javax.swing.JButton();
        EditarCartaAccion = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        AreaDeDatos = new javax.swing.JTextArea();
        verInfo = new javax.swing.JButton();
        LabelConteo = new javax.swing.JLabel();
        LabelDisponibles = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("CERRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CREA TU MAZO ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(255, 255, 255)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));

        jLabel12.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("MANO JUGADOR");

        GuardarMazo.setBackground(new java.awt.Color(51, 255, 51));
        GuardarMazo.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        GuardarMazo.setForeground(new java.awt.Color(0, 0, 0));
        GuardarMazo.setText("GUARDAR TODO");
        GuardarMazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarMazoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("INFORMACION DE CARTA ELEGIDA:");

        CrearCartaNuevaAccionMenu.setBackground(new java.awt.Color(0, 255, 0));
        CrearCartaNuevaAccionMenu.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        CrearCartaNuevaAccionMenu.setForeground(new java.awt.Color(0, 0, 0));
        CrearCartaNuevaAccionMenu.setText("CREAR CARTA");
        CrearCartaNuevaAccionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearCartaNuevaAccionMenuActionPerformed(evt);
            }
        });

        EditarCartaAccion.setBackground(new java.awt.Color(51, 255, 0));
        EditarCartaAccion.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        EditarCartaAccion.setForeground(new java.awt.Color(0, 0, 0));
        EditarCartaAccion.setText("EDITAR CARTA");
        EditarCartaAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCartaAccionActionPerformed(evt);
            }
        });

        AreaDeDatos.setColumns(20);
        AreaDeDatos.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        AreaDeDatos.setRows(5);
        jScrollPane3.setViewportView(AreaDeDatos);

        verInfo.setBackground(new java.awt.Color(0, 255, 0));
        verInfo.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        verInfo.setForeground(new java.awt.Color(0, 0, 0));
        verInfo.setText("VER INFO CARTAS");
        verInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInfoActionPerformed(evt);
            }
        });

        LabelConteo.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        LabelConteo.setForeground(new java.awt.Color(0, 0, 0));
        LabelConteo.setText("CONTEO: ");

        LabelDisponibles.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        LabelDisponibles.setForeground(new java.awt.Color(0, 0, 0));
        LabelDisponibles.setText("DISPONIBLE:");

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DA CLICK SOBRE LA CARTA QUE DESEAS ELEGIR Y CREA TU MAZO :D");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(verInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CrearCartaNuevaAccionMenu)
                        .addGap(27, 27, 27)
                        .addComponent(EditarCartaAccion)
                        .addGap(63, 63, 63)
                        .addComponent(GuardarMazo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(224, 224, 224))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(LabelConteo, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(LabelDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addComponent(PanelMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 1165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verInfo)
                    .addComponent(CrearCartaNuevaAccionMenu)
                    .addComponent(EditarCartaAccion)
                    .addComponent(GuardarMazo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LabelDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LabelConteo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(PanelMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
     MenuJugadorVsJugador menu1 = new MenuJugadorVsJugador();
     menu1.setTitle("MENU JUGADOR");
     menu1.setLocationRelativeTo(null);
     menu1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el juego?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION)
            {
            this.dispose();
            System.exit(0);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void GuardarMazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarMazoActionPerformed
        // TODO add your handling code here:
       //JOptionPane.showMessageDialog(null, "ACA SE ACTIVARIA LA FUNCION GUARDAR EL MAZO DENTRO DE LA CLASE JUGADOR \n");
     //Jugador jugador = new Jugador(); // O el constructor que uses
      
        try {
        String nombreArchivo = JOptionPane.showInputDialog(this, "Ingrese un nombre para su mazo:", "Guardar Mazo", JOptionPane.PLAIN_MESSAGE);
        if (nombreArchivo != null && !nombreArchivo.trim().isEmpty()) {
            
            jugador.guardarBaraja(nombreArchivo.trim() + ".dat");
            JOptionPane.showMessageDialog(this, " ON MAZO guardado exitosamente como: " + nombreArchivo + ".dat"+" DEL JUGADOR: ", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar el mazo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_GuardarMazoActionPerformed
// JOptionPane.showMessageDialog(null, "VER SI MUESTRA NOMBRE: "+jugador.getNombre()+"\n");
   //JOptionPane.showMessageDialog(this, "El nombre ingresado fue: " + jugador.getNombre());
    
    private void verInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInfoActionPerformed
        // TODO add your handling code here:
       // Crear un nuevo JPanel para contener los botones de las cartas
       
    JPanel panelContenido = new JPanel();
    panelContenido.setLayout(new java.awt.GridLayout(3, 6)); // Ajustar filas y columnas según las cartas muestra.

    // Crear instancia del backend
   // CrearCartas crearCartas = new CrearCartas();
   Carta[] cartasMuestra = crearCartasGeneral.getBarajaMuestras();
    //crearCartasGeneral.inicializarCartasMuestras();
    crearCartasGeneral.imprimirCartasConsolaBaraja(); // Verificar en consola
  //  Carta[] cartasMuestra = crearCartasGeneral.getCartasMuestra(); // Obtenemos el arreglo de cartas
   // Obtener las cartas muestra desde la instancia compartida
  //  Carta[] cartasMuestra = crearCartas.getCartasMuestra();
   
    // Verificar si hay cartas muestra
    if (cartasMuestra == null || cartasMuestra.length == 0) {
        JOptionPane.showMessageDialog(this, "No hay cartas disponibles para mostrar XD.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }
   int cantDisponibles =0; //CONTEO DE CANTIDAD DE CARTAS DISPONIBLES A ELEGIR
   // Usar un array para almacenar el conteo
    final int[] conteo = {0};
    // Crear botones con imágenes y acciones
    for (int i = 0; i < cartasMuestra.length; i++) {
        
        Carta carta = cartasMuestra[i];
        JButton boton = new JButton();

        // Intentar cargar la imagen desde la ruta definida en la carta
        try {
            URL urlImagen = getClass().getResource(carta.getRutaDeImagen());
            if (urlImagen != null) {
                boton.setIcon(new ImageIcon(urlImagen));
            } else {
                System.err.println("No se encontró la imagen en: " + carta.getRutaDeImagen());
            }
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + e.getMessage());
        }
           cantDisponibles++;
        // Agregar un ActionListener para cada botón
        int indiceCarta = i;
        boton.addActionListener(evt1 -> {
             // Incrementar conteo y actualizar JLabel
            conteo[0]++;
            LabelConteo.setText("CANTIDAD DE CARTAS ELEGIDAS: " + conteo[0]);
            // Mostrar la información de la carta seleccionada
            AreaDeDatos.setText("HA ELEGIDO: "+cartasMuestra[indiceCarta].getInfo());
            // Agregar la carta seleccionada a la lista del jugador
            Carta cartaSeleccionada = cartasMuestra[indiceCarta];
           // JOptionPane.showMessageDialog(this, "El nombre ingresado fue: " + name.getNombre());
            jugador.agregarCarta(cartaSeleccionada); 
        });
        

        // Agregar el botón al panel
        panelContenido.add(boton);
       // LabelConteo.setText(" :"+conteo);
       // Incrementar el conteo y actualizar el JLabel
            //conteo++;
           LabelDisponibles.setText("CANTIDAD DE CARTAS DISPONIBLES: " + cantDisponibles);
    }

    // Configurar el JScrollPane con el panel contenido
    PanelMostrar.setViewportView(panelContenido);

    // Actualizar la interfaz gráfica
    PanelMostrar.revalidate();
    PanelMostrar.repaint();        
    }//GEN-LAST:event_verInfoActionPerformed

    private void CrearCartaNuevaAccionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearCartaNuevaAccionMenuActionPerformed
        
     //this.dispose();
     CrearNuevaCarta menu1 = new CrearNuevaCarta(crearCartasGeneral); // Reutiliza la misma instancia
     //CrearNuevaCarta menu1 = new CrearNuevaCarta(crearCartasGeneral);
     menu1.setTitle("MENU CREAR NUEVA CARTA");
     menu1.setLocationRelativeTo(null);
     menu1.setVisible(true);
     
    }//GEN-LAST:event_CrearCartaNuevaAccionMenuActionPerformed

    private void EditarCartaAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarCartaAccionActionPerformed
        // TODO add your handling code here:
        EditarCarta menuEditar = new EditarCarta(crearCartasGeneral);// Reutiliza la misma instancia
        menuEditar.setTitle("MENU CREAR NUEVA CARTA");
        menuEditar.setLocationRelativeTo(null);
        menuEditar.setVisible(true);
    }//GEN-LAST:event_EditarCartaAccionActionPerformed
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaDeDatos;
    private javax.swing.JButton CrearCartaNuevaAccionMenu;
    private javax.swing.JButton EditarCartaAccion;
    private javax.swing.JButton GuardarMazo;
    private javax.swing.JLabel LabelConteo;
    private javax.swing.JLabel LabelDisponibles;
    private javax.swing.JScrollPane PanelMostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton verInfo;
    // End of variables declaration//GEN-END:variables
}

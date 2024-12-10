/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Fronted;

import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.Carta;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.CartaEnergias;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.CartaHechizos;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.CartaMounstruo;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.CrearCartas;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.TipoElemento;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class CrearNuevaCarta extends javax.swing.JFrame {
    private Carta carta;
    private CrearCartas crearCartas; //baraja de creacion de cartas desde el codigo en la clase
    /**
     * Creates new form CrearNuevaCarta
     */
    public CrearNuevaCarta(CrearCartas crearCartas) {
        initComponents();
        this.crearCartas= crearCartas;
        inicializarComboBoxes();
        
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
        AccionCerrar = new javax.swing.JButton();
        AccionRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboTiposDeCarta = new javax.swing.JComboBox<>();
        TextFieldNombreNuevaCarta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2PuntosVida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ComboTiposDeFase = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField3RutaDeImagen = new javax.swing.JTextField();
        AccionGuardarCartaNueva = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField4EfectoCarta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField1DescripcionCarta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        AccionCerrar.setBackground(new java.awt.Color(255, 0, 0));
        AccionCerrar.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        AccionCerrar.setForeground(new java.awt.Color(0, 0, 0));
        AccionCerrar.setText("CERRAR");
        AccionCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccionCerrarActionPerformed(evt);
            }
        });

        AccionRegresar.setBackground(new java.awt.Color(255, 204, 0));
        AccionRegresar.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        AccionRegresar.setForeground(new java.awt.Color(0, 0, 0));
        AccionRegresar.setText("REGRESAR");
        AccionRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccionRegresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CREAR NUEVA CARTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AccionRegresar)
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(AccionCerrar)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AccionCerrar)
                    .addComponent(AccionRegresar))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOMBRE DE LA CARTA NUEVA:");

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("TIPO DE CARTA:");

        ComboTiposDeCarta.setBackground(new java.awt.Color(0, 255, 255));
        ComboTiposDeCarta.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        ComboTiposDeCarta.setForeground(new java.awt.Color(0, 0, 0));
        ComboTiposDeCarta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboTiposDeCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTiposDeCartaActionPerformed(evt);
            }
        });

        TextFieldNombreNuevaCarta.setBackground(new java.awt.Color(0, 255, 255));
        TextFieldNombreNuevaCarta.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        TextFieldNombreNuevaCarta.setForeground(new java.awt.Color(0, 0, 0));
        TextFieldNombreNuevaCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldNombreNuevaCartaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("PUNTOS DE VIDA:");

        jTextField2PuntosVida.setBackground(new java.awt.Color(0, 255, 255));
        jTextField2PuntosVida.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jTextField2PuntosVida.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2PuntosVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2PuntosVidaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("TIPO DE FASE");

        ComboTiposDeFase.setBackground(new java.awt.Color(0, 255, 255));
        ComboTiposDeFase.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        ComboTiposDeFase.setForeground(new java.awt.Color(0, 0, 0));
        ComboTiposDeFase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboTiposDeFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTiposDeFaseActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("RUTA DE IMAGEN (URL):");

        jTextField3RutaDeImagen.setBackground(new java.awt.Color(0, 255, 255));
        jTextField3RutaDeImagen.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jTextField3RutaDeImagen.setForeground(new java.awt.Color(0, 0, 0));
        jTextField3RutaDeImagen.setText("Ej: /imagenes2/10.png");
        jTextField3RutaDeImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3RutaDeImagenActionPerformed(evt);
            }
        });

        AccionGuardarCartaNueva.setBackground(new java.awt.Color(0, 255, 0));
        AccionGuardarCartaNueva.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        AccionGuardarCartaNueva.setForeground(new java.awt.Color(0, 0, 0));
        AccionGuardarCartaNueva.setText("GUARDAR CARTA");
        AccionGuardarCartaNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccionGuardarCartaNuevaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("EFECTO DE LA CARTA:");

        jTextField4EfectoCarta.setBackground(new java.awt.Color(0, 255, 255));
        jTextField4EfectoCarta.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jTextField4EfectoCarta.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4EfectoCarta.setText("INGRESE EL EFECTO");
        jTextField4EfectoCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4EfectoCartaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("DESCRIPCION DE LA CARTA:");

        jTextField1DescripcionCarta.setBackground(new java.awt.Color(0, 255, 255));
        jTextField1DescripcionCarta.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jTextField1DescripcionCarta.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1DescripcionCarta.setText("INGRESE DESCRIPCION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ComboTiposDeCarta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextFieldNombreNuevaCarta)
                                .addComponent(ComboTiposDeFase, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField3RutaDeImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addComponent(jTextField4EfectoCarta))
                            .addComponent(jTextField1DescripcionCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField2PuntosVida, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(AccionGuardarCartaNueva)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextFieldNombreNuevaCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboTiposDeCarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ComboTiposDeFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3RutaDeImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4EfectoCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1DescripcionCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(AccionGuardarCartaNueva)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2PuntosVida, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicializarComboBoxes() {
        // Limpiar los elementos existentes
        ComboTiposDeCarta.removeAllItems();
        ComboTiposDeFase.removeAllItems();

        // Agregar los valores de TipoElemento al jComboBox1
        // LOS TIPOS DISPONIBLES SON FUEGO, AGUA, TIERRA, AIRE, NORMAL, ENTRENADOR,PLANTA,ENERGIA,HECHIZO,MOUNSTRUO; 
        for (TipoElemento tipo : TipoElemento.values()) {
            ComboTiposDeCarta.addItem(tipo.name());
        }

        // Agregar las opciones de evolución al jComboBox2
         ComboTiposDeFase.addItem("BASICO");
         ComboTiposDeFase.addItem("EVOLUCION 1");
         ComboTiposDeFase.addItem("EVOLUCION 2");
         ComboTiposDeFase.addItem("MEGAEVOLUCION");
    }
    private void ComboTiposDeCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTiposDeCartaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboTiposDeCartaActionPerformed

    private void AccionRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccionRegresarActionPerformed
        // TODO add your handling code here:
       this.dispose();/*
     CrearMazoJugador1 menu1 = new CrearMazoJugador1(crearCartasGeneral);
     menu1.setTitle("MENU CREAR MAZO");
     menu1.setLocationRelativeTo(null);
     menu1.setVisible(true);*/
    }//GEN-LAST:event_AccionRegresarActionPerformed

    private void AccionCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccionCerrarActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea cerrar este frame?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION)
            {
            this.dispose();
            }
    }//GEN-LAST:event_AccionCerrarActionPerformed

    private void ComboTiposDeFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTiposDeFaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboTiposDeFaseActionPerformed

    private void jTextField3RutaDeImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3RutaDeImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3RutaDeImagenActionPerformed

    private void TextFieldNombreNuevaCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldNombreNuevaCartaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldNombreNuevaCartaActionPerformed

    private void jTextField4EfectoCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4EfectoCartaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4EfectoCartaActionPerformed

    private void AccionGuardarCartaNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccionGuardarCartaNuevaActionPerformed
        // TODO add your handling code here:
        if (crearCartas== null) {
        JOptionPane.showMessageDialog(this, "Error XD: El backend no está inicializado.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        try {
        // Obtener datos comunes
        String nombre = TextFieldNombreNuevaCarta.getText();
        TipoElemento tipo = TipoElemento.valueOf((String) ComboTiposDeCarta.getSelectedItem());
        String rutaImagen = jTextField3RutaDeImagen.getText();
        String efecto = jTextField4EfectoCarta.getText();
        String descripcion = jTextField1DescripcionCarta.getText();
        int idCarta = crearCartas.getCartasMuestra().length + 1; // Generar ID único

        Carta nuevaCarta = null;

        // Determinar el tipo de carta y pedir atributos específicos
        if (tipo == TipoElemento.FUEGO || tipo == TipoElemento.AGUA || tipo == TipoElemento.TIERRA || 
            tipo == TipoElemento.AIRE || tipo == TipoElemento.NORMAL || tipo == TipoElemento.PLANTA) {

            // Atributos específicos para cartas de tipo Monstruo
            int puntosVida = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese los puntos de vida de la carta:", "Puntos de Vida", JOptionPane.PLAIN_MESSAGE));
            int ataque = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantidad de daño el ataque:", "Ataque", JOptionPane.PLAIN_MESSAGE));

            String fase = (String) ComboTiposDeFase.getSelectedItem(); // BASICO, EVOLUCION, etc.
            nuevaCarta = new CartaMounstruo(idCarta, nombre, fase, tipo, rutaImagen, puntosVida, ataque, efecto, descripcion);

        } else if (tipo == TipoElemento.ENTRENADOR || tipo == TipoElemento.ENERGIA) {

            // Atributos específicos para cartas de Energía
            nuevaCarta = new CartaEnergias(idCarta, nombre, tipo, rutaImagen, efecto, descripcion);

        } else if (tipo == TipoElemento.HECHIZO) {

            // Atributos específicos para cartas de Hechizo
            int poderHechizo = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el poder del hechizo:", "Poder del Hechizo", JOptionPane.PLAIN_MESSAGE));
            nuevaCarta = new CartaHechizos(idCarta, nombre, tipo, rutaImagen, efecto, poderHechizo, descripcion);
        }
        
        // Agregar la nueva carta al backend
        crearCartas.crearNuevaCarta(nuevaCarta);

        // Confirmación
        JOptionPane.showMessageDialog(this, "Carta creada exitosamente: " + nuevaCarta.getNombre(), "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar los campos del formulario
        limpiarFormulario();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Verifica que los campos numéricos tengan valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al crear la carta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AccionGuardarCartaNuevaActionPerformed

    private void jTextField2PuntosVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2PuntosVidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2PuntosVidaActionPerformed

        // Método para limpiar el formulario después de guardar una carta
    private void limpiarFormulario() {
        TextFieldNombreNuevaCarta.setText("");
    jTextField3RutaDeImagen.setText("");
    jTextField4EfectoCarta.setText("");
    ComboTiposDeCarta.setSelectedIndex(0);
    ComboTiposDeFase.setSelectedIndex(0);
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccionCerrar;
    private javax.swing.JButton AccionGuardarCartaNueva;
    private javax.swing.JButton AccionRegresar;
    private javax.swing.JComboBox<String> ComboTiposDeCarta;
    private javax.swing.JComboBox<String> ComboTiposDeFase;
    private javax.swing.JTextField TextFieldNombreNuevaCarta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1DescripcionCarta;
    private javax.swing.JTextField jTextField2PuntosVida;
    private javax.swing.JTextField jTextField3RutaDeImagen;
    private javax.swing.JTextField jTextField4EfectoCarta;
    // End of variables declaration//GEN-END:variables
}
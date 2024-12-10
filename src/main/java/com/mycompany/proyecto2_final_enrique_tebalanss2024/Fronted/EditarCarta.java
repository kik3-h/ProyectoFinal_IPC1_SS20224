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
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class EditarCarta extends javax.swing.JFrame {
    private CrearCartas crearCartasGeneral;
    private Carta cartaSeleccionada; // Carta actualmente seleccionada
    private int indiceSeleccionado; // Índice de la carta seleccionada
    /**
     * Creates new form EditarCarta
     */
    public EditarCarta(CrearCartas crearCartas) {
        this.crearCartasGeneral= crearCartas;
        initComponents();
         mostrarCartasEnScrollPane();
    }

    private void mostrarCartasEnScrollPane() {
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new java.awt.GridLayout(3, 6)); // Configurar filas y columnas según el total de cartas

       // Carta[] cartasMuestra = crearCartasGeneral.getCartasMuestra();
        Carta[] cartasMuestra = crearCartasGeneral.getCartasMuestra();
        
        if (cartasMuestra == null || cartasMuestra.length == 0) {
            JOptionPane.showMessageDialog(this, "No hay cartas disponibles para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (int i = 0; i < cartasMuestra.length; i++) {
            Carta carta = cartasMuestra[i];
            JButton boton = new JButton();

            // Configurar la imagen del botón
            try {
                URL urlImagen = getClass().getResource(carta.getRutaDeImagen());
                if (urlImagen != null) {
                    boton.setIcon(new ImageIcon(urlImagen));
                }
            } catch (Exception e) {
                System.err.println("Error al cargar la imagen: " + e.getMessage());
            }

            int indice = i; // Guardar índice de la carta actual
            boton.addActionListener(evt -> {
                cartaSeleccionada = carta;
                indiceSeleccionado = indice;
                mostrarInformacionCarta();
            });

            panelContenido.add(boton);
        }

        jScrollPaneMostrarCartas.setViewportView(panelContenido);
        jScrollPaneMostrarCartas.revalidate();
        jScrollPaneMostrarCartas.repaint();
    }
    private void mostrarInformacionCarta() {
    if (cartaSeleccionada == null) return;

    // Mostrar atributos comunes
    jLabelIdCarta.setText(String.valueOf(cartaSeleccionada.getId())); //el valuof convierte el int a string
    jLabelNombreOriginal.setText(cartaSeleccionada.getNombre());
    jLabelTipoDeCartaOriginal.setText(cartaSeleccionada.getTipo().name());
    jLabelRutaDeImagenOriginal.setText(cartaSeleccionada.getRutaDeImagen());
    jLabelDescripcionOriginal.setText(cartaSeleccionada.getDescripcion());

    // Mostrar atributos específicos según el tipo de carta
    if (cartaSeleccionada instanceof CartaMounstruo) {
        CartaMounstruo cartaMounstruo = (CartaMounstruo) cartaSeleccionada;
        jLabelPuntosDeVidaOriginal.setText(String.valueOf(cartaMounstruo.getPuntosVida()));
        jLabelPuntosDeAtaqueOriginal.setText(String.valueOf(cartaMounstruo.getAtaque()));
        jLabelTipoDeFaseOriginal.setText(cartaMounstruo.getFase());
    } else if (cartaSeleccionada instanceof CartaHechizos) {
        CartaHechizos cartaHechizo = (CartaHechizos) cartaSeleccionada;
        jLabel1PoderDeHechizoOriginal.setText(String.valueOf(cartaHechizo.getEfectoCuracion()));
    }
    inicializarComboBoxes();
  }
    private void inicializarComboBoxes() {
    // Limpiar los elementos existentes
    jComboBox1NuevoTipoDeCarta.removeAllItems();
    jComboBox2NuevoTipoDeFase.removeAllItems();

    // Agregar los valores de TipoElemento al jComboBox1
    for (TipoElemento tipo : TipoElemento.values()) {
        jComboBox1NuevoTipoDeCarta.addItem(tipo.name());
    }

    // Agregar las opciones de evolución al jComboBox2
    jComboBox2NuevoTipoDeFase.addItem("BASICO");
    jComboBox2NuevoTipoDeFase.addItem("EVOLUCION 1");
    jComboBox2NuevoTipoDeFase.addItem("EVOLUCION 2");
    jComboBox2NuevoTipoDeFase.addItem("MEGAEVOLUCION");
    }
    
    private void limpiarFormulario() {
        jTextFieldNombreNuevo.setText("");
        jTextField4NuevaRutaDeImagen.setText("");
       // jTextField4EfectoCarta.setText("");
        NuevaDescripcion.setText("");
        jComboBox1NuevoTipoDeCarta.setSelectedIndex(0);
        jComboBox2NuevoTipoDeFase.setSelectedIndex(0);
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
        jButtonAccionRegresar = new javax.swing.JButton();
        jButtonAccionCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPaneMostrarCartas = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDeDatosCartaElegida = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelNombreOriginal = new javax.swing.JLabel();
        jLabelTipoDeCartaOriginal = new javax.swing.JLabel();
        jLabelTipoDeFaseOriginal = new javax.swing.JLabel();
        jLabelRutaDeImagenOriginal = new javax.swing.JLabel();
        jLabelDescripcionOriginal = new javax.swing.JLabel();
        jLabelPuntosDeVidaOriginal = new javax.swing.JLabel();
        jLabelPuntosDeAtaqueOriginal = new javax.swing.JLabel();
        jLabel1PoderDeHechizoOriginal = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldNombreNuevo = new javax.swing.JTextField();
        jTextField4NuevaRutaDeImagen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1NuevoTipoDeCarta = new javax.swing.JComboBox<>();
        jComboBox2NuevoTipoDeFase = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        NuevaDescripcion = new javax.swing.JTextField();
        AccionGuardarCartaEditada = new javax.swing.JButton();
        jLabelIdCarta = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jButtonAccionRegresar.setBackground(new java.awt.Color(0, 255, 0));
        jButtonAccionRegresar.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButtonAccionRegresar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAccionRegresar.setText("REGRESAR");
        jButtonAccionRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccionRegresarActionPerformed(evt);
            }
        });

        jButtonAccionCerrar.setBackground(new java.awt.Color(255, 0, 0));
        jButtonAccionCerrar.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButtonAccionCerrar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAccionCerrar.setText("CERRAR");
        jButtonAccionCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccionCerrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("EDITAR CARTAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAccionRegresar)
                .addGap(207, 207, 207)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAccionCerrar)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAccionRegresar)
                    .addComponent(jButtonAccionCerrar)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));

        jTextAreaDeDatosCartaElegida.setColumns(20);
        jTextAreaDeDatosCartaElegida.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDeDatosCartaElegida);

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("VER INFO DE CARTA A EDITAR:");

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DA CLICK SOBRE LA CARTA QUE DESEAS EDITAR:");

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DATOS ORIGINALES:");

        jLabelNombreOriginal.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabelNombreOriginal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNombreOriginal.setText("NOMBRE:");

        jLabelTipoDeCartaOriginal.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabelTipoDeCartaOriginal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTipoDeCartaOriginal.setText("TIPO DE CARTA:");

        jLabelTipoDeFaseOriginal.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabelTipoDeFaseOriginal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTipoDeFaseOriginal.setText("TIPO DE FASE:");

        jLabelRutaDeImagenOriginal.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabelRutaDeImagenOriginal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelRutaDeImagenOriginal.setText("RUTA DE IMAGEN:");

        jLabelDescripcionOriginal.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabelDescripcionOriginal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDescripcionOriginal.setText("DESCRIPCION DE LA CARTA:");

        jLabelPuntosDeVidaOriginal.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabelPuntosDeVidaOriginal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPuntosDeVidaOriginal.setText("PUNTOS DE VIDA:");

        jLabelPuntosDeAtaqueOriginal.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabelPuntosDeAtaqueOriginal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPuntosDeAtaqueOriginal.setText("PUNTOS DE ATAQUE:");

        jLabel1PoderDeHechizoOriginal.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel1PoderDeHechizoOriginal.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1PoderDeHechizoOriginal.setText("PODER HECHIZO");

        jLabel13.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("INGRESE DATOS NUEVOS:");

        jTextFieldNombreNuevo.setBackground(new java.awt.Color(0, 255, 255));
        jTextFieldNombreNuevo.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jTextFieldNombreNuevo.setForeground(new java.awt.Color(0, 0, 0));

        jTextField4NuevaRutaDeImagen.setBackground(new java.awt.Color(0, 255, 255));
        jTextField4NuevaRutaDeImagen.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jTextField4NuevaRutaDeImagen.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4NuevaRutaDeImagen.setText("EJ: /imagenes2/15.png");

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("NOMBRE NUEVO:");

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("TIPO DE CARTA:");

        jLabel7.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("TIPO DE FASE");

        jLabel8.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("RUTA DE IMAGEN:");

        jComboBox1NuevoTipoDeCarta.setBackground(new java.awt.Color(0, 255, 255));
        jComboBox1NuevoTipoDeCarta.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jComboBox1NuevoTipoDeCarta.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1NuevoTipoDeCarta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2NuevoTipoDeFase.setBackground(new java.awt.Color(0, 255, 255));
        jComboBox2NuevoTipoDeFase.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jComboBox2NuevoTipoDeFase.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox2NuevoTipoDeFase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("NUEVA DESCRIPCION:");

        NuevaDescripcion.setBackground(new java.awt.Color(0, 255, 255));
        NuevaDescripcion.setForeground(new java.awt.Color(0, 0, 0));

        AccionGuardarCartaEditada.setBackground(new java.awt.Color(51, 255, 0));
        AccionGuardarCartaEditada.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        AccionGuardarCartaEditada.setForeground(new java.awt.Color(0, 0, 0));
        AccionGuardarCartaEditada.setText("GUARDAR CARTA EDITADA");
        AccionGuardarCartaEditada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccionGuardarCartaEditadaActionPerformed(evt);
            }
        });

        jLabelIdCarta.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabelIdCarta.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdCarta.setText("ID CARTA:");

        jLabel10.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("ID CARTA:");

        jLabel11.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("NOMBRE:");

        jLabel12.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("TIPO:");

        jLabel14.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("FASE:");

        jLabel15.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("RUTA:");

        jLabel16.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("DESCRIPCION:");

        jLabel17.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("PUNTOS VIDA:");

        jLabel18.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("PUNTOS ATAQUE:");

        jLabel19.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("PODER HECHIZO:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(188, 188, 188))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(140, 140, 140))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPaneMostrarCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelPuntosDeAtaqueOriginal)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelNombreOriginal)
                                            .addComponent(jLabelTipoDeCartaOriginal)
                                            .addComponent(jLabelTipoDeFaseOriginal)
                                            .addComponent(jLabelRutaDeImagenOriginal)
                                            .addComponent(jLabelIdCarta))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(34, 34, 34))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabelPuntosDeVidaOriginal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addGap(43, 43, 43)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNombreNuevo)
                                    .addComponent(jTextField4NuevaRutaDeImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addComponent(jComboBox1NuevoTipoDeCarta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2NuevoTipoDeFase, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NuevaDescripcion))
                                .addGap(166, 166, 166))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1PoderDeHechizoOriginal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AccionGuardarCartaEditada)
                                .addGap(196, 196, 196))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDescripcionOriginal)
                        .addGap(737, 737, 737)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneMostrarCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIdCarta)
                            .addComponent(jLabel10))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombreOriginal)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTipoDeCartaOriginal)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldNombreNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox1NuevoTipoDeCarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTipoDeFaseOriginal)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jComboBox2NuevoTipoDeFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRutaDeImagenOriginal)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField4NuevaRutaDeImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescripcionOriginal)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPuntosDeVidaOriginal)
                            .addComponent(NuevaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPuntosDeAtaqueOriginal)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1PoderDeHechizoOriginal)
                            .addComponent(jLabel19)))
                    .addComponent(AccionGuardarCartaEditada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
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

    private void AccionGuardarCartaEditadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccionGuardarCartaEditadaActionPerformed
        // TODO add your handling code here:
        if (cartaSeleccionada == null) {
        JOptionPane.showMessageDialog(this, "No hay carta seleccionada para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Obtener los nuevos valores ingresados por el usuario
        String nuevoNombre = jTextFieldNombreNuevo.getText();
        String nuevaRutaImagen = jTextField4NuevaRutaDeImagen.getText();
        String nuevaDescripcion = NuevaDescripcion.getText();

        // Validar valores y aplicar cambios
        cartaSeleccionada.setNombre(nuevoNombre.isEmpty() ? cartaSeleccionada.getNombre() : nuevoNombre);
        cartaSeleccionada.setRutaDeImagen(nuevaRutaImagen.isEmpty() ? cartaSeleccionada.getRutaDeImagen() : nuevaRutaImagen);
        cartaSeleccionada.setDescripcion(nuevaDescripcion.isEmpty() ? cartaSeleccionada.getDescripcion() : nuevaDescripcion);
        //aca en esto si se guardan los nuevos atributos en la carta elegida? 
       // Carta cartaSeleccionada = null;

        if (cartaSeleccionada instanceof CartaMounstruo) {
            CartaMounstruo cartaMounstruo = (CartaMounstruo) cartaSeleccionada;
            int nuevoPuntosVida = Integer.parseInt(JOptionPane.showInputDialog(this, 
                "Ingrese los puntos de vida de la carta:", cartaMounstruo.getPuntosVida()));
            int nuevoAtaque = Integer.parseInt(JOptionPane.showInputDialog(this, 
                "Ingrese la cantidad de daño del ataque:", cartaMounstruo.getAtaque()));
            String nuevaFase = (String) jComboBox2NuevoTipoDeFase.getSelectedItem();
            
            cartaMounstruo.setPuntosVida(nuevoPuntosVida);
            cartaMounstruo.setAtaque(nuevoAtaque);
            cartaMounstruo.setFase(nuevaFase);
           // cartaMounstruo.setPuntosVida(nuevoPuntosVida.isEmpty()? cartaMounstruo.getPuntosVida() : nuevoPuntosVida);
            //cartaMounstruo.setPuntosVida((int) Double.parseDouble(puntosVidaE)); esto seme ocurre para mandar el valor que ingrese en el joption pane
          /*  cartaMounstruo.setPuntosVida((int) Double.parseDouble(jLabelPuntosDeVidaOriginal.getText()));
            cartaMounstruo.setAtaque(Integer.parseInt(jLabelPuntosDeAtaqueOriginal.getText()));
            cartaMounstruo.setFase((String) jComboBox2NuevoTipoDeFase.getSelectedItem());*/
        } else if (cartaSeleccionada instanceof CartaHechizos) {
            CartaHechizos cartaHechizo = (CartaHechizos) cartaSeleccionada;

            // Solicitar atributos específicos para cartas de tipo hechizo
            int poderHechizo = Integer.parseInt(JOptionPane.showInputDialog(this, 
                "Ingrese el nuevo poder del hechizo:", cartaHechizo.getEfectoCuracion()));
            // Actualizar atributos específicos
            cartaHechizo.setEfectoCuracion(poderHechizo);
        }else if (cartaSeleccionada instanceof CartaEnergias) {
            CartaEnergias cartaEnergia = (CartaEnergias) cartaSeleccionada;

            // Solicitar atributos específicos para cartas de tipo energía
            String nuevoEfecto = JOptionPane.showInputDialog(this, 
                "Ingrese el nuevo efecto de la carta:", cartaEnergia.getTipoEfecto());
            // Actualizar atributos específicos
            cartaEnergia.setTipoEfecto(nuevoEfecto.isEmpty() ? cartaEnergia.getTipoEfecto() : nuevoEfecto);
        }
        // Reemplazar la carta en la lista enlazada
        crearCartasGeneral.reemplazarCarta(indiceSeleccionado, cartaSeleccionada);

        JOptionPane.showMessageDialog(this, "Carta editada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        this.dispose(); // Cerrar el frame de edición
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: Verifica que los campos numéricos sean válidos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    limpiarFormulario();
    }//GEN-LAST:event_AccionGuardarCartaEditadaActionPerformed

    private void jButtonAccionRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccionRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonAccionRegresarActionPerformed

    private void jButtonAccionCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccionCerrarActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea cerrar este frame?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION)
            {
            this.dispose();
            }
    }//GEN-LAST:event_jButtonAccionCerrarActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccionGuardarCartaEditada;
    private javax.swing.JTextField NuevaDescripcion;
    private javax.swing.JButton jButtonAccionCerrar;
    private javax.swing.JButton jButtonAccionRegresar;
    private javax.swing.JComboBox<String> jComboBox1NuevoTipoDeCarta;
    private javax.swing.JComboBox<String> jComboBox2NuevoTipoDeFase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel1PoderDeHechizoOriginal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDescripcionOriginal;
    private javax.swing.JLabel jLabelIdCarta;
    private javax.swing.JLabel jLabelNombreOriginal;
    private javax.swing.JLabel jLabelPuntosDeAtaqueOriginal;
    private javax.swing.JLabel jLabelPuntosDeVidaOriginal;
    private javax.swing.JLabel jLabelRutaDeImagenOriginal;
    private javax.swing.JLabel jLabelTipoDeCartaOriginal;
    private javax.swing.JLabel jLabelTipoDeFaseOriginal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneMostrarCartas;
    private javax.swing.JTextArea jTextAreaDeDatosCartaElegida;
    private javax.swing.JTextField jTextField4NuevaRutaDeImagen;
    private javax.swing.JTextField jTextFieldNombreNuevo;
    // End of variables declaration//GEN-END:variables
}

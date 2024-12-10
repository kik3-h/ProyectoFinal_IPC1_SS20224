/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Fronted;

import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.Carta;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.CrearCartas;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.ListaEnlazada;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.Mazo;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.TipoElemento;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class MenuPrepararPartida extends javax.swing.JFrame {
        private Mazo mazoCargado;
        private Mazo mazoIA;
        private JPanel panelBanca;
        private JPanel panelMano;
        private JPanel panelPremio;
        private JPanel panelPila;
        private int conteoMano = 0;
        private int conteoBanca = 0;
        private int conteoPremio = 0;
        private boolean cartaActivaSeleccionada = false;
    /**
     * Creates new form MenuPrepararPartida
     */
    public MenuPrepararPartida() {
        initComponents();
        // Inicialización de paneles
        panelBanca = new JPanel(new GridLayout(1, 4, 10, 10));
        panelMano = new JPanel(new GridLayout(1, 7, 10, 10));
        panelPremio = new JPanel(new GridLayout(1, 3, 10, 10));
        panelPila = new JPanel(new GridLayout(5, 8, 10, 10));

        // Asignar los paneles a los JScrollPane correspondientes
        jScrollPane1CartasBancaJugador.setViewportView(panelBanca);
        jScrollPane4CartasManoJugador.setViewportView(panelMano);
        jScrollPaneCartasPremioJugador.setViewportView(panelPremio);
        jScrollPaneCartasPila.setViewportView(panelPila);         //apaneles dinamicos y  no perder el progreso
    }
  
    private void cargarMazo() {
        try {
            // Mostrar archivos .dat disponibles
            File carpeta = new File(".");
            File[] archivosDat = carpeta.listFiles((dir, name) -> name.endsWith(".dat"));

            if (archivosDat == null || archivosDat.length == 0) {
                JOptionPane.showMessageDialog(this, "No hay mazos disponibles para cargar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] opciones = Arrays.stream(archivosDat).map(File::getName).toArray(String[]::new);
            String archivoSeleccionado = (String) JOptionPane.showInputDialog(this, "Seleccione un mazo:",
                    "Cargar Mazo", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            if (archivoSeleccionado != null) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSeleccionado))) {
                    mazoCargado = (Mazo) ois.readObject();
                    dividirCartasPorTipo(mazoCargado);
                   
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el mazo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void prepararCartasIA() { //metodo para que la IA elija sus cartas 
    // Usar las cartas por defecto de CrearCartas
    CrearCartas crearCartas = new CrearCartas(); // Inicializar cartas por defecto
    ListaEnlazada cartasDisponiblesIA = crearCartas.obtenerCartasMuestras(); // Cartas por defecto

    // Crear el mazo para la IA
    mazoIA = new Mazo("Mazo IA");

    Random random = new Random();
    JPanel panelBancaIA = new JPanel(new GridLayout(1, 4, 10, 10));
    JPanel panelPremioIA = new JPanel(new GridLayout(1, 3, 10, 10));
    JPanel panelManoIA = new JPanel(new GridLayout(1, 7, 10, 10));

    jScrollPaneCartasEnBancaIA.setViewportView(panelBancaIA);
   // jScrollPaneCartasPremioIA.setViewportView(panelPremioIA);
    jScrollPaneCartasEnManoIA.setViewportView(panelManoIA);

    // 1. Seleccionar 4 cartas para la banca
    for (int i = 0; i < 4; i++) {
        if (cartasDisponiblesIA.obtenerTamanio() == 0) break;

        int indiceAleatorio = random.nextInt(cartasDisponiblesIA.obtenerTamanio());
        Carta carta = cartasDisponiblesIA.obtenerNodo(indiceAleatorio);
        cartasDisponiblesIA.eliminarNodo(carta); // Eliminar de la lista para evitar duplicados

        mazoIA.getCartas().agregarCarta(carta); // Agregar al mazo de la IA
        JButton botonCarta = crearBotonCartaIA(carta);
        botonCarta.addActionListener(e -> mostrarCartaEnArea(carta));
        panelBancaIA.add(botonCarta);
    }

    // 2. Seleccionar 3 cartas premio
    for (int i = 0; i < 3; i++) {
        if (cartasDisponiblesIA.obtenerTamanio() == 0) break;

        int indiceAleatorio = random.nextInt(cartasDisponiblesIA.obtenerTamanio());
        Carta carta = cartasDisponiblesIA.obtenerNodo(indiceAleatorio);
        cartasDisponiblesIA.eliminarNodo(carta);

        mazoIA.getCartas().agregarCarta(carta);
        JButton botonCarta = crearBotonCartaIA(carta);
        botonCarta.addActionListener(e -> mostrarCartaEnArea(carta));
        panelPremioIA.add(botonCarta);
    }

    // 3. Seleccionar 1 carta activa
    if (cartasDisponiblesIA.obtenerTamanio() > 0) {
        Carta cartaActiva = cartasDisponiblesIA.obtenerNodo(0);
        cartasDisponiblesIA.eliminarNodo(cartaActiva); //ojo a eso que borra

        mazoIA.getCartas().agregarCarta(cartaActiva);
        jLabelCartaActivaIA.setText(cartaActiva.getNombre());
        try {
            URL urlImagen = getClass().getResource(cartaActiva.getRutaDeImagen());
            if (urlImagen != null) {
                jLabelCartaActivaIA.setIcon(new ImageIcon(urlImagen));
            }
        } catch (Exception e) {
            System.err.println("Error al cargar imagen de carta activa IA: " + e.getMessage());
        }
    }

    // 4. El resto de las cartas se agregan a la mano
    while (cartasDisponiblesIA.obtenerTamanio() > 0) {
        Carta carta = cartasDisponiblesIA.obtenerNodo(0);
        cartasDisponiblesIA.eliminarNodo(carta);
        
        mazoIA.getCartas().agregarCarta(carta);
        JButton botonCarta = crearBotonCartaIA(carta);
        botonCarta.addActionListener(e -> mostrarCartaEnArea(carta));
        panelManoIA.add(botonCarta);
    }

    // Actualizar los paneles
    panelBancaIA.revalidate();
    panelBancaIA.repaint();
    panelPremioIA.revalidate();
    panelPremioIA.repaint();
    panelManoIA.revalidate();
    panelManoIA.repaint();
}
    private JButton crearBotonCartaIA(Carta carta) { //en la IA se crean esto de manera independiente por ser otro metodo
    JButton botonCarta = new JButton(carta.getNombre());

    // Configurar imagen de la carta
    try {
        URL urlImagen = getClass().getResource(carta.getRutaDeImagen());
        if (urlImagen != null) {
            botonCarta.setIcon(new ImageIcon(urlImagen));
            mostrarCartaEnArea(carta);
        }
    } catch (Exception e) {
        botonCarta.setText(carta.getNombre());
    }

    return botonCarta;
}
    
    private void dividirCartasPorTipo(Mazo mazo) {
        JPanel panelHechizos = new JPanel(new GridLayout(5, 8, 10, 10));
        JPanel panelEnergias = new JPanel(new GridLayout(5, 8, 10, 10));
        JPanel panelMounstruos = new JPanel(new GridLayout(5, 8, 10, 10));

        jScrollPaneMostrarCartasHechizosMazoCargado.setViewportView(panelHechizos);
        jScrollPaneMostrarCartasEnergiasMazoCargado.setViewportView(panelEnergias);
        jScrollPaneMostrarCartasMounstruoMazoCargado.setViewportView(panelMounstruos);

        for (int i = 0; i < mazo.getCartas().obtenerTamanio(); i++) {
            Carta carta = mazo.getCartas().obtenerNodo(i);
            JButton botonCarta = new JButton(carta.getNombre());

            // Opcional: Mostrar imagen de la carta
            try {
                URL urlImagen = getClass().getResource(carta.getRutaDeImagen());
                if (urlImagen != null) {
                    botonCarta.setIcon(new ImageIcon(urlImagen));
                }
            } catch (Exception ex) {
                botonCarta.setText(carta.getNombre());
            }

            // Acción al seleccionar la carta
            botonCarta.addActionListener(e -> seleccionarCarta(carta));

            // Dividir por tipo
            if (carta.getTipo() == TipoElemento.HECHIZO) {
                panelHechizos.add(botonCarta);
            } else if (carta.getTipo() == TipoElemento.ENTRENADOR || carta.getTipo() == TipoElemento.ENERGIA) {
                panelEnergias.add(botonCarta);
            } else { // Mounstruos (FUEGO, AGUA, TIERRA, AIRE, NORMAL, PLANTA)
                panelMounstruos.add(botonCarta);
            }
        }
            panelHechizos.revalidate();
            panelHechizos.repaint();
            panelEnergias.revalidate();
            panelEnergias.repaint();
            panelMounstruos.revalidate();
            panelMounstruos.repaint();
    }
    private void mostrarCartaEnArea(Carta carta) { //metodo para mostrar las cartas en el jtexta area segun lo que elija el jugador jasj
        jTextAreaDeDatosCartas.setText(carta.getInfo());
    }
    
    private void seleccionarCarta(Carta carta) {
        mostrarCartaEnArea(carta);

        if (cartaActivaSeleccionada && conteoMano >= 5 && conteoBanca >= 4 && conteoPremio >= 3) {
            JOptionPane.showMessageDialog(this, "Límite alcanzado. Todas las cartas se moveran automáticamente a la pila.");
            moverCartasRestantesAPila();
            
            return;
        }

        int opcion = JOptionPane.showOptionDialog(this, "¿Dónde desea colocar esta carta?",
                "Seleccionar Carta", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null,
                new String[]{"Mano", "Banca", "Carta Activa", "Carta Premio", "Cancelar"}, "Mano");

        switch (opcion) {
            case 0: // Mano
                if (conteoMano < 5) {
                    agregarCartaAMano(carta);
                    eliminarCartaDePanel(carta); // Eliminar del panel visual
                } else {
                    JOptionPane.showMessageDialog(this, "Ya tienes 5 cartas en la mano.");
                }
                break;

            case 1: // Banca
                if (conteoBanca < 4) {
                    agregarCartaABanca(carta);
                    eliminarCartaDePanel(carta); // Eliminar del panel visual
                } else {
                    JOptionPane.showMessageDialog(this, "Ya tienes 4 cartas en la banca.");
                }
                break;

            case 2: // Carta Activa
                if (!cartaActivaSeleccionada) {
                    establecerCartaActiva(carta);
                    eliminarCartaDePanel(carta); // Eliminar del panel visual
                } else {
                    JOptionPane.showMessageDialog(this, "Ya tienes una carta activa.");
                }
                break;

            case 3: // Carta Premio
                if (conteoPremio < 3) {
                    agregarCartaACartaPremio(carta);
                    eliminarCartaDePanel(carta); // Eliminar del panel visual
                } else {
                    JOptionPane.showMessageDialog(this, "Ya tienes 3 cartas premio.");
                }
                break;

            default: // Cancelar
                break;
        }
    }
    private void eliminarCartaDePanel(Carta carta) { //metodo que elimina visualmente la carta elegida por el jugador
        JPanel panel = null;

        // Determinar el panel donde se encuentra la carta
        if (carta.getTipo() == TipoElemento.HECHIZO) {
            panel = (JPanel) jScrollPaneMostrarCartasHechizosMazoCargado.getViewport().getView();
        } else if (carta.getTipo() == TipoElemento.ENTRENADOR || carta.getTipo() == TipoElemento.ENERGIA) {
            panel = (JPanel) jScrollPaneMostrarCartasEnergiasMazoCargado.getViewport().getView();
        } else { // Monstruos
            panel = (JPanel) jScrollPaneMostrarCartasMounstruoMazoCargado.getViewport().getView();
        }

        // Buscar y eliminar el botón correspondiente a la carta
        if (panel != null) {
            for (int i = 0; i < panel.getComponentCount(); i++) {
                JButton botonCarta = (JButton) panel.getComponent(i);
                if (botonCarta.getText().equals(carta.getNombre())) {
                    panel.remove(botonCarta); // Eliminar el botón del panel
                    break;
                }
            }

            // Refrescar el panel
            panel.revalidate();
            panel.repaint();
        }
    }
    
    private void agregarCartaAMano(Carta carta) {
        if (conteoMano >= 5) {
         JOptionPane.showMessageDialog(this, "Ya tienes 5 cartas en la mano.");
         return;
        }

     JButton botonCarta = crearBotonCartaJugador(carta);
     botonCarta.addActionListener(e -> mostrarCartaEnArea(carta));
     panelMano.add(botonCarta);

     conteoMano++;
     panelMano.revalidate();
     panelMano.repaint();
    }

    private void agregarCartaABanca(Carta carta) {
    if (conteoBanca >= 4) {
        JOptionPane.showMessageDialog(this, "Ya tienes 4 cartas en la banca.");
        return;
    }

    JButton botonCarta = crearBotonCartaJugador(carta);
    botonCarta.addActionListener(e -> mostrarCartaEnArea(carta));
    panelBanca.add(botonCarta);

    conteoBanca++;
    panelBanca.revalidate();
    panelBanca.repaint();
    
    }

    private void establecerCartaActiva(Carta carta) {
     if (cartaActivaSeleccionada) {
        JOptionPane.showMessageDialog(this, "Ya tienes una carta activa.");
        return;
    }

    try {
        URL urlImagen = getClass().getResource(carta.getRutaDeImagen());
        if (urlImagen != null) {
            jLabelCartaActivaJugador.setIcon(new ImageIcon(urlImagen));
        }
    } catch (Exception ex) {
        jLabelCartaActivaJugador.setText(carta.getNombre() + carta.getInfo());
    }

    cartaActivaSeleccionada = true;
    }

    private void agregarCartaACartaPremio(Carta carta) {
    if (conteoPremio >= 3) {
        JOptionPane.showMessageDialog(this, "Ya tienes 3 cartas premio.");
        return;
    }

    JButton botonCarta = crearBotonCartaJugador(carta);
    botonCarta.addActionListener(e -> mostrarCartaEnArea(carta));
    panelPremio.add(botonCarta);

    conteoPremio++;
    panelPremio.revalidate();
    panelPremio.repaint();
    }
    
    private void moverCartasRestantesAPila() {
            // Obtener el panel de la pila del jugador
        JPanel panelPila = (JPanel) jScrollPaneCartasPila.getViewport().getView();
            if (panelPila == null) {
                panelPila = new JPanel(new GridLayout(5, 8, 10, 10));
                jScrollPaneCartasPila.setViewportView(panelPila);
            }

        // Iterar a través de las cartas del mazo
        for (int i = 0; i < mazoCargado.getCartas().obtenerTamanio(); i++) {
            Carta carta = mazoCargado.getCartas().obtenerNodo(i); // Obtener la carta actual

            // Crear un botón para la carta y agregarlo al panel de la pila
            JButton botonCarta = crearBotonCartaJugador(carta);
            botonCarta.addActionListener(e -> mostrarCartaEnArea(carta));
            panelPila.add(botonCarta);

            // Eliminar visualmente la carta de los paneles correspondientes
            eliminarCartaDePanel(carta);

            // Opcional: Mensaje en consola para depuración
            System.out.println("Carta movida a la pila: " + carta.getNombre());
        }

        // Refrescar el panel de la pila
        panelPila.revalidate();
        panelPila.repaint();
    }
    
    private JButton crearBotonCartaJugador(Carta carta) {
        JButton botonCarta = new JButton(carta.getNombre());
        //botonCarta.addActionListener(e -> mostrarCartaEnArea(carta));
           try {
               URL urlImagen = getClass().getResource(carta.getRutaDeImagen());
               if (urlImagen != null) {
                   botonCarta.setIcon(new ImageIcon(urlImagen));
                   mostrarCartaEnArea(carta);
               }
           } catch (Exception e) {
               botonCarta.setText(carta.getNombre());
           }
           return botonCarta;
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
        jLabel1 = new javax.swing.JLabel();
        JButtonAccionCerrar = new javax.swing.JButton();
        jButtonAccionRegresar = new javax.swing.JButton();
        jButtonCargarMazo = new javax.swing.JButton();
        jButtonBarajear = new javax.swing.JButton();
        jButtonAccionRobar = new javax.swing.JButton();
        jButtonComenzarPartida = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelCartasDescartadaIA = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPaneCartasEnManoIA = new javax.swing.JScrollPane();
        jLabelCartaPremio1IA = new javax.swing.JLabel();
        jLabelCartaPremio2IA = new javax.swing.JLabel();
        jLabelCartaPremio3IA = new javax.swing.JLabel();
        jScrollPaneCartasEnBancaIA = new javax.swing.JScrollPane();
        jLabelCartaActivaIA = new javax.swing.JLabel();
        jLabelCartaPremio1Jugador = new javax.swing.JLabel();
        jLabelCartaActivaJugador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1CartasBancaJugador = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4CartasManoJugador = new javax.swing.JScrollPane();
        jScrollPaneCartasDescartadasJugador = new javax.swing.JScrollPane();
        jScrollPaneCartasPila = new javax.swing.JScrollPane();
        jScrollPaneCartasPremioJugador = new javax.swing.JScrollPane();
        jScrollPaneMostrarCartasEnergiasMazoCargado = new javax.swing.JScrollPane();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPaneMostrarCartasHechizosMazoCargado = new javax.swing.JScrollPane();
        jLabel34 = new javax.swing.JLabel();
        jScrollPaneMostrarCartasMounstruoMazoCargado = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDeDatosCartas = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PREPARACION DE LA PARTIDA");

        JButtonAccionCerrar.setBackground(new java.awt.Color(255, 0, 0));
        JButtonAccionCerrar.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        JButtonAccionCerrar.setForeground(new java.awt.Color(0, 0, 0));
        JButtonAccionCerrar.setText("CERRAR");
        JButtonAccionCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonAccionCerrarActionPerformed(evt);
            }
        });

        jButtonAccionRegresar.setBackground(new java.awt.Color(255, 204, 51));
        jButtonAccionRegresar.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButtonAccionRegresar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAccionRegresar.setText("REGRESAR");
        jButtonAccionRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccionRegresarActionPerformed(evt);
            }
        });

        jButtonCargarMazo.setBackground(new java.awt.Color(51, 255, 51));
        jButtonCargarMazo.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jButtonCargarMazo.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCargarMazo.setText("1. CARGAR MAZO");
        jButtonCargarMazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarMazoActionPerformed(evt);
            }
        });

        jButtonBarajear.setBackground(new java.awt.Color(51, 255, 0));
        jButtonBarajear.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButtonBarajear.setForeground(new java.awt.Color(0, 0, 0));
        jButtonBarajear.setText("2. BARAJEAR");
        jButtonBarajear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBarajearActionPerformed(evt);
            }
        });

        jButtonAccionRobar.setBackground(new java.awt.Color(51, 255, 0));
        jButtonAccionRobar.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButtonAccionRobar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAccionRobar.setText("3. ROBAR");
        jButtonAccionRobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccionRobarActionPerformed(evt);
            }
        });

        jButtonComenzarPartida.setBackground(new java.awt.Color(0, 255, 0));
        jButtonComenzarPartida.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jButtonComenzarPartida.setForeground(new java.awt.Color(0, 0, 0));
        jButtonComenzarPartida.setText("GUARDAR Y COMENZAR PARTIDA");
        jButtonComenzarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComenzarPartidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAccionRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCargarMazo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBarajear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAccionRobar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonComenzarPartida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JButtonAccionCerrar)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JButtonAccionCerrar)
                        .addComponent(jLabel1)
                        .addComponent(jButtonComenzarPartida))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAccionRegresar)
                        .addComponent(jButtonCargarMazo)
                        .addComponent(jButtonBarajear)
                        .addComponent(jButtonAccionRobar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));

        jPanel3.setBackground(new java.awt.Color(255, 153, 255));

        jLabelCartasDescartadaIA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes2/6.png"))); // NOI18N
        jLabelCartasDescartadaIA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCartaPremio1IA.setText("Carta Premio");
        jLabelCartaPremio1IA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCartaPremio2IA.setText("PREMIO IA");
        jLabelCartaPremio2IA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCartaPremio3IA.setText("PREMIO IA");
        jLabelCartaPremio3IA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCartaActivaIA.setText("CARTA ACTIVA IA");
        jLabelCartaActivaIA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCartaPremio1Jugador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCartaActivaJugador.setText("CARTA ACTIVA JUG");
        jLabelCartaActivaJugador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("VS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCartaPremio1Jugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCartasDescartadaIA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPaneCartasEnManoIA, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPaneCartasEnBancaIA, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabelCartaActivaIA, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCartaActivaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCartaPremio3IA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCartaPremio2IA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCartaPremio1IA, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelCartasDescartadaIA)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCartaPremio1Jugador, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelCartaPremio1IA, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCartaPremio2IA, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCartaPremio3IA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPaneCartasEnManoIA, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneCartasEnBancaIA, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelCartaActivaIA, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addComponent(jLabelCartaActivaJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneCartasPremioJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4CartasManoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1CartasBancaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneCartasPila)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jScrollPaneCartasDescartadasJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPaneCartasDescartadasJugador))
                            .addComponent(jScrollPane1CartasBancaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPaneCartasPila, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jScrollPane4CartasManoJugador)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPaneCartasPremioJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(204, 204, 204)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel32.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("CARTAS ENERGIAS:");

        jLabel33.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("CARTAS HECHIZOS:");

        jLabel34.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("CARTAS MOUNSTRUO:");

        jTextAreaDeDatosCartas.setColumns(20);
        jTextAreaDeDatosCartas.setFont(new java.awt.Font("OCR A Extended", 1, 10)); // NOI18N
        jTextAreaDeDatosCartas.setForeground(new java.awt.Color(0, 0, 0));
        jTextAreaDeDatosCartas.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDeDatosCartas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel32))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneMostrarCartasEnergiasMazoCargado, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel33))
                    .addComponent(jLabel34)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPaneMostrarCartasMounstruoMazoCargado, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPaneMostrarCartasHechizosMazoCargado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneMostrarCartasEnergiasMazoCargado, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneMostrarCartasHechizosMazoCargado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneMostrarCartasMounstruoMazoCargado, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAccionRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccionRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
     MenuJugadorVsJugador menu1 = new MenuJugadorVsJugador();
     menu1.setTitle("MENU JUGADOR");
     menu1.setLocationRelativeTo(null);
     menu1.setVisible(true);
    }//GEN-LAST:event_jButtonAccionRegresarActionPerformed

    private void JButtonAccionCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonAccionCerrarActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el juego?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION)
            {
            this.dispose();
            System.exit(0);
            }
    }//GEN-LAST:event_JButtonAccionCerrarActionPerformed

    private void jButtonBarajearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBarajearActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, "CREAR EN EL BACK BARAJEAR Y MOSTRAR IMAGENES EN LABEL \n");
        barajearCartas();
    }//GEN-LAST:event_jButtonBarajearActionPerformed

    private void jButtonAccionRobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccionRobarActionPerformed
        // TODO add your handling code here:
        this.dispose();
     MenuRobarCarta menu1 = new MenuRobarCarta();
     menu1.setTitle("MENU JUGADOR");
     menu1.setLocationRelativeTo(null);
     menu1.setVisible(true);
    }//GEN-LAST:event_jButtonAccionRobarActionPerformed

    private void jButtonCargarMazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarMazoActionPerformed
        // TODO add your handling code here:
       // JOptionPane.showMessageDialog(null, "ACCION LEER EL ARCHIVO DEL MAZO Y MOSTRAR EN LABELS \n");
        cargarMazo();
       prepararCartasIA();
    }//GEN-LAST:event_jButtonCargarMazoActionPerformed

    private void jButtonComenzarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComenzarPartidaActionPerformed
        // TODO add your handling code here:
        
        //aca implementar codigo en el back pa guardar la preparaicon de la partida
        
        this.dispose();
     PartidaMenu menu1 = new PartidaMenu();
     menu1.setTitle("MENU JUGAR PARTIDA");
     menu1.setLocationRelativeTo(null);
     menu1.setVisible(true);
  //   lanzarMoneda();
    }//GEN-LAST:event_jButtonComenzarPartidaActionPerformed
   /* private void lanzarMoneda() {
    // Crear una nueva ventana para lanzar la moneda
    JFrame ventana = new JFrame("Lanzamiento de Moneda");
    MonedaJuego panelMoneda = new MonedaJuego(new Partida()); // Reemplaza con tu objeto `Partida`
    JLabel texto = new JLabel("Presiona la moneda para lanzarla", SwingConstants.CENTER);

    // Configurar ventana
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLayout(new BorderLayout());
    ventana.add(texto, BorderLayout.NORTH);
    ventana.add(panelMoneda, BorderLayout.CENTER);
    ventana.setSize(350, 350);
    ventana.setLocationRelativeTo(null); // Centrar la ventana
    ventana.setVisible(true);
}*/
    private void barajearCartas() {
    if (mazoCargado == null) {
        JOptionPane.showMessageDialog(this, "Cargue un mazo antes de barajar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    mazoCargado.getCartas().barajearCartas();
    dividirCartasPorTipo(mazoCargado);
    JOptionPane.showMessageDialog(this, "Mazo barajeado correctamente.");
    
    }
    
    private void asignarCartasIA() {
    if (mazoCargado == null) {
        JOptionPane.showMessageDialog(this, "Cargue un mazo antes de asignar cartas a la IA.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    ListaEnlazada cartasIA = new ListaEnlazada();
    Random random = new Random();

    for (int i = 0; i < 7; i++) { // Roba 7 cartas iniciales
        int indice = random.nextInt(mazoCargado.getCartas().obtenerTamanio());
        Carta carta = mazoCargado.getCartas().obtenerNodo(indice);
        cartasIA.agregarCarta(carta);
        mazoCargado.getCartas().eliminarNodo(carta); // Remover de pila original
    }

    JOptionPane.showMessageDialog(this, "Cartas asignadas a la IA.");
}
    
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
            java.util.logging.Logger.getLogger(MenuPrepararPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrepararPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrepararPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrepararPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrepararPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonAccionCerrar;
    private javax.swing.JButton jButtonAccionRegresar;
    private javax.swing.JButton jButtonAccionRobar;
    private javax.swing.JButton jButtonBarajear;
    private javax.swing.JButton jButtonCargarMazo;
    private javax.swing.JButton jButtonComenzarPartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabelCartaActivaIA;
    private javax.swing.JLabel jLabelCartaActivaJugador;
    private javax.swing.JLabel jLabelCartaPremio1IA;
    private javax.swing.JLabel jLabelCartaPremio1Jugador;
    private javax.swing.JLabel jLabelCartaPremio2IA;
    private javax.swing.JLabel jLabelCartaPremio3IA;
    private javax.swing.JLabel jLabelCartasDescartadaIA;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1CartasBancaJugador;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4CartasManoJugador;
    private javax.swing.JScrollPane jScrollPaneCartasDescartadasJugador;
    private javax.swing.JScrollPane jScrollPaneCartasEnBancaIA;
    private javax.swing.JScrollPane jScrollPaneCartasEnManoIA;
    private javax.swing.JScrollPane jScrollPaneCartasPila;
    private javax.swing.JScrollPane jScrollPaneCartasPremioJugador;
    private javax.swing.JScrollPane jScrollPaneMostrarCartasEnergiasMazoCargado;
    private javax.swing.JScrollPane jScrollPaneMostrarCartasHechizosMazoCargado;
    private javax.swing.JScrollPane jScrollPaneMostrarCartasMounstruoMazoCargado;
    private javax.swing.JTextArea jTextAreaDeDatosCartas;
    // End of variables declaration//GEN-END:variables
}

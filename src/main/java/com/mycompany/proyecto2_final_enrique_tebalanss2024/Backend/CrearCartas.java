/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author DELL
 */
public final class CrearCartas {
    private ListaEnlazada cartasMuestras;
    private ListaEnlazada barajaCreadaCopia;
    private ListaEnlazada barajaCreada;
    private ListaEnlazada cartasPremio;
    private ListaEnlazada cartasEnMano;
    private ListaEnlazada cartasDescartadas;
    public final int max_Cartas = 40;
    public final int min_Cartas = 30;
    public Carta[] barajaMuestras;
    
    // mi constructor ajskdj
    public CrearCartas() {
        this.cartasMuestras = new ListaEnlazada();
        barajaCreada = new ListaEnlazada();
        inicializarCartasMuestras();
    }
    
    public void inicializarCartasMuestras()
    {
        barajaMuestras = new Carta[20];
        cartasMuestras = new ListaEnlazada(); // Asegúrate de reiniciar esta lista
        //(0,"Bulbasor1","BASICO",TipoElemento.TIERRA,80.0,10,false,"/Img/Bulbasor1.png");
         //CARTAS ENERGIA  //CLASE a la que pertenece /id/nombre/tipo elemento/ ruta de imagen / EFECTO/ DESCRIPCION
        barajaMuestras[0] = new CartaEnergias(0,"ENERGIA AGUA",TipoElemento.ENERGIA,"/imagenes2/50.png","ENERGIA","DA MAS ENERGIA A TIPOS AGUA");  
        barajaMuestras[1] = new CartaEnergias(1,"CARTA ENERGIA FUEGO",TipoElemento.ENERGIA,"/imagenes2/52.png","ENERGIA","DA MAS ENERGIA A TIPOS FUEGO");
        barajaMuestras[2] = new CartaEnergias(2,"CARTA ENERGIA TIERRA",TipoElemento.ENERGIA,"/imagenes2/51.png","ENERGIA","DA MAS ENERGIA A TIPOS TIERRA");
        barajaMuestras[3] = new CartaEnergias(3,"CARTA ENERGIA AIRE",TipoElemento.ENERGIA,"/imagenes2/49.png"," ENERGIA","DA MAS PODER A TIPOS AIRE");
        barajaMuestras[4] = new CartaEnergias(4,"CARTA ENERGIA NORMAL",TipoElemento.ENTRENADOR,"/imagenes2/54.png","ENERGIA","DA MAS PODER A TIPO NORMAL");
         //CARTAS HECHIZOS                  /VIDA / TIPO DE ELEMENTO CARTA / RUTA DE ACCESO / EFECTO / VALOREFECTO / DESCRIPCION
        barajaMuestras[5] = new CartaHechizos(5,"CURACION",TipoElemento.HECHIZO,"/imagenes2/55.png","VIDA",30,"DA VIDA COMO JESUS"); //ese 30 da curacion a la carta
        barajaMuestras[6] = new CartaHechizos(6,"CURACION DOBLE",TipoElemento.HECHIZO,"/imagenes2/56.png","VIDA",50,"DA 50 PTS DE VIDA");
        barajaMuestras[7] = new CartaHechizos(7,"ATRACCION",TipoElemento.HECHIZO,"/imagenes2/57.png","REVIVIR",10,"REVIVE AL POKEMON COMO JESUS");
        barajaMuestras[8] = new CartaHechizos(8,"ATRAPAR",TipoElemento.HECHIZO,"/imagenes2/58.png","ATRAPA",10,"ATRAPA AL POKEMON COMO TU EX KASJKS");
         // CARTAS MOUNSTRUO                         /ID / NOMBRE / FASE / TIPO ELEMENTO / RUTA DE IMAGE / VIDA / DAÑO / EFECTO / DESCRIPCION
        barajaMuestras[9] = new CartaMounstruo(9,"CHARMANDER","BASICO",TipoElemento.FUEGO,"/imagenes2/1.png",70,30,"QUEMAR","SU CHAMBA ES QUEMAR");
        barajaMuestras[10] = new CartaMounstruo(10,"CHARMELEON","EVOLUCION",TipoElemento.FUEGO,"/imagenes2/2.png",100,90,"QUEMAR","EXPERTO EN HUACHICOLEAR XD");
        barajaMuestras[11] = new CartaMounstruo(11,"BULBASAUR","BASICO",TipoElemento.PLANTA,"/imagenes2/3.png",70,20,"LATIGAZO","QUIERE HIERBA? XD");
        barajaMuestras[12] = new CartaMounstruo(12,"IVYSAUR","EVOLUCION",TipoElemento.PLANTA,"/imagenes2/4.png",100,50,"LATIGAZO","DAR MADRAZOS CON UN LATIGO UWU");
        barajaMuestras[13] = new CartaMounstruo(13,"CATERPIE","BASICO",TipoElemento.PLANTA,"/imagenes2/5.png",50,10,"CABEZAZO","CHOCONOYO VERDE JAJAJA");
        barajaMuestras[14] = new CartaMounstruo(14,"METAPOD","EVOLUCION", TipoElemento.PLANTA,"/imagenes2/6.png",90,20,"CABEZAZO","COMO EL SAMAYAC, SALADO Y FEO");
        barajaMuestras[15] = new CartaMounstruo(15,"SQUIRTLE","BASICO",TipoElemento.AGUA,"/imagenes2/7.png",60,20,"CHORRO","UNA TORTUGA QUE SE MEA A TODOS ESO ES");
        barajaMuestras[16] = new CartaMounstruo(16,"WARTORTLE","EVOLUCION",TipoElemento.AGUA,"/imagenes2/8.png",100,50,"CHORRO","TORTUGA NINJA MAMADISIMA ");
        barajaMuestras[17] = new CartaMounstruo(17,"PIDGEY","BASICO",TipoElemento.AIRE,"/imagenes2/9.png",50,20,"TORNADO","SANATE CAFES");
        barajaMuestras[18] = new CartaMounstruo(18,"PIDGEOT","EVOLUCION",TipoElemento.AIRE,"/imagenes2/10.png",130,40,"TORNADO"," PAJARRACO GRIS FORNICADOR DE LECHUZAS");
        barajaMuestras[19] = new CartaMounstruo(19,"PIKACHU","BASICO",TipoElemento.NORMAL,"/imagenes2/19.png",60,50,"BOLA","RATA ELECTRICAAAAA");
        
         // Agregar estas cartas también a la lista enlazada
        for (int i = 0; i < barajaMuestras.length; i++) { // Cambia el límite según cuántas cartas hayas inicializado
            cartasMuestras.agregarCarta(barajaMuestras[i]);
        }
    }
    
     public void agregarCartaABaraja(Carta carta) {
        if (carta == null) {
            JOptionPane.showMessageDialog(null, "La carta es nula. No se puede agregar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (barajaCreada.obtenerTamanio() >= max_Cartas) {
            JOptionPane.showMessageDialog(null, "La baraja ya está llena. No se pueden agregar más cartas.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        barajaCreada.agregarCarta(carta);
    }
     /**
     * Este metodo sirve para mezclar las barajas(listas enlazadas que forman una baraja)
     */
    public void barajearBaraja() {
        Random random = new Random();
        
        for (int i = 0; i < barajaCreada.obtenerTamanio() - 1; i++) {
            int j = i + random.nextInt(barajaCreada.obtenerTamanio() - i);
            intercambiarCartas(i, j);
        }
    }    
    private void intercambiarCartas(int i, int j) {
        if (i == j) {
            return; // No se necesita intercambiar si las posiciones son iguales
        }
        
        // Encuentra las cartas en las posiciones i y j
        Nodo nodoI = barajaCreada.obtenerNodoEnPosicion(i);
        Nodo nodoJ = barajaCreada.obtenerNodoEnPosicion(j);
        
        // Intercambia las cartas entre estos nodos
        Carta temp = nodoI.getCarta();
        nodoI.setCarta(nodoJ.getCarta());
        nodoJ.setCarta(temp);
    }    
     public void imprimirCartasConsolaBaraja() {
        barajaCreada.imprimirCartas();   
    }
    public void guardarBaraja(String nombreArchivo) {
        barajaCreada.guardarEnArchivo(nombreArchivo);
    }
    public Carta[] getBarajaMuestras() {
        return barajaMuestras;
    }
    public void setBarajaCreada(ListaEnlazada barajaCreada) {
        this.barajaCreada = barajaCreada;
    }
    public ListaEnlazada getBarajaCreada() {
        return barajaCreada;
    }
    /**
     * Método para agregar una nueva carta elegida a la lista de cartas muestra.
     *
     * @param nuevaCarta La carta que se desea agregar.
     */
    public void agregarCartaMuestra(Carta nuevaCarta) {
        if (nuevaCarta == null) {
            JOptionPane.showMessageDialog(null, "La carta es nula. No se puede agregar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        cartasMuestras.agregarCarta(nuevaCarta);
        JOptionPane.showMessageDialog(null, "Carta agregada exitosamente a las cartas muestra.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //METODO PARA AGREGAR AL ARREGLO DE CARTAS UNA NUEVA CARTA DISEÑADA DESDE 0 POR EL JUGADOR
    public void crearNuevaCarta(Carta nuevaCarta) {
     if (nuevaCarta == null) {
        JOptionPane.showMessageDialog(null, "La carta es nula. No se puede agregar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear un nuevo array con una longitud mayor en 1 para añadir la nueva carta
    Carta[] agregarCarta = new Carta[barajaMuestras.length + 1];
    System.arraycopy(barajaMuestras, 0, agregarCarta, 0, barajaMuestras.length); // Copiar las cartas existentes
    agregarCarta[barajaMuestras.length] = nuevaCarta; // Añadir la nueva carta al final
    barajaMuestras = agregarCarta; // Reasignar barajaMuestras al nuevo array

    // Agregar la nueva carta también a la lista enlazada
    cartasMuestras.agregarCarta(nuevaCarta);

    JOptionPane.showMessageDialog(null, "Nueva carta agregada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
}
    //se espera que sea un metodo donde agrega a las cartas muestra, la carta editada por el jugador de una carta original y se agregue al arreglo de cartasMuestras
    public void reemplazarCarta(int posicion, Carta nuevaCarta)
    {
        if (nuevaCarta == null) {
        JOptionPane.showMessageDialog(null, "La carta es nula. No se puede reemplazar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Llamar al método de la lista enlazada para reemplazar el nodo
        cartasMuestras.reemplazarNodo(posicion, nuevaCarta);
    }
    /**
     * Devuelve la lista enlazada de cartas muestra.
     *
     * @return ListaEnlazada con las cartas predefinidas.
     */
    public ListaEnlazada obtenerCartasMuestras() {
        return cartasMuestras;
    }
    public ListaEnlazada getCartasMuestras() {
        return cartasMuestras; // Supongo que `cartasMuestra` es un atributo de tipo `Carta[]`.
    }
    public Carta[] getCartasMuestra() {
    Carta[] cartasArray = new Carta[cartasMuestras.obtenerTamanio()];
    for (int i = 0; i < cartasMuestras.obtenerTamanio(); i++) {
        cartasArray[i] = cartasMuestras.obtenerNodo(i); // Usa el método de la lista enlazada
    }
    return cartasArray;
    }  
}

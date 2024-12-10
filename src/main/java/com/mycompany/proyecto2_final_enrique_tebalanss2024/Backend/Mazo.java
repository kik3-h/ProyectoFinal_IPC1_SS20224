/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;
import java.util.Random;
/**
 *
 * @author DELL
 */
public class Mazo implements Serializable ,Cloneable {
    private static final long serialVersionUID = 1L; // Define un ID fijo
    private String nombre; // Nombre del mazo
    private ListaEnlazada cartas; // Lista enlazada de cartas
    private final int MAX_CARTAS = 40; // Límite de cartas por mazo
    
    // Constructor
    public Mazo(String nombre) {
        this.nombre = nombre;
        this.cartas = new ListaEnlazada(); //aca mando a construir y llamar mi lista enlazada
    }
    // Métodos

    /**
     * Agrega una carta al mazo.
     * 
     * @param carta La carta que se desea agregar.
     * @return true si la carta fue agregada, false si el mazo ya está lleno.
     */
     public String agregarCarta(Carta carta) {
        if (cartas.obtenerTamanio() >= MAX_CARTAS) {
           JOptionPane.showMessageDialog(null, "EL MAZO YA TIENE 40 CARTAS. NO PUEDES AGREGAR MAS \n");
            return "El mazo ya contiene 40 cartas. No puedes agregar más.";
        }
        cartas.agregarCarta(carta);
        JOptionPane.showMessageDialog(null, "CARTA "+carta.getNombre()+" agregada correctamente al mazo \n");
        return "Carta \"" + carta.getNombre() + "\" agregada al mazo.";
    }

     /**
     * Guarda el mazo en un archivo .dat.
     *
     * @return Mensaje indicando el resultado
     */
    public String guardarMazo() {
        if (cartas.obtenerTamanio() < MAX_CARTAS) {
            JOptionPane.showMessageDialog(null, "El mazo no está completo. Asegúrate de que tenga 40 cartas antes de guardarlo. \n");
            return "El mazo no está completo. Asegúrate de que tenga 40 cartas antes de guardarlo.";
        }
        try (FileOutputStream fileOut = new FileOutputStream(nombre + ".dat");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this);
            JOptionPane.showMessageDialog(null, "El mazo "+nombre+"Se ha guardado correctamente como:"+nombre+"dat "+" \n");
            return "El mazo \"" + nombre + "\" se ha guardado correctamente en \"" + nombre + ".dat\".";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR EL MAZO \n");
            return "Error al guardar el mazo: " + e.getMessage();
        }
    }

    /**
     * Muestra todas las cartas del mazo.
     *
     * @return String con la información de las cartas
     */
    public String mostrarCartas() {
        if (cartas.obtenerTamanio() == 0) {
            JOptionPane.showMessageDialog(null, "El mazo esta vacio \n");
            return "El mazo está vacío.";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Cartas en el mazo:\n");
        for (int i = 0; i < cartas.obtenerTamanio(); i++) {
            builder.append(i + 1).append(". ").append(cartas.obtenerNodo(i).getInfo()).append("\n");
        }
        return builder.toString();
    }
    
    public  String duplicarCarta(Carta carta) {
    if (cartas.obtenerTamanio() >= MAX_CARTAS) {
        return "El mazo ya contiene 40 cartas. No puedes duplicar más.";
    }
    // Crear una copia de la carta
    Carta copia = carta.clonar();
    cartas.agregarCarta(copia);
    return "Carta duplicada correctamente: " + copia.getNombre();
    }
    
    public void barajearCartas() {
    Random random = new Random(); // Para generar números aleatorios

    // Obtener el tamaño del mazo
    int tamanio = cartas.obtenerTamanio();

    // Iterar sobre las cartas desde el final hacia el principio
    for (int i = tamanio - 1; i > 0; i--) {
        // Elegir un índice aleatorio desde 0 hasta i (inclusive)
        int j = random.nextInt(i + 1);

        // Intercambiar las cartas en las posiciones i y j
        Nodo nodoI = cartas.obtenerNodoEnPosicion(i);
        Nodo nodoJ = cartas.obtenerNodoEnPosicion(j);

        // Intercambiar las cartas entre los nodos
        Carta temp = nodoI.getCarta();
        nodoI.setCarta(nodoJ.getCarta());
        nodoJ.setCarta(temp);
    }

    JOptionPane.showMessageDialog(null, "¡El mazo ha sido barajado correctamente!", "Barajear Mazo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public Mazo copiarMazo(String nuevoNombre) {
    Mazo copia = new Mazo(nuevoNombre);
    Nodo actual = this.cartas.getCabeza();

        while (actual != null) {
            copia.getCartas().agregarCarta(actual.getCarta()); // Agregar una copia de cada carta
            actual = actual.getNodoSiguiente();
        }

        return copia;
    }
    
    public String ObtenerInfo(Carta carta)
    {
        String info;
        info = carta.getInfo();
        return info;
    }
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEnlazada getCartas() {
        return cartas;
    }

    public int getMaxCartas() {
        return MAX_CARTAS;
    }
}

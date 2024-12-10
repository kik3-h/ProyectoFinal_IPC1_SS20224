/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend;

import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Jugador {
    private String nombre;
    private Mazo mazo;
    private ListaEnlazada cartasSeleccionadas; // Lista de cartas seleccionadas por el jugador
    
    public Jugador(String nombre)
    {
        this.cartasSeleccionadas = new ListaEnlazada(); 
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
     // Método para agregar una carta
    public void agregarCarta(Carta carta) {
        if (cartasSeleccionadas.obtenerTamanio() < 40) { // Límite de 40 cartas por mazo
            cartasSeleccionadas.agregarCarta(carta);
            System.out.println("CARTA SELECCIONADA CORRECTAMENTE A TU MAZO");
        } else {
            JOptionPane.showMessageDialog(null, "EL MAZO YA TIENE 40 CARTAS. NO PUEDES AGREGAR MAS \n");
            System.out.println("El mazo ya esta lleno.");
        }
    }
    
    // Método para obtener el mazo del jugador
    public ListaEnlazada getCartasSeleccionadas() {
        return cartasSeleccionadas;
    }

    // Método para guardar el mazo en un archivo
    public void guardarBaraja(String nombreArchivo) {
        Mazo mazo = new Mazo(nombreArchivo);
        for (int i = 0; i < cartasSeleccionadas.obtenerTamanio(); i++) {
            mazo.agregarCarta(cartasSeleccionadas.obtenerNodo(i));
        }
        mazo.guardarMazo();
    }
 
}

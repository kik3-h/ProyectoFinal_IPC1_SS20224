/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Nodo implements Serializable {
    public Carta carta;
    public Nodo nodoSiguiente;

    // Constructor
    public Nodo(Carta carta) {
        this.carta = carta;
        this.nodoSiguiente = null;
    }

    // Getters y Setters
    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public Nodo getNodoSiguiente() {
        return nodoSiguiente;
    }

    public void setNodoSiguiente(Nodo nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }
}

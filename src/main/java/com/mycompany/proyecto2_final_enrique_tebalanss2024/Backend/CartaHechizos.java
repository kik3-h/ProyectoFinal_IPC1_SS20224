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
public class CartaHechizos extends Carta implements Serializable, Cloneable{
    private String efecto;
    private int cantEfecto; // es la cantidad ya sea de curacion o magia que le de la carta hechizos al pokemon o carta
    // Constructor con parámetros
    public CartaHechizos(int id, String nombre, TipoElemento tipo, String rutaDeImagen, String efecto, int cantEfecto, String descripcion) {
        super(id, nombre, tipo, rutaDeImagen, descripcion);
        this.efecto = efecto;
        this.cantEfecto = cantEfecto;
    }
    // Getter y Setter
    
    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }
    public int getEfectoCuracion() {
        return cantEfecto;
    }

    public void setEfectoCuracion(int cantEfecto) {
        this.cantEfecto = cantEfecto;
    }

    // Sobrescribe el método getInfo()
    @Override
    public String getInfo() {
        return super.getInfo() + ", Efecto: " + efecto+"-" +"\n";
    }
    
     public Carta clonar() { //metodo para clonar carta en caso que en el frame EditarMazoJugador1 el jugador seleccione duplicar carta
        try {
            return (Carta) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Esto nunca debería ocurrir si la clase implementa Cloneable
        }
    }
}

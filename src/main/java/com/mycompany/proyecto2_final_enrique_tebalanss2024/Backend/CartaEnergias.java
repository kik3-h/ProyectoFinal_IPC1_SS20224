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
public class CartaEnergias extends Carta implements Serializable,Cloneable {
    private String tipoEfecto;
    public CartaEnergias(int id, String nombre,TipoElemento tipo,String rutaDeImagen, String tipoEfecto, String descripcion){
        super(id,nombre, tipo, rutaDeImagen, descripcion);
        this.tipoEfecto = tipoEfecto;       
    }
    // Getters y Setters
    public String getTipoEfecto()
    {
        return tipoEfecto;
    }
    public void setTipoEfecto(String tipoEfecto)
    {
        this.tipoEfecto = tipoEfecto;
    }
    // Método para mostrar información
   // Sobrescribe el método getInfo()
    @Override
    public String getInfo() {
        return super.getInfo() + ", Tipo de Efecto: " + tipoEfecto+ "-"+"\n";
    }
     public Carta clonar() {
        try {
            return (Carta) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Esto nunca debería ocurrir si la clase implementa Cloneable
        }
    }
         //by: kik3.h   
}

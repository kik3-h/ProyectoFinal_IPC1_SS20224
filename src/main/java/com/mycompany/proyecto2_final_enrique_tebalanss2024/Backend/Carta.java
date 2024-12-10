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
public class Carta implements Serializable,Cloneable{
    private int id;
    private String nombre;
    private TipoElemento tipo;
    private String rutaDeImagen;
    private String descripcion;
    // Constructor
    public Carta(int id, String nombre, TipoElemento tipo, String rutaDeImagen, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo =tipo;
        this.rutaDeImagen = rutaDeImagen;
        this.descripcion = descripcion;
    }
    // Getters y Setters kjasdkja nmms voy atrasadooooo 16-11-2024 22:50 Hrs
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoElemento getTipo() {
        return tipo;
    }
    public void setTipo(TipoElemento tipo) {
        this.tipo = tipo;
    }
    public String getRutaDeImagen() {
        return rutaDeImagen;
    }
    public void setRutaDeImagen(String rutaDeImagen) {
        this.rutaDeImagen = rutaDeImagen;
    }
    // Método para mostrar información
    public String getInfo() {
        return " ID: " + id + ", Nombre: " + nombre + ", Tipo: " + tipo +"\n "+ ", RUTA: " + rutaDeImagen+" DESCRIPCION: "+descripcion+"\n ";
    }
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion)
    {
        this.descripcion= descripcion;
    }
    public Carta clonar() { //metodo para clonar carta en caso que en el frame EditarMazoJugador1 el jugador seleccione duplicar carta
        try {
            return (Carta) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Esto nunca debería ocurrir si la clase implementa Cloneable
        }
    }
    
}



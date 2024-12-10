/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend;

/**
 *
 * @author DELL
 */
public class NombreJugador { //clase nomas pa almacenar el nombre real del jugador para mandarlo y obtenerlo en diferentes clases sin que se borre
     private String nombre;
     
     public NombreJugador(String nombre)
     {
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
}

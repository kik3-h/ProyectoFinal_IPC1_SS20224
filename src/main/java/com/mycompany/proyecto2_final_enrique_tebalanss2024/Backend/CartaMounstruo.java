/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend;
import com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend.TipoElemento;
import java.io.Serializable;
/**
 *
 * @author DELL
 */
public class CartaMounstruo extends Carta implements Serializable,Cloneable {
    private int puntosVida;
    private int ataque;
    private int costeRetirada;
    private String fase;
    private String descripcion;
    private String efecto;
    public CartaMounstruo(int id, String nombre, String fase,TipoElemento tipo, String rutaDeImagen, int puntosVida, int ataque, String efecto, String descripcion) {
        super(id, nombre, tipo, rutaDeImagen, descripcion); // Llama al constructor de Carta
        this.fase = fase;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
        this.efecto = efecto;
        this.descripcion = descripcion;
    }
    // Getters y Setters
    public String getFase()
    {
        return fase;
    }
    public void setFase(String par)
    {
        this.fase = fase;
    }
    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public String getEfecto ()
    {
        return efecto;
    }
    
    public void setEfecto(String efecto)
    {
        this.efecto = efecto;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
    
    
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
            
    // Sobrescribe el método getInfo()
    @Override
    public String getInfo() {
        return super.getInfo() +" fase:"+fase+ ", Vida: " + puntosVida + ", Ataque: " + ataque+ "-"+"\n";
    }
    public Carta clonar() { //metodo para clonar carta en caso que en el frame EditarMazoJugador1 el jugador seleccione duplicar carta
        try {
            return (Carta) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Esto nunca debería ocurrir si la clase implementa Cloneable
        }
    }
}

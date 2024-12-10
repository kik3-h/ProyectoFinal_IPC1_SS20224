/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author DELL
 */
public class ListaEnlazada implements Serializable{
    private static final long serialVersionUID = 1L; // Define un ID fijo
    private Nodo cabeza;
    private int tamanio;

    // Constructor
    public ListaEnlazada() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    // Métodos básicos
    public void agregarCarta(Carta carta) {
        Nodo nuevoNodo = new Nodo(carta);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getNodoSiguiente() != null) {
                actual = actual.getNodoSiguiente();
            }
            actual.setNodoSiguiente(nuevoNodo);
        }
        tamanio++;
    }

    public boolean eliminarNodo(Carta carta) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.getCarta().equals(carta)) {
            cabeza = cabeza.getNodoSiguiente();
            tamanio--;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.getNodoSiguiente() != null) {
            if (actual.getNodoSiguiente().getCarta().equals(carta)) {
                actual.setNodoSiguiente(actual.getNodoSiguiente().getNodoSiguiente());
                tamanio--;
                return true;
            }
            actual = actual.getNodoSiguiente();
        }
        return false;
    }

    public Carta obtenerNodo(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            return null;
        }
        Nodo actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getNodoSiguiente();
        }
        return actual.getCarta();
    }

    public int obtenerTamanio() {
        return tamanio;
    }
    
    public Nodo obtenerNodoEnPosicion(int posicion) {
    Nodo actual = cabeza; // Suponiendo que la lista enlazada tiene un nodo cabeza
    int contador = 0;

    // Recorre la lista hasta la posición deseada
    while (actual != null && contador < posicion) {
        actual = actual.getNodoSiguiente();
        contador++;
    }

    return actual;
    }
    
    // Método para imprimir todas las cartas de la lista
    public void imprimirCartas() {
        Nodo actual = cabeza;
        while (actual != null) {
        System.out.println(actual.getCarta()); // un toString en la clase Carta para imprimir detalles
        actual = actual.getNodoSiguiente();
        }
    }
    /**
     * Recibe una nombre para el archivo y convierte a archivo binario la lista enlazada que forma una baraja
     * @param nombreArchivo 
     */
    public void guardarEnArchivo(String nombreArchivo) {
        if (tamanio >= 30 && tamanio <= 40) {
            try (FileOutputStream fos = new FileOutputStream(nombreArchivo+".dat"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(this);
                JOptionPane.showMessageDialog(null, "La Baraja de cartas se ha guardado exitosamente en " + nombreArchivo, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar la lista de cartas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "La Baraja debe tener entre 30 y 40 cartas para poder guardarse. Actualmente tiene: " + tamanio, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * 
     * 
     * 
     * busca una archivo binario para mostrar la lista enlazada que tiene adentro
     * @param nombreArchivo 
     */
    public void mostrarBarajaGuardada(String nombreArchivo) {
        try (FileInputStream fis = new FileInputStream(nombreArchivo); ObjectInputStream ois = new ObjectInputStream(fis)) {
            ListaEnlazada listaCargada = (ListaEnlazada) ois.readObject();
            JOptionPane.showMessageDialog(null, "Baraja cargada desde " + nombreArchivo, "Información", JOptionPane.INFORMATION_MESSAGE);
            listaCargada.imprimirCartas();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la baraja: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void reducirTamanio(){
        this.tamanio--;
    }
    /**
     * Funcion que elimina la primera carta, sirve para cuando sacamos las "manos y premios" donde se sacan las primeras cartas
     * @return 
     */
    public Carta eliminarPrimeraCarta() {
        if (cabeza == null) {
            return null;  // Si la lista está vacía, no hay carta para eliminar
        }

            Carta carta = cabeza.getCarta();  // Obtener la carta del primer nodo
            cabeza = cabeza.getNodoSiguiente();  // Mover la cabeza al siguiente nodo
            reducirTamanio();
            return carta;
    }
    /**
     * sirve para agragar a las listas los nodos que sacamos de otras listas y queremos pasarla a una nueva lista enlazada
     * @param nuevoNodo 
     */
    public void agregarAlFinal(Nodo nuevoNodo) {
        if (cabeza == null) {
            // Si la lista está vacía, el nuevo nodo será la cabeza
            cabeza = nuevoNodo;
        } else {
            // Si la lista no está vacía, recorre hasta el final y añade el nodo
            Nodo actual = cabeza;
            while (actual.getNodoSiguiente() != null) {
                actual = actual.getNodoSiguiente();
            }
            actual.setNodoSiguiente(nuevoNodo);
        }
    }
    
    /**
     * sirve para eliminar un nodo en especial, sirve en las ediciones de cartas
     * @param nodoAEliminar 
     */
    public void eliminarNodo(Nodo nodoAEliminar) {
        Carta cartaEliminada;
        if (cabeza == nodoAEliminar) {
            // Si el nodo a eliminar es la cabeza, actualiza la cabeza
            cartaEliminada = cabeza.getCarta();
            cabeza = cabeza.getNodoSiguiente();
        } else {
            // Busca el nodo en la lista
            Nodo actual = cabeza;
            while (actual.getNodoSiguiente() != null && actual.getNodoSiguiente() != nodoAEliminar) {
                actual = actual.getNodoSiguiente();
            }

            if (actual.getNodoSiguiente() == nodoAEliminar) {
                // Enlaza el nodo actual al nodo siguiente de nodoAEliminar para eliminarlo
                cartaEliminada = nodoAEliminar.getCarta();
                actual.setNodoSiguiente(nodoAEliminar.getNodoSiguiente());
            } else {
                // Si el nodo no se encuentra en la lista
                JOptionPane.showMessageDialog(null, "El nodo no se encuentra en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        tamanio--; // Disminuye el tamaño de la lista
    }

    public void reemplazarNodo(int posicion, Carta nuevaCarta) {
        if (posicion < 0 || posicion >= tamanio) {
            JOptionPane.showMessageDialog(null, "La posición es inválida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

            Nodo actual = cabeza;
            for (int i = 0; i < posicion; i++) {
                actual = actual.getNodoSiguiente();
            }

        // Reemplazar la carta en el nodo actual
        actual.setCarta(nuevaCarta);
        JOptionPane.showMessageDialog(null, "Carta reemplazada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void barajearCartas() {
    if (tamanio <= 1) {
        return; // No es necesario barajar si la lista tiene 0 o 1 carta
    }
    
    Random random = new Random();
    
    for (int i = 0; i < tamanio - 1; i++) {
        int j = i + random.nextInt(tamanio - i);
        intercambiarCartas(i, j);
    }
}

// Método auxiliar para intercambiar dos cartas en posiciones específicas
private void intercambiarCartas(int i, int j) {
    if (i == j) {
        return; // No se necesita intercambiar si las posiciones son iguales
    }
    
    // Encuentra los nodos en las posiciones i y j
    Nodo nodoI = obtenerNodoEnPosicion(i);
    Nodo nodoJ = obtenerNodoEnPosicion(j);
    
    // Intercambia las cartas entre estos nodos
    Carta temp = nodoI.getCarta();
    nodoI.setCarta(nodoJ.getCarta());
    nodoJ.setCarta(temp);
}
    public Nodo getCabeza() {
        return cabeza;
    }
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
}

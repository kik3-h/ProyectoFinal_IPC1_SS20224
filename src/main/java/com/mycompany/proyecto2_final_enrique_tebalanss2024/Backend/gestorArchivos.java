/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_final_enrique_tebalanss2024.Backend;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class gestorArchivos {
    private static final String PATH_CARPETA = "com/mycompany/proyecto2_final_enrique_tebalanss2024";
    private static final String PATH_RELATIVO_ARCHIVO = "texto.txt";
    private static final String PATH_ABSOLUTO_ARCHIVO = "com/mycompany/proyecto2_final_enrique_tebalanss2024";
    private static final String PATH_ARCHIVO = PATH_RELATIVO_ARCHIVO;
    
    public void conectarConCarpeta() {
        File carpeta = new File(PATH_CARPETA);
        System.out.println("Existe? " + carpeta.exists());
        System.out.println("Es carpeta? " + carpeta.isDirectory());
        System.out.println("Se puede modificar? " + carpeta.canWrite());
        System.out.println("AOculto? " + carpeta.isHidden());
        if (carpeta.exists() && carpeta.isDirectory()) {
            System.out.println("archivos ocultos dentro de carpeta: ");
            for (String fileName : carpeta.list()) {
                File archivoEnCarpeta = new File(PATH_CARPETA + File.separator + fileName);
                if (archivoEnCarpeta.isHidden()) {
                    System.out.println(fileName);
                }
            }
        }
    }
    
    public void escribirEnArchivoDeTexto(String contenido) {
        File archivoTexto = new File(PATH_ARCHIVO);
        try(FileWriter fileWriter = new FileWriter(archivoTexto, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.newLine();
            bufferedWriter.append(contenido);
            //bufferedWriter.append(contenido);
        } catch (IOException e) {
            // manejar error
            e.printStackTrace();
        }   
    }
     /*public void leerDesdeArchivoTexto() {
        File archivoTexto = new File(PATH_ARCHIVO);
        try (FileInputStream fileInputStream = new FileInputStream(archivoTexto);) {
            int byteEnArchivo = fileInputStream.read();
            while (byteEnArchivo != -1) {
                char caracter = (char) byteEnArchivo;
                System.out.println(caracter);
                byteEnArchivo = fileInputStream.read();
            }
        } catch (IOException e) {
            // manejar error
            e.printStackTrace();
        }
        
        try (FileReader fileReader = new FileReader(archivoTexto);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String linea = bufferedReader.readLine();
            while(linea != null) {
                System.out.println(linea);
                linea = bufferedReader.readLine();
            }
        } catch (IOException e) {
        }
        
        try (Scanner scannerFile = new Scanner(archivoTexto)) {
            while (true) {
                String linea = scannerFile.nextLine();
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException ex) {
            System.out.println("no hay mas lineas por leer");
        }
    }*/
    
    public String leerArchivoDeTextoCompleto() {
        StringBuilder contenido = new StringBuilder();
        File archivoTexto = new File(PATH_ARCHIVO);

        try (FileReader fileReader = new FileReader(archivoTexto);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String linea;
            while((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea).append("\n");  // Agregar cada línea al contenido
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenido.toString();
    }
    
    public void limpiarArchivo() {
    File archivoTexto = new File(PATH_ARCHIVO);
    try (FileWriter fileWriter = new FileWriter(archivoTexto, false)) {
        // Sobrescribimos el archivo sin escribir nada, lo que lo limpia
        fileWriter.write("");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

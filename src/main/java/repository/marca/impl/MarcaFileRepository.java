/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.marca.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import domain.Marca;
import repository.marca.MarcaRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Marca
 *
 *
 */
public class MarcaFileRepository implements MarcaRepository {

    private static final String RUTA_ARCHIVO = "marcas.txt";
    public static final int TAMANIO_INICIAL = 10;
    private static Marca[] marcas = new Marca[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idMarcaes

    // Constructor
    public MarcaFileRepository() {
        loadFromFile();
    }

    private void loadFromFile() {
        File file = new File(RUTA_ARCHIVO);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                if (size >= marcas.length) {
                    marcas = Arrays.copyOf(marcas, marcas.length * 2);
                }

                String line = scanner.nextLine();
                String[] fields = line.split("\\|");
                Marca marca = new Marca();
                marca.setIdMarca(Integer.valueOf(fields[0]));
                marca.setMarca(fields[1]);
                marcas[size++] = marca;
                if (secuenciaId <= marca.getIdMarca()) {
                    secuenciaId = marca.getIdMarca() + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() { //try with resources //AutoCloseable
        try (PrintWriter out = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (int i = 0; i < size; i++) {
                Marca marca = marcas[i];
                out.println(marca.getIdMarca() + "|" 
                        + marca.getMarca());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    @Override
    public void create(Marca marca) {
        if (size == marcas.length) {
            // Redimensionar el arreglo
            Marca[] nuevoArreglo = new Marca[size * 2];
            System.arraycopy(marcas, 0, nuevoArreglo, 0, size);
            marcas = nuevoArreglo;
        }

        marca.setIdMarca(secuenciaId);  // Asignar el idMarca automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo

        marcas[size] = marca;
        size++;
        saveToFile();
    }

    @Override
    public Marca read(int idMarca) {
        for (int i = 0; i < size; i++) {
            if (marcas[i].getIdMarca().equals(idMarca)) {
                return marcas[i];
            }
        }
        return null;
    }

    @Override
    public Marca[] readAll() {
        Marca[] activeArticles = new Marca[size];
        System.arraycopy(marcas, 0, activeArticles, 0, size);
        return activeArticles;
    }

    @Override
    public Marca[] readAllWithOrder(Comparator criterio) {
        Marca[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }

    // UPDATE
    @Override
    public boolean update(int idMarca, Marca updatedMarca) {
        for (int i = 0; i < size; i++) {
            if (marcas[i].getIdMarca().equals(idMarca)) {
                updatedMarca.setIdMarca(idMarca);
                marcas[i] = updatedMarca;
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idMarca) {
        for (int i = 0; i < size; i++) {
            if (marcas[i].getIdMarca().equals(idMarca)) {
                // Desplazar los elementos restantes
                System.arraycopy(marcas, i + 1, marcas, i, size - i - 1);
                size--;
                saveToFile();
                return true;
            }
        }
        return false;
    }
}

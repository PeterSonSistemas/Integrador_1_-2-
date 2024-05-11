/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.localproducto.impl;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import peter.unmsm.javabasico.sixcar.s.a.c.domain.LocalProducto;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.localproducto.LocalProductoRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase LocalProducto
 *
 *
 */
public class LocalProductoFileRepository implements LocalProductoRepository {

    private static final String RUTA_ARCHIVO = "localProductos.txt";
    public static final int TAMANIO_INICIAL = 10;
    private static LocalProducto[] localProductos = new LocalProducto[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idLocalProductoes

    // Constructor
    public LocalProductoFileRepository() {
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
                if (size >= localProductos.length) {
                    localProductos = Arrays.copyOf(localProductos, localProductos.length * 2);
                }

                String line = scanner.nextLine();
                String[] fields = line.split("\\|");
                LocalProducto localProducto = new LocalProducto();
                localProducto.setIdLocalProducto(Integer.valueOf(fields[0]));
                localProducto.setStock(Integer.parseInt(fields[1]));
                localProductos[size++] = localProducto;
                if (secuenciaId <= localProducto.getIdLocalProducto()) {
                    secuenciaId = localProducto.getIdLocalProducto() + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() { //try with resources //AutoCloseable
        try (PrintWriter out = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (int i = 0; i < size; i++) {
                LocalProducto localProducto = localProductos[i];
                out.println(localProducto.getIdLocalProducto() + "|"
                        + localProducto.getStock());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    @Override
    public void create(LocalProducto localProducto) {
        if (size == localProductos.length) {
            // Redimensionar el arreglo
            LocalProducto[] nuevoArreglo = new LocalProducto[size * 2];
            System.arraycopy(localProductos, 0, nuevoArreglo, 0, size);
            localProductos = nuevoArreglo;
        }

        localProducto.setIdLocalProducto(secuenciaId);  // Asignar el idLocalProducto automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo

        localProductos[size] = localProducto;
        size++;
        saveToFile();
    }

    @Override
    public LocalProducto read(int idLocalProducto) {
        for (int i = 0; i < size; i++) {
            if (localProductos[i].getIdLocalProducto().equals(idLocalProducto)) {
                return localProductos[i];
            }
        }
        return null;
    }

    @Override
    public LocalProducto[] readAll() {
        LocalProducto[] activeArticles = new LocalProducto[size];
        System.arraycopy(localProductos, 0, activeArticles, 0, size);
        return activeArticles;
    }

    @Override
    public LocalProducto[] readAllWithOrder(Comparator criterio) {
        LocalProducto[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }

    // UPDATE
    @Override
    public boolean update(int idLocalProducto, LocalProducto updatedLocalProducto) {
        for (int i = 0; i < size; i++) {
            if (localProductos[i].getIdLocalProducto().equals(idLocalProducto)) {
                updatedLocalProducto.setIdLocalProducto(idLocalProducto);
                localProductos[i] = updatedLocalProducto;
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idLocalProducto) {
        for (int i = 0; i < size; i++) {
            if (localProductos[i].getIdLocalProducto().equals(idLocalProducto)) {
                // Desplazar los elementos restantes
                System.arraycopy(localProductos, i + 1, localProductos, i, size - i - 1);
                size--;
                saveToFile();
                return true;
            }
        }
        return false;
    }
}

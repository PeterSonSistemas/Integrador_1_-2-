/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.carro.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import peter.unmsm.javabasico.sixcar.s.a.c.domain.Carro;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.carro.CarroRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Carro
 *
 *
 */
public class CarroFileRepository implements CarroRepository {

    private static final String RUTA_ARCHIVO = "carros.txt";
    public static final int TAMANIO_INICIAL = 10;
    private static Carro[] carros = new Carro[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idCarroes

    // Constructor
    public CarroFileRepository() {
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
                if (size >= carros.length) {
                    carros = Arrays.copyOf(carros, carros.length * 2);
                }

                String line = scanner.nextLine();
                String[] fields = line.split("\\|");
                Carro carro = new Carro();
                carro.setNumeroBoletaCarro(Integer.parseInt(fields[0]));
                carro.setIdCarro(Integer.valueOf(fields[1]));
                carro.setMarca(fields[2]);
                carro.setPlaca(fields[3]);
                carro.setAnio(Short.parseShort(fields[4]));
                carros[size++] = carro;
                if (secuenciaId <= carro.getIdCarro()) {
                    secuenciaId = carro.getIdCarro() + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() { //try with resources //AutoCloseable
        try (PrintWriter out = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (int i = 0; i < size; i++) {
                Carro carro = carros[i];
                out.println(carro.getNumeroBoletaCarro()+ "|"
                        + carro.getIdCarro()+ "|"
                        + carro.getMarca()+ "|"
                        + carro.getPlaca()+ "|"
                        + carro.getAnio());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    @Override
    public void create(Carro carro) {
        if (size == carros.length) {
            // Redimensionar el arreglo
            Carro[] nuevoArreglo = new Carro[size * 2];
            System.arraycopy(carros, 0, nuevoArreglo, 0, size);
            carros = nuevoArreglo;
        }

        carro.setIdCarro(secuenciaId);  // Asignar el idCarro automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo

        carros[size] = carro;
        size++;
        saveToFile();
    }

    @Override
    public Carro read(int idCarro) {
        for (int i = 0; i < size; i++) {
            if (carros[i].getNumeroBoletaCarro() == (idCarro)) {
                return carros[i];
            }
        }
        return null;
    }

    @Override
    public Carro[] readAll() {
        Carro[] activeArticles = new Carro[size];
        System.arraycopy(carros, 0, activeArticles, 0, size);
        return activeArticles;
    }

    @Override
    public Carro[] readAllWithOrder(Comparator criterio) {
        Carro[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }

    // UPDATE
    @Override
    public boolean update(int idCarro, Carro updatedCarro) {
        for (int i = 0; i < size; i++) {
            if (carros[i].getIdCarro().equals(idCarro)) {
                updatedCarro.setIdCarro(idCarro);
                carros[i] = updatedCarro;
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idCarro) {
        for (int i = 0; i < size; i++) {
            if (carros[i].getIdCarro().equals(idCarro)) {
                // Desplazar los elementos restantes
                System.arraycopy(carros, i + 1, carros, i, size - i - 1);
                size--;
                saveToFile();
                return true;
            }
        }
        return false;
    }
}

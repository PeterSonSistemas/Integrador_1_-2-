/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.alarma.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import peter.unmsm.javabasico.sixcar.s.a.c.domain.Alarma;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.alarma.AlarmaRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Alarma
 *
 *
 */
public class AlarmaFileRepository implements AlarmaRepository {

    private static final String RUTA_ARCHIVO = "alarmas.txt";
    public static final int TAMANIO_INICIAL = 10;
    private static Alarma[] alarmas = new Alarma[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idAlarmaes

    // Constructor
    public AlarmaFileRepository() {
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
                if (size >= alarmas.length) {
                    alarmas = Arrays.copyOf(alarmas, alarmas.length * 2);
                }

                String line = scanner.nextLine();
                String[] fields = line.split("\\|");
                Alarma alarma = new Alarma();
                alarma.setIdAlarma(Integer.valueOf(fields[0]));
                alarma.setMensaje(fields[1]);
                alarma.setActivada(Boolean.parseBoolean(fields[2]));
                alarmas[size++] = alarma;
                if (secuenciaId <= alarma.getIdAlarma()) {
                    secuenciaId = alarma.getIdAlarma() + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() { //try with resources //AutoCloseable
        try (PrintWriter out = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (int i = 0; i < size; i++) {
                Alarma alarma = alarmas[i];
                out.println(alarma.getIdAlarma() + "|"
                        + alarma.getMensaje()+ "|"
                        + alarma.isActivada());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    @Override
    public void create(Alarma alarma) {
        if (size == alarmas.length) {
            // Redimensionar el arreglo
            Alarma[] nuevoArreglo = new Alarma[size * 2];
            System.arraycopy(alarmas, 0, nuevoArreglo, 0, size);
            alarmas = nuevoArreglo;
        }

        alarma.setIdAlarma(secuenciaId);  // Asignar el idAlarma automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo

        alarmas[size] = alarma;
        size++;
        saveToFile();
    }

    @Override
    public Alarma read(int idAlarma) {
        for (int i = 0; i < size; i++) {
            if (alarmas[i].getIdAlarma().equals(idAlarma)) {
                return alarmas[i];
            }
        }
        return null;
    }

    @Override
    public Alarma[] readAll() {
        Alarma[] activeArticles = new Alarma[size];
        System.arraycopy(alarmas, 0, activeArticles, 0, size);
        return activeArticles;
    }

    @Override
    public Alarma[] readAllWithOrder(Comparator criterio) {
        Alarma[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }

    // UPDATE
    @Override
    public boolean update(int idAlarma, Alarma updatedAlarma) {
        for (int i = 0; i < size; i++) {
            if (alarmas[i].getIdAlarma().equals(idAlarma)) {
                updatedAlarma.setIdAlarma(idAlarma);
                alarmas[i] = updatedAlarma;
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idAlarma) {
        for (int i = 0; i < size; i++) {
            if (alarmas[i].getIdAlarma().equals(idAlarma)) {
                // Desplazar los elementos restantes
                System.arraycopy(alarmas, i + 1, alarmas, i, size - i - 1);
                size--;
                saveToFile();
                return true;
            }
        }
        return false;
    }
}

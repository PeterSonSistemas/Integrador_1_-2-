/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.comprobante.impl;

import peter.unmsm.javabasico.sixcar.s.a.c.repository.comprobante.impl.*;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.comprobante.impl.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import peter.unmsm.javabasico.sixcar.s.a.c.util.FormatoDate;

import peter.unmsm.javabasico.sixcar.s.a.c.domain.Comprobante;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.comprobante.ComprobanteRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Comprobante
 *
 *
 */
public class ComprobanteFileRepository implements ComprobanteRepository {
    //variable de paquetes
    FormatoDate fd = new FormatoDate();
    
    //variables
    private static final String RUTA_ARCHIVO = "comprobantes.txt";
    public static final int TAMANIO_INICIAL = 10;
    private static Comprobante[] comprobantes = new Comprobante[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar numeroBoletaes

    // Constructor
    public ComprobanteFileRepository() {
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
                if (size >= comprobantes.length) {
                    comprobantes = Arrays.copyOf(comprobantes, comprobantes.length * 2);
                }

                String line = scanner.nextLine();
                String[] fields = line.split("\\|");
                Comprobante comprobante = new Comprobante();
                comprobante.setNumeroBoleta(Integer.valueOf(fields[0]));
                comprobante.setTipoComprobante(fields[1]);
                comprobante.setRUCempresa(fields[2]);
                comprobante.setNumeroTelefono(fields[3]);
                comprobante.setFecha(fd.FechaParse(fields[4]));
                comprobantes[size++] = comprobante;
                if (secuenciaId <= comprobante.getNumeroBoleta()) {
                    secuenciaId = comprobante.getNumeroBoleta() + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() { //try with resources //AutoCloseable
        try (PrintWriter out = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (int i = 0; i < size; i++) {
                Comprobante comprobante = comprobantes[i];
                out.println(comprobante.getNumeroBoleta()+ "|"
                        + comprobante.getTipoComprobante()+ "|"
                        + comprobante.getRUCempresa()+ "|"
                        + comprobante.getNumeroTelefono()+ "|"
                        + fd.FechaFormat(comprobante.getFecha()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    @Override
    public void create(Comprobante comprobante) {
        if (size == comprobantes.length) {
            // Redimensionar el arreglo
            Comprobante[] nuevoArreglo = new Comprobante[size * 2];
            System.arraycopy(comprobantes, 0, nuevoArreglo, 0, size);
            comprobantes = nuevoArreglo;
        }

        comprobante.setNumeroBoleta(secuenciaId);  // Asignar el numeroBoleta automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo

        comprobantes[size] = comprobante;
        size++;
        saveToFile();
    }

    @Override
    public Comprobante read(int numeroBoleta) {
        for (int i = 0; i < size; i++) {
            if (comprobantes[i].getNumeroBoleta().equals(numeroBoleta)) {
                return comprobantes[i];
            }
        }
        return null;
    }

    @Override
    public Comprobante[] readAll() {
        Comprobante[] activeArticles = new Comprobante[size];
        System.arraycopy(comprobantes, 0, activeArticles, 0, size);
        return activeArticles;
    }

    @Override
    public Comprobante[] readAllWithOrder(Comparator criterio) {
        Comprobante[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }

    // UPDATE
    @Override
    public boolean update(int numeroBoleta, Comprobante updatedComprobante) {
        for (int i = 0; i < size; i++) {
            if (comprobantes[i].getNumeroBoleta().equals(numeroBoleta)) {
                updatedComprobante.setNumeroBoleta(numeroBoleta);
                comprobantes[i] = updatedComprobante;
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int numeroBoleta) {
        for (int i = 0; i < size; i++) {
            if (comprobantes[i].getNumeroBoleta().equals(numeroBoleta)) {
                // Desplazar los elementos restantes
                System.arraycopy(comprobantes, i + 1, comprobantes, i, size - i - 1);
                size--;
                saveToFile();
                return true;
            }
        }
        return false;
    }
}

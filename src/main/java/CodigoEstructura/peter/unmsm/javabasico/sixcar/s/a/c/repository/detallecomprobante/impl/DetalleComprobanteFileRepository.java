/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.detallecomprobante.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import peter.unmsm.javabasico.sixcar.s.a.c.domain.DetalleComprobante;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.detallecomprobante.DetalleComprobanteRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase DetalleComprobante
 *
 *
 */
public class DetalleComprobanteFileRepository implements DetalleComprobanteRepository {

    private static final String RUTA_ARCHIVO = "detalleComprobantes.txt";
    public static final int TAMANIO_INICIAL = 10;
    private static DetalleComprobante[] detalleComprobantes = new DetalleComprobante[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idDetalleComprobantees

    // Constructor
    public DetalleComprobanteFileRepository() {
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
                if (size >= detalleComprobantes.length) {
                    detalleComprobantes = Arrays.copyOf(detalleComprobantes, detalleComprobantes.length * 2);
                }

                String line = scanner.nextLine();
                String[] fields = line.split("\\|");
                DetalleComprobante detalleComprobante = new DetalleComprobante();
                detalleComprobante.setNumeroBoletaDetalleComprobante(Integer.parseInt(fields[0]));
                detalleComprobante.setIdDetalleComprobante(Integer.valueOf(fields[1]));
                detalleComprobante.setNombreProducto(fields[2]);
                detalleComprobante.setCantidadProducto(Short.parseShort(fields[3]));
                detalleComprobante.setPrecioProducto(Float.parseFloat(fields[4]));
                detalleComprobante.setTotalProducto(new BigDecimal(fields[5]));
                detalleComprobante.setTotal(new BigDecimal(fields[6]));
                detalleComprobante.setCantidadProductoRegistrar(Byte.parseByte(fields[7]));
                detalleComprobantes[size++] = detalleComprobante;
                if (secuenciaId <= detalleComprobante.getIdDetalleComprobante()) {
                    secuenciaId = detalleComprobante.getIdDetalleComprobante() + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() { //try with resources //AutoCloseable
        try (PrintWriter out = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (int i = 0; i < size; i++) {
                DetalleComprobante detalleComprobante = detalleComprobantes[i];
                out.println(detalleComprobante.getNumeroBoletaDetalleComprobante() + "|"
                        + detalleComprobante.getIdDetalleComprobante() + "|"
                        + detalleComprobante.getNombreProducto() + "|"
                        + detalleComprobante.getCantidadProducto() + "|"
                        + detalleComprobante.getPrecioProducto() + "|"
                        + detalleComprobante.getTotalProducto() + "|"
                        + detalleComprobante.getTotal().toPlainString() + "|"
                        + detalleComprobante.getCantidadProductoRegistrar() + "|");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    @Override
    public void create(DetalleComprobante detalleComprobante) {
        if (size == detalleComprobantes.length) {
            // Redimensionar el arreglo
            DetalleComprobante[] nuevoArreglo = new DetalleComprobante[size * 2];
            System.arraycopy(detalleComprobantes, 0, nuevoArreglo, 0, size);
            detalleComprobantes = nuevoArreglo;
        }

        detalleComprobante.setIdDetalleComprobante(secuenciaId);  // Asignar el idDetalleComprobante automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo

        detalleComprobantes[size] = detalleComprobante;
        size++;
        saveToFile();
    }

    @Override
    public DetalleComprobante read(short idDetalleComprobante) {
        for (int i = 0; i < size; i++) {
            if (detalleComprobantes[i].getNumeroBoletaDetalleComprobante() == (idDetalleComprobante)) {
                return detalleComprobantes[i];
            }
        }
        return null;
    }

    @Override
    public DetalleComprobante[] readAll() {
        DetalleComprobante[] activeArticles = new DetalleComprobante[size];
        System.arraycopy(detalleComprobantes, 0, activeArticles, 0, size);
        return activeArticles;
    }

    @Override
    public DetalleComprobante[] readAllWithCriteria(short criterio) {
        List<DetalleComprobante> matchingDetails = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (detalleComprobantes[i].getNumeroBoletaDetalleComprobante() == criterio) {
                matchingDetails.add(detalleComprobantes[i]);
            }
        }

        if (matchingDetails.isEmpty()) {
            return null; // Retorna null si no se encuentran detalles con el criterio especificado
        } else {
            return matchingDetails.toArray(new DetalleComprobante[0]);
        }
    }

    @Override
    public DetalleComprobante[] readAllWithOrder(Comparator criterio) {
        DetalleComprobante[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }

    // UPDATE
    @Override
    public boolean update(int idDetalleComprobante, DetalleComprobante updatedDetalleComprobante) {
        for (int i = 0; i < size; i++) {
            if (detalleComprobantes[i].getIdDetalleComprobante().equals(idDetalleComprobante)) {
                updatedDetalleComprobante.setIdDetalleComprobante(idDetalleComprobante);
                detalleComprobantes[i] = updatedDetalleComprobante;
                saveToFile();
                return true;
            }
        }
        return false;
    }
    
    

    // DELETE
    @Override
    public boolean delete(int idDetalleComprobante) {
        for (int i = 0; i < size; i++) {
            if (detalleComprobantes[i].getNumeroBoletaDetalleComprobante() == (idDetalleComprobante)) {
                // Desplazar los elementos restantes
                System.arraycopy(detalleComprobantes, i + 1, detalleComprobantes, i, size - i - 1);
                size--;
                saveToFile();
                return true;
            }
        }
        return false;
    }
}

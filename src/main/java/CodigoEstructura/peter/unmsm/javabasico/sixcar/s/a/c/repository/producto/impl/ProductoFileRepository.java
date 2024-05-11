/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.producto.impl;

import peter.unmsm.javabasico.sixcar.s.a.c.repository.producto.impl.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import peter.unmsm.javabasico.sixcar.s.a.c.domain.Producto;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.producto.ProductoRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Producto
 *
 *
 */
public class ProductoFileRepository implements ProductoRepository {

    private static final String RUTA_ARCHIVO = "productos.txt";
    public static final int TAMANIO_INICIAL = 10;
    private static Producto[] productos = new Producto[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idProductoes

    // Constructor
    public ProductoFileRepository() {
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
                if (size >= productos.length) {
                    productos = Arrays.copyOf(productos, productos.length * 2);
                }

                String line = scanner.nextLine();
                String[] fields = line.split("\\|");
                Producto producto = new Producto();
                producto.setIdProducto(Integer.valueOf(fields[0]));
                producto.setCodigo(fields[1]);
                producto.setNombre(fields[2]);
                producto.setTipoProducto(fields[3]);
                producto.setTipoBoca(fields[4]);
                producto.setTipoManguera(fields[5]);
                producto.setTipo(fields[6]);
                producto.setTamaño(Double.parseDouble(fields[7]));
                producto.setPrecioMenor(Float.parseFloat(fields[8]));
                producto.setPrecioInstalado(Float.parseFloat(fields[9]));
                producto.setPrecioMayor(Float.parseFloat(fields[10]));
                producto.setAnio(fields[11]);
                producto.setStock(Integer.parseInt(fields[12]));
                producto.setMarca(fields[13]);
                productos[size++] = producto;
                if (secuenciaId <= producto.getIdProducto()) {
                    secuenciaId = producto.getIdProducto() + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() { //try with resources //AutoCloseable
        try (PrintWriter out = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (int i = 0; i < size; i++) {
                Producto producto = productos[i];
                out.println(producto.getIdProducto() + "|"
                        + producto.getCodigo()+ "|"
                        + producto.getNombre()+ "|"
                        + producto.getTipoProducto()+ "|"
                        + producto.getTipoBoca()+ "|"
                        + producto.getTipoManguera()+ "|"
                        + producto.getTipo()+ "|"
                        + producto.getTamaño()+ "|"
                        + producto.getPrecioMenor()+ "|"
                        + producto.getPrecioInstalado()+ "|"
                        + producto.getPrecioMayor()+ "|"
                        + producto.getAnio()+ "|"
                        + producto.getStock()+ "|"
                        + producto.getMarca());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    @Override
    public void create(Producto producto) {
        if (size == productos.length) {
            // Redimensionar el arreglo
            Producto[] nuevoArreglo = new Producto[size * 2];
            System.arraycopy(productos, 0, nuevoArreglo, 0, size);
            productos = nuevoArreglo;
        }

        producto.setIdProducto(secuenciaId);  // Asignar el idProducto automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo

        productos[size] = producto;
        size++;
        saveToFile();
    }

    @Override
    public Producto read(String idProducto) {
        for (int i = 0; i < size; i++) {
            if (productos[i].getCodigo().equals(idProducto)) {
                return productos[i];
            }
        }
        return null;
    }

    @Override
    public Producto[] readAll() {
        Producto[] activeArticles = new Producto[size];
        System.arraycopy(productos, 0, activeArticles, 0, size);
        return activeArticles;
    }

    @Override
    public Producto[] readAllWithOrder(Comparator criterio) {
        Producto[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }

    // UPDATE
    @Override
    public boolean update(String idProducto, Producto updatedProducto) {
        for (int i = 0; i < size; i++) {
            if (productos[i].getCodigo().equals(idProducto)) {
//                updatedProducto.setCodigo(idProducto);
                productos[i] = updatedProducto;
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(String idProducto) {
        for (int i = 0; i < size; i++) {
            if (productos[i].getCodigo().equals(idProducto)) {
                // Desplazar los elementos restantes
                System.arraycopy(productos, i + 1, productos, i, size - i - 1);
                size--;
                saveToFile();
                return true;
            }
        }
        return false;
    }
}

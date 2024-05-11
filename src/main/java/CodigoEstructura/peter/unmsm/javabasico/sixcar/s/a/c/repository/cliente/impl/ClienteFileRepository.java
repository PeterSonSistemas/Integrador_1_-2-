/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.cliente.impl;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import peter.unmsm.javabasico.sixcar.s.a.c.domain.Cliente;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.cliente.ClienteRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Cliente
 *
 *
 */
public class ClienteFileRepository implements ClienteRepository {

    private static final String RUTA_ARCHIVO = "clientes.txt";
    public static final int TAMANIO_INICIAL = 10;
    private static Cliente[] clientes = new Cliente[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idClientees

    // Constructor
    public ClienteFileRepository() {
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
                if (size >= clientes.length) {
                    clientes = Arrays.copyOf(clientes, clientes.length * 2);
                }

                String line = scanner.nextLine();
                String[] fields = line.split("\\|");
                Cliente cliente = new Cliente();
                cliente.setNumeroBoletaCliente(Integer.parseInt(fields[0]));
                cliente.setIdCliente(Integer.valueOf(fields[1]));
                cliente.setTipoDocumento(fields[2]);
                cliente.setNumeroDocumento(fields[3]);
                cliente.setTelefono(fields[4]);
                cliente.setRUC(fields[5]);
                clientes[size++] = cliente;
                if (secuenciaId <= cliente.getIdCliente()) {
                    secuenciaId = cliente.getIdCliente() + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() { //try with resources //AutoCloseable
        try (PrintWriter out = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (int i = 0; i < size; i++) {
                Cliente cliente = clientes[i];
                out.println(cliente.getNumeroBoletaCliente()+ "|"
                        +cliente.getIdCliente()+ "|"
                        + cliente.getTipoDocumento()+ "|"
                        + cliente.getNumeroDocumento()+ "|"
                        + cliente.getTelefono()+ "|"
                        + cliente.getRUC());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    @Override
    public void create(Cliente cliente) {
        if (size == clientes.length) {
            // Redimensionar el arreglo
            Cliente[] nuevoArreglo = new Cliente[size * 2];
            System.arraycopy(clientes, 0, nuevoArreglo, 0, size);
            clientes = nuevoArreglo;
        }

        cliente.setIdCliente(secuenciaId);  // Asignar el idCliente automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo

        clientes[size] = cliente;
        size++;
        saveToFile();
    }

    @Override
    public Cliente read(int idCliente) {
        for (int i = 0; i < size; i++) {
            if (clientes[i].getNumeroBoletaCliente() == (idCliente)) {
                return clientes[i];
            }
        }
        return null;
    }

    @Override
    public Cliente[] readAll() {
        Cliente[] activeArticles = new Cliente[size];
        System.arraycopy(clientes, 0, activeArticles, 0, size);
        return activeArticles;
    }

    @Override
    public Cliente[] readAllWithOrder(Comparator criterio) {
        Cliente[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }

    // UPDATE
    @Override
    public boolean update(int idCliente, Cliente updatedCliente) {
        for (int i = 0; i < size; i++) {
            if (clientes[i].getIdCliente() == (idCliente)) {
                updatedCliente.setIdCliente(idCliente);
                clientes[i] = updatedCliente;
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idCliente) {
        for (int i = 0; i < size; i++) {
            if (clientes[i].getIdCliente().equals(idCliente)) {
                // Desplazar los elementos restantes
                System.arraycopy(clientes, i + 1, clientes, i, size - i - 1);
                size--;
                saveToFile();
                return true;
            }
        }
        return false;
    }
}

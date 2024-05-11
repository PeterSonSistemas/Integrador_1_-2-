/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.empleado.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import domain.Empleado;
import repository.empleado.EmpleadoRepository;
/**
 *
 * 
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Empleado
 *
 *
 */
public class EmpleadoFileRepository implements EmpleadoRepository {

    private static final String RUTA_ARCHIVO = "empleado.txt";
    public static final int TAMANIO_INICIAL = 10;
    private static Empleado[] alarmas = new Empleado[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idEmpleadoes

    // Constructor
    public EmpleadoFileRepository() {
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
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(Integer.valueOf(fields[0]));
                empleado.setCodigo(fields[1]);
                empleado.setNombre(fields[2]);
                empleado.setApellido(fields[3]);
                empleado.setSexo(fields[4]);
                empleado.setDni(fields[5]);
                empleado.setNumeroContacto(fields[6]);
                empleado.setEstado(fields[7]);
                alarmas[size++] = empleado;
                if (secuenciaId <= empleado.getIdEmpleado()) {
                    secuenciaId = empleado.getIdEmpleado() + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() { //try with resources //AutoCloseable
        try (PrintWriter out = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (int i = 0; i < size; i++) {
                Empleado empleado = alarmas[i];
                out.println(empleado.getIdEmpleado() + "|"
                        + empleado.getCodigo()+ "|" 
                        + empleado.getNombre()+ "|" 
                        + empleado.getApellido()+ "|" 
                        + empleado.getSexo()+ "|" 
                        + empleado.getDni()+ "|" 
                        + empleado.getNumeroContacto()+ "|" 
                        + empleado.getEstado());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    @Override
    public void create(Empleado empleado) {
        if (size == alarmas.length) {
            // Redimensionar el arreglo
            Empleado[] nuevoArreglo = new Empleado[size * 2];
            System.arraycopy(alarmas, 0, nuevoArreglo, 0, size);
            alarmas = nuevoArreglo;
        }

        empleado.setIdEmpleado(secuenciaId);  // Asignar el idEmpleado automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo

        alarmas[size] = empleado;
        size++;
        saveToFile();
    }

    @Override
    public Empleado read(int idEmpleado) {
        for (int i = 0; i < size; i++) {
            if (alarmas[i].getIdEmpleado().equals(idEmpleado)) {
                return alarmas[i];
            }
        }
        return null;
    }

    @Override
    public Empleado[] readAll() {
        Empleado[] activeArticles = new Empleado[size];
        System.arraycopy(alarmas, 0, activeArticles, 0, size);
        return activeArticles;
    }

    @Override
    public Empleado[] readAllWithOrder(Comparator criterio) {
        Empleado[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }

    // UPDATE
    @Override
    public boolean update(int idEmpleado, Empleado updatedEmpleado) {
        for (int i = 0; i < size; i++) {
            if (alarmas[i].getIdEmpleado().equals(idEmpleado)) {
                updatedEmpleado.setIdEmpleado(idEmpleado);
                alarmas[i] = updatedEmpleado;
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idEmpleado) {
        for (int i = 0; i < size; i++) {
            if (alarmas[i].getIdEmpleado().equals(idEmpleado)) {
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

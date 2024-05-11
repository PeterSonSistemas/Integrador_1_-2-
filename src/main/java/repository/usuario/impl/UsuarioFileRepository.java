/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.usuario.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import domain.Usuario;
import repository.usuario.UsuarioRepository;

/**
 *
 * 
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Usuario
 *
 *
 */
public class UsuarioFileRepository implements UsuarioRepository {

    private static final String RUTA_ARCHIVO = "usuarios.txt";
    public static final int TAMANIO_INICIAL = 10;
    private static Usuario[] usuarios = new Usuario[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idUsuarioes

    // Constructor
    public UsuarioFileRepository() {
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
                if (size >= usuarios.length) {
                    usuarios = Arrays.copyOf(usuarios, usuarios.length * 2);
                }

                String line = scanner.nextLine();
                String[] fields = line.split("\\|");
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(Integer.valueOf(fields[0]));
                usuario.setNombreUsuario(fields[1]);
                usuario.setContraseña(fields[2]);
                usuarios[size++] = usuario;
                if (secuenciaId <= usuario.getIdUsuario()) {
                    secuenciaId = usuario.getIdUsuario() + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() { //try with resources //AutoCloseable
        try (PrintWriter out = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (int i = 0; i < size; i++) {
                Usuario usuario = usuarios[i];
                out.println(usuario.getIdUsuario() + "|" 
                        + usuario.getNombreUsuario() + "|" 
                        + usuario.getContraseña());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    @Override
    public void create(Usuario usuario) {
        if (size == usuarios.length) {
            // Redimensionar el arreglo
            Usuario[] nuevoArreglo = new Usuario[size * 2];
            System.arraycopy(usuarios, 0, nuevoArreglo, 0, size);
            usuarios = nuevoArreglo;
        }

        usuario.setIdUsuario(secuenciaId);  // Asignar el idUsuario automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo

        usuarios[size] = usuario;
        size++;
        saveToFile();
    }

    @Override
    public Usuario read(int idUsuario) {
        for (int i = 0; i < size; i++) {
            if (usuarios[i].getIdUsuario().equals(idUsuario)) {
                return usuarios[i];
            }
        }
        return null;
    }

    @Override
    public Usuario[] readAll() {
        Usuario[] activeArticles = new Usuario[size];
        System.arraycopy(usuarios, 0, activeArticles, 0, size);
        return activeArticles;
    }

    @Override
    public Usuario[] readAllWithOrder(Comparator criterio) {
        Usuario[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }

    // UPDATE
    @Override
    public boolean update(int idUsuario, Usuario updatedUsuario) {
        for (int i = 0; i < size; i++) {
            if (usuarios[i].getIdUsuario().equals(idUsuario)) {
                updatedUsuario.setIdUsuario(idUsuario);
                usuarios[i] = updatedUsuario;
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idUsuario) {
        for (int i = 0; i < size; i++) {
            if (usuarios[i].getIdUsuario().equals(idUsuario)) {
                // Desplazar los elementos restantes
                System.arraycopy(usuarios, i + 1, usuarios, i, size - i - 1);
                size--;
                saveToFile();
                return true;
            }
        }
        return false;
    }
}

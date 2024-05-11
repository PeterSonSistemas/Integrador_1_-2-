/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.usuario.impl;

import java.util.Arrays;
import java.util.Comparator;
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
public class UsuarioArrayRepository implements UsuarioRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static Usuario[] usuarios = new Usuario[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idUsuarioes

    
    
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
    }

    @Override
    public Usuario read(int idUsuario) {
        for (int i = 0; i < size; i++) {
            if (usuarios[i].getIdUsuario() == idUsuario) {
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
            if (usuarios[i].getIdUsuario() == idUsuario) {
                updatedUsuario.setIdUsuario(idUsuario);
                usuarios[i] = updatedUsuario;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idUsuario) {
        for (int i = 0; i < size; i++) {
            if (usuarios[i].getIdUsuario() == idUsuario) {
                // Desplazar los elementos restantes
                System.arraycopy(usuarios, i + 1, usuarios, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }
}
  
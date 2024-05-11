/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.marca.impl;

import java.util.Arrays;
import java.util.Comparator;
import domain.Marca;
import repository.marca.MarcaRepository;
/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Marca
 *
 *
 */
public class MarcaArrayRepository implements MarcaRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static Marca[] marcas = new Marca[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idMarcaes

    
    
    // CREATE
    @Override
    public void create(Marca alarma) {
        if (size == marcas.length) {
            // Redimensionar el arreglo
            Marca[] nuevoArreglo = new Marca[size * 2];
            System.arraycopy(marcas, 0, nuevoArreglo, 0, size);
            marcas = nuevoArreglo;
        }
        
        alarma.setIdMarca(secuenciaId);  // Asignar el idMarca automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo
        
        marcas[size] = alarma;
        size++;
    }

    @Override
    public Marca read(int idMarca) {
        for (int i = 0; i < size; i++) {
            if (marcas[i].getIdMarca() == idMarca) {
                return marcas[i];
            }
        }
        return null;
    }

    @Override
    public Marca[] readAll() {
        Marca[] activeArticles = new Marca[size];
        System.arraycopy(marcas, 0, activeArticles, 0, size);
        return activeArticles;
    }
    
    @Override
    public Marca[] readAllWithOrder(Comparator criterio) {
        Marca[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }
    

    // UPDATE
    @Override
    public boolean update(int idMarca, Marca updatedMarca) {
        for (int i = 0; i < size; i++) {
            if (marcas[i].getIdMarca() == idMarca) {
                updatedMarca.setIdMarca(idMarca);
                marcas[i] = updatedMarca;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idMarca) {
        for (int i = 0; i < size; i++) {
            if (marcas[i].getIdMarca() == idMarca) {
                // Desplazar los elementos restantes
                System.arraycopy(marcas, i + 1, marcas, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }
}
  
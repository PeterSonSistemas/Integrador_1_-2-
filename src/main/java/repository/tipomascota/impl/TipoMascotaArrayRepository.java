/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.tipomascota.impl;

import java.util.Arrays;
import java.util.Comparator;
import domain.TipoMascota;
import repository.tipomascota.TipoMascotaRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase TipoMascota
 *
 *
 */
public class TipoMascotaArrayRepository implements TipoMascotaRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static TipoMascota[] tipoMascotas = new TipoMascota[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idTipoMascotaes

    
    
    // CREATE
    @Override
    public void create(TipoMascota tipoMascota) {
        if (size == tipoMascotas.length) {
            // Redimensionar el arreglo
            TipoMascota[] nuevoArreglo = new TipoMascota[size * 2];
            System.arraycopy(tipoMascotas, 0, nuevoArreglo, 0, size);
            tipoMascotas = nuevoArreglo;
        }
        
        tipoMascota.setIdTipoMascota(secuenciaId);  // Asignar el idTipoMascota automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo
        
        tipoMascotas[size] = tipoMascota;
        size++;
    }

    @Override
    public TipoMascota read(int idTipoMascota) {
        for (int i = 0; i < size; i++) {
            if (tipoMascotas[i].getIdTipoMascota() == idTipoMascota) {
                return tipoMascotas[i];
            }
        }
        return null;
    }

    @Override
    public TipoMascota[] readAll() {
        TipoMascota[] activeArticles = new TipoMascota[size];
        System.arraycopy(tipoMascotas, 0, activeArticles, 0, size);
        return activeArticles;
    }
    
    @Override
    public TipoMascota[] readAllWithOrder(Comparator criterio) {
        TipoMascota[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }
    

    // UPDATE
    @Override
    public boolean update(int idTipoMascota, TipoMascota updatedTipoMascota) {
        for (int i = 0; i < size; i++) {
            if (tipoMascotas[i].getIdTipoMascota() == idTipoMascota) {
                updatedTipoMascota.setIdTipoMascota(idTipoMascota);
                tipoMascotas[i] = updatedTipoMascota;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idTipoMascota) {
        for (int i = 0; i < size; i++) {
            if (tipoMascotas[i].getIdTipoMascota() == idTipoMascota) {
                // Desplazar los elementos restantes
                System.arraycopy(tipoMascotas, i + 1, tipoMascotas, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

}
  
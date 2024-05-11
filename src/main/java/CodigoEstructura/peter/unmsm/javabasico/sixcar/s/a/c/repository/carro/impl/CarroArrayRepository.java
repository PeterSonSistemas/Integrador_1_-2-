/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.carro.impl;

import java.util.Arrays;
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Carro;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.carro.CarroRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Carro
 *
 *
 */
public class CarroArrayRepository implements CarroRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static Carro[] carros = new Carro[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idCarroes

    
    
    // CREATE
    @Override
    public void create(Carro carro) {
        if (size == carros.length) {
            // Redimensionar el arreglo
            Carro[] nuevoArreglo = new Carro[size * 2];
            System.arraycopy(carros, 0, nuevoArreglo, 0, size);
            carros = nuevoArreglo;
        }
        
        carro.setIdCarro(secuenciaId);  // Asignar el idCarro automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo
        
        carros[size] = carro;
        size++;
    }

    @Override
    public Carro read(int idCarro) {
        for (int i = 0; i < size; i++) {
            if (carros[i].getIdCarro() == idCarro) {
                return carros[i];
            }
        }
        return null;
    }

    @Override
    public Carro[] readAll() {
        Carro[] activeArticles = new Carro[size];
        System.arraycopy(carros, 0, activeArticles, 0, size);
        return activeArticles;
    }
    
    @Override
    public Carro[] readAllWithOrder(Comparator criterio) {
        Carro[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }
    

    // UPDATE
    @Override
    public boolean update(int idCarro, Carro updatedCarro) {
        for (int i = 0; i < size; i++) {
            if (carros[i].getIdCarro() == idCarro) {
                updatedCarro.setIdCarro(idCarro);
                carros[i] = updatedCarro;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idCarro) {
        for (int i = 0; i < size; i++) {
            if (carros[i].getIdCarro() == idCarro) {
                // Desplazar los elementos restantes
                System.arraycopy(carros, i + 1, carros, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }
}
  
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.localproducto.impl;

import java.util.Arrays;
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.LocalProducto;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.localproducto.LocalProductoRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase LocalProducto
 *
 *
 */
public class LocalProductoArrayRepository implements LocalProductoRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static LocalProducto[] localProductos = new LocalProducto[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idLocalProductoes

    
    
    // CREATE
    @Override
    public void create(LocalProducto localProducto) {
        if (size == localProductos.length) {
            // Redimensionar el arreglo
            LocalProducto[] nuevoArreglo = new LocalProducto[size * 2];
            System.arraycopy(localProductos, 0, nuevoArreglo, 0, size);
            localProductos = nuevoArreglo;
        }
        
        localProducto.setIdLocalProducto(secuenciaId);  // Asignar el idLocalProducto automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo
        
        localProductos[size] = localProducto;
        size++;
    }

    @Override
    public LocalProducto read(int idLocalProducto) {
        for (int i = 0; i < size; i++) {
            if (localProductos[i].getIdLocalProducto() == idLocalProducto) {
                return localProductos[i];
            }
        }
        return null;
    }

    @Override
    public LocalProducto[] readAll() {
        LocalProducto[] activeArticles = new LocalProducto[size];
        System.arraycopy(localProductos, 0, activeArticles, 0, size);
        return activeArticles;
    }
    
    @Override
    public LocalProducto[] readAllWithOrder(Comparator criterio) {
        LocalProducto[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }
    

    // UPDATE
    @Override
    public boolean update(int idLocalProducto, LocalProducto updatedLocalProducto) {
        for (int i = 0; i < size; i++) {
            if (localProductos[i].getIdLocalProducto() == idLocalProducto) {
                updatedLocalProducto.setIdLocalProducto(idLocalProducto);
                localProductos[i] = updatedLocalProducto;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idLocalProducto) {
        for (int i = 0; i < size; i++) {
            if (localProductos[i].getIdLocalProducto() == idLocalProducto) {
                // Desplazar los elementos restantes
                System.arraycopy(localProductos, i + 1, localProductos, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }
}
  
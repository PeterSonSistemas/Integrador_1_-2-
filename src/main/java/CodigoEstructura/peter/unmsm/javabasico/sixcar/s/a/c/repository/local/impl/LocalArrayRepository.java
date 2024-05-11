/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.local.impl;

import java.util.Arrays;
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Local;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.local.LocalRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Local
 *
 *
 */
public class LocalArrayRepository implements LocalRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static Local[] locals = new Local[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idLocales

    
    
    // CREATE
    @Override
    public void create(Local local) {
        if (size == locals.length) {
            // Redimensionar el arreglo
            Local[] nuevoArreglo = new Local[size * 2];
            System.arraycopy(locals, 0, nuevoArreglo, 0, size);
            locals = nuevoArreglo;
        }
        
        local.setIdLocal(secuenciaId);  // Asignar el idLocal automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo
        
        locals[size] = local;
        size++;
    }

    @Override
    public Local read(int idLocal) {
        for (int i = 0; i < size; i++) {
            if (locals[i].getIdLocal() == idLocal) {
                return locals[i];
            }
        }
        return null;
    }

    @Override
    public Local[] readAll() {
        Local[] activeArticles = new Local[size];
        System.arraycopy(locals, 0, activeArticles, 0, size);
        return activeArticles;
    }
    
    @Override
    public Local[] readAllWithOrder(Comparator criterio) {
        Local[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }
    

    // UPDATE
    @Override
    public boolean update(int idLocal, Local updatedLocal) {
        for (int i = 0; i < size; i++) {
            if (locals[i].getIdLocal() == idLocal) {
                updatedLocal.setIdLocal(idLocal);
                locals[i] = updatedLocal;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idLocal) {
        for (int i = 0; i < size; i++) {
            if (locals[i].getIdLocal() == idLocal) {
                // Desplazar los elementos restantes
                System.arraycopy(locals, i + 1, locals, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }
}
  
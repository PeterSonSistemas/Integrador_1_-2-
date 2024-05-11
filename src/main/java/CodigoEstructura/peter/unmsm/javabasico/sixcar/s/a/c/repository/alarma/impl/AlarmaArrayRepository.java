/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.alarma.impl;

import java.util.Arrays;
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Alarma;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.alarma.AlarmaRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Alarma
 *
 *
 */
public class AlarmaArrayRepository implements AlarmaRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static Alarma[] alarmas = new Alarma[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idAlarmaes

    
    
    // CREATE
    @Override
    public void create(Alarma alarma) {
        if (size == alarmas.length) {
            // Redimensionar el arreglo
            Alarma[] nuevoArreglo = new Alarma[size * 2];
            System.arraycopy(alarmas, 0, nuevoArreglo, 0, size);
            alarmas = nuevoArreglo;
        }
        
        alarma.setIdAlarma(secuenciaId);  // Asignar el idAlarma automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo
        
        alarmas[size] = alarma;
        size++;
    }

    @Override
    public Alarma read(int idAlarma) {
        for (int i = 0; i < size; i++) {
            if (alarmas[i].getIdAlarma() == idAlarma) {
                return alarmas[i];
            }
        }
        return null;
    }

    @Override
    public Alarma[] readAll() {
        Alarma[] activeArticles = new Alarma[size];
        System.arraycopy(alarmas, 0, activeArticles, 0, size);
        return activeArticles;
    }
    
    @Override
    public Alarma[] readAllWithOrder(Comparator criterio) {
        Alarma[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }
    

    // UPDATE
    @Override
    public boolean update(int idAlarma, Alarma updatedAlarma) {
        for (int i = 0; i < size; i++) {
            if (alarmas[i].getIdAlarma() == idAlarma) {
                updatedAlarma.setIdAlarma(idAlarma);
                alarmas[i] = updatedAlarma;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idAlarma) {
        for (int i = 0; i < size; i++) {
            if (alarmas[i].getIdAlarma() == idAlarma) {
                // Desplazar los elementos restantes
                System.arraycopy(alarmas, i + 1, alarmas, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }
}
  
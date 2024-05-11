/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.comprobante.impl;

import java.util.Arrays;
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Comprobante;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.comprobante.ComprobanteRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Comprobante
 *
 *
 */
public class ComprobanteArrayRepository implements ComprobanteRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static Comprobante[] Comprobantes = new Comprobante[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar identificadores

    
    
    // CREATE
    @Override
    public void create(Comprobante Comprobante) {
        if (size == Comprobantes.length) {
            // Redimensionar el arreglo
            Comprobante[] nuevoArreglo = new Comprobante[size * 2];
            System.arraycopy(Comprobantes, 0, nuevoArreglo, 0, size);
            Comprobantes = nuevoArreglo;
        }
        
        Comprobante.setNumeroBoleta(secuenciaId);  // Asignar el identificador automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo
        
        Comprobantes[size] = Comprobante;
        size++;
    }

    @Override
    public Comprobante read(int identificador) {
        for (int i = 0; i < size; i++) {
            if (Comprobantes[i].getNumeroBoleta()== identificador) {
                return Comprobantes[i];
            }
        }
        return null;
    }

    @Override
    public Comprobante[] readAll() {
        Comprobante[] activeArticles = new Comprobante[size];
        System.arraycopy(Comprobantes, 0, activeArticles, 0, size);
        return activeArticles;
    }
    
    @Override
    public Comprobante[] readAllWithOrder(Comparator criterio) {
        Comprobante[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }
    

    // UPDATE
    @Override
    public boolean update(int identificador, Comprobante updatedComprobante) {
        for (int i = 0; i < size; i++) {
            if (Comprobantes[i].getNumeroBoleta()== identificador) {
                updatedComprobante.setNumeroBoleta(identificador);
                Comprobantes[i] = updatedComprobante;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int identificador) {
        for (int i = 0; i < size; i++) {
            if (Comprobantes[i].getNumeroBoleta()== identificador) {
                // Desplazar los elementos restantes
                System.arraycopy(Comprobantes, i + 1, Comprobantes, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }
}
  
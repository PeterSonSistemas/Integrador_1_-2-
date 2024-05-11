/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.detallecomprobante.impl;

import java.util.Arrays;
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.DetalleComprobante;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.detallecomprobante.DetalleComprobanteRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase DetalleComprobante
 *
 *
 */
public class DetalleComprobanteArrayRepository implements DetalleComprobanteRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static DetalleComprobante[] detalleComprobantes = new DetalleComprobante[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idDetalleComprobantees

    
    
    // CREATE
    @Override
    public void create(DetalleComprobante detalleComprobante) {
        if (size == detalleComprobantes.length) {
            // Redimensionar el arreglo
            DetalleComprobante[] nuevoArreglo = new DetalleComprobante[size * 2];
            System.arraycopy(detalleComprobantes, 0, nuevoArreglo, 0, size);
            detalleComprobantes = nuevoArreglo;
        }
        
        detalleComprobante.setIdDetalleComprobante(secuenciaId);  // Asignar el idDetalleComprobante automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo
        
        detalleComprobantes[size] = detalleComprobante;
        size++;
    }

    @Override
    public DetalleComprobante read(short idDetalleComprobante) {
        for (int i = 0; i < size; i++) {
            if (detalleComprobantes[i].getIdDetalleComprobante() == idDetalleComprobante) {
                return detalleComprobantes[i];
            }
        }
        return null;
    }

    @Override
    public DetalleComprobante[] readAll() {
        DetalleComprobante[] activeArticles = new DetalleComprobante[size];
        System.arraycopy(detalleComprobantes, 0, activeArticles, 0, size);
        return activeArticles;
    }
    
    @Override
    public DetalleComprobante[] readAllWithOrder(Comparator criterio) {
        DetalleComprobante[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }
    

    // UPDATE
    @Override
    public boolean update(int idDetalleComprobante, DetalleComprobante updatedDetalleComprobante) {
        for (int i = 0; i < size; i++) {
            if (detalleComprobantes[i].getIdDetalleComprobante() == idDetalleComprobante) {
                updatedDetalleComprobante.setIdDetalleComprobante(idDetalleComprobante);
                detalleComprobantes[i] = updatedDetalleComprobante;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idDetalleComprobante) {
        for (int i = 0; i < size; i++) {
            if (detalleComprobantes[i].getIdDetalleComprobante() == idDetalleComprobante) {
                // Desplazar los elementos restantes
                System.arraycopy(detalleComprobantes, i + 1, detalleComprobantes, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public DetalleComprobante[] readAllWithCriteria(short criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
  
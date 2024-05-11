/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.cliente.impl;

import java.util.Arrays;
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Cliente;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.cliente.ClienteRepository;

/**
 *
 * @author Timothy
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Cliente
 *
 *
 */
public class ClienteArrayRepository implements ClienteRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static Cliente[] clientes = new Cliente[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idClientees

    
    
    // CREATE
    @Override
    public void create(Cliente cliente) {
        if (size == clientes.length) {
            // Redimensionar el arreglo
            Cliente[] nuevoArreglo = new Cliente[size * 2];
            System.arraycopy(clientes, 0, nuevoArreglo, 0, size);
            clientes = nuevoArreglo;
        }
        
        cliente.setIdCliente(secuenciaId);  // Asignar el idCliente automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo
        
        clientes[size] = cliente;
        size++;
    }

    @Override
    public Cliente read(int idCliente) {
        for (int i = 0; i < size; i++) {
            if (clientes[i].getIdCliente() == idCliente) {
                return clientes[i];
            }
        }
        return null;
    }

    @Override
    public Cliente[] readAll() {
        Cliente[] activeArticles = new Cliente[size];
        System.arraycopy(clientes, 0, activeArticles, 0, size);
        return activeArticles;
    }
    
    @Override
    public Cliente[] readAllWithOrder(Comparator criterio) {
        Cliente[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }
    

    // UPDATE
    @Override
    public boolean update(int idCliente, Cliente updatedCliente) {
        for (int i = 0; i < size; i++) {
            if (clientes[i].getIdCliente() == idCliente) {
                updatedCliente.setIdCliente(idCliente);
                clientes[i] = updatedCliente;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idCliente) {
        for (int i = 0; i < size; i++) {
            if (clientes[i].getIdCliente() == idCliente) {
                // Desplazar los elementos restantes
                System.arraycopy(clientes, i + 1, clientes, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }
}
  
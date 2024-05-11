/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.producto.impl;

import java.util.Arrays;
import java.util.Comparator;
import domain.Producto;
import repository.producto.ProductoRepository;
/**
 *
 * 
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Producto
 *
 *
 */
public class ProductoArrayRepository implements ProductoRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static Producto[] productos = new Producto[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idProductoes

    
    
    // CREATE
    @Override
    public void create(Producto producto) {
        if (size == productos.length) {
            // Redimensionar el arreglo
            Producto[] nuevoArreglo = new Producto[size * 2];
            System.arraycopy(productos, 0, nuevoArreglo, 0, size);
            productos = nuevoArreglo;
        }
        
        producto.setIdProducto(secuenciaId);  // Asignar el idProducto automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo
        
        productos[size] = producto;
        size++;
    }

    @Override
    public Producto read(int idProducto) {
        for (int i = 0; i < size; i++) {
            if (productos[i].getIdProducto() == idProducto) {
                return productos[i];
            }
        }
        return null;
    }

    @Override
    public Producto[] readAll() {
        Producto[] activeArticles = new Producto[size];
        System.arraycopy(productos, 0, activeArticles, 0, size);
        return activeArticles;
    }
    
    @Override
    public Producto[] readAllWithOrder(Comparator criterio) {
        Producto[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }
    

    // UPDATE
    @Override
    public boolean update(int idProducto, Producto updatedProducto) {
        for (int i = 0; i < size; i++) {
            if (productos[i].getIdProducto() == idProducto) {
                updatedProducto.setIdProducto(idProducto);
                productos[i] = updatedProducto;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idProducto) {
        for (int i = 0; i < size; i++) {
            if (productos[i].getIdProducto() == idProducto) {
                // Desplazar los elementos restantes
                System.arraycopy(productos, i + 1, productos, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }
}
  
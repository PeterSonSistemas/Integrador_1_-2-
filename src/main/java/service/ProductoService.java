package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import CodigoEstructura.peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.orders.*;
import service.*;
import java.util.Comparator;
import domain.Producto;
import repository.producto.ProductoRepository;
import repository.producto.impl.ProductoArrayRepository;
import repository.producto.impl.ProductoFileRepository;
import util.Constantes;
import static util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class ProductoService {
    //variable de paquetes
    ProductoRepository productoRepository;

    //tipo de almacenamiento de datos
    public ProductoService() {
        switch (Constantes.TIPO_REPOSITORIO_ACTUAL) {
            case ARCHIVO -> productoRepository = new ProductoFileRepository();           
            case MEMORIA -> productoRepository = new ProductoArrayRepository();
            default -> throw new AssertionError();
        }
        
    }
    //==========================================================
    
    // CREATE producto
    public boolean adicionar(Producto producto) {
        // Validación de negocio
        if (producto.getNombre().isEmpty()
                && producto.getCodigo().isEmpty()
                && producto.getPrecioVenta() <= 0
                && producto.getStock() <= 0) {
            return false;
        }

        productoRepository.create(producto);
        return true;
    }
    //==========================================

    // READ ALL leer todo
    public Producto[] consultar() {
        return productoRepository.readAll();
    }
    //========================================
    
    // READ leer por id
    public Producto consultarPorId(int idConsultar) {
        return productoRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public Producto[] consultaPorCriterioOrden(Comparator criterio) {
        return productoRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    // UPDATE
    public boolean modificar(int identificador, Producto producto) {
        // Validación de negocio
        if (producto.getNombre().isEmpty()
                && producto.getCodigo().isEmpty()
                && producto.getPrecioVenta() <= 0
                && producto.getStock() <= 0) {
            return false;
        }

        return productoRepository.update(identificador, producto);
    }

    // DELETE
    public boolean eliminar(int identificador) {

        return productoRepository.delete(identificador);
    }
    
    

}

package peter.unmsm.javabasico.sixcar.s.a.c.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Producto;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.producto.ProductoRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.producto.impl.ProductoArrayRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.producto.impl.ProductoFileRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.util.Constantes;
import static peter.unmsm.javabasico.sixcar.s.a.c.util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class ProductoService {

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
        if (producto.getPrecioMenor()<= 0 
                && producto.getPrecioMayor() <= 0 
                && producto.getNombre().isEmpty() 
                && producto.getTipoProducto().isEmpty() 
                && producto.getMarca().isEmpty()
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
    public Producto consultarPorId(String idConsultar) {
        return productoRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public Producto[] consultaPorCriterioOrden(Comparator criterio) {
        return productoRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    // UPDATE
    public boolean modificar(String identificador, Producto producto) {
        // Validación de negocio
        if (producto.getPrecioMenor()<= 0 
                && producto.getPrecioMayor() <= 0 
                && producto.getNombre().isEmpty() 
                && producto.getCodigo().isEmpty() 
                && producto.getTipoProducto().isEmpty() 
                && producto.getPrecioInstalado() <= 0
                && producto.getMarca().isEmpty()
                && producto.getStock() <= 0) {
            return false;
        }

        return productoRepository.update(identificador, producto);
    }

    // DELETE
    public boolean eliminar(String identificador) {

        return productoRepository.delete(identificador);
    }
    
    

}

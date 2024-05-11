/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.producto;

import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Producto;

/**
 *
 * @author Timothy
 */
public interface ProductoRepository {

    void create(Producto producto);

    Producto read(String IdProducto);

    Producto[] readAll();

    Producto[] readAllWithOrder(Comparator criterio);

    boolean update(String IdProducto, Producto updatedProducto);

    boolean delete(String IdProducto);
    
    
    
    default boolean delete2(String IdProducto){
        return true;
    }
    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.producto;

import java.util.Comparator;
import domain.Producto;
/**
 *
 * 
 */
public interface ProductoRepository {

    void create(Producto producto);

    Producto read(int IdProducto);

    Producto[] readAll();

    Producto[] readAllWithOrder(Comparator criterio);

    boolean update(int IdProducto, Producto updatedProducto);

    boolean delete(int IdProducto);
    
    
    
    default boolean delete2(int IdProducto){
        return true;
    }
    

}

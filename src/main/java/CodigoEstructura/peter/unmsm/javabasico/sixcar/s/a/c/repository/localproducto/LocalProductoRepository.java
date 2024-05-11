/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.localproducto;

import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.LocalProducto;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.*;

/**
 *
 * @author Timothy
 */
public interface LocalProductoRepository {

    void create(LocalProducto localProducto);

    LocalProducto read(int IdLocalProducto);

    LocalProducto[] readAll();

    LocalProducto[] readAllWithOrder(Comparator criterio);

    boolean update(int IdLocalProducto, LocalProducto updatedLocalProducto);

    boolean delete(int IdLocalProducto);
    
    
    
    default boolean delete2(int IdLocalProducto){
        return true;
    }
    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.comprobante;

import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Comprobante;

/**
 *
 * @author Timothy
 */
public interface ComprobanteRepository {

    void create(Comprobante comprobante);

    Comprobante read(int NumeroComprobante);

    Comprobante[] readAll();

    Comprobante[] readAllWithOrder(Comparator criterio);

    boolean update(int NumeroComprobante, Comprobante updatedComprobante);

    boolean delete(int NumeroComprobante);
    
    
    
    default boolean delete2(int NumeroComprobante){
        return true;
    }
    

}

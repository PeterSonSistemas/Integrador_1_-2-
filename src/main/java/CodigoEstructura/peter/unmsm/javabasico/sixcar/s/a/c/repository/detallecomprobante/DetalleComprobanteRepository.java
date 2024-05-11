/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.detallecomprobante;

import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.DetalleComprobante;

/**
 *
 * @author Timothy
 */
public interface DetalleComprobanteRepository {

    void create(DetalleComprobante detalleComprobante);

    DetalleComprobante read(short IdDetalleComprobante);

    DetalleComprobante[] readAll();

    DetalleComprobante[] readAllWithOrder(Comparator criterio);
    
    DetalleComprobante[] readAllWithCriteria(short criterio);

    boolean update(int IdDetalleComprobante, DetalleComprobante updatedDetalleComprobante);

    boolean delete(int IdDetalleComprobante);
    
    
    
    default boolean delete2(int IdDetalleComprobante){
        return true;
    }
    

}

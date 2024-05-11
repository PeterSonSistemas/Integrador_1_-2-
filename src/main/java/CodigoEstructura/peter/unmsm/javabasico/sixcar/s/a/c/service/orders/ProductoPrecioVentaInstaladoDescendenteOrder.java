/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.service.orders;

import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Producto;

/**
 *
 * @author Timothy
 */
public class ProductoPrecioVentaInstaladoDescendenteOrder implements Comparator<Producto> {

    @Override
    public int compare(Producto o1, Producto o2) {
        
        Float O1 = o1.getPrecioInstalado();
        Float O2 = o2.getPrecioInstalado();
        
        return O2.compareTo(O1);
    }
    
}

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
public class ProductoTamañoOrder implements Comparator<Producto> {

    @Override
    public int compare(Producto o1, Producto o2) {
        
        Double O1 = o1.getTamaño();
        Double O2 = o2.getTamaño();
        
        return O1.compareTo(O2);
    }
    
}

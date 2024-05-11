/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.service.orders;

import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.DetalleComprobante;

/**
 *
 * @author Timothy
 */
public class DetalleComprobanteOrder implements Comparator<DetalleComprobante> {

    private int criterio;

    public DetalleComprobanteOrder(int criterio) {
        this.criterio = criterio;
    }

    @Override
    public int compare(DetalleComprobante o1, DetalleComprobante o2) {
        int numeroBoleta1 = o1.getNumeroBoletaDetalleComprobante();
        int numeroBoleta2 = o2.getNumeroBoletaDetalleComprobante();

        // Comparar con el criterio
        if (numeroBoleta1 == criterio && numeroBoleta2 != criterio) {
            return -1; // o1 va antes que o2
        } else if (numeroBoleta1 != criterio && numeroBoleta2 == criterio) {
            return 1; // o2 va antes que o1
        } else {
            return 0; // Son iguales en términos de ordenación
        }
    }
}


package peter.unmsm.javabasico.sixcar.s.a.c.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import peter.unmsm.javabasico.sixcar.s.a.c.service.orders.*;
import java.math.BigDecimal;
import peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.orders.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.DetalleComprobante;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.detallecomprobante.DetalleComprobanteRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.detallecomprobante.impl.DetalleComprobanteArrayRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.detallecomprobante.impl.DetalleComprobanteFileRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.util.Constantes;
import peter.unmsm.javabasico.sixcar.s.a.c.util.FormatoDate;
import static peter.unmsm.javabasico.sixcar.s.a.c.util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class DetalleComprobanteService {
    //variable de paquetes
    FormatoDate fd = new FormatoDate();
    
    DetalleComprobanteRepository detalleComprobanteRepository;

    //tipo de almacenamiento de datos
    public DetalleComprobanteService() {
        switch (Constantes.TIPO_REPOSITORIO_ACTUAL) {
            case ARCHIVO -> detalleComprobanteRepository = new DetalleComprobanteFileRepository();           
            case MEMORIA -> detalleComprobanteRepository = new DetalleComprobanteArrayRepository();
            default -> throw new AssertionError();
        }
        
    }
    //==========================================================
    
    // CREATE detalleComprobante
    public boolean adicionar(DetalleComprobante detalleComprobante) {
         //Validación de negocio
        if (detalleComprobante.getNombreProducto().isEmpty()
                && detalleComprobante.getPrecioProducto() <= 0
                && detalleComprobante.getCantidadProducto() <= 0
                && detalleComprobante.getCantidadProductoRegistrar()<= 0
                && detalleComprobante.getTotalProducto().compareTo(BigDecimal.ZERO) <= 0
                && detalleComprobante.getTotal().compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        detalleComprobanteRepository.create(detalleComprobante);
        return true;
    }
    //==========================================

    // READ ALL leer todo
    public DetalleComprobante[] consultar() {
        return detalleComprobanteRepository.readAll();
    }
    //========================================
    
    // READ leer por id
    public DetalleComprobante consultarPorId(short idConsultar) {
        return detalleComprobanteRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public DetalleComprobante[] consultaPorCriterioOrden(Comparator criterio) {
        return detalleComprobanteRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    public DetalleComprobante[] consiltarPorCriterio(short criterio){
        return detalleComprobanteRepository.readAllWithCriteria(criterio);
    }
    
    // UPDATE
    public boolean modificar(int identificador, DetalleComprobante detalleComprobante) {
         //Validación de negocio
        if (detalleComprobante.getNombreProducto().isEmpty()
                && detalleComprobante.getPrecioProducto() <= 0
                && detalleComprobante.getCantidadProducto() <= 0
                && detalleComprobante.getCantidadProductoRegistrar()<= 0
                && detalleComprobante.getTotalProducto().compareTo(BigDecimal.ZERO) <= 0
                && detalleComprobante.getTotal().compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        return detalleComprobanteRepository.update(identificador, detalleComprobante);
    }

    // DELETE
    public boolean eliminar(int identificador) {

        return detalleComprobanteRepository.delete(identificador);
    }
    
     public boolean eliminarDetalleComprobante(int identificador) {

        return detalleComprobanteRepository.delete(identificador);
    }
    
    

}

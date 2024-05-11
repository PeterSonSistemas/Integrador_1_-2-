package peter.unmsm.javabasico.sixcar.s.a.c.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Comprobante;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.comprobante.ComprobanteRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.comprobante.impl.ComprobanteArrayRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.comprobante.impl.ComprobanteFileRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.util.Constantes;
import peter.unmsm.javabasico.sixcar.s.a.c.util.FormatoDate;
import static peter.unmsm.javabasico.sixcar.s.a.c.util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class ComprobanteService {
    //variable de paquetes
    FormatoDate fd = new FormatoDate();
    
    ComprobanteRepository comprobanteRepository;

    //tipo de almacenamiento de datos
    public ComprobanteService() {
        switch (Constantes.TIPO_REPOSITORIO_ACTUAL) {
            case ARCHIVO -> comprobanteRepository = new ComprobanteFileRepository();           
            case MEMORIA -> comprobanteRepository = new ComprobanteArrayRepository();
            default -> throw new AssertionError();
        }
        
    }
    //==========================================================
    
    // CREATE comprobante
    public boolean adicionar(Comprobante comprobante) {
        // Validación de negocio
        if (comprobante.getTipoComprobante().isEmpty()
                && fd.FechaFormat(comprobante.getFecha()).isEmpty()) {
            return false;
        }

        comprobanteRepository.create(comprobante);
        return true;
    }
    //==========================================

    // READ ALL leer todo
    public Comprobante[] consultar() {
        return comprobanteRepository.readAll();
    }
    //========================================
    
    // READ leer por id
    public Comprobante consultarPorId(int idConsultar) {
        return comprobanteRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public Comprobante[] consultaPorCriterioOrden(Comparator criterio) {
        return comprobanteRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    // UPDATE
    public boolean modificar(int identificador, Comprobante comprobante) {
        // Validación de negocio
        if (comprobante.getTipoComprobante().isEmpty()
                && fd.FechaFormat(comprobante.getFecha()).isEmpty()) {
            return false;
        }

        return comprobanteRepository.update(identificador, comprobante);
    }

    // DELETE
    public boolean eliminar(int identificador) {

        return comprobanteRepository.delete(identificador);
    }
    
    

}

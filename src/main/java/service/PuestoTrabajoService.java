package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import CodigoEstructura.peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.orders.*;
import service.*;
import java.util.Comparator;
import domain.PuestoTrabajo;
import repository.puestotrabajo.PuestoTrabajoRepository;
import repository.puestotrabajo.impl.PuestoTrabajoArrayRepository;
import repository.puestoTrabajo.impl.PuestoTrabajoFileRepository;
import util.Constantes;
import util.FormatoDate;
import static util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class PuestoTrabajoService {
    //variable de paquetes
    PuestoTrabajoRepository puestoTrabajoRepository;

    //tipo de almacenamiento de datos
    public PuestoTrabajoService() {
        switch (Constantes.TIPO_REPOSITORIO_ACTUAL) {
            case ARCHIVO -> puestoTrabajoRepository = new PuestoTrabajoFileRepository();           
            case MEMORIA -> puestoTrabajoRepository = new PuestoTrabajoArrayRepository();
            default -> throw new AssertionError();
        }
        
    }
    //==========================================================
    
    // CREATE puestoTrabajo
    public boolean adicionar(PuestoTrabajo puestoTrabajo) {
        // Validación de negocio
        if (puestoTrabajo.getNombrePuesto().isEmpty()
                && puestoTrabajo.getDescripción().isEmpty()) {
            return false;
        }

        puestoTrabajoRepository.create(puestoTrabajo);
        return true;
    }
    //==========================================

    // READ ALL leer todo
    public PuestoTrabajo[] consultar() {
        return puestoTrabajoRepository.readAll();
    }
    //========================================
    
    // READ leer por id
    public PuestoTrabajo consultarPorId(int idConsultar) {
        return puestoTrabajoRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public PuestoTrabajo[] consultaPorCriterioOrden(Comparator criterio) {
        return puestoTrabajoRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    // UPDATE
    public boolean modificar(int identificador, PuestoTrabajo puestoTrabajo) {
        // Validación de negocio
        if (puestoTrabajo.getNombrePuesto().isEmpty()
                && puestoTrabajo.getDescripción().isEmpty()) {
            return false;
        }

        return puestoTrabajoRepository.update(identificador, puestoTrabajo);
    }

    // DELETE
    public boolean eliminar(int identificador) {

        return puestoTrabajoRepository.delete(identificador);
    }
    
    

}

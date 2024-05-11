package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import CodigoEstructura.peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.orders.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import java.util.Comparator;
import domain.Empleado;
import repository.empleado.EmpleadoRepository;
import repository.empleado.impl.EmpleadoArrayRepository;
import repository.empleado.impl.EmpleadoFileRepository;
import util.Constantes;
import util.FormatoDate;
import static util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class EmpleadoService {
    //variable de paquetes
    EmpleadoRepository empleadoRepository;

    //tipo de almacenamiento de datos
    public EmpleadoService() {
        switch (Constantes.TIPO_REPOSITORIO_ACTUAL) {
            case ARCHIVO -> empleadoRepository = new EmpleadoFileRepository();           
            case MEMORIA -> empleadoRepository = new EmpleadoArrayRepository();
            default -> throw new AssertionError();
        }
        
    }
    //==========================================================
    
    // CREATE empleado
    public boolean adicionar(Empleado empleado) {
        // Validación de negocio
        if (empleado.getCodigo().isEmpty()
                && empleado.getNombre().isEmpty()
                && empleado.getApellido().isEmpty()
                && empleado.getSexo().isEmpty()
                && empleado.getDni().isEmpty()
                && empleado.getNumeroContacto().isEmpty()
                && empleado.getEstado().isEmpty()) {
            return false;
        }

        empleadoRepository.create(empleado);
        return true;
    }
    //==========================================

    // READ ALL leer todo
    public Empleado[] consultar() {
        return empleadoRepository.readAll();
    }
    //========================================
    
    // READ leer por id
    public Empleado consultarPorId(int idConsultar) {
        return empleadoRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public Empleado[] consultaPorCriterioOrden(Comparator criterio) {
        return empleadoRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    // UPDATE
    public boolean modificar(int identificador, Empleado empleado) {
        // Validación de negocio
        if (empleado.getCodigo().isEmpty()
                && empleado.getNombre().isEmpty()
                && empleado.getApellido().isEmpty()
                && empleado.getSexo().isEmpty()
                && empleado.getDni().isEmpty()
                && empleado.getNumeroContacto().isEmpty()
                && empleado.getEstado().isEmpty()) {
            return false;
        }

        return empleadoRepository.update(identificador, empleado);
    }

    // DELETE
    public boolean eliminar(int identificador) {

        return empleadoRepository.delete(identificador);
    }
    
    

}

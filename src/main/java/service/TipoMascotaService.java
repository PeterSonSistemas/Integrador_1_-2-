package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import CodigoEstructura.peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.orders.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import java.util.Comparator;
import domain.TipoMascota;
import repository.tipomascota.TipoMascotaRepository;
import repository.tipomascota.impl.TipoMascotaArrayRepository;
import repository.tipoMascota.impl.TipoMascotaFileRepository;
import util.Constantes;
import static util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class TipoMascotaService {
    //variable de paquetes
    TipoMascotaRepository tipoMascotaRepository;

    //tipo de almacenamiento de datos
    public TipoMascotaService() {
        switch (Constantes.TIPO_REPOSITORIO_ACTUAL) {
            case ARCHIVO -> tipoMascotaRepository = new TipoMascotaFileRepository();           
            case MEMORIA -> tipoMascotaRepository = new TipoMascotaArrayRepository();
            default -> throw new AssertionError();
        }
        
    }
    //==========================================================
    
    // CREATE tipoMascota
    public boolean adicionar(TipoMascota tipoMascota) {
        // Validación de negocio
        if (tipoMascota.getMascota().isEmpty()) {
            return false;
        }

        tipoMascotaRepository.create(tipoMascota);
        return true;
    }
    //==========================================

    // READ ALL leer todo
    public TipoMascota[] consultar() {
        return tipoMascotaRepository.readAll();
    }
    //========================================
    
    // READ leer por id
    public TipoMascota consultarPorId(int idConsultar) {
        return tipoMascotaRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public TipoMascota[] consultaPorCriterioOrden(Comparator criterio) {
        return tipoMascotaRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    // UPDATE
    public boolean modificar(int identificador, TipoMascota tipoMascota) {
        // Validación de negocio
        if (tipoMascota.getMascota().isEmpty()) {
            return false;
        }

        return tipoMascotaRepository.update(identificador, tipoMascota);
    }

    // DELETE
    public boolean eliminar(int identificador) {

        return tipoMascotaRepository.delete(identificador);
    }
    
    

}

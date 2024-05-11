package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import CodigoEstructura.peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.orders.*;
import service.*;
import java.util.Comparator;
import domain.Marca;
import repository.marca.MarcaRepository;
import repository.marca.impl.MarcaArrayRepository;
import repository.marca.impl.MarcaFileRepository;
import util.Constantes;
import util.FormatoDate;
import static util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class MarcaService {
    //variable de paquetes
    MarcaRepository marcaRepository;

    //tipo de almacenamiento de datos
    public MarcaService() {
        switch (Constantes.TIPO_REPOSITORIO_ACTUAL) {
            case ARCHIVO -> marcaRepository = new MarcaFileRepository();           
            case MEMORIA -> marcaRepository = new MarcaArrayRepository();
            default -> throw new AssertionError();
        }
        
    }
    //==========================================================
    
    // CREATE marca
    public boolean adicionar(Marca marca) {
        // Validación de negocio
        if (marca.getMarca().isEmpty()) {
            return false;
        }

        marcaRepository.create(marca);
        return true;
    }
    //==========================================

    // READ ALL leer todo
    public Marca[] consultar() {
        return marcaRepository.readAll();
    }
    //========================================
    
    // READ leer por id
    public Marca consultarPorId(int idConsultar) {
        return marcaRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public Marca[] consultaPorCriterioOrden(Comparator criterio) {
        return marcaRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    // UPDATE
    public boolean modificar(int identificador, Marca marca) {
        // Validación de negocio
        if (marca.getMarca().isEmpty()) {
            return false;
        }

        return marcaRepository.update(identificador, marca);
    }

    // DELETE
    public boolean eliminar(int identificador) {

        return marcaRepository.delete(identificador);
    }
    
    

}

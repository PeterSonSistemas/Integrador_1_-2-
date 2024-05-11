package peter.unmsm.javabasico.sixcar.s.a.c.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import peter.unmsm.javabasico.sixcar.s.a.c.service.orders.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Carro;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.carro.CarroRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.carro.impl.CarroArrayRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.carro.impl.CarroFileRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.util.Constantes;
import peter.unmsm.javabasico.sixcar.s.a.c.util.FormatoDate;
import static peter.unmsm.javabasico.sixcar.s.a.c.util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class CarroService {
    //variable de paquetes
    FormatoDate fd = new FormatoDate();
    
    CarroRepository carroRepository;

    //tipo de almacenamiento de datos
    public CarroService() {
        switch (Constantes.TIPO_REPOSITORIO_ACTUAL) {
            case ARCHIVO -> carroRepository = new CarroFileRepository();           
            case MEMORIA -> carroRepository = new CarroArrayRepository();
            default -> throw new AssertionError();
        }
        
    }
    //==========================================================
    
    // CREATE carro
    public boolean adicionar(Carro carro) {
        // Validación de negocio
//        if (carro.getTipoCarro().isEmpty()
//                && fd.FechaFormat(carro.getFecha()).isEmpty()) {
//            return false;
//        }

        carroRepository.create(carro);
        return true;
    }
    //==========================================

    // READ ALL leer todo
    public Carro[] consultar() {
        return carroRepository.readAll();
    }
    //========================================
    
    // READ leer por id
    public Carro consultarPorId(int idConsultar) {
        return carroRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public Carro[] consultaPorCriterioOrden(Comparator criterio) {
        return carroRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    // UPDATE
    public boolean modificar(int identificador, Carro carro) {
        // Validación de negocio
//        if (carro.getTipoCarro().isEmpty()
//                && fd.FechaFormat(carro.getFecha()).isEmpty()) {
//            return false;
//        }

        return carroRepository.update(identificador, carro);
    }

    // DELETE
    public boolean eliminar(int identificador) {

        return carroRepository.delete(identificador);
    }
    
    

}

package peter.unmsm.javabasico.sixcar.s.a.c.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Local;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.local.LocalRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.local.impl.LocalArrayRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.local.impl.LocalFileRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.util.Constantes;
import static peter.unmsm.javabasico.sixcar.s.a.c.util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class LocalService {

    LocalRepository localRepository;

    //tipo de almacenamiento de datos
    public LocalService() {
        switch (Constantes.TIPO_REPOSITORIO_ACTUAL) {
            case ARCHIVO -> localRepository = new LocalFileRepository();           
            case MEMORIA -> localRepository = new LocalArrayRepository();
            default -> throw new AssertionError();
        }
        
    }
    //==========================================================
    
    // CREATE local
    public boolean adicionar(Local local) {
        // Validación de negocio
        if (local.getDireccion().isEmpty()
                && local.getNombre().isEmpty()
                && local.getNumero()<=0) {
            return false;
        }

        localRepository.create(local);
        return true;
    }
    //==========================================

    // READ ALL leer todo
    public Local[] consultar() {
        return localRepository.readAll();
    }
    //========================================
    
    // READ leer por id
    public Local consultarPorId(int idConsultar) {
        return localRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public Local[] consultaPorCriterioOrden(Comparator criterio) {
        return localRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    // UPDATE
    public boolean modificar(int identificador, Local local) {
        // Validación de negocio
        if (local.getDireccion().isEmpty()
                && local.getNombre().isEmpty()
                && local.getNumero() <= 0) {
            return false;
        }

        return localRepository.update(identificador, local);
    }

    // DELETE
    public boolean eliminar(int identificador) {

        return localRepository.delete(identificador);
    }
    
    

}

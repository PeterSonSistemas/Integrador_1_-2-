/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.local;

import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Local;

/**
 *
 * @author Timothy
 */
public interface LocalRepository {

    void create(Local local);

    Local read(int IdLocal);

    Local[] readAll();

    Local[] readAllWithOrder(Comparator criterio);

    boolean update(int IdLocal, Local updatedLocal);

    boolean delete(int IdLocal);
    
    
    
    default boolean delete2(int IdLocal){
        return true;
    }
    

}

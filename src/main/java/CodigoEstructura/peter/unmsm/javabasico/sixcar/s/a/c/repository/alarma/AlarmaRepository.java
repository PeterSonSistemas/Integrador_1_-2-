/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.alarma;

import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Alarma;

/**
 *
 * @author Timothy
 */
public interface AlarmaRepository {

    void create(Alarma alarma);

    Alarma read(int IdAlarma);

    Alarma[] readAll();

    Alarma[] readAllWithOrder(Comparator criterio);

    boolean update(int IdAlarma, Alarma updatedAlarma);

    boolean delete(int IdAlarma);
    
    
    
    default boolean delete2(int IdAlarma){
        return true;
    }
    

}

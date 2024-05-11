/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.puestotrabajo;

import java.util.Comparator;
import domain.PuestoTrabajo;
/**
 *
 * @author Timothy
 */
public interface PuestoTrabajoRepository {

    void create(PuestoTrabajo puestotrabajo);

    PuestoTrabajo read(int IdPuestoTrabajo);

    PuestoTrabajo[] readAll();

    PuestoTrabajo[] readAllWithOrder(Comparator criterio);

    boolean update(int IdPuestoTrabajo, PuestoTrabajo updatedPuestoTrabajo);

    boolean delete(int IdPuestoTrabajo);
    
    
    
    default boolean delete2(int IdPuestoTrabajo){
        return true;
    }
    

}

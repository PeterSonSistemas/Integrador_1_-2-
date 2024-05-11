/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.tipomascota;
import java.util.Comparator;
import domain.TipoMascota;
/**
 *
 * @author Timothy
 */
public interface TipoMascotaRepository {

    void create(TipoMascota tipomascota);

    TipoMascota read(int IdTipoMascota);

    TipoMascota[] readAll();

    TipoMascota[] readAllWithOrder(Comparator criterio);

    boolean update(int IdTipoMascota, TipoMascota updatedTipoMascota);

    boolean delete(int IdTipoMascota);
    
    
    
    default boolean delete2(int IdTipoMascota){
        return true;
    }
    

}

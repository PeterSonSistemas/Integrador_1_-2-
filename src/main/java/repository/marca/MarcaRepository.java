/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.marca;

import java.util.Comparator;
import domain.Marca;
/**
 *
 * @author Timothy
 */
public interface MarcaRepository {

    void create(Marca marca);

    Marca read(int IdMarca);

    Marca[] readAll();

    Marca[] readAllWithOrder(Comparator criterio);

    boolean update(int IdMarca, Marca updatedMarca);

    boolean delete(int IdMarca);
    
    
    
    default boolean delete2(int IdMarca){
        return true;
    }
    

}

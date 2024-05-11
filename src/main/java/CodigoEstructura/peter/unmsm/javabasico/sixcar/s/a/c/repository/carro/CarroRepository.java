/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.carro;

import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Carro;

/**
 *
 * @author Timothy
 */
public interface CarroRepository {

    void create(Carro carro);

    Carro read(int IdCarro);

    Carro[] readAll();

    Carro[] readAllWithOrder(Comparator criterio);

    boolean update(int IdCarro, Carro updatedCarro);

    boolean delete(int IdCarro);
    
    
    
    default boolean delete2(int IdCarro){
        return true;
    }
    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.repository.cliente;

import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Cliente;

/**
 *
 * @author Timothy
 */
public interface ClienteRepository {

    void create(Cliente cliente);

    Cliente read(int IdCliente);

    Cliente[] readAll();

    Cliente[] readAllWithOrder(Comparator criterio);

    boolean update(int IdCliente, Cliente updatedCliente);

    boolean delete(int IdCliente);
    
    
    default boolean delete2(int IdCliente){
        return true;
    }
    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.usuario;

import java.util.Comparator;
import domain.Usuario;
/**
 *
 * @author Timothy
 */
public interface UsuarioRepository {

    void create(Usuario usuario);

    Usuario read(int IdUsuario);

    Usuario[] readAll();

    Usuario[] readAllWithOrder(Comparator criterio);

    boolean update(int IdUsuario, Usuario updatedUsuario);

    boolean delete(int IdUsuario);
    
    
    
    default boolean delete2(int IdUsuario){
        return true;
    }
    

}

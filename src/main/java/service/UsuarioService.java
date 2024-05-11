package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Comparator;
import domain.Usuario;
import repository.usuario.UsuarioRepository;
import repository.usuario.impl.UsuarioArrayRepository;
import repository.usuario.impl.UsuarioFileRepository;
import util.Constantes;
import util.FormatoDate;
import static util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class UsuarioService {
    //variable de paquetes
    UsuarioRepository usuarioRepository;

    //tipo de almacenamiento de datos
    public UsuarioService() {
        switch (Constantes.TIPO_REPOSITORIO_ACTUAL) {
            case ARCHIVO -> usuarioRepository = new UsuarioFileRepository();           
            case MEMORIA -> usuarioRepository = new UsuarioArrayRepository();
            default -> throw new AssertionError();
        }
        
    }
    //==========================================================
    
    // CREATE usuario
    public boolean adicionar(Usuario usuario) {
        // Validación de negocio
        if (usuario.getNombreUsuario().isEmpty()
                && usuario.getContraseña().isEmpty()) {
            return false;
        }

        usuarioRepository.create(usuario);
        return true;
    }
    //==========================================

    // READ ALL leer todo
    public Usuario[] consultar() {
        return usuarioRepository.readAll();
    }
    //========================================
    
    // READ leer por id
    public Usuario consultarPorId(int idConsultar) {
        return usuarioRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public Usuario[] consultaPorCriterioOrden(Comparator criterio) {
        return usuarioRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    // UPDATE
    public boolean modificar(int identificador, Usuario usuario) {
        // Validación de negocio
        if (usuario.getNombreUsuario().isEmpty()
                && usuario.getContraseña().isEmpty()) {
            return false;
        }

        return usuarioRepository.update(identificador, usuario);
    }

    // DELETE
    public boolean eliminar(int identificador) {

        return usuarioRepository.delete(identificador);
    }
    
    

}

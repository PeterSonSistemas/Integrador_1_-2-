package peter.unmsm.javabasico.sixcar.s.a.c.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import peter.unmsm.javabasico.sixcar.s.a.c.service.orders.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import java.util.Comparator;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Cliente;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.cliente.ClienteRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.cliente.impl.ClienteArrayRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.repository.cliente.impl.ClienteFileRepository;
import peter.unmsm.javabasico.sixcar.s.a.c.util.Constantes;
import peter.unmsm.javabasico.sixcar.s.a.c.util.FormatoDate;
import static peter.unmsm.javabasico.sixcar.s.a.c.util.TipoRepositorio.ARCHIVO;

/**
 *
 * @author Timothy
 */
public class ClienteService {
    //variable de paquetes
    FormatoDate fd = new FormatoDate();
    
    ClienteRepository clienteRepository;

    //tipo de almacenamiento de datos
    public ClienteService() {
        switch (Constantes.TIPO_REPOSITORIO_ACTUAL) {
            case ARCHIVO -> clienteRepository = new ClienteFileRepository();           
            case MEMORIA -> clienteRepository = new ClienteArrayRepository();
            default -> throw new AssertionError();
        }
        
    }
    //==========================================================
    
    // CREATE cliente
    public boolean adicionar(Cliente cliente) {
        // Validación de negocio
//        if (cliente.getTipoCliente().isEmpty()
//                && fd.FechaFormat(cliente.getFecha()).isEmpty()) {
//            return false;
//        }

        clienteRepository.create(cliente);
        return true;
    }
    //==========================================

    // READ ALL leer todo
    public Cliente[] consultar() {
        return clienteRepository.readAll();
    }
    //========================================
    
    // READ leer por id
    public Cliente consultarPorId(int idConsultar) {
        return clienteRepository.read(idConsultar);
    }
    //=================================================
    
    // READ 
    public Cliente[] consultaPorCriterioOrden(Comparator criterio) {
        return clienteRepository.readAllWithOrder(criterio);
    }
    //===========================================================

    // UPDATE
    public boolean modificar(int identificador, Cliente cliente) {
         //Validación de negocio
//        if (cliente.getTipoCliente().isEmpty()
//                && fd.FechaFormat(cliente.getFecha()).isEmpty()) {
//            return false;
//        }

        return clienteRepository.update(identificador, cliente);
    }

    // DELETE
    public boolean eliminar(int identificador) {

        return clienteRepository.delete(identificador);
    }
    
    

}

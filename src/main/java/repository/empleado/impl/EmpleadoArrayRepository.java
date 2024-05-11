package repository.empleado.impl;

import java.util.Arrays;
import java.util.Comparator;
import domain.Empleado;
import repository.empleado.EmpleadoRepository;
/**
 *
 *
 *
 * Implementa un CRUD (Create, Read, Update y Delete) basado en Arreglos para la
 * clase Empleado
 *
 *
 */
public class EmpleadoArrayRepository implements EmpleadoRepository {

    
    public static final int TAMANIO_INICIAL = 10;
    private static Empleado[] empleados = new Empleado[TAMANIO_INICIAL];
    private static int size = 0;
    private static int secuenciaId = 1;  // Variable estática para generar idAlarmaes

    
    
    // CREATE
    @Override
    public void create(Empleado empleado) {
        if (size == empleados.length) {
            // Redimensionar el arreglo
            Empleado[] nuevoArreglo = new Empleado[size * 2];
            System.arraycopy(empleados, 0, nuevoArreglo, 0, size);
            empleados = nuevoArreglo;
        }
        
        empleado.setIdEmpleado(secuenciaId);  // Asignar el idAlarma automático
        secuenciaId++;  // Incrementar el contador para el próximo artículo
        
        empleados[size] = empleado;
        size++;
    }

    @Override
    public Empleado read(int idEmpleado) {
        for (int i = 0; i < size; i++) {
            if (empleados[i].getIdEmpleado() == idEmpleado) {
                return empleados[i];
            }
        }
        return null;
    }

    @Override
    public Empleado[] readAll() {
        Empleado[] activeArticles = new Empleado[size];
        System.arraycopy(empleados, 0, activeArticles, 0, size);
        return activeArticles;
    }
    
    @Override
    public Empleado[] readAllWithOrder(Comparator criterio) {
        Empleado[] activeArticles = readAll();
        Arrays.sort(activeArticles, criterio);
        return activeArticles;
    }
    

    // UPDATE
    @Override
    public boolean update(int idEmpleado, Empleado updatedEmpleado) {
        for (int i = 0; i < size; i++) {
            if (empleados[i].getIdEmpleado() == idEmpleado) {
                updatedEmpleado.setIdEmpleado(idEmpleado);
                empleados[i] = updatedEmpleado;
                return true;
            }
        }
        return false;
    }

    // DELETE
    @Override
    public boolean delete(int idEmpleado) {
        for (int i = 0; i < size; i++) {
            if (empleados[i].getIdEmpleado() == idEmpleado) {
                // Desplazar los elementos restantes
                System.arraycopy(empleados, i + 1, empleados, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }
}
  
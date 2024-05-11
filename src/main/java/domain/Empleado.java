/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Objects;

/**
 *
 * @author JESSY
 */
public class Empleado implements Comparable<Empleado>{
    
    //identificador
    private Integer IdEmpleado;
            
    //atributos
    private String codigo;
    private String nombre;
    private String apellido;
    private String sexo;
    private String dni;
    private String numeroContacto;
    private String estado;
            
    //referencias
    private PuestoTrabajo puestoTrabajo;
    
    //getters y setters de atributos
    public Integer getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(Integer IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //getters y setter de referencias
    public PuestoTrabajo getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(PuestoTrabajo puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    //constructores
    public Empleado(Integer IdEmpleado, String codigo, String nombre, String apellido, String sexo, String dni, String numeroContacto, String estado) {
        this.IdEmpleado = IdEmpleado;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
        this.numeroContacto = numeroContacto;
        this.estado = estado;
    }

    //constructor vacio
    public Empleado() {
    }

    //toString
    @Override
    public String toString() {
        return "Empleado{" + "IdEmpleado=" + IdEmpleado + ", codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", dni=" + dni + ", numeroContacto=" + numeroContacto + ", estado=" + estado + ", puestoTrabajo=" + puestoTrabajo + '}';
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.IdEmpleado);
        return hash;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        return Objects.equals(this.IdEmpleado, other.IdEmpleado);
    }
    
    //compareTo
    @Override
    public int compareTo(Empleado o) {
        return this.IdEmpleado.compareTo(o.IdEmpleado);
    }
    
    
    
    
}

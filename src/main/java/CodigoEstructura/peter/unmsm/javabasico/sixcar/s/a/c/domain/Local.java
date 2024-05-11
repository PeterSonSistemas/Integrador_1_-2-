/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.domain;

import java.util.Arrays;
import java.util.Objects;


/**
 *
 * @author JESSY
 */
public class Local implements Comparable<Local>{
    //identificador
    private Integer IdLocal;
    
    //atributos
    private String direccion;
    private int numero;
    private String nombre;
    
    //referencias
    private Comprobante comprobante;
    
    //arreglo por relacion de muchos a muchos
    private LocalProducto [] localProductoLocal;

    //geters and seters
    public Integer getIdLocal() {
        return IdLocal;
    }

    public void setIdLocal(Integer IdLocal) {
        this.IdLocal = IdLocal;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //geter y seter de referencias
    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    //geter y seter de arreglo por muchos a muchos 
    public LocalProducto[] getLocalProductoLocal() {
        return localProductoLocal;
    }

    public void setLocalProductoLocal(LocalProducto[] localProductoLocal) {
        this.localProductoLocal = localProductoLocal;
    }
    
    //constructor
    public Local(Integer IdLocal, String direccion, int numero, String nombre) {
        this.IdLocal = IdLocal;
        this.direccion = direccion;
        this.numero = numero;
        this.nombre = nombre;
    }

    //constructor vacio
    public Local() {
    }
    
    //toString
    @Override
    public String toString() {
        return "Local{" + "IdLocal=" + IdLocal + ", direccion=" + direccion + ", numero=" + numero + ", nombre=" + nombre + ", comprobante=" + comprobante + ", "
                + "localProductoLocal=" + Arrays.toString(localProductoLocal) + '}';
    }
    
    //hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.IdLocal;
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
        final Local other = (Local) obj;
        return Objects.equals(this.IdLocal, other.IdLocal);
    }
    
    //compareTo
    @Override
    public int compareTo(Local o) {
        return this.IdLocal.compareTo(o.IdLocal);
    }
    
    
    
}

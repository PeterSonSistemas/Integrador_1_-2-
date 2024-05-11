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
public class PuestoTrabajo implements Comparable<PuestoTrabajo>{
    
    //identificador
    private Integer IdPuestoTrabajo;
            
    //atributos
    private String nombrePuesto;
    private String descripción;
    
    //getters y setters
    public Integer getIdPuestoTrabajo() {
        return IdPuestoTrabajo;
    }

    public void setIdPuestoTrabajo(Integer IdPuestoTrabajo) {
        this.IdPuestoTrabajo = IdPuestoTrabajo;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
    
    //constructores
    public PuestoTrabajo(Integer IdPuestoTrabajo, String nombrePuesto, String descripción) {
        this.IdPuestoTrabajo = IdPuestoTrabajo;
        this.nombrePuesto = nombrePuesto;
        this.descripción = descripción;
    }
    
    //constructor vacio
    public PuestoTrabajo() {
    }

    //toString
    @Override
    public String toString() {
        return "PuestoTrabajo{" + "IdPuestoTrabajo=" + IdPuestoTrabajo + ", nombrePuesto=" + nombrePuesto + ", descripci\u00f3n=" + descripción + '}';
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.IdPuestoTrabajo);
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
        final PuestoTrabajo other = (PuestoTrabajo) obj;
        return Objects.equals(this.IdPuestoTrabajo, other.IdPuestoTrabajo);
    }

    //compareTo
    @Override
    public int compareTo(PuestoTrabajo o) {
        return this.IdPuestoTrabajo.compareTo(o.IdPuestoTrabajo);
    }
    
    
    
    
    
    
    
    
    
}

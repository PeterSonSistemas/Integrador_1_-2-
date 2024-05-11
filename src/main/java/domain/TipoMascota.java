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
public class TipoMascota implements Comparable<TipoMascota>{
    
    //identificador
    private Integer IdTipoMascota;
    
    //atributo
    private String mascota;
    
    //getters and setters
    public Integer getIdTipoMascota() {
        return IdTipoMascota;
    }

    public void setIdTipoMascota(Integer IdTipoMascota) {
        this.IdTipoMascota = IdTipoMascota;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    //constructor
    public TipoMascota(Integer IdTipoMascota, String mascota) {
        this.IdTipoMascota = IdTipoMascota;
        this.mascota = mascota;
    }

    //constructor vacio
    public TipoMascota() {
    }

    //toString
    @Override
    public String toString() {
        return "TipoMascota{" + "IdTipoMascota=" + IdTipoMascota + ", mascota=" + mascota + '}';
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.IdTipoMascota);
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
        final TipoMascota other = (TipoMascota) obj;
        return Objects.equals(this.IdTipoMascota, other.IdTipoMascota);
    }

    //compareTo
    @Override
    public int compareTo(TipoMascota o) {
        return this.IdTipoMascota.compareTo(o.IdTipoMascota);
    }
    
    
    
    
    
}

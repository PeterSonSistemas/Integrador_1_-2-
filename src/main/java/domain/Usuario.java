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
public class Usuario implements Comparable<Usuario>{
    
    //Identificador
    private Integer IdUsuario; 
    
    //Atributos
    private String nombreUsuario;
    private String contraseña;

    
    //getters and setters de identificador y atributos
    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    //constructor
    public Usuario(Integer IdUsuario, String nombreUsuario, String contraseña) {
        this.IdUsuario = IdUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    //constructor vacio
    public Usuario() {
    }

    //toString
    @Override
    public String toString() {
        return "Usuario{" + "IdUsuario=" + IdUsuario + ", nombreUsuario=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + '}';
    }

    //hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.IdUsuario);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.IdUsuario, other.IdUsuario);
    }

    //compareto
    @Override
    public int compareTo(Usuario o) {
        return this.IdUsuario.compareTo(IdUsuario);
    }
    
    
    
    
    
}

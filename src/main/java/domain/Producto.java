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
public class Producto implements Comparable<Producto>{
    
    //identificador
    private Integer IdProducto;
            
    //atributos
    private String nombre;
    private String codigo;
    private float precioVenta;
    private int stock;
    private Marca marca;
    
    //referencias
    private TipoMascota tipoMascota;

    //getters y setters de atributos
    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    
    //getters y setters de referencias
    public TipoMascota getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }
    
    //contructor
    public Producto(Integer IdProducto, String nombre, String codigo, float precioVenta, int stock, Marca marca) {
        this.IdProducto = IdProducto;
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.marca = marca;
    }

    //constructor vacio
    public Producto() {
    }
    
    //toString
    @Override
    public String toString() {
        return "Producto{" + "IdProducto=" + IdProducto + ", nombre=" + nombre + ", codigo=" + codigo + ", precioVenta=" + precioVenta + ", stock=" + stock + ", marca=" + marca + ", tipoMascota=" + tipoMascota + '}';
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.IdProducto);
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
        final Producto other = (Producto) obj;
        return Objects.equals(this.IdProducto, other.IdProducto);
    }

    //compareTo
    @Override
    public int compareTo(Producto o) {
        return this.IdProducto.compareTo(o.IdProducto);
    }
    
    
    
    
}

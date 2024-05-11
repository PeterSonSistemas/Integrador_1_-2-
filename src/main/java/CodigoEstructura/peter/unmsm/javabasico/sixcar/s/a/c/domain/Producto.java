package peter.unmsm.javabasico.sixcar.s.a.c.domain;

import java.util.Arrays;
import java.util.Objects;


/**
 *
 * @author JESSY
 */
public class Producto implements Comparable<Producto>{
    //identificador
    private Integer IdProducto;

    //atributos
    private String codigo;
    private String nombre;
    private String tipoBoca;
    private String tipoProducto;
    private String tipo; //AT o MT
    private String tipoManguera; //AT o MT
    private double tamaño; //tapa 
    private float precioMenor;
    private float precioInstalado;
    private float precioMayor;
    private String anio;
    private int stock;
    private String marca;

    //referencias
    private Alarma alarma;

    //arreglo por relacion de muchos a muchos
    private LocalProducto[] localProductoProducto;
    private DetalleComprobante[] detalleComprobanteProducto;

    //geter y seter
    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public float getPrecioInstalado() {
        return precioInstalado;
    }

    public void setPrecioInstalado(float precioInstalado) {
        this.precioInstalado = precioInstalado;
    }

    public String getTipoManguera() {
        return tipoManguera;
    }

    public void setTipoManguera(String tipoManguera) {
        this.tipoManguera = tipoManguera;
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

    public String getTipoBoca() {
        return tipoBoca;
    }

    public void setTipoBoca(String tipoBoca) {
        this.tipoBoca = tipoBoca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public float getPrecioMenor() {
        return precioMenor;
    }

    public void setPrecioMenor(float precioMenor) {
        this.precioMenor = precioMenor;
    }

    public float getPrecioMayor() {
        return precioMayor;
    }

    public void setPrecioMayor(float precioMayor) {
        this.precioMayor = precioMayor;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //geter y seter de referencias
    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

    //geter y seter de arreglo por muchos a muchos
    public LocalProducto[] getLocalProductoProducto() {
        return localProductoProducto;
    }

    public void setLocalProductoProducto(LocalProducto[] localProductoProducto) {
        this.localProductoProducto = localProductoProducto;
    }
    
    
    public DetalleComprobante[] getDetalleComprobanteProducto() {
        return detalleComprobanteProducto;
    }

    public void setDetalleComprobanteProducto(DetalleComprobante[] detalleComprobanteProducto) {
        this.detalleComprobanteProducto = detalleComprobanteProducto;
    }

    //constructor
    public Producto(Integer IdProducto, String codigo, String nombre, String tipoBoca, String tipoProducto, String tipo, String tipomanguera, double tamaño, float precioMenor, float precioInstalado, float precioMayor, String anio, int stock, String marca) {
        this.IdProducto = IdProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipoBoca = tipoBoca;
        this.tipoProducto = tipoProducto;
        this.tipo = tipo;
        this.tipoManguera = tipomanguera;
        this.tamaño = tamaño;
        this.precioMenor = precioMenor;
        this.precioInstalado = precioInstalado;
        this.precioMayor = precioMayor;
        this.anio = anio;
        this.stock = stock;
        this.marca = marca;
    }
    
    //constructor vacio
    public Producto() {
    }
    
    //ToString
    @Override
    public String toString() {
        return "Producto{" + "IdProducto=" + IdProducto + ", codigo=" + codigo + ", nombre=" + nombre + ", tipoBoca=" + tipoBoca + ", tipoProducto=" + tipoProducto + ", tipo=" + tipo + ", tipomanguera=" + tipoManguera + ", tama\u00f1o=" + tamaño + ", precioMenor=" + precioMenor + ", precioInstalado=" + precioInstalado + ", precioMayor=" + precioMayor + ", anio=" + anio + ", stock=" + stock + ", marca=" + marca + ", alarma=" + alarma + ", localProductoProducto=" + localProductoProducto + ", detalleComprobanteProducto=" + detalleComprobanteProducto + '}';
    }
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.IdProducto;
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
    

    //comparableTo
    @Override
    public int compareTo(Producto o) {
        return this.IdProducto.compareTo(o.IdProducto);
    }

    
    
    
}

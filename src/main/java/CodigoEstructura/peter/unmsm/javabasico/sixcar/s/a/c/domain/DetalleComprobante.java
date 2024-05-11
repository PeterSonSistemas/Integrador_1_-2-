package peter.unmsm.javabasico.sixcar.s.a.c.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author JESSY
 */
public class DetalleComprobante implements Comparable<DetalleComprobante>{
    //identificador
    private Integer IdDetalleComprobante;

    //atributos
    private int numeroBoletaDetalleComprobante;
    private byte cantidadProductoRegistrar;
    private String nombreProducto;
    private short cantidadProducto;
    private float precioProducto;
    private BigDecimal totalProducto;
    private BigDecimal total;
    
    //referencias
    private Producto producto;
    private Comprobante comprobante;
    
    //geter y seter
    public Integer getIdDetalleComprobante() {
        return IdDetalleComprobante;
    }

    public void setIdDetalleComprobante(Integer IdDetalleComprobante) {
        this.IdDetalleComprobante = IdDetalleComprobante;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public short getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(short cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public BigDecimal getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(BigDecimal totalProducto) {
        this.totalProducto = totalProducto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getNumeroBoletaDetalleComprobante() {
        return numeroBoletaDetalleComprobante;
    }

    public void setNumeroBoletaDetalleComprobante(int numeroBoletaDetalleComprobante) {
        this.numeroBoletaDetalleComprobante = numeroBoletaDetalleComprobante;
    }

    public byte getCantidadProductoRegistrar() {
        return cantidadProductoRegistrar;
    }

    public void setCantidadProductoRegistrar(byte cantidadProductoRegistrar) {
        this.cantidadProductoRegistrar = cantidadProductoRegistrar;
    }
    
    //geter y seter de referencias
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }
    
    //constructor

    public DetalleComprobante(byte cantidadProductoRegistrar,int numeroBoletaDetalleComprobante ,Integer IdDetalleComprobante, String nombreProducto, short cantidadProducto, float precioProducto, BigDecimal totalProducto, BigDecimal total) {
        this.cantidadProductoRegistrar = cantidadProductoRegistrar;
        this.numeroBoletaDetalleComprobante = numeroBoletaDetalleComprobante;
        this.IdDetalleComprobante = IdDetalleComprobante;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.totalProducto = totalProducto;
        this.total = total;
    }
    
    //constructor vacio
    public DetalleComprobante() {
    }
    
    //ToString
    @Override
    public String toString() {
        return "DetalleComprobante{" + "IdDetalleComprobante=" + IdDetalleComprobante + ", numeroBoletaDetalleComprobante=" + numeroBoletaDetalleComprobante + ", cantidadProductoRegistrar=" + cantidadProductoRegistrar + ", nombreProducto=" + nombreProducto + ", cantidadProducto=" + cantidadProducto + ", precioProducto=" + precioProducto + ", totalProducto=" + totalProducto + ", total=" + total + ", producto=" + producto + ", comprobante=" + comprobante + '}';
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.IdDetalleComprobante;
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
        final DetalleComprobante other = (DetalleComprobante) obj;
        return Objects.equals(this.IdDetalleComprobante, other.IdDetalleComprobante);
    }
    
    //compareTo
    @Override
    public int compareTo(DetalleComprobante o) {
        return this.IdDetalleComprobante.compareTo(o.IdDetalleComprobante);
    }
    
    
    
}

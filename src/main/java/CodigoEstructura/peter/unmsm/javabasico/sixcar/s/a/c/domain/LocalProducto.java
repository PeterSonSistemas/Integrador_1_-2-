package peter.unmsm.javabasico.sixcar.s.a.c.domain;

import java.util.Objects;


/**
 *
 * @author JESSY
 */
public class LocalProducto implements Comparable<LocalProducto>{
    //identificador
    private Integer IdLocalProducto;
    
    //atributos
    private int  stock  ;
    
    //referencias
    private Producto producto;
    private Local local;

    //geter y seter
    public Integer getIdLocalProducto() {
        return IdLocalProducto;
    }

    public void setIdLocalProducto(Integer IdLocalProducto) {
        this.IdLocalProducto = IdLocalProducto;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //geter y seter de referencias
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    //constructor
    public LocalProducto(Integer IdLocalProducto, int stock) {
        this.IdLocalProducto = IdLocalProducto;
        this.stock = stock;
    }
    
    //constructor vacio
    public LocalProducto() {
    }
    
    //ToString
    @Override
    public String toString() {
        return "LocalProducto{" + "IdLocalProducto=" + IdLocalProducto + ", stock=" + stock + ", producto=" + producto + ", local=" + local + '}';
    }
    
    //hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.IdLocalProducto;
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
        final LocalProducto other = (LocalProducto) obj;
        return Objects.equals(this.IdLocalProducto, other.IdLocalProducto);
    }
    
    //compareTo
    @Override
    public int compareTo(LocalProducto o) {
        return this.IdLocalProducto.compareTo(o.IdLocalProducto);
    }
    
    
    
}

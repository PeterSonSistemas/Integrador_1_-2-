package peter.unmsm.javabasico.sixcar.s.a.c.domain;


import java.util.Arrays;
import java.util.Date;
import java.util.Objects;


/**
 *
 * @author JESSY
 */
public class Comprobante implements Comparable<Comprobante>{
    //identificador
    private Integer numeroBoleta;

    //atributos
    private String tipoComprobante;
    private String RUCempresa;
    private String numeroTelefono;
    private Date fecha;
    
    //referencias
    private Local local;
    private Carro carro;
    private Cliente cliente;
    
    //arreglo por relacion de muchos a muchos
    private DetalleComprobante [] detalleComprobanteComprobante;
    
    //geter y seter 
    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getRUCempresa() {
        return RUCempresa;
    }

    public void setRUCempresa(String RUCempresa) {
        this.RUCempresa = RUCempresa;
    }

    public Integer getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(Integer numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    //geter y seter de referencias
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    //geter y seter de arreglo por muchos a muchos 
    public DetalleComprobante[] getDetalleComprobanteComprobante() {
        return detalleComprobanteComprobante;
    }

    public void setDetalleComprobanteComprobante(DetalleComprobante[] detalleComprobanteComprobante) {
        this.detalleComprobanteComprobante = detalleComprobanteComprobante;
    }
    
    //constructor
    public Comprobante(String tipoComprobante, String RUCempresa, Integer numeroBoleta, String numeroTelefono, Date fecha) {
        this.tipoComprobante = tipoComprobante;
        this.RUCempresa = RUCempresa;
        this.numeroBoleta = numeroBoleta;
        this.numeroTelefono = numeroTelefono;
        this.fecha = fecha;
    }
    
    //constructor vacio
    public Comprobante() {
    }

    //ToString
    @Override
    public String toString() {
        return "Comprobante{" + ", tipoComprobante=" + tipoComprobante + ", RUCempresa=" + RUCempresa + ", numeroBoleta=" + numeroBoleta + ", numeroTelefono=" + numeroTelefono + ", fecha=" + fecha + ", local=" + local + ", carro=" + carro + ", cliente=" + cliente + ", detalleComprobanteComprobante=" + Arrays.toString(detalleComprobanteComprobante) + '}';
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.numeroBoleta;
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
        final Comprobante other = (Comprobante) obj;
        return Objects.equals(this.numeroBoleta, other.numeroBoleta);
    }
   
    //compareTo
    @Override
    public int compareTo(Comprobante o) {
        return this.numeroBoleta.compareTo(o.numeroBoleta);
    }
    
    

}

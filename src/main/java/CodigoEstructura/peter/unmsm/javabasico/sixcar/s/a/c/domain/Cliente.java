package peter.unmsm.javabasico.sixcar.s.a.c.domain;

import java.util.Objects;



/**
 *
 * @author JESSY
 */

public class Cliente implements Comparable<Cliente>{
    //identificador
    private Integer IdCliente;

    //atributos
    private int numeroBoletaCliente;
    private String tipoDocumento;
    private String numeroDocumento;
    private String telefono;
    private String RUC;

    //geter y seter
    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }
    
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public int getNumeroBoletaCliente() {
        return numeroBoletaCliente;
    }

    public void setNumeroBoletaCliente(int numeroBoletaCliente) {
        this.numeroBoletaCliente = numeroBoletaCliente;
    }
    
    //constructor
    public Cliente(int numeroBoletaCliente,Integer IdCliente, String tipoDocumento, String numeroDocumento, String telefono, String RUC) {
        this.numeroBoletaCliente = numeroBoletaCliente;
        this.IdCliente = IdCliente;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.RUC = RUC;
    }

    //constructor vacio
    public Cliente() {
    }
    
    //ToString
    @Override
    public String toString() {
        return "Cliente{" + "IdCliente=" + IdCliente + ", numeroBoletaCliente=" + numeroBoletaCliente + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", telefono=" + telefono + ", RUC=" + RUC + '}';
    }
    

    //hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.IdCliente;
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
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.IdCliente, other.IdCliente);
    }

    //compateTo
    @Override
    public int compareTo(Cliente o) {
        return this.IdCliente.compareTo(o.IdCliente);
    }
    
    
    
    
}

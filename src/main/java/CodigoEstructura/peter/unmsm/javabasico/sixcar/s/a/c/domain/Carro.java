package peter.unmsm.javabasico.sixcar.s.a.c.domain;

import java.util.Objects;


/**
 *
 * @author JESSY
 */
public class Carro implements Comparable<Carro>{
    //identificador
    private Integer IdCarro;

    //atributos
    private int numeroBoletaCarro;
    private String marca;
    private short anio;
    private String placa;

    //geter y setter
    public Integer getIdCarro() {
        return IdCarro;
    }

    public void setIdCarro(Integer IdCarro) {
        this.IdCarro = IdCarro;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroBoletaCarro() {
        return numeroBoletaCarro;
    }

    public void setNumeroBoletaCarro(int numeroBoletaCarro) {
        this.numeroBoletaCarro = numeroBoletaCarro;
    }
    
    
    //constructor
    public Carro(int numeroBoletaCarro, Integer IdCarro, String marca, short anio, String placa) {
        this.numeroBoletaCarro = numeroBoletaCarro;
        this.IdCarro = IdCarro;
        this.marca = marca;
        this.anio = anio;
        this.placa = placa;
    }
    
    
    //constructor vacio
    public Carro() {
    }
    
    //ToString

    @Override
    public String toString() {
        return "Carro{" + "IdCarro=" + IdCarro + ", numeroBoletaCarro=" + numeroBoletaCarro + ", marca=" + marca + ", anio=" + anio + ", placa=" + placa + '}';
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.IdCarro;
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
        final Carro other = (Carro) obj;
        return Objects.equals(this.IdCarro, other.IdCarro);
    }
    
    //compareTo
    @Override
    public int compareTo(Carro o) {
        return this.IdCarro.compareTo(o.IdCarro);
    }
    
    
}

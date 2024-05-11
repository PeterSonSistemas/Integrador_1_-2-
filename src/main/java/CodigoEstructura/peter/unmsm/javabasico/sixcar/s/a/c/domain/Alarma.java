package peter.unmsm.javabasico.sixcar.s.a.c.domain;

import java.util.Objects;

public class Alarma implements Comparable<Alarma>{

    //identificador
    private Integer IdAlarma;
    
    //atributos
    private boolean activada;
    private String mensaje;
    
    //geter y setter

    public Integer getIdAlarma() {
        return IdAlarma;
    }

    public void setIdAlarma(Integer IdAlarma) {
        this.IdAlarma = IdAlarma;
    }
    
    public boolean isActivada() {
        return activada;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //constructor
    public Alarma(Integer IdAlarma, boolean activada, String mensaje) {
        this.IdAlarma = IdAlarma;
        this.activada = activada;
        this.mensaje = mensaje;
    }
    
    //constructor vacio
    public Alarma() {
    }
    
    //ToString
    @Override
    public String toString() {
        return "Alarma{" + "IdAlarma=" + IdAlarma + ", activada=" + activada + ", mensaje=" + mensaje + '}';
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.IdAlarma;
        return hash;
    }

    //Equals
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
        final Alarma other = (Alarma) obj;
        return Objects.equals(this.IdAlarma, other.IdAlarma);
    }
    
    //comprateTo
    @Override
    public int compareTo(Alarma o) {
        return this.IdAlarma.compareTo(o.IdAlarma);
    }
    
    
}


package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class CalificacionPK implements Serializable {

    @Column(name = "cod_matricula", nullable = false, length = 10)
    private String codMatricula;
    @Column(name = "cod_nrc", nullable = false)
    private short codNrc;

    public CalificacionPK() {
    }

    public CalificacionPK(String codMatricula, short codNrc) {
        this.codMatricula = codMatricula;
        this.codNrc = codNrc;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public short getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(short codNrc) {
        this.codNrc = codNrc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMatricula != null ? codMatricula.hashCode() : 0);
        hash += (int) codNrc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CalificacionPK)) {
            return false;
        }
        CalificacionPK other = (CalificacionPK) object;
        if ((this.codMatricula == null && other.codMatricula != null) || (this.codMatricula != null && !this.codMatricula.equals(other.codMatricula))) {
            return false;
        }
        if (this.codNrc != other.codNrc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codMatricula=" + codMatricula + ", codNrc=" + codNrc + " ]";
    }

}

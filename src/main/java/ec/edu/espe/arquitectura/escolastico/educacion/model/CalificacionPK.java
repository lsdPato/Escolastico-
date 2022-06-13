
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class CalificacionPK implements Serializable {

    @Column(name = "cod_matricula", nullable = false, length = 10)
    private String codMatricula;
    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;

    @Column(name = "cod_nrc", nullable = false)
    private Integer codNrc;



    public CalificacionPK() {
    }

    public CalificacionPK(String codMatricula, Integer codPersona, Integer codNrc) {
        this.codMatricula = codMatricula;
        this.codPersona = codPersona;
        this.codNrc = codNrc;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }


    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public Integer getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(Integer codNrc) {
        this.codNrc = codNrc;
    }
    public Integer getCodPersona() {
        return codPersona;
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


package ec.edu.espe.arquitectura.escolastico.educacion.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class NrcPK implements Serializable {

    @Column(name = "cod_nrc", nullable = false)
    private Integer codNrc;

    @Column(name = "cod_periodo", nullable = false)
    private int codPeriodo;

    @Column(name = "cod_departamento", nullable = false)
    private int codDepartamento;

    @Column(name = "cod_materia", nullable = false)
    private int codMateria;

    public NrcPK() {
    }

    public Integer getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(Integer codNrc) {
        this.codNrc = codNrc;
    }

    public int getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(int codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public int getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(int codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public int getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codNrc;
        hash += (int) codPeriodo;
        hash += (int) codDepartamento;
        hash += (int) codMateria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof NrcPK)) {
            return false;
        }
        NrcPK other = (NrcPK) object;
        if (this.codNrc != other.codNrc) {
            return false;
        }
        if (this.codPeriodo != other.codPeriodo) {
            return false;
        }
        if (this.codDepartamento != other.codDepartamento) {
            return false;
        }
        if (this.codMateria != other.codMateria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codNrc=" + codNrc + ", codPeriodo=" + codPeriodo + ", codDepartamento=" + codDepartamento + ", codMateria=" + codMateria + " ]";
    }

}

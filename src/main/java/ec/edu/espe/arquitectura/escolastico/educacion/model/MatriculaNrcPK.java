
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class MatriculaNrcPK implements Serializable {

    @Column(name = "cod_nrc", nullable = false)
    private short codNrc;
    @Column(name = "cod_periodo", nullable = false)
    private int codPeriodo;
    @Column(name = "cod_departamento", nullable = false)
    private int codDepartamento;
    @Column(name = "cod_materia", nullable = false)
    private int codMateria;
    @Column(name = "cod_matricula", nullable = false, length = 10)
    private String codMatricula;
    @Column(name = "cod_persona", nullable = false)
    private int codPersona;

    public MatriculaNrcPK() {
    }

    public short getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(short codNrc) {
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

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codNrc;
        hash += (int) codPeriodo;
        hash += (int) codDepartamento;
        hash += (int) codMateria;
        hash += (codMatricula != null ? codMatricula.hashCode() : 0);
        hash += (int) codPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MatriculaNrcPK)) {
            return false;
        }
        MatriculaNrcPK other = (MatriculaNrcPK) object;
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
        if ((this.codMatricula == null && other.codMatricula != null) || (this.codMatricula != null && !this.codMatricula.equals(other.codMatricula))) {
            return false;
        }
        if (this.codPersona != other.codPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codNrc=" + codNrc + ", codPeriodo=" + codPeriodo + ", codDepartamento=" + codDepartamento + ", codMateria=" + codMateria + ", codMatricula=" + codMatricula + ", codPersona=" + codPersona + " ]";
    }

}

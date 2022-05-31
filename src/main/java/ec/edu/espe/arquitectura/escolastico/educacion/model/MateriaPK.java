
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class MateriaPK implements Serializable {

    @Column(name = "cod_materia", nullable = false)
    private Integer codMateria;
    @Column(name = "cod_departamento", nullable = false)
    private Integer codDepartamento;

    public MateriaPK() {
    }

    public MateriaPK(Integer codMateria, Integer codDepartamento) {
        this.codMateria = codMateria;
        this.codDepartamento = codDepartamento;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codMateria;
        hash += (int) codDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MateriaPK)) {
            return false;
        }
        MateriaPK other = (MateriaPK) object;
        if (this.codMateria != other.codMateria) {
            return false;
        }
        if (this.codDepartamento != other.codDepartamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codMateria=" + codMateria + ", codDepartamento=" + codDepartamento + " ]";
    }

}

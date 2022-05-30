
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "edu_prerequisito")

public class Prerequisito implements Serializable {

    private static final long serialVersionUID = 12345L;
    @Id
    @Column(name = "cod_prerequisito", nullable = false)
    private Integer codPrerequisito;
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @Column(name = "cod_materia", nullable = false, insertable = false, updatable = false)
    private Integer codMateria;
    @JoinColumns({
            @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false),
            @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false)})
    @ManyToOne(optional = false)
    private Materia materia;
    @JoinColumns({
            @JoinColumn(name = "cod_materia_prerequisito", referencedColumnName = "cod_materia", nullable = false),
            @JoinColumn(name = "edu_cod_departamento", referencedColumnName = "cod_departamento", nullable = false)})
    @ManyToOne(optional = false)
    private Materia prerequisito;

    public Prerequisito() {
    }

    public Prerequisito(Integer codPrerequisito) {
        this.codPrerequisito = codPrerequisito;
    }

    public Integer getCodPrerequisito() {
        return codPrerequisito;
    }

    public void setCodPrerequisito(Integer codPrerequisito) {
        this.codPrerequisito = codPrerequisito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    public Materia getPrerequisito() {
        return prerequisito;
    }

    public void setPrerequisito(Materia prerequisito) {
        this.prerequisito = prerequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrerequisito != null ? codPrerequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Prerequisito)) {
            return false;
        }
        Prerequisito other = (Prerequisito) object;
        if ((this.codPrerequisito == null && other.codPrerequisito != null) || (this.codPrerequisito != null && !this.codPrerequisito.equals(other.codPrerequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codPrerequisito=" + codPrerequisito + " ]";
    }

}

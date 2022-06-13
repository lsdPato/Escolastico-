
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "edu_prerequisito")

public class Prerrequisito implements Serializable {

    private static final long serialVersionUID = 62945L;
    @Id
    @Column(name = "cod_prerequisito", nullable = false)
    private Integer codPrerrequisito;
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

    public Prerrequisito() {
    }

    public Prerrequisito(Integer codPrerrequisito) {
        this.codPrerrequisito = codPrerrequisito;
    }

    public Integer getCodPrerrequisito() {
        return codPrerrequisito;
    }

    public void setCodPrerrequisito(Integer codPrerequisito) {
        this.codPrerrequisito = codPrerequisito;
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
        hash += (codPrerrequisito != null ? codPrerrequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Prerrequisito)) {
            return false;
        }
        Prerrequisito other = (Prerrequisito) object;
        if ((this.codPrerrequisito == null && other.codPrerrequisito != null) || (this.codPrerrequisito != null && !this.codPrerrequisito.equals(other.codPrerrequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codPrerequisito=" + codPrerrequisito + " ]";
    }

}

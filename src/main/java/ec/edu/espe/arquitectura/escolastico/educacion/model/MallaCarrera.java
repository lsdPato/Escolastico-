
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "edu_malla_carrera")

public class MallaCarrera implements Serializable {

    private static final long serialVersionUID = 21345L;
    @Id
//    @GeneratedValue
    @Column(name = "cod_materiacarrera", nullable = false)
    private Integer codMateriacarrera;
    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "cod_carrera", nullable = false)
    private Integer codCarrera;

    @Column(name = "cod_materia", nullable = false, insertable = false, updatable = false)
    private Integer codMateria;

    @JsonBackReference(value = "carrera")
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Carrera carrera;

    @JoinColumns({
            @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false),
            @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false)})
    @ManyToOne(optional = false)
    private Materia materia;

    public MallaCarrera() {
    }

    public MallaCarrera(Integer codMateriacarrera) {
        this.codMateriacarrera = codMateriacarrera;
    }

    public Integer getCodMateriacarrera() {
        return codMateriacarrera;
    }

    public void setCodMateriacarrera(Integer codMateriacarrera) {
        this.codMateriacarrera = codMateriacarrera;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    public void setCarrera(Carrera codCarrera) {
        this.carrera = codCarrera;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Integer getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Integer codCarrera) {
        this.codCarrera = codCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMateriacarrera != null ? codMateriacarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MallaCarrera)) {
            return false;
        }
        MallaCarrera other = (MallaCarrera) object;
        if ((this.codMateriacarrera == null && other.codMateriacarrera != null) || (this.codMateriacarrera != null && !this.codMateriacarrera.equals(other.codMateriacarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codMateriacarrera=" + codMateriacarrera + " ]";
    }

}

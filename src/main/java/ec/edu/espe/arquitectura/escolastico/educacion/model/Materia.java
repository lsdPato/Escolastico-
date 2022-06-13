
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "edu_materia")
public class Materia implements Serializable {

    private static final long serialVersionUID = 213459755L;
    @EmbeddedId
    private MateriaPK pk;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "creditos", nullable = false, precision = 4, scale = 2)
    private BigDecimal creditos;
    @Column(name = "horas", nullable = false, precision = 4, scale = 2)
    private BigDecimal horas;
    @Column(name = "ponderacion", nullable = false, precision = 5, scale = 2)
    private BigDecimal ponderacion;
    //@JsonIgnore
    @JsonBackReference(value = "materia_nrcs")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private List<Nrc> nrcs;
    @JsonBackReference(value = "materia_mallaCarrera")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private List<MallaCarrera> carreras;
    @JsonBackReference(value = "materia_prerrequisito")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prerequisito", fetch = FetchType.EAGER)
    private List<Prerrequisito> prerrequisitos;

    public Materia() {
    }

    public Materia(MateriaPK materiaPK) {
        this.pk = materiaPK;
    }

    public Materia(int codMateria, int codDepartamento) {
        this.pk = new MateriaPK(codMateria, codDepartamento);
    }

    public MateriaPK getPk() {
        return pk;
    }

    public void setmateriaPK(MateriaPK materiaPK) {
        this.pk = materiaPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCreditos() {
        return creditos;
    }

    public void setCreditos(BigDecimal creditos) {
        this.creditos = creditos;
    }

    public BigDecimal getHoras() {
        return horas;
    }

    public void setHoras(BigDecimal horas) {
        this.horas = horas;
    }

    public BigDecimal getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(BigDecimal ponderacion) {
        this.ponderacion = ponderacion;
    }

    public List<Nrc> getNrcs() {
        return nrcs;
    }

    public void setNrcs(List<Nrc> list) {
        this.nrcs = list;
    }

    public List<MallaCarrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<MallaCarrera> mallaCarreraList) {
        this.carreras = mallaCarreraList;
    }

    public List<Prerrequisito> getPrerequisitos() {
        return prerrequisitos;
    }

    public void setPrerequisitos(List<Prerrequisito> prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ materiaPK=" + pk + " ]";
    }

}

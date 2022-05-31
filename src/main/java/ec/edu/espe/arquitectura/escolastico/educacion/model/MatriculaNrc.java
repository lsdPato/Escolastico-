
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "edu_matricula_nrc")

public class MatriculaNrc implements Serializable {

    private static final long serialVersionUID = 12345L;
    @EmbeddedId
    private MatriculaNrcPK pk;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "numero", nullable = false)
    private Integer numero;
    @Column(name = "costo", nullable = false, precision = 7, scale = 2)
    private BigDecimal costo;
    @JoinColumns({
            @JoinColumn(name = "cod_matricula", referencedColumnName = "cod_matricula", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Matricula matricula;
    @JoinColumns({
            @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nrc nrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculaNrc")
    private List<Calificacion> calificaciones;

    public MatriculaNrc() {
    }

    public MatriculaNrc(MatriculaNrcPK matriculaNrcPK) {
        this.pk = matriculaNrcPK;
    }

    public MatriculaNrcPK getPk() {
        return pk;
    }

    public void setPk(MatriculaNrcPK matriculaNrcPK) {
        this.pk = matriculaNrcPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Nrc getNrc() {
        return nrc;
    }

    public void setNrc(Nrc nrc) {
        this.nrc = nrc;
    }

    public List<Calificacion> getCalificacionList() {
        return calificaciones;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificaciones = calificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MatriculaNrc)) {
            return false;
        }
        MatriculaNrc other = (MatriculaNrc) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ matriculaNrcPK=" + pk + " ]";
    }

}

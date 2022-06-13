
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ec.edu.espe.arquitectura.escolastico.orgfisica.model.Aula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "edu_nrc_horario")

public class NrcHorario implements Serializable {

    private static final long serialVersionUID = 54345L;
    @EmbeddedId
    private NrcHorarioPK pk;

    @Column(name = "hora_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;


    @Column(name = "hora_fin", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFin;

    @JoinColumns({
            @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nrc nrc;

    @JsonBackReference
    @JoinColumn(name = "cod_aula", referencedColumnName = "cod_aula", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aula aula;

    public NrcHorario() {
    }

    public NrcHorario(NrcHorarioPK nrcHorarioPK) {
        this.pk = nrcHorarioPK;
    }

    public NrcHorarioPK getPk() {
        return pk;
    }

    public void setPk(NrcHorarioPK nrcHorarioPK) {
        this.pk = nrcHorarioPK;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Nrc getNrc() {
        return nrc;
    }

    public void setNrc(Nrc nrc) {
        this.nrc = nrc;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof NrcHorario)) {
            return false;
        }
        NrcHorario other = (NrcHorario) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ nrcHorarioPK=" + pk + " ]";
    }

}

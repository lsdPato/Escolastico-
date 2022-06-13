
package ec.edu.espe.arquitectura.escolastico.orgfisica.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ofi_aula")
public class Aula implements Serializable {

    private static final long serialVersionUID = 653432L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_aula", nullable = false)
    private Integer codAula;
    @Column(name = "cod_tipo_aula", nullable = false, insertable = false, updatable = false)
    private String codTipoAula;
    @Column(name = "cod_alterno", nullable = false, length = 10)
    private String codAlterno;
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;
    @Column(name = "cod_edificio_bloque", nullable = false, updatable = false, insertable = false)
    private String codEdificioBloque;
    @Column(name = "piso", nullable = false)
    private Integer piso;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aula", fetch = FetchType.EAGER)
    private List<NrcHorario> nrcHorarios;
    @JoinColumn(name = "cod_edificio", referencedColumnName = "cod_edificio")
    @ManyToOne
    private Edificio edificio;
    @JoinColumn(name = "cod_edificio_bloque", referencedColumnName = "cod_edificio_bloque")
    @ManyToOne
    private EdificioBloque edificioBloque;
    @JoinColumn(name = "cod_tipo_aula", referencedColumnName = "cod_tipo_aula")
    @ManyToOne
    private TipoAula tipoAula;

    public Aula() {
    }

    public Aula(Integer codAula) {
        this.codAula = codAula;
    }

    public Integer getCodAula() {
        return codAula;
    }

    public void setCodAula(Integer codAula) {
        this.codAula = codAula;
    }

    public String getCodAlterno() {
        return codAlterno;
    }

    public void setCodAlterno(String codAlterno) {
        this.codAlterno = codAlterno;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getAudUsuario() {
        return audUsuario;
    }

    public void setAudUsuario(String audUsuario) {
        this.audUsuario = audUsuario;
    }

    public Date getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }

    public String getAudIp() {
        return audIp;
    }

    public void setAudIp(String audIp) {
        this.audIp = audIp;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<NrcHorario> getNrcHorarios() {
        return nrcHorarios;
    }

    public void setNrcHorarios(List<NrcHorario> nrcHorarioList) {
        this.nrcHorarios = nrcHorarioList;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio codEdificio) {
        this.edificio = codEdificio;
    }

    public String getCodEdificioBloque() {
        return codEdificioBloque;
    }

    public void setCodEdificioBloque(String codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    public ec.edu.espe.arquitectura.escolastico.orgfisica.model.EdificioBloque getEdificioBloque() {
        return edificioBloque;
    }

    public void setEdificioBloque(ec.edu.espe.arquitectura.escolastico.orgfisica.model.EdificioBloque edificioBloque) {
        this.edificioBloque = edificioBloque;
    }

    public String getCodTipoAula() {
        return codTipoAula;
    }

    public void setCodTipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    public ec.edu.espe.arquitectura.escolastico.orgfisica.model.TipoAula getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(ec.edu.espe.arquitectura.escolastico.orgfisica.model.TipoAula tipoAula) {
        this.tipoAula = tipoAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAula != null ? codAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.codAula == null && other.codAula != null) || (this.codAula != null && !this.codAula.equals(other.codAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codAula=" + codAula + " ]";
    }

}


package ec.edu.espe.arquitectura.escolastico.orgfisica.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ofi_aula")
public class Aula implements Serializable {

    private static final long serialVersionUID = 123432L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_aula", nullable = false)
    private Integer codAula;
    @Column(name = "cod_alterno", nullable = false, length = 10)
    private String codAlterno;
    @Column(name = "capacidad", nullable = false)
    private short capacidad;
    @Column(name = "piso", nullable = false)
    private short piso;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aula")
    private List<NrcHorario> nrcHorarioList;
    @JoinColumn(name = "cod_edificio", referencedColumnName = "cod_edificio")
    @ManyToOne
    private Edificio codEdificio;
    @JoinColumn(name = "cod_edificio_bloque", referencedColumnName = "cod_edificio_bloque")
    @ManyToOne
    private EdificioBloque codEdificioBloque;
    @JoinColumn(name = "cod_tipo_aula", referencedColumnName = "cod_tipo_aula")
    @ManyToOne
    private TipoAula codTipoAula;

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

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    public short getPiso() {
        return piso;
    }

    public void setPiso(short piso) {
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<NrcHorario> getNrcHorarioList() {
        return nrcHorarioList;
    }

    public void setNrcHorarioList(List<NrcHorario> nrcHorarioList) {
        this.nrcHorarioList = nrcHorarioList;
    }

    public Edificio getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(Edificio codEdificio) {
        this.codEdificio = codEdificio;
    }

    public EdificioBloque getCodEdificioBloque() {
        return codEdificioBloque;
    }

    public void setCodEdificioBloque(EdificioBloque codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    public TipoAula getCodTipoAula() {
        return codTipoAula;
    }

    public void setCodTipoAula(TipoAula codTipoAula) {
        this.codTipoAula = codTipoAula;
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


package ec.edu.espe.arquitectura.escolastico.orgfisica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ofi_tipo_aula")
public class TipoAula implements Serializable {

    private static final long serialVersionUID = 890854L;
    @Id
    @Column(name = "cod_tipo_aula", nullable = false, length = 10)
    private String codTipoAula;
    @Column(name = "descripcion", nullable = false, length = 128)
    private String descripcion;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;

    public TipoAula() {
    }

    public TipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    public String getCodTipoAula() {
        return codTipoAula;
    }

    public void setCodTipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoAula != null ? codTipoAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoAula)) {
            return false;
        }
        TipoAula other = (TipoAula) object;
        if ((this.codTipoAula == null && other.codTipoAula != null) || (this.codTipoAula != null && !this.codTipoAula.equals(other.codTipoAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoAula[ codTipoAula=" + codTipoAula + " ]";
    }

}


package ec.edu.espe.arquitectura.escolastico.persona.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "per_tipo_persona")

public class TipoPersona implements Serializable {
    private static final long serialVersionUID = 8991559565284474096L;

    @Id
    @Column(name = "cod_tipo_persona", nullable = false, length = 3)
    private String codTipoPersona;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;

    public TipoPersona() {
    }

    public TipoPersona(String codTipoPersona) {
        this.codTipoPersona = codTipoPersona;
    }

    public String getCodTipoPersona() {
        return codTipoPersona;
    }

    public void setCodTipoPersona(String codTipoPersona) {
        this.codTipoPersona = codTipoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (codTipoPersona != null ? codTipoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoPersona)) {
            return false;
        }
        TipoPersona other = (TipoPersona) object;
        if ((this.codTipoPersona == null && other.codTipoPersona != null) || (this.codTipoPersona != null && !this.codTipoPersona.equals(other.codTipoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codTipoPersona=" + codTipoPersona + " ]";
    }

}

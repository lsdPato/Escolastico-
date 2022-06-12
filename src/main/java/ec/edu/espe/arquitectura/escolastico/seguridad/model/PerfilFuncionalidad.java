
package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "seg_perfil_funcionalidad")

public class PerfilFuncionalidad implements Serializable {

    private static final long serialVersionUID = 12312L;
    @EmbeddedId
    private PerfilFuncionalidadPK pk;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    @Version
    private Integer version;
    @JoinColumn(name = "cod_funcionalidad", referencedColumnName = "cod_funcionalidad", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionalidad funcionalidad;
    @JoinColumn(name = "cod_perfil", referencedColumnName = "cod_perfil", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;

    public PerfilFuncionalidad() {
    }

    public PerfilFuncionalidad(String codPerfil, Integer codFuncionalidad) {
        this.pk = new PerfilFuncionalidadPK(codPerfil, codFuncionalidad);
    }

    public PerfilFuncionalidadPK getPerfilFuncionalidadPK() {
        return pk;
    }

    public void setPerfilFuncionalidadPK(PerfilFuncionalidadPK PerfilFuncionalidadPK) {
        this.pk = PerfilFuncionalidadPK;
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

    public Funcionalidad getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(Funcionalidad funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PerfilFuncionalidad)) {
            return false;
        }
        PerfilFuncionalidad other = (PerfilFuncionalidad) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ PerfilFuncionalidadPK=" + pk + " ]";
    }

}

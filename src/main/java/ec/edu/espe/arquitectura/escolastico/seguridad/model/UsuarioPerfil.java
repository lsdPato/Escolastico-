
package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "seg_usuario_perfil")


public class UsuarioPerfil implements Serializable {

    private static final long serialVersionUID = 165465L;
    @EmbeddedId
    private UsuarioPerfilPK pk;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;
    @JoinColumn(name = "cod_perfil", referencedColumnName = "cod_perfil", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioPerfil() {
    }

    public UsuarioPerfil(String codUsuario, String codPerfil) {
        this.pk = new UsuarioPerfilPK(codUsuario, codPerfil);
    }

    public UsuarioPerfilPK getUsuarioPerfilPK() {
        return pk;
    }

    public void setUsuarioPerfilPK(UsuarioPerfilPK UsuarioPerfilPK) {
        this.pk = UsuarioPerfilPK;
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

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil Perfil) {
        this.perfil = Perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.usuario = Usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UsuarioPerfil)) {
            return false;
        }
        UsuarioPerfil other = (UsuarioPerfil) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ UsuarioPerfilPK=" + pk + " ]";
    }

}

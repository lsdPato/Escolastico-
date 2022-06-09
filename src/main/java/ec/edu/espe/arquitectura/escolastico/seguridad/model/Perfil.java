
package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "seg_perfil")
@Proxy(lazy = false)
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1324324L;
    @Id
    @Column(name = "cod_perfil", nullable = false, length = 8)
    private String codPerfil;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<UsuarioPerfil> usuarioPerfiles;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<PerfilFuncionalidad> perfilFuncionalidades;

    public Perfil() {
    }

    public Perfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<UsuarioPerfil> getUsuarioPerfiles() {
        return usuarioPerfiles;
    }

    public void setUsuarioPerfiles(List<UsuarioPerfil> usuarioPerfilList) {
        this.usuarioPerfiles = usuarioPerfilList;
    }

    public List<PerfilFuncionalidad> getPerfilFuncionalidades() {
        return perfilFuncionalidades;
    }

    public void setPerfilFuncionalidades(List<PerfilFuncionalidad> perfilFuncionalidadList) {
        this.perfilFuncionalidades = perfilFuncionalidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPerfil != null ? codPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.codPerfil == null && other.codPerfil != null) || (this.codPerfil != null && !this.codPerfil.equals(other.codPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codPerfil=" + codPerfil + " ]";
    }

}

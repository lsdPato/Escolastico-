
package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "seg_usuario", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"mail"})})

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1543L;
    @Id
    @Column(name = "cod_usuario", nullable = false, length = 30)
    private String codUsuario;
    @Column(name = "mail", nullable = false, length = 128)
    private String mail;
    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;
    @Column(name = "telefono", length = 10)
    private String telefono;
    @Column(name = "clave", nullable = false, length = 64)
    private String clave;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "origen", nullable = false, length = 3)
    private String origen;
    @Column(name = "fecha_cambio_clave")
    @Temporal(TemporalType.DATE)
    private Date fechaCambioClave;
    @Column(name = "nro_intentos_fallidos", nullable = false)
    private Integer nroIntentosFallidos;
    @Column(name = "fecha_ultima_sesion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaSesion;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<UsuarioPerfil> usuarioPerfilList;

    public Usuario() {
    }

    public Usuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Date getFechaCambioClave() {
        return fechaCambioClave;
    }

    public void setFechaCambioClave(Date fechaCambioClave) {
        this.fechaCambioClave = fechaCambioClave;
    }

    public Integer getNroIntentosFallidos() {
        return nroIntentosFallidos;
    }

    public void setNroIntentosFallidos(Integer nroIntentosFallidos) {
        this.nroIntentosFallidos = nroIntentosFallidos;
    }

    public Date getFechaUltimaSesion() {
        return fechaUltimaSesion;
    }

    public void setFechaUltimaSesion(Date fechaUltimaSesion) {
        this.fechaUltimaSesion = fechaUltimaSesion;
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

    public List<UsuarioPerfil> getUsuarioPerfilList() {
        return usuarioPerfilList;
    }

    public void setUsuarioPerfilList(List<UsuarioPerfil> usuarioPerfilList) {
        this.usuarioPerfilList = usuarioPerfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codUsuario=" + codUsuario + " ]";
    }

}


package ec.edu.espe.arquitectura.escolastico.persona.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "per_documento_persona")
public class DocumentoPersona implements Serializable {

    private static final long serialVersionUID = 12233L;
    @EmbeddedId
    private DocumentoPersonaPK pk;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "archivado", length = 1)
    private String archivado;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fecha_caducidad")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidad;
    @Column(name = "digitalizado", length = 1)
    private String digitalizado;
    @Column(name = "url", length = 255)
    private String url;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "cod_tipo_documento", referencedColumnName = "cod_tipo_documento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;

    public DocumentoPersona() {
    }

    public DocumentoPersona(int codPersona, String codTipoDocumento) {
        this.pk = new DocumentoPersonaPK(codPersona, codTipoDocumento);
    }

    public DocumentoPersonaPK getDocumentoPersonaPK() {
        return pk;
    }

    public void setDocumentoPersonaPK(DocumentoPersonaPK pk) {
        this.pk = pk;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getArchivado() {
        return archivado;
    }

    public void setArchivado(String archivado) {
        this.archivado = archivado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getDigitalizado() {
        return digitalizado;
    }

    public void setDigitalizado(String digitalizado) {
        this.digitalizado = digitalizado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DocumentoPersona)) {
            return false;
        }
        DocumentoPersona other = (DocumentoPersona) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "documentoPersona[ pk=" + pk + " ]";
    }

}


package ec.edu.espe.arquitectura.escolastico.persona.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "per_direccion_persona")
public class DireccionPersona implements Serializable {

    private static final long serialVersionUID = 12345L;
    @EmbeddedId
    private DireccionPersonaPK pk;
    @Column(name = "cod_tipo_direccion", nullable = false, length = 3)
    private String codTipoDireccion;
    @Column(name = "cod_org_geo_direccion", nullable = false)
    private int codOrgGeoDireccion;
    @Column(name = "calle_principal", nullable = false, length = 100)
    private String callePrincipal;
    @Column(name = "numeracion", nullable = false, length = 15)
    private String numeracion;
    @Column(name = "calle_secundaria", length = 100)
    private String calleSecundaria;
    @Column(name = "direccion_adicional", length = 50)
    private String direccionAdicional;
    @Column(name = "barrio", length = 100)
    private String barrio;
    @Column(name = "referencia", length = 255)
    private String referencia;
    @Column(name = "telefono", length = 15)
    private String telefono;
    @Column(name = "principal", nullable = false, length = 1)
    private String principal;
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

    public DireccionPersona() {
    }

    public DireccionPersona(int codPersona, Integer secDireccion) {
        this.pk = new DireccionPersonaPK(codPersona, secDireccion);
    }

    public DireccionPersonaPK getDireccionPersonaPK() {
        return pk;
    }

    public void setDireccionPersonaPK(DireccionPersonaPK pk) {
        this.pk = pk;
    }

    public String getCodTipoDireccion() {
        return codTipoDireccion;
    }

    public void setCodTipoDireccion(String codTipoDireccion) {
        this.codTipoDireccion = codTipoDireccion;
    }

    public int getCodOrgGeoDireccion() {
        return codOrgGeoDireccion;
    }

    public void setCodOrgGeoDireccion(int codOrgGeoDireccion) {
        this.codOrgGeoDireccion = codOrgGeoDireccion;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getDireccionAdicional() {
        return direccionAdicional;
    }

    public void setDireccionAdicional(String direccionAdicional) {
        this.direccionAdicional = direccionAdicional;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DireccionPersona)) {
            return false;
        }
        DireccionPersona other = (DireccionPersona) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DireccionPersona[ DireccionPersonaPK=" + pk + " ]";
    }

}

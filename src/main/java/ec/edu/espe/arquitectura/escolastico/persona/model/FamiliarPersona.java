
package ec.edu.espe.arquitectura.escolastico.persona.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "per_familiar_persona")
public class FamiliarPersona implements Serializable {

    private static final long serialVersionUID = 123445L;
    @EmbeddedId
    private FamiliarPersonaPK pk;
    @Column(name = "tipo_familiar", nullable = false, length = 3)
    private String tipoFamiliar;
    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;
    @Column(name = "tipo_identificacion", length = 3)
    private String tipoIdentificacion;
    @Column(name = "identificacion", length = 20)
    private String identificacion;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "telefono", length = 20)
    private String telefono;
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

    public FamiliarPersona() {
    }

    public FamiliarPersona(int codPersona, Integer secFamiliarPersona) {
        this.pk = new FamiliarPersonaPK(codPersona, secFamiliarPersona);
    }

    public FamiliarPersonaPK getFamiliarPersonaPK() {
        return pk;
    }

    public void setFamiliarPersonaPK(FamiliarPersonaPK pk) {
        this.pk = pk;
    }

    public String getTipoFamiliar() {
        return tipoFamiliar;
    }

    public void setTipoFamiliar(String tipoFamiliar) {
        this.tipoFamiliar = tipoFamiliar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        if (!(object instanceof FamiliarPersona)) {
            return false;
        }
        FamiliarPersona other = (FamiliarPersona) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ pk=" + pk + " ]";
    }

}

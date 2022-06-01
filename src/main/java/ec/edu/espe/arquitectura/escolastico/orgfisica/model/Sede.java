
package ec.edu.espe.arquitectura.escolastico.orgfisica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ofi_sede")
public class Sede implements Serializable {

    private static final long serialVersionUID = 782456L;
    @Id
    @Column(name = "cod_sede", nullable = false, length = 8)
    private String codSede;
    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;
    @Column(name = "direccion", length = 10)
    private String direccion;
    @Column(name = "es_principal", nullable = false, length = 1)
    private String esPrincipal;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;
    @OneToMany(mappedBy = "codSede")
    private List<Edificio> edificios;
    @JoinColumn(name = "cod_institucion", referencedColumnName = "cod_institucion")
    @ManyToOne
    private InstitucionFisica institucion;

    public Sede() {
    }

    public Sede(String codSede) {
        this.codSede = codSede;
    }

    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(String esPrincipal) {
        this.esPrincipal = esPrincipal;
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

    public List<Edificio> getEdificioList() {
        return edificios;
    }

    public void setEdificioList(List<Edificio> edificioList) {
        this.edificios = edificioList;
    }

    public InstitucionFisica getCodInstitucion() {
        return institucion;
    }

    public void setCodInstitucion(InstitucionFisica codInstitucion) {
        this.institucion = codInstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSede != null ? codSede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.codSede == null && other.codSede != null) || (this.codSede != null && !this.codSede.equals(other.codSede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sede[ codSede=" + codSede + " ]";
    }

}

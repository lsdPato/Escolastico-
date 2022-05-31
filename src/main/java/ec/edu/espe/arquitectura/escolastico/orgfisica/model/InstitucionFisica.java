
package ec.edu.espe.arquitectura.escolastico.orgfisica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ofi_institucion")
public class InstitucionFisica implements Serializable {

    private static final long serialVersionUID = 13456L;
    @Id
    @Column(name = "cod_institucion", nullable = false)
    private Integer codInstitucion;
    @Column(name = "ruc", nullable = false, length = 13)
    private String ruc;
    @Column(name = "razon_social", nullable = false, length = 250)
    private String razonSocial;
    @Column(name = "nombre_comercial", nullable = false, length = 250)
    private String nombreComercial;
    @Column(name = "dominio", length = 128)
    private String dominio;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;
    @OneToMany(mappedBy = "codInstitucion")
    private List<Sede> sedeList;

    public InstitucionFisica() {
    }

    public InstitucionFisica(Integer codInstitucion) {
        this.codInstitucion = codInstitucion;
    }

    public Integer getCodInstitucion() {
        return codInstitucion;
    }

    public void setCodInstitucion(Integer codInstitucion) {
        this.codInstitucion = codInstitucion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
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

    public List<Sede> getSedeList() {
        return sedeList;
    }

    public void setSedeList(List<Sede> sedeList) {
        this.sedeList = sedeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInstitucion != null ? codInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof InstitucionFisica)) {
            return false;
        }
        InstitucionFisica other = (InstitucionFisica) object;
        if ((this.codInstitucion == null && other.codInstitucion != null) || (this.codInstitucion != null && !this.codInstitucion.equals(other.codInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Institucion[ codInstitucion=" + codInstitucion + " ]";
    }

}

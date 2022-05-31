
package ec.edu.espe.arquitectura.escolastico.general.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gen_pais_estructura")
public class PaisEstructura implements Serializable {

    private static final long serialVersionUID = 87971L;
    @EmbeddedId
    private PaisEstructuraPK pk;
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pais pais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paisEstructura")
    private List<UbicacionGeografica> ubicacionGeograficaList;

    public PaisEstructura() {
    }

    public PaisEstructura(PaisEstructuraPK pk) {
        this.pk = pk;
    }

    public PaisEstructuraPK getPk() {
        return pk;
    }

    public void setPk(PaisEstructuraPK pk) {
        this.pk = pk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<UbicacionGeografica> getUbicacionGeograficaList() {
        return ubicacionGeograficaList;
    }

    public void setUbicacionGeograficaList(List<UbicacionGeografica> ubicacionGeograficaList) {
        this.ubicacionGeograficaList = ubicacionGeograficaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof PaisEstructura)) {
            return false;
        }
        PaisEstructura other = (PaisEstructura) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ PaisEstructuraPK=" + pk + " ]";
    }

}

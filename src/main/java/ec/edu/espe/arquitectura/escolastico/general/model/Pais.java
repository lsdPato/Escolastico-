package ec.edu.espe.arquitectura.escolastico.general.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gen_pais")

public class Pais implements Serializable {

    private static final long serialVersionUID = 1234678L;
    @Id
    @Column(name = "cod_pais", nullable = false, length = 2)
    private String codPais;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "por_omision", nullable = false, length = 1)
    private String porOmision;
    @Column(name = "codigo_telefonico", length = 3)
    private String codigoTelefonico;
    @Column(name = "nacionalidad", length = 50)
    private String nacionalidad;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private List<PaisEstructura> paisEstructuras;
    @OneToMany(mappedBy = "codPais")
    private List<UbicacionGeografica> ubicacionGeograficas;

    public Pais() {
    }

    public Pais(String codPais) {
        this.codPais = codPais;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorOmision() {
        return porOmision;
    }

    public void setPorOmision(String porOmision) {
        this.porOmision = porOmision;
    }

    public String getCodigoTelefonico() {
        return codigoTelefonico;
    }

    public void setCodigoTelefonico(String codigoTelefonico) {
        this.codigoTelefonico = codigoTelefonico;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public List<PaisEstructura> getPaisEstructuras() {
        return paisEstructuras;
    }

    public void setPaisEstructuras(List<PaisEstructura> PaisEstructuraList) {
        this.paisEstructuras = PaisEstructuraList;
    }

    public List<UbicacionGeografica> getUbicacionGeograficas() {
        return ubicacionGeograficas;
    }

    public void setUbicacionGeograficas(List<UbicacionGeografica> ubicacionGeograficaList) {
        this.ubicacionGeograficas = ubicacionGeograficaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codPais=" + codPais + " ]";
    }

}

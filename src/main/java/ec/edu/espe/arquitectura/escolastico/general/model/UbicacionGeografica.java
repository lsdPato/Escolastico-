
package ec.edu.espe.arquitectura.escolastico.general.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gen_ubicacion_geografica")
public class UbicacionGeografica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_ubicacion_geo_int", nullable = false)
    private Integer codUbicacionGeoInt;
    @Column(name = "cod_pais", nullable = false)
    private String codPais;
    @Column(name = "cod_nivel", nullable = false)
    private Short nivel;
    @Column(name = "cod_ubicacion_geografica", nullable = false)
    private String codUbicacionGeografica;
    @Column(name = "cod_ubicacion_geo_padre", nullable = false, length = 20)
    private Integer codUbicacionGeoPadre;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "codigo_area_telefono", length = 4)
    private String codigoAreaTelefono;
    @Column(name = "codigo_alterno", length = 15)
    private String codigoAlterno;
    @Column(name = "codigo_postal", length = 15)
    private String codigoPostal;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    @OneToMany(mappedBy = "codUbicacionGeoInt")
    private List<InstitucionGeneral> institucionList;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Pais pais;
    @JoinColumns({
            @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "nivel", referencedColumnName = "nivel", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PaisEstructura paisEstructura;
    @OneToMany(mappedBy = "codUbicacionGeoPadre")
    private List<UbicacionGeografica> ubicacionGeograficaList;
    @JoinColumn(name = "cod_ubicacion_geo_padre", referencedColumnName = "cod_ubicacion_geo_int", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private UbicacionGeografica ubicacionGeoPadre;

    public UbicacionGeografica() {
    }

    public UbicacionGeografica(Integer codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    public Integer getCodUbicacionGeoInt() {
        return codUbicacionGeoInt;
    }

    public void setCodUbicacionGeoInt(Integer codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public Short getNivel() {
        return nivel;
    }

    public void setNivel(Short nivel) {
        this.nivel = nivel;
    }

    public String getCodUbicacionGeografica() {
        return codUbicacionGeografica;
    }

    public void setCodUbicacionGeografica(String codUbicacionGeografica) {
        this.codUbicacionGeografica = codUbicacionGeografica;
    }

    public Integer getCodUbicacionGeoPadre() {
        return codUbicacionGeoPadre;
    }

    public void setCodUbicacionGeoPadre(Integer codUbicacionGeoPadre) {
        this.codUbicacionGeoPadre = codUbicacionGeoPadre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoAreaTelefono() {
        return codigoAreaTelefono;
    }

    public void setCodigoAreaTelefono(String codigoAreaTelefono) {
        this.codigoAreaTelefono = codigoAreaTelefono;
    }

    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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

    public List<InstitucionGeneral> getInstitucionList() {
        return institucionList;
    }

    public void setInstitucionList(List<InstitucionGeneral> institucionList) {
        this.institucionList = institucionList;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public PaisEstructura getPaisEstructura() {
        return paisEstructura;
    }

    public void setPaisEstructura(PaisEstructura paisEstructura) {
        this.paisEstructura = paisEstructura;
    }

    public List<UbicacionGeografica> getUbicacionGeograficaList() {
        return ubicacionGeograficaList;
    }

    public void setUbicacionGeograficaList(List<UbicacionGeografica> ubicacionGeograficaList) {
        this.ubicacionGeograficaList = ubicacionGeograficaList;
    }

    public UbicacionGeografica getUbicacionGeoPadre() {
        return ubicacionGeoPadre;
    }

    public void setUbicacionGeoPadre(UbicacionGeografica ubicacionGeoPadre) {
        this.ubicacionGeoPadre = ubicacionGeoPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUbicacionGeoInt != null ? codUbicacionGeoInt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof UbicacionGeografica)) {
            return false;
        }
        UbicacionGeografica other = (UbicacionGeografica) object;
        if ((this.codUbicacionGeoInt == null && other.codUbicacionGeoInt != null) || (this.codUbicacionGeoInt != null && !this.codUbicacionGeoInt.equals(other.codUbicacionGeoInt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codUbicacionGeoInt=" + codUbicacionGeoInt + " ]";
    }

}

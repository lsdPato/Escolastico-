
package ec.edu.espe.arquitectura.escolastico.persona.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.general.model.Pais;
import ec.edu.espe.arquitectura.escolastico.general.model.UbicacionGeografica;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "per_persona")
@Proxy
public class Persona implements Serializable {
    private static final long serialVersionUID = -1471250292976955422L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;
    @Column(name = "codigo_alterno", nullable = false, length = 15)
    private String codigoAlterno;
    @Column(name = "tipo_identificacion", nullable = false, length = 3)
    private String tipoIdentificacion;
    @Column(name = "identificacion", nullable = false, length = 20)
    private String identificacion;
    @Column(name = "nombre1", nullable = false, length = 32)
    private String nombre1;
    @Column(name = "nombre2", length = 32)
    private String nombre2;
    @Column(name = "apellido1", nullable = false, length = 32)
    private String apellido1;
    @Column(name = "apellido2", length = 32)
    private String apellido2;
    @Column(name = "nombre_completo", nullable = false, length = 128)
    private String nombreCompleto;
    @Column(name = "nombre_comun", length = 64)
    private String nombreComun;
    @Column(name = "genero", nullable = false, length = 3)
    private String genero;
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "estado_civil", nullable = false, length = 3)
    private String estadoCivil;
    @Column(name = "email", nullable = false, length = 128)
    private String email;
    @Column(name = "email_alterno", length = 128)
    private String emailAlterno;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "telefono_movil", length = 20)
    private String telefonoMovil;
    @Column(name = "extranjero", nullable = false, length = 1)
    private String extranjero;
    @Column(name = "requiere_representante", nullable = false, length = 1)
    private String requiereRepresentante;
    @Column(name = "discapacidad", nullable = false, length = 1)
    private String discapacidad;
    @Column(name = "porcentaje_discapacidad")
    private Integer porcentajeDiscapacidad;
    @Column(name = "carnet_conadis", length = 10)
    private String carnetConadis;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    @Version
    private Integer version;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<DireccionPersona> direcciones;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Matricula> matriculas;
    @JsonIgnore
    @JoinColumn(name = "cod_pais_nacimiento", referencedColumnName = "cod_pais")
    @ManyToOne
    private Pais paisNacimiento;
    @JsonIgnore
    @JoinColumn(name = "nacionalidad", referencedColumnName = "cod_pais")
    @ManyToOne
    private Pais nacionalidad;
    @JsonIgnore
    @JoinColumn(name = "lugar_nacimiento", referencedColumnName = "cod_ubicacion_geo_int")
    @ManyToOne
    private UbicacionGeografica lugarNacimiento;
    @JsonIgnore
    @JoinColumn(name = "cod_tipo_discapacidad", referencedColumnName = "cod_tipo_discapacidad")
    @ManyToOne
    private TipoDiscapacidad tipoDiscapacidad;
    @JsonIgnore
    @JoinColumn(name = "cod_tipo_persona", referencedColumnName = "cod_tipo_persona")
    @ManyToOne
    private TipoPersona tipoPersona;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
    private List<DocumentoPersona> documentos;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<FamiliarPersona> familiares;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<HistTipoPersona> historialesTipoPersona;

    public Persona() {
    }

    public Persona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
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

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAlterno() {
        return emailAlterno;
    }

    public void setEmailAlterno(String emailAlterno) {
        this.emailAlterno = emailAlterno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(String extranjero) {
        this.extranjero = extranjero;
    }

    public String getRequiereRepresentante() {
        return requiereRepresentante;
    }

    public void setRequiereRepresentante(String requiereRepresentante) {
        this.requiereRepresentante = requiereRepresentante;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public Integer getPorcentajeDiscapacidad() {
        return porcentajeDiscapacidad;
    }

    public void setPorcentajeDiscapacidad(Integer porcentajeDiscapacidad) {
        this.porcentajeDiscapacidad = porcentajeDiscapacidad;
    }

    public String getCarnetConadis() {
        return carnetConadis;
    }

    public void setCarnetConadis(String carnetConadis) {
        this.carnetConadis = carnetConadis;
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

    public List<DireccionPersona> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionPersona> direccionPersonaList) {
        this.direcciones = direccionPersonaList;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculaList) {
        this.matriculas = matriculaList;
    }

    public Pais getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(Pais codPaisNacimiento) {
        this.paisNacimiento = codPaisNacimiento;
    }

    public Pais getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Pais nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public UbicacionGeografica getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(UbicacionGeografica lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public TipoDiscapacidad getTipoDiscapacidad() {
        return tipoDiscapacidad;
    }

    public void setTipoDiscapacidad(TipoDiscapacidad codTipoDiscapacidad) {
        this.tipoDiscapacidad = codTipoDiscapacidad;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona codTipoPersona) {
        this.tipoPersona = codTipoPersona;
    }

    public List<DocumentoPersona> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoPersona> documentoPersonaList) {
        this.documentos = documentoPersonaList;
    }

    public List<FamiliarPersona> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(List<FamiliarPersona> familiarPersonaList) {
        this.familiares = familiarPersonaList;
    }

    public List<HistTipoPersona> getHistorialesTipoPersona() {
        return historialesTipoPersona;
    }

    public void setHistorialesTipoPersona(List<HistTipoPersona> histTipoPersonaList) {
        this.historialesTipoPersona = histTipoPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPersona != null ? codPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.codPersona == null && other.codPersona != null) || (this.codPersona != null && !this.codPersona.equals(other.codPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codPersona=" + codPersona + " ]";
    }

}

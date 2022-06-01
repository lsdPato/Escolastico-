
package ec.edu.espe.arquitectura.escolastico.orgfisica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ofi_edificio")
public class Edificio implements Serializable {

    private static final long serialVersionUID = 132444L;
    @Id
    @Column(name = "cod_edificio", nullable = false, length = 8)
    private String codEdificio;
    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;
    @Column(name = "cod_sede", length = 8)
    private String codSede;
    @Column(name = "cod_alterno", length = 16)
    private String codAlterno;
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    @Column(name = "direccion", nullable = false, length = 256)
    private String direccion;
    @Column(name = "comentario", length = 1000)
    private String comentario;
    @Column(name = "maneja_bloques", nullable = false, length = 1)
    private String manejaBloques;
    @Column(name = "posee_aulas", nullable = false, length = 1)
    private String poseeAulas;

    @Column(name = "pisos", nullable = false)
    private Integer pisos;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;
    @JoinColumn(name = "cod_sede", referencedColumnName = "cod_sede", nullable = false,updatable = false,insertable = false)
    @ManyToOne
    private Sede sede;
    @OneToMany(mappedBy = "edificio")
    private List<EdificioBloque> edificioBloque;
    @OneToMany(mappedBy = "edificio")
    private List<Aula> aulas;

    public Edificio() {
    }

    public Edificio(String codEdificio) {
        this.codEdificio = codEdificio;
    }

    public String getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(String codEdificio) {
        this.codEdificio = codEdificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodAlterno() {
        return codAlterno;
    }

    public void setCodAlterno(String codAlterno) {
        this.codAlterno = codAlterno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getManejaBloques() {
        return manejaBloques;
    }

    public void setManejaBloques(String manejaBloques) {
        this.manejaBloques = manejaBloques;
    }

    public String getPoseeAulas() {
        return poseeAulas;
    }

    public void setPoseeAulas(String poseeAulas) {
        this.poseeAulas = poseeAulas;
    }

    public Integer getPisos() {
        return pisos;
    }

    public void setPisos(Integer pisos) {
        this.pisos = pisos;
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

    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public List<EdificioBloque> getEdificioBloque() {
        return edificioBloque;
    }

    public void setEdificioBloque(List<EdificioBloque> edificioBloque) {
        this.edificioBloque = edificioBloque;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEdificio != null ? codEdificio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Edificio)) {
            return false;
        }
        Edificio other = (Edificio) object;
        if ((this.codEdificio == null && other.codEdificio != null) || (this.codEdificio != null && !this.codEdificio.equals(other.codEdificio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Edificio[ codEdificio=" + codEdificio + " ]";
    }

}

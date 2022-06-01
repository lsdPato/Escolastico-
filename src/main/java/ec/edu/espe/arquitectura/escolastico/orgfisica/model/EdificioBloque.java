
package ec.edu.espe.arquitectura.escolastico.orgfisica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ofi_edificio_bloque")
public class EdificioBloque implements Serializable {

    private static final long serialVersionUID = 89256L;
    @Id
    @Column(name = "cod_edificio_bloque", nullable = false, length = 8)
    private String codEdificioBloque;
    @Column(name = "nombre_bloque", nullable = false, length = 128)
    private String nombreBloque;
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;
    @JoinColumn(name = "cod_edificio", referencedColumnName = "cod_edificio")
    @ManyToOne
    private Edificio edificio;
    @OneToMany(mappedBy = "codEdificioBloque")
    private List<Aula> aulas;

    public EdificioBloque() {
    }

    public EdificioBloque(String codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    public String getCodEdificioBloque() {
        return codEdificioBloque;
    }

    public void setCodEdificioBloque(String codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    public String getNombreBloque() {
        return nombreBloque;
    }

    public void setNombreBloque(String nombreBloque) {
        this.nombreBloque = nombreBloque;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio codEdificio) {
        this.edificio = codEdificio;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulaList) {
        this.aulas = aulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEdificioBloque != null ? codEdificioBloque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EdificioBloque)) {
            return false;
        }
        EdificioBloque other = (EdificioBloque) object;
        if ((this.codEdificioBloque == null && other.codEdificioBloque != null) || (this.codEdificioBloque != null && !this.codEdificioBloque.equals(other.codEdificioBloque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EdificioBloque[ codEdificioBloque=" + codEdificioBloque + " ]";
    }

}

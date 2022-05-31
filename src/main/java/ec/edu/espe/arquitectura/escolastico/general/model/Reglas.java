

package ec.edu.espe.arquitectura.escolastico.general.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "gen_reglas")
public class Reglas implements Serializable {

    private static final long serialVersionUID = 156478L;
    @Id
    @Column(name = "cod_regla", nullable = false, length = 30)
    private String codRegla;
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @Column(name = "valor_numerico")
    private Integer valorNumerico;
    @Column(name = "valor_texto", length = 50)
    private String valorTexto;
    @Column(name = "unidad", nullable = false, length = 100)
    private String unidad;
    @Column(name = "clasificacion", nullable = false, length = 3)
    private String clasificacion;
    @Column(name = "descripcion_detallada", length = 500)
    private String descripcionDetallada;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;

    public Reglas() {
    }

    public Reglas(String codRegla) {
        this.codRegla = codRegla;
    }

    public String getCodRegla() {
        return codRegla;
    }

    public void setCodRegla(String codRegla) {
        this.codRegla = codRegla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(Integer valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public String getValorTexto() {
        return valorTexto;
    }

    public void setValorTexto(String valorTexto) {
        this.valorTexto = valorTexto;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcionDetallada() {
        return descripcionDetallada;
    }

    public void setDescripcionDetallada(String descripcionDetallada) {
        this.descripcionDetallada = descripcionDetallada;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRegla != null ? codRegla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Reglas)) {
            return false;
        }
        Reglas other = (Reglas) object;
        if ((this.codRegla == null && other.codRegla != null) || (this.codRegla != null && !this.codRegla.equals(other.codRegla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codRegla=" + codRegla + " ]";
    }

}

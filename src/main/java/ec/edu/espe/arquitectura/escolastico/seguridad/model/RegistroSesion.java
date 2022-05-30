
package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "seg_registro_sesion")

public class RegistroSesion implements Serializable {

    private static final long serialVersionUID = 134234L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "secuencia", nullable = false)
    private Integer secuencia;
    @Column(name = "cod_usuario", nullable = false, length = 32)
    private String codUsuario;
    @Column(name = "fecha_conexion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConexion;
    @Column(name = "ip_conexion", nullable = false, length = 30)
    private String ipConexion;
    @Column(name = "resultado", nullable = false, length = 3)
    private String resultado;
    @Column(name = "error", length = 5)
    private String error;

    public RegistroSesion() {
    }

    public RegistroSesion(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Date getFechaConexion() {
        return fechaConexion;
    }

    public void setFechaConexion(Date fechaConexion) {
        this.fechaConexion = fechaConexion;
    }

    public String getIpConexion() {
        return ipConexion;
    }

    public void setIpConexion(String ipConexion) {
        this.ipConexion = ipConexion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuencia != null ? secuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RegistroSesion)) {
            return false;
        }
        RegistroSesion other = (RegistroSesion) object;
        if ((this.secuencia == null && other.secuencia != null) || (this.secuencia != null && !this.secuencia.equals(other.secuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ secuencia=" + secuencia + " ]";
    }

}

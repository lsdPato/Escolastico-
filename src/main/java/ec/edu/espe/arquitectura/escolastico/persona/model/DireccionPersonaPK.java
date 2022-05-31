
package ec.edu.espe.arquitectura.escolastico.persona.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DireccionPersonaPK implements Serializable {

    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;
    @Column(name = "sec_direccion", nullable = false)
    private Integer secDireccion;

    public DireccionPersonaPK() {
    }

    public DireccionPersonaPK(Integer codPersona, Integer secDireccion) {
        this.codPersona = codPersona;
        this.secDireccion = secDireccion;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public Integer getSecDireccion() {
        return secDireccion;
    }

    public void setSecDireccion(Integer secDireccion) {
        this.secDireccion = secDireccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPersona;
        hash += (int) secDireccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof DireccionPersonaPK)) {
            return false;
        }
        DireccionPersonaPK other = (DireccionPersonaPK) object;
        if (this.codPersona != other.codPersona) {
            return false;
        }
        if (this.secDireccion != other.secDireccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DireccionPersonaPK[ codPersona=" + codPersona + ", secDireccion=" + secDireccion + " ]";
    }

}

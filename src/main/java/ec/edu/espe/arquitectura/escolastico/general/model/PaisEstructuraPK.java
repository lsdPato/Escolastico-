
package ec.edu.espe.arquitectura.escolastico.general.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PaisEstructuraPK implements Serializable {

    @Column(name = "cod_pais", nullable = false, length = 2)
    private String codPais;
    @Column(name = "nivel", nullable = false)
    private short nivel;

    public PaisEstructuraPK() {
    }

    public PaisEstructuraPK(String codPais, short nivel) {
        this.codPais = codPais;
        this.nivel = nivel;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public short getNivel() {
        return nivel;
    }

    public void setNivel(short nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        hash += (int) nivel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof PaisEstructuraPK)) {
            return false;
        }
        PaisEstructuraPK other = (PaisEstructuraPK) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codPais=" + codPais + ", nivel=" + nivel + " ]";
    }

}

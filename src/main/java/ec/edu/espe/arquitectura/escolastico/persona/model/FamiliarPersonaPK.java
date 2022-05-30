
package ec.edu.espe.arquitectura.escolastico.persona.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FamiliarPersonaPK implements Serializable {

    @Column(name = "cod_persona", nullable = false)
    private int codPersona;
    @Column(name = "sec_familiar_persona", nullable = false)
    private short secFamiliarPersona;

    public FamiliarPersonaPK() {
    }

    public FamiliarPersonaPK(int codPersona, short secFamiliarPersona) {
        this.codPersona = codPersona;
        this.secFamiliarPersona = secFamiliarPersona;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public short getSecFamiliarPersona() {
        return secFamiliarPersona;
    }

    public void setSecFamiliarPersona(short secFamiliarPersona) {
        this.secFamiliarPersona = secFamiliarPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPersona;
        hash += (int) secFamiliarPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FamiliarPersonaPK)) {
            return false;
        }
        FamiliarPersonaPK other = (FamiliarPersonaPK) object;
        if (this.codPersona != other.codPersona) {
            return false;
        }
        if (this.secFamiliarPersona != other.secFamiliarPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "familiarPersonaPK[ codPersona=" + codPersona + ", secFamiliarPersona=" + secFamiliarPersona + " ]";
    }

}

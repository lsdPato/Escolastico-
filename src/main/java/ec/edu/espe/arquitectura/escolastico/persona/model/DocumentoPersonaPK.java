
package ec.edu.espe.arquitectura.escolastico.persona.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DocumentoPersonaPK implements Serializable {

    @Column(name = "cod_persona", nullable = false)
    private int codPersona;
    @Column(name = "cod_tipo_documento", nullable = false, length = 16)
    private String codTipoDocumento;

    public DocumentoPersonaPK() {
    }

    public DocumentoPersonaPK(int codPersona, String codTipoDocumento) {
        this.codPersona = codPersona;
        this.codTipoDocumento = codTipoDocumento;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(String codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPersona;
        hash += (codTipoDocumento != null ? codTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DocumentoPersonaPK)) {
            return false;
        }
        DocumentoPersonaPK other = (DocumentoPersonaPK) object;
        if (this.codPersona != other.codPersona) {
            return false;
        }
        if ((this.codTipoDocumento == null && other.codTipoDocumento != null) || (this.codTipoDocumento != null && !this.codTipoDocumento.equals(other.codTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "documentoPersonaPK[ codPersona=" + codPersona + ", codTipoDocumento=" + codTipoDocumento + " ]";
    }

}


package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UsuarioPerfilPK implements Serializable {

    @Column(name = "cod_usuario", nullable = false, length = 30)
    private String codUsuario;
    @Column(name = "cod_perfil", nullable = false, length = 8)
    private String codPerfil;

    public UsuarioPerfilPK() {
    }

    public UsuarioPerfilPK(String codUsuario, String codPerfil) {
        this.codUsuario = codUsuario;
        this.codPerfil = codPerfil;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        hash += (codPerfil != null ? codPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UsuarioPerfilPK)) {
            return false;
        }
        UsuarioPerfilPK other = (UsuarioPerfilPK) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        if ((this.codPerfil == null && other.codPerfil != null) || (this.codPerfil != null && !this.codPerfil.equals(other.codPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codUsuario=" + codUsuario + ", codPerfil=" + codPerfil + " ]";
    }

}

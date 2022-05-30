
package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.UsuarioPerfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.UsuarioPerfilPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioPerfilRespository extends JpaRepository<UsuarioPerfil, UsuarioPerfilPK> {

}

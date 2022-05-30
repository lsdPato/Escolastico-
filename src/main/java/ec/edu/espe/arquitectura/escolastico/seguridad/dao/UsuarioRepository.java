
package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByMail(String mail);

    List<Usuario> findByNombreLike(String nombrePattern);

    List<Usuario> findByEstado(String estado);

    List<Usuario> findByNombreLikeAndEstado(String nombrePattern, String estado);
}

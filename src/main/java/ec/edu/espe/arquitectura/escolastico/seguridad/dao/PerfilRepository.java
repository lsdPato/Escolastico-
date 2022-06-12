
package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, String> {
    List<Perfil> findByEstado(String estado);
    Optional<Perfil> findByEstadoAndCodPerfil(String estado,String codPerfil);
}

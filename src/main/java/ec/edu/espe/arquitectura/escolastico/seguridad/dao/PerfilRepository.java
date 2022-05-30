
package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfilRepository extends JpaRepository<Perfil, String> {
    List<Perfil> findByEstado(String estado);
}

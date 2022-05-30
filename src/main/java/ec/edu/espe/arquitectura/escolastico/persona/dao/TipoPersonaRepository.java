
package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.TipoPersona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoPersonaRepository extends JpaRepository<TipoPersona, String> {
    List<TipoPersona> findByEstado(String estado);
}

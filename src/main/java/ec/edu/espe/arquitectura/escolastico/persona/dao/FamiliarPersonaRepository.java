
package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.FamiliarPersona;
import ec.edu.espe.arquitectura.escolastico.persona.model.FamiliarPersonaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamiliarPersonaRepository extends JpaRepository<FamiliarPersona, FamiliarPersonaPK> {
    List<FamiliarPersona> findByTipoFamiliar(String tipoFamiliar);

    FamiliarPersona findByIdentificacion(String identificacion);
}

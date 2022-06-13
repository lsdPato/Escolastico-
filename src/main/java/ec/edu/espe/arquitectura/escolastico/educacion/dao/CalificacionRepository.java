
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.escolastico.educacion.model.CalificacionPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CalificacionRepository extends JpaRepository<Calificacion, CalificacionPK> {

    Optional<Calificacion> findByPkCodNrcAndPkCodPersona(Integer codNrc,Integer codPersona);

    List<Calificacion> findByPkCodPersonaAndCodPeriodo(Integer codPersona, Integer coPeriodo);

    List<Calificacion> findByPkCodPersona(Integer codPersona);


}

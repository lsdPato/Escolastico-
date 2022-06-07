
package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.HistTipoPersona;
import ec.edu.espe.arquitectura.escolastico.persona.model.HistTipoPersonaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface HistTipoPersonaRepository extends JpaRepository<HistTipoPersona, HistTipoPersonaPK> {
    List<HistTipoPersona> findByFechaInicioBetween(Date fechaInicio, Date fechaFinal);

    List<HistTipoPersona> findByFechaInicioBetweenAndPkCodTipoPersona(Date fechaInicio, Date fechaFinal, String codTipoPersona);
}


package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorarioPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface NrcHorarioRepository extends JpaRepository<NrcHorario, NrcHorarioPK> {


    Optional<NrcHorario> findByPkCodAulaAndPkDiaSemanaAndHoraInicioAndPkCodPeriodo(Integer codAula, String diaSemana, Date horaInicio, Integer periodo);


    List<NrcHorario> findByPkCodMateriaAndPkCodPeriodo(Integer codMateria, Integer codPeriodo);
}
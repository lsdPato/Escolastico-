
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorarioPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface NrcHorarioRepository extends JpaRepository<NrcHorario, NrcHorarioPK> {


    List<NrcHorario> findByPkCodAulaAndPkDiaSemana(Integer codAula, String diaSemana);

    List<NrcHorario> findByPkCodMateria(Integer codMateria);

    List<NrcHorario> findByPkCodMateriaAndPkCodPeriodo(Integer codMateria, Integer codPeriodo);
}
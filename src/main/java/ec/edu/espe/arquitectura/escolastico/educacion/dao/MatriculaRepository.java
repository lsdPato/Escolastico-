
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaPK> {
    List<Matricula> findByTipoOrderByTipo(String tipo);

    List<Matricula> findByFechaBetween(Date fechaInicial, Date fechaFinal);

    List<Matricula> findByPkCodPersona(Integer codPersona);

    List<Matricula> findByCodPeriodoAndCodCarrera(Integer codPeriodo, Integer CodCarrera);

    Optional<Matricula> findByCodPeriodoAndPkCodPersona(Integer codPeriodo, Integer codPersona);

    Optional<Matricula> findByPkCodMatriculaAndPkCodPersona(String codMatricula, Integer codPersona);
}
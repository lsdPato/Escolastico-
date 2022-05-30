
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaPK> {
    List<Matricula> findByTipo(String tipo);

    List<Matricula> findByFechaBetween(Date fechaInicial, Date fechaFinal);

    List<Matricula> findByCodPersona(Integer codpersona);

    List<Matricula> findByCodPeriodoAndCodCarrera(Integer codPeriodo, Integer CodCarrera);
}
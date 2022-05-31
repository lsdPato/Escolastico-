
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {

    List<Periodo> findByFechaInicio(Date fechaInicio);

    List<Periodo> findByNombreLike(String nombre);

    List<Periodo> findByNivel(String modalidad);
}
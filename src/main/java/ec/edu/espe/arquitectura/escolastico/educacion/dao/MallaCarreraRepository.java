
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MallaCarreraRepository extends JpaRepository<MallaCarrera, Integer> {

    List<MallaCarrera> findByCodCarreraOrderByCarrera(Integer carrera);

    List<MallaCarrera> findByCodCarreraAndNivelOrderByNivel(Integer carrera, Integer nivel);
}
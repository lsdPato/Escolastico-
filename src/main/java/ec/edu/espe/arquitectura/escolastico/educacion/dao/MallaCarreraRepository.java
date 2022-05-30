
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MallaCarreraRepository extends JpaRepository<MallaCarrera, Integer> {

    List<MallaCarrera> findByCodCarrera(Integer carrera);

    List<MallaCarrera> findByCodCarreraAndNivel(Integer carrera, Integer nivel);
}
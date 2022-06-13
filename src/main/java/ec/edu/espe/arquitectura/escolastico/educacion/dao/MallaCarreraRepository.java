
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MallaCarreraRepository extends JpaRepository<MallaCarrera, Integer> {

    List<MallaCarrera> findByCodCarreraOrderByNivel(Integer carrera);

    List<MallaCarrera> findByCodCarreraAndNivel(Integer carrera, Integer nivel);

    Optional<MallaCarrera> findTopByOrderByCodMateriacarreraDesc();

    Optional<MallaCarrera> findByCodCarreraAndCodMateria(Integer carrera, Integer materia);
}
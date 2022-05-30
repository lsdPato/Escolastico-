
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    List<Carrera> findByTotalSemestres(int totalSemestres);

    Carrera findByNombre(String nombre);

    List<Carrera> findByModalidad(String modalidad);

    List<Carrera> findByNombreAndModalidad(String nombre, String modalidad);

}
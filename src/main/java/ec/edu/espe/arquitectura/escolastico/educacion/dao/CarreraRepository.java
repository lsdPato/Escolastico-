
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    Carrera findByNombreOrderByNombre(String nombre);

    List<Carrera> findByModalidadOrderByModalidad(String modalidad);


}
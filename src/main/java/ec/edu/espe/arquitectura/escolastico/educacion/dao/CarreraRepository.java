
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    List<Carrera> findByNombreOrderByNombre(String nombre);

    List<Carrera> findByModalidadOrderByModalidad(String modalidad);

    List<Carrera> findByNivel(String nivel);

    List<Carrera> findByCodDepartamento(Integer departamento);
}
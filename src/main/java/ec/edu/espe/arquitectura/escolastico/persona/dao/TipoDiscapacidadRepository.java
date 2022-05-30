
package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.TipoDiscapacidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoDiscapacidadRepository extends JpaRepository<TipoDiscapacidad, String> {
    List<TipoDiscapacidad> findByNombreLike(String nombre);
}


package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Prerrequisito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrerrequisitoRepository extends JpaRepository<Prerrequisito, Integer> {

    List<Prerrequisito> findByCodMateria(Integer codMateria);

    List<Prerrequisito> findByTipoAndCodMateria(String tipo, Integer codMateria);
    Optional<Prerrequisito> findTopByOrderByCodPrerrequisito();
}
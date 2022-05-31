
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Prerequisito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrerequisitoRepository extends JpaRepository<Prerequisito, Integer> {

    List<Prerequisito> findByCodMateria(Integer codMateria);

    List<Prerequisito> findByTipoAndCodMateria(String tipo, Integer codMateria);


}
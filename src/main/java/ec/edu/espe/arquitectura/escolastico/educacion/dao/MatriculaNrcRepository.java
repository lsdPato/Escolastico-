
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrcPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaNrcRepository extends JpaRepository<MatriculaNrc, MatriculaNrcPK> {

    List<MatriculaNrc> findByEstado(String estado);
    List<MatriculaNrc> findByPkCodPersonaAndEstado(Integer codPersona, String estado);

}
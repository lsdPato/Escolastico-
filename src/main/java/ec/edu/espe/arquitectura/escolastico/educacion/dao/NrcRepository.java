
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NrcRepository extends JpaRepository<Nrc, NrcPK> {

    List<Nrc> findByNombreLike(String nombrePattern);

    List<Nrc> findByNombreLikeAndCupoDisponibleIsGreaterThan(String nombrePattern, short cupo);

    List<Nrc> findByCodPersona(Integer codDocente);

    List<Nrc> findByPkCodPeriodoAndPkCodMateria(Integer codPeriodo, Integer codMateria);

    List<Nrc> findByNombreLikeAndCupoRegistradoGreaterThan(String nombrePattern, short cupoRegistradoMinimo);

}

package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NrcRepository extends JpaRepository<Nrc, NrcPK> {

    List<Nrc> findByPkCodMateriaLikeAndCupoDisponibleIsGreaterThan(Integer materia, Integer cupo);

    List<Nrc> findByPkCodPeriodoAndPkCodMateria(Integer codPeriodo, Integer codMateria);

    Optional<Nrc> findByPkCodigoNrc(Integer codNrc);
}
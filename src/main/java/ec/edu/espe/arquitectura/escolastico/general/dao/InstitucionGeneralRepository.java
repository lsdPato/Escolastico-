
package ec.edu.espe.arquitectura.escolastico.general.dao;

import ec.edu.espe.arquitectura.escolastico.general.model.InstitucionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstitucionGeneralRepository extends JpaRepository<InstitucionGeneral, String> {
    List<InstitucionGeneral> findByCodUbicacionGeoInt(Integer codUbicacionGeoInt);
}

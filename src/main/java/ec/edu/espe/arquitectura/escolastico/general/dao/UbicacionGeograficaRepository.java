
package ec.edu.espe.arquitectura.escolastico.general.dao;

import ec.edu.espe.arquitectura.escolastico.general.model.UbicacionGeografica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UbicacionGeograficaRepository extends JpaRepository<UbicacionGeografica, String> {
    List<UbicacionGeografica> findByCodPaisAndNivel(String codPais, Short Nivel);

    UbicacionGeografica findByCodUbicacionGeoPadre(Integer codUbicacionGeoPadre);
}

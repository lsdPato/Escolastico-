
package ec.edu.espe.arquitectura.escolastico.general.dao;

import ec.edu.espe.arquitectura.escolastico.general.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, String> {
    Optional<Pais> findByCodigoTelefonico(String codigoTelefonico);

    List<Pais> findByNombreLike(String nombrePattern);
}

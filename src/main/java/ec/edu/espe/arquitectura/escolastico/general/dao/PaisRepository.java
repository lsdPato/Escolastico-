
package ec.edu.espe.arquitectura.escolastico.general.dao;

import ec.edu.espe.arquitectura.escolastico.general.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, String> {
    Pais findByCodigoTelefonico(String codigoTelefonico);
}

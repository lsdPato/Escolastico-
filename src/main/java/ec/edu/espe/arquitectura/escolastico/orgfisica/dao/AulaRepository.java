package ec.edu.espe.arquitectura.escolastico.orgfisica.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisica.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Integer> {
    List<Aula> findByCapacidadAndCodEdificioBloque(Integer capacidad, String edificioBloque);

    List<Aula> findByCodTipoAulaAndCodEdificioBloque(String codTipoAula, String edificioBloque);

    List<Aula> findByCodTipoAulaAndCapacidadAndCodEdificioBloque(String codTipoAula, Integer capacidad, String edificioBloque);
}

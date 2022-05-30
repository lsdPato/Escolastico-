package ec.edu.espe.arquitectura.escolastico.orgfisica.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisica.model.EdificioBloque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EdificioBloqueRepository extends JpaRepository<EdificioBloque, String> {
    List<EdificioBloque> findByDescripcion(String descripcion);
}

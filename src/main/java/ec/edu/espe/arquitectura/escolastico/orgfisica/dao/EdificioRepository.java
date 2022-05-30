package ec.edu.espe.arquitectura.escolastico.orgfisica.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisica.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EdificioRepository extends JpaRepository<Edificio, String> {
    List<Edificio> findByPoseeAulas(String poseeAulas);
}

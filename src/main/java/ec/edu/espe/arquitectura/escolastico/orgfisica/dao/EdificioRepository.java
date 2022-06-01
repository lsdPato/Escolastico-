package ec.edu.espe.arquitectura.escolastico.orgfisica.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisica.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EdificioRepository extends JpaRepository<Edificio, String> {
    List<Edificio> findByPoseeAulasAndCodSede(String poseeAulas, String codSede);

    List<Edificio> findByCodSede(String codSede);
}

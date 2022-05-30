package ec.edu.espe.arquitectura.escolastico.orgfisica.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisica.model.InstitucionFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstitucionFisicaRepository extends JpaRepository<InstitucionFisica, Short> {
    List<InstitucionFisica> findByNombreComercial(String nombreComercial);
}

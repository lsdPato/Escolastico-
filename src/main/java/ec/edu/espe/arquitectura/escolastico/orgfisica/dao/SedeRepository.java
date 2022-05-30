package ec.edu.espe.arquitectura.escolastico.orgfisica.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisica.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SedeRepository extends JpaRepository<Sede, String> {
    List<Sede> findByEsPrincipal(String esPrincipal);
}


package ec.edu.espe.arquitectura.escolastico.general.dao;


import ec.edu.espe.arquitectura.escolastico.general.model.Reglas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReglasRepository extends JpaRepository<Reglas, String> {
    List<Reglas> findByClasificacion(String clasificacion);
}

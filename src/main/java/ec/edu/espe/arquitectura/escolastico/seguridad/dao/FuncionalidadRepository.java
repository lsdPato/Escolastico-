
package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Funcionalidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionalidadRepository extends JpaRepository<Funcionalidad, Integer> {
    List<Funcionalidad> findByCodModuloAndEstado(String codModulo, String estado);
    List<Funcionalidad> findByEstado(String estado);

    Optional<Funcionalidad> findByCodFuncionalidadAndEstado(Integer codFuncionalida, String estado);
}

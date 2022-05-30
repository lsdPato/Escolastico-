
package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.RegistroSesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RegistroSesionRepository extends JpaRepository<RegistroSesion, Integer> {
    List<RegistroSesion> findByCodUsuarioAndFechaConexionGreaterThan(String codUsuario, Date fechaConexion);

    List<RegistroSesion> findByCodUsuarioAndResultadoAndFechaConexionGreaterThan(String codUsuario, String resultado, Date fechaConexion);
}

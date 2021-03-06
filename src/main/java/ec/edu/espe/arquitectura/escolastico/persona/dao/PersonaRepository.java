
package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findByIdentificacion(String identificacion);

    List<Persona> findByNombreCompletoIgnoreCaseLikeOrderByNombreCompleto(String nombreCompleto);

    List<Persona> findByApellido1AndApellido2(String apellido1, String apellido2);

    List<Persona> findByDiscapacidad(String discapacidad);

    Optional<Persona> findByEmailOrderByEmail(String email);

    List<Persona> findByEstado(String estado);

    Persona findByEmailAlterno(String emailAlterno);

    List<Persona> findByFechaNacimientoBetween(Date fechaInicio, Date fechaFinal);


    List<Persona> findByEstadoAndNombreCompletoLike(String estado, String nombreCompleto);
}

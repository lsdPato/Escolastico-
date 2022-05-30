
package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByIdentificacion(String identificacion);

    List<Persona> findByGenero(String genero);

    List<Persona> findByNombreCompletoLike(String nombreCompleto);

    List<Persona> findByDiscapacidad(String discapacidad);

    Persona findByEmail(String email);

    Persona findByEmailAlterno(String emailAlterno);

    List<Persona> findByFechaNacimientoGreaterThan(Date fechaNacimiento);


    List<Persona> findByEstadoAndNombreCompletoLike(String estado, String nombreCompleto);
}

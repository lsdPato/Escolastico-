
package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.DocumentoPersona;
import ec.edu.espe.arquitectura.escolastico.persona.model.DocumentoPersonaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DocumentoPersonaRepository extends JpaRepository<DocumentoPersona, DocumentoPersonaPK> {
    List<DocumentoPersona> findByEstadoAndFechaRegistroGreaterThan(String estado, Date fechaRegistro);

    List<DocumentoPersona> findByEstadoAndFechaRegistroGreaterThanAndArchivado(String estado, Date fechaRegistro, String archivado);
}

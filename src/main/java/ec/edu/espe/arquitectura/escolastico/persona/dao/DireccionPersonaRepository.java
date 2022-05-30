
package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.DireccionPersona;
import ec.edu.espe.arquitectura.escolastico.persona.model.DireccionPersonaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DireccionPersonaRepository extends JpaRepository<DireccionPersona, DireccionPersonaPK> {
    List<DireccionPersona> findByCodTipoDireccionAndPrincipal(String tipoDireccion, String principal);

    List<DireccionPersona> findByCallePrincipalLikeAndNumeracionLikeAndCalleSecundariaLikeAndPrincipal(String callePrincipal, String numeracion, String calleSecundaria, String principal);

    List<DireccionPersona> findByBarrioLike(String barrio);
}

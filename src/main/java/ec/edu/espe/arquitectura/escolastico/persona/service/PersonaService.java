package ec.edu.espe.arquitectura.escolastico.persona.service;

import ec.edu.espe.arquitectura.escolastico.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.NoEncontradoException;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
    public Persona obtenerPorCodigo(Integer codigo){
        Optional<Persona> personaOpt = this.personaRepository.findById(codigo);

        if (personaOpt.isPresent()) {
            return personaOpt.get();
        } else {
            return null;
        }

    }
    public void crear(Persona persona) {

        this.personaRepository.save(persona);
    }
    public void modificar(Persona persona) {
        Persona personaDB = this.obtenerPorCodigo(persona.getCodPersona());
        personaDB.setNombreCompleto(persona.getNombreCompleto());
        personaDB.setApellido1(persona.getApellido1());
        personaDB.setApellido2(persona.getApellido2());
        personaDB.setEstado(persona.getEstado());
        personaDB.setEstadoCivil(persona.getEstadoCivil());
        personaDB.setTelefonoMovil(persona.getTelefonoMovil());
        personaDB.setDirecciones(personaDB.getDirecciones());
        personaDB.setGenero(personaDB.getGenero());
        personaDB.setRequiereRepresentante(personaDB.getRequiereRepresentante());
        this.personaRepository.save(personaDB);
    }

    public List<Persona> listarPersonasActivos() {
        return this.personaRepository.findByEstado(EstadosEnum.ACTIVO.getValor());
    }

    public List<Persona> listarDiscapacidad(String discapacidad) {
        return this.personaRepository.findByDiscapacidad(discapacidad);
    }
    public Optional<Persona> listarIdentificador(String identificacion) {
        return this.personaRepository.findByIdentificacion(identificacion);
    }
}

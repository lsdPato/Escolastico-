package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.TipoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MatriculaNrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.exception.NoExisteCupoException;
import ec.edu.espe.arquitectura.escolastico.educacion.exception.PersonaNoAutorizadaException;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcPK;
import ec.edu.espe.arquitectura.escolastico.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.NoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NrcService {
    private final NrcRepository nrcRespository;
    private final MatriculaNrcRepository matriculaNrcRepository;

    private final PersonaRepository personaRepository;

    public NrcService(NrcRepository nrcRespository, MatriculaNrcRepository matriculaNrcRepository,
                      PersonaRepository personaRepository) {
        this.nrcRespository = nrcRespository;
        this.matriculaNrcRepository = matriculaNrcRepository;
        this.personaRepository = personaRepository;
    }

    public Nrc obtenerPorCodigo(NrcPK pk) {
        Optional<Nrc> nrcOpt = this.nrcRespository.findById(pk);
        if (nrcOpt.isPresent()) {
            return nrcOpt.get();
        } else {
            return null;
        }

    }

    public void crear(Nrc nrc) {

        Persona personaOpt = this.personaRepository.findById(nrc.getCodPersona())
                .orElseThrow(() -> new NoEncontradoException("No existe la persona"));

        if (!(personaOpt.getTipoPersona().getCodTipoPersona().equals(TipoPersonaEnum.DOCENTE.getValor()))){
            throw new PersonaNoAutorizadaException("La persona no es un profesor");
        }
        this.nrcRespository.save(nrc);
    }

    public void modificar(Nrc nrc) {
        Optional<Nrc> nrcBd = this.nrcRespository.findByPkCodNrc(nrc.getPk().getCodNrc());
        nrcBd.get().setCupoDisponible(nrc.getCupoDisponible());
        nrcBd.get().setCupoRegistrado(nrc.getCupoRegistrado());
        this.nrcRespository.save(nrc);
    }


    public List<Nrc> listarMateriaYPerido(Integer codPeriodo, Integer codMateria) {
        return this.nrcRespository.findByPkCodPeriodoAndPkCodMateria(codPeriodo, codMateria);
    }

    public void actualizarCupos(Integer codNrc, Integer codPeriodo) {

        Optional<Nrc> nrc = this.nrcRespository.findByPkCodNrcAndPkCodPeriodo(codNrc, codPeriodo);
        if (nrc.get().getCupoDisponible() == 0) {
            throw new NoExisteCupoException("No hay cupos Disponibles en este NRC");
        }
        nrc.get().setCupoDisponible(nrc.get().getCupoDisponible() - 1);
        nrc.get().setCupoRegistrado(nrc.get().getCupoRegistrado() + 1);
        this.nrcRespository.save(nrc.get());
    }

}


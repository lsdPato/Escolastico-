package ec.edu.espe.arquitectura.escolastico.educacion.service;


import ec.edu.espe.arquitectura.escolastico.educacion.TipoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.*;
import ec.edu.espe.arquitectura.escolastico.educacion.exception.MatriculaNrcExisteException;
import ec.edu.espe.arquitectura.escolastico.educacion.exception.NoExisteCupoException;
import ec.edu.espe.arquitectura.escolastico.educacion.exception.PersonaNoAutorizadaException;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrcPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.NoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaNrcService {

    private final MatriculaNrcRepository matriculaNrcRepository;

    private final MatriculaRepository matriculaRepository;

    private final CarreraRepository carreraRepository;

    private final NrcRepository nrcRepository;

    private final MateriaRepository materiaRepository;

    private final PersonaRepository personaRepository;


    public MatriculaNrcService(MatriculaNrcRepository matriculaNrcRepository, MatriculaRepository matriculaRepository,
                               CarreraRepository carreraRepository, NrcRepository nrcRepository,
                               MateriaRepository materiaRepository, PersonaRepository personaRepository) {
        this.matriculaNrcRepository = matriculaNrcRepository;
        this.matriculaRepository = matriculaRepository;
        this.carreraRepository = carreraRepository;
        this.nrcRepository = nrcRepository;
        this.materiaRepository = materiaRepository;
        this.personaRepository = personaRepository;
    }

    public List<MatriculaNrc> obtenerMatriculasActivas(MatriculaNrc matriculaNrc){
        List<MatriculaNrc> matriculaNrcOpt = this.matriculaNrcRepository.findByPkCodPersonaAndEstado(matriculaNrc
                .getPk().getCodPersona(), EstadosEnum.ACTIVO.getValor());
        return matriculaNrcOpt;
    }

    public void generarMatriculaANrc(Matricula matricula, Nrc nrc){

        MatriculaNrcPK nuevaMatriculaNrcPK = new MatriculaNrcPK(nrc.getPk().getCodNrc(),nrc.getPk().getCodPeriodo(),
                nrc.getPk().getCodDepartamento(), nrc.getPk().getCodMateria(),matricula.getPk().getCodMatricula(),
                matricula.getPk().getCodPersona());

        Optional<MatriculaNrc> registrosDeMatricula = this.matriculaNrcRepository
                .findByPkCodPersonaAndPkCodMatriculaAndPkCodPeriodo(nuevaMatriculaNrcPK.getCodPersona(),
                        nuevaMatriculaNrcPK.getCodMateria(), nuevaMatriculaNrcPK.getCodPeriodo());
        if (registrosDeMatricula.isPresent()){
            throw new MatriculaNrcExisteException("El usuario ya se encuentra matriculado en esta materia");
        }

        Nrc nrcOpt = this.nrcRepository.findByPkCodNrcAndPkCodPeriodo(nuevaMatriculaNrcPK.getCodNrc(),
                nuevaMatriculaNrcPK.getCodPeriodo()).orElseThrow(() -> new NoEncontradoException("No existe Nrc"));

        if (nrcOpt.getCupoDisponible() == 0){
            throw new NoExisteCupoException("No hay cupos disponibles para el Nrc seleccionado");
        }

        Persona personaOpt = this.personaRepository.findById(nuevaMatriculaNrcPK.getCodPersona())
                .orElseThrow(() -> new NoEncontradoException("No existe la persona"));

        if (!(personaOpt.getTipoPersona().getCodTipoPersona().equals(TipoPersonaEnum.ALUMNO.getValor()))){
            throw new PersonaNoAutorizadaException("La persona no es un estudiante");
        }
        //MatriculaNrc registroMatriculaNrc = new MatriculaNrc(matriculaNrcPK);



    }
}

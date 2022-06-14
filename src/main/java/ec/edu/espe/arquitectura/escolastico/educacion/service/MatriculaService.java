package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.MatriculaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.persona.model.TipoPersona;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {
    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }


    public Matricula obtenerPorCodigo(Integer codMateria, Integer codPeriodo){
        Optional<Matricula> matriculaOpt = this.matriculaRepository.findByCodPeriodoAndPkCodPersona(codMateria,codPeriodo);
        if (matriculaOpt.isPresent()) {
            return matriculaOpt.get();
        } else {
            return null;
        }
    }
    public void crearMatricula(Matricula matricula) {

        this.matriculaRepository.save(matricula);
    }

    public List<Matricula> listarMatriculas(Integer codPersona){
        return  this.matriculaRepository.findByPkCodPersona(codPersona);
    }
    public List<Matricula> listarMatriculasPorTipo(String tipo){
        return  this.matriculaRepository.findByTipoOrderByTipo(tipo);
    }
}

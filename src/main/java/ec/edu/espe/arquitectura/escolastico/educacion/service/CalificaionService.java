package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.CalificacionRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MatriculaNrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificaionService {
    private final CalificacionRepository calificacionRepository;
    private final MatriculaNrcRepository matriculaNrcRepository;


    public CalificaionService(CalificacionRepository calificacionRepository, MatriculaNrcRepository matriculaNrcRepository) {
        this.calificacionRepository = calificacionRepository;
        this.matriculaNrcRepository = matriculaNrcRepository;
    }
    public Calificacion obtenerPorCodigo(Integer codNrc, Integer codPersona){
        Optional<Calificacion> calificaionOpt = this.calificacionRepository.findByPkCodNrcAndPkCodPersona(codNrc,codPersona);
        if (calificaionOpt.isPresent()) {
            return calificaionOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Calificacion calificion) {
        this.calificacionRepository.save(calificion);
    }
    public Optional<Calificacion> listarCalificaciones(Integer nrc, Integer codPersona) {
        return this.calificacionRepository.findByPkCodNrcAndPkCodPersona(nrc, codPersona);
    }
    public List<Calificacion> listarCalificaionPorPeriodo(Integer codPersona, Integer codPeriodo){
        return this.calificacionRepository.findByPkCodPersonaAndCodPeriodo(codPersona,codPeriodo);
    }
    public List<Calificacion> listarCalificaionPorPersonas(Integer codPersona){
        return this.calificacionRepository.findByPkCodPersona(codPersona);
    }

    public void modificar(Calificacion calificaion) {
        Calificacion calificacionDB = this.obtenerPorCodigo(calificaion.getPk().getCodNrc(),calificaion.getPk().getCodPersona());
        calificacionDB.setNota1(calificaion.getNota1());
        calificacionDB.setNota2(calificaion.getNota2());
        calificacionDB.setNota3(calificaion.getNota3());
        calificacionDB.setNota4(calificaion.getNota4());
        calificacionDB.setObservacion(calificaion.getObservacion());

        this.calificacionRepository.save(calificacionDB);
    }




}

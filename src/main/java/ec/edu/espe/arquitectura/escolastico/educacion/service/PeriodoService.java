package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.PeriodoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.ModuloRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.ModuloService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PeriodoService {

    private final PeriodoRepository periodoRepository;

    public PeriodoService(PeriodoRepository periodoRepository){
        this.periodoRepository = periodoRepository;
    }

    public void crear(Periodo periodo) {
        this.periodoRepository.save(periodo);
    }

    public List<Periodo> listarPorModalidad(String modalidad){
        return this.periodoRepository.findByNivel(modalidad);
    }

    public List<Periodo> listarPorFechaInicialYModalidad(Date fecha, String modalidad){
        return this.periodoRepository.findByFechaInicioAndNivel(fecha, modalidad);
    }

}

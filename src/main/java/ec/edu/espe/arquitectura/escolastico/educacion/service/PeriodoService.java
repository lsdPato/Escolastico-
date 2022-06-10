package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.PeriodoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public List<Periodo> listarPorFechaInicialYModalidad(String fecha, String modalidad) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(fecha);
        return this.periodoRepository.findByFechaInicioAndNivel(date, modalidad);
    }

}

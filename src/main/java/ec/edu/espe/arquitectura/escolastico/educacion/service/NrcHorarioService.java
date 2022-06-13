package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcHorarioRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.exception.AsignarHorarioException;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.escolastico.orgfisica.dao.AulaRepository;
import ec.edu.espe.arquitectura.escolastico.orgfisica.model.Aula;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NrcHorarioService {

    private final NrcHorarioRepository nrcHorarioRepository;

    private final NrcRepository nrcRepository;

    private final AulaRepository aulaRepository;

    public NrcHorarioService(NrcHorarioRepository nrcHorarioRepository, NrcRepository nrcRepository,
                             AulaRepository aulaRepository) {
        this.nrcHorarioRepository = nrcHorarioRepository;
        this.nrcRepository = nrcRepository;
        this.aulaRepository = aulaRepository;
    }

    public void asignarHorario(Integer nrc, Integer aula, String dia, Date horaIni, Date horaFin)
            throws AsignarHorarioException {
        Optional<Nrc> nrcBD = this.nrcRepository.findByPkCodNrc(nrc);
        Optional<Aula> aulaBD = this.aulaRepository.findById(aula);
        NrcHorario nrcHorarioTmp = new NrcHorario();

        if(nrcBD.isPresent() && aulaBD.isPresent()){
            if(this.nrcHorarioRepository.findByPkCodAulaAndPkDiaSemanaAndHoraInicioAndPkCodPeriodo(
                    aulaBD.get().getCodAula(),dia, horaIni, nrcBD.get().getPk().getCodPeriodo()).isPresent()){
                throw new AsignarHorarioException("El aula ya se encuentra asignada en ese horario");
            }
            nrcHorarioTmp.getPk().setCodNrc(nrcBD.get().getPk().getCodNrc());
            nrcHorarioTmp.getPk().setCodMateria(nrcBD.get().getPk().getCodMateria());
            nrcHorarioTmp.getPk().setCodDepartamento(nrcBD.get().getPk().getCodDepartamento());
            nrcHorarioTmp.getPk().setCodPeriodo(nrcBD.get().getPk().getCodPeriodo());
            nrcHorarioTmp.getPk().setCodAula(aulaBD.get().getCodAula());
            nrcHorarioTmp.getPk().setDiaSemana(dia);
            nrcHorarioTmp.setHoraInicio(horaIni);
            nrcHorarioTmp.setHoraFin(horaFin);

            this.nrcHorarioRepository.save(nrcHorarioTmp);

        }

    }

    public List<NrcHorario> listarPorMateriaYPeriodo(Integer materia, Integer periodo){
        return this.nrcHorarioRepository.findByPkCodMateriaAndPkCodPeriodo(materia,periodo);
    }
}

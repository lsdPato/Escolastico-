package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcHorarioRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.exception.AsignarHorarioException;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorarioPK;
import ec.edu.espe.arquitectura.escolastico.orgfisica.dao.AulaRepository;
import ec.edu.espe.arquitectura.escolastico.orgfisica.model.Aula;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.NoEncontradoException;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public void asignarHorario(Integer nrc, Integer aula, String dia, String horaIni, String horaFin)
            throws AsignarHorarioException, ParseException, NoEncontradoException {
        Optional<Nrc> nrcBD = this.nrcRepository.findByPkCodNrc(nrc);
        Optional<Aula> aulaBD = this.aulaRepository.findById(aula);
        NrcHorario nrcHorarioTmp = new NrcHorario();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date horaI = dateFormat.parse(horaIni);
        Date horaF = dateFormat.parse(horaFin);

        if(nrcBD.isPresent() && aulaBD.isPresent()){
            if(this.nrcHorarioRepository.findByPkCodAulaAndPkDiaSemanaAndHoraInicioAndPkCodPeriodo(
                    aulaBD.get().getCodAula(),dia, horaI, nrcBD.get().getPk().getCodPeriodo()).isPresent()){
                throw new AsignarHorarioException("El aula ya se encuentra asignada en ese horario");
            }
            NrcHorarioPK pk = new NrcHorarioPK();
            pk.setCodNrc(nrcBD.get().getPk().getCodNrc());
            pk.setCodPeriodo(nrcBD.get().getPk().getCodPeriodo());
            pk.setCodMateria(nrcBD.get().getPk().getCodMateria());
            pk.setCodDepartamento(nrcBD.get().getPk().getCodDepartamento());
            pk.setCodAula(aulaBD.get().getCodAula());
            pk.setDiaSemana(dia);
            nrcHorarioTmp.setPk(pk);
            nrcHorarioTmp.setHoraInicio(horaI);
            nrcHorarioTmp.setHoraFin(horaF);

            this.nrcHorarioRepository.save(nrcHorarioTmp);

        }else{
            throw new NoEncontradoException("No se ha encontrado el NRC o aula");
        }

    }

    public List<NrcHorario> listarPorMateriaYPeriodo(Integer materia, Integer periodo){
        return this.nrcHorarioRepository.findByPkCodMateriaAndPkCodPeriodo(materia,periodo);
    }
}

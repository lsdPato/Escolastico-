package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.MatriculaNrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcPK;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NrcService {
    private final NrcRepository nrcRespository;
    private final MatriculaNrcRepository matriculaNrcRepository;

    public NrcService(NrcRepository nrcRespository, MatriculaNrcRepository matriculaNrcRepository) {
        this.nrcRespository = nrcRespository;
        this.matriculaNrcRepository = matriculaNrcRepository;
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
        this.nrcRespository.save(nrc);
    }

    public void modificar(Nrc nrc) {
        Optional<Nrc> nrcBd = this.nrcRespository.findByPkCodigoNrc(nrc.getPk().getCodNrc());
        nrc.setCupoDisponible(nrcBd.get().getCupoDisponible());
        nrc.setCupoRegistrado(nrcBd.get().getCupoRegistrado());
        this.nrcRespository.save(nrc);
    }


    public List<Nrc> listarMateriaYPerido(Integer codPeriodo, Integer codMateria) {
        return this.nrcRespository.findByPkCodPeriodoAndPkCodMateria(codPeriodo, codMateria);
    }

    public void calcularCupos(Integer codNrc) {
        List<MatriculaNrc> nrcLista = this.matriculaNrcRepository.findByPkCodNrc(codNrc);
        Optional<Nrc> nrc = this.nrcRespository.findByPkCodigoNrc(codNrc);
        if(nrc.get().getCupoDisponible() == 0){
            return;
        }
        for (MatriculaNrc registro : nrcLista) {
            if (!(registro == null)) {
                nrc.get().setCupoDisponible(nrc.get().getCupoDisponible() - 1);
                nrc.get().setCupoRegistrado(nrc.get().getCupoRegistrado() + 1);
                this.nrcRespository.save(nrc.get());
            }


        }
    }


}

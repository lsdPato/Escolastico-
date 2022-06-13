package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.TipoPrerrequisitoEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.PrerrequisitoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Prerrequisito;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrerrequisitoService {

    private final PrerrequisitoRepository requisitoRepository;

    public PrerrequisitoService(PrerrequisitoRepository requisitoRepository) {
        this.requisitoRepository = requisitoRepository;
    }

    public void generarPrerrequisito(Materia materia, Materia materiaPrerrequisito){
        Optional<Prerrequisito> prerrequisito = this.requisitoRepository.findTopByOrderByCodPrerrequisito();
        Prerrequisito nuevoPrerrequisito = new Prerrequisito();
        Integer codNuevoPrerrequisito = 0;
        if (prerrequisito.isEmpty()){
            codNuevoPrerrequisito = 1;
        }else{
            codNuevoPrerrequisito = prerrequisito.get().getCodPrerrequisito() + 1;
        }
        nuevoPrerrequisito.setCodPrerrequisito(codNuevoPrerrequisito);
        nuevoPrerrequisito.setMateria(materia);
        nuevoPrerrequisito.setCodMateria(materia.getPk().getCodMateria());
        nuevoPrerrequisito.setPrerequisito(materiaPrerrequisito);
        nuevoPrerrequisito.setTipo(TipoPrerrequisitoEnum.OBLIGATORIO.getValor());
        this.requisitoRepository.save(nuevoPrerrequisito);
    }

    public void cambiarObligatoriedad(Prerrequisito prerrequisito){
        Optional<Prerrequisito> prerrequisitoDb = this.requisitoRepository.findById(prerrequisito.getCodPrerrequisito());
        if (prerrequisitoDb.get().getTipo().equals("OBL")){
            prerrequisitoDb.get().setTipo(TipoPrerrequisitoEnum.OPCIONAL.getValor());
        }else if (prerrequisitoDb.get().getTipo().equals("OPC")){
            prerrequisitoDb.get().setTipo(TipoPrerrequisitoEnum.OBLIGATORIO.getValor());
        }
        this.requisitoRepository.save(prerrequisitoDb.get());
    }

    public List<Prerrequisito> listarPrerrequisitos(Materia materia){
        return this.requisitoRepository.findByCodMateria(materia.getPk().getCodMateria());
    }
}

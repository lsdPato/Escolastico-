package ec.edu.espe.arquitectura.escolastico.educacion.service;


import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public Materia obtenerPorCodigo(Integer codMateria, Integer codDepartamento){
        Optional<Materia> materiaOpt = this.materiaRepository.findByPkCodMateriaAndPkCodDepartamento(codMateria,codDepartamento);
        if (materiaOpt.isPresent()) {
            return materiaOpt.get();
        } else {
            return null;
        }
    }

    public void crearMateria(Materia materia) {
        this.materiaRepository.save(materia);
    }

    public void modificarMateria(Materia materia){
        Materia materiaDb = this.obtenerPorCodigo(materia.getPk().getCodMateria(), materia.getPk().getCodDepartamento());
        materiaDb.setNombre(materia.getNombre());
        materiaDb.setCreditos(materia.getCreditos());
        materiaDb.setHoras(materia.getHoras());
        materiaDb.setPonderacion(materia.getPonderacion());
        this.materiaRepository.save(materiaDb);
    }

    public List<Materia> listarMaterias(String nombrePattern){
        nombrePattern = String.format("%%%s%%", nombrePattern);
        return  this.materiaRepository.findByNombreLikeOrderByNombre(nombrePattern);
    }
}

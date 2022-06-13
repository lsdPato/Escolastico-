package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.CarreraRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MallaCarreraRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.exception.MateriaCarreraExisteException;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MallaCarreraService {

    private final MallaCarreraRepository mallaCarreraRepository;
    private final MateriaRepository materiaRepository;
    private final CarreraRepository carreraRepository;


    public MallaCarreraService(MallaCarreraRepository mallaCarreraRepository, MateriaRepository materiaRepository, CarreraRepository carreraRepository) {
        this.mallaCarreraRepository = mallaCarreraRepository;
        this.materiaRepository = materiaRepository;
        this.carreraRepository = carreraRepository;
    }

    public List<MallaCarrera> listarMallaPorCarrera(Integer carrera){
        return this.mallaCarreraRepository.findByCodCarreraOrderByNivel(carrera);
    }

    public List<MallaCarrera> listarMallaPorCarreraYNivel(Integer carrera, Integer nivel){
        return this.mallaCarreraRepository.findByCodCarreraAndNivel(carrera, nivel);
    }

    public void asignarMateriaCarrera(Integer codMateria, Integer codCarrera, Integer nivel) throws MateriaCarreraExisteException {

        Optional<Materia> materiaBD = this.materiaRepository.findByPkCodMateria(codMateria);
        Optional<Carrera> carreraBD = this.carreraRepository.findById(codCarrera);
        MallaCarrera mallaCarreraTmp = new MallaCarrera();

        if(materiaBD.isPresent() && carreraBD.isPresent()){
            if(this.mallaCarreraRepository.findByCodCarreraAndCodMateria(carreraBD.get().getCodCarrera(), materiaBD.get().getPk().getCodMateria()).isPresent()){
                throw new MateriaCarreraExisteException("La Materia ya ha sido asignada a la Carrera");
            }
            Optional<MallaCarrera> mallaOpt = this.mallaCarreraRepository.findTopByOrderByCodMateriacarreraDesc();
            if(mallaOpt.isPresent()){
                mallaCarreraTmp.setCodMateriacarrera(mallaOpt.get().getCodMateriacarrera()+1);
            }else{
                mallaCarreraTmp.setCodMateriacarrera(1);
            }

            mallaCarreraTmp.setCodCarrera(carreraBD.get().getCodCarrera());
            mallaCarreraTmp.setMateria(materiaBD.get());
            mallaCarreraTmp.setNivel(nivel);

            this.mallaCarreraRepository.save(mallaCarreraTmp);
        }

    }



}

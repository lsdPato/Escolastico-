package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.CarreraRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {
    private final CarreraRepository carreraRepository;

    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public List<Carrera> obtenerPorNombre(String nombrePattern){
        return this.carreraRepository.findByNombreLikeOrderByNombre("%" + nombrePattern + "%");
    }

    public Carrera obtenerPorCodigo(Integer codigo){
        Optional<Carrera> carreraOpt = this.carreraRepository.findById(codigo);
        if(carreraOpt.isPresent()){
            return carreraOpt.get();
        }else {
            return null;
        }
    }

    public List<Carrera> listarPorDepartamento(Integer codDepartamento){
        return this.carreraRepository.findByCodDepartamento(codDepartamento);
    }

    public List<Carrera> listarPorModalidad(String modalidad){
        return this.carreraRepository.findByModalidadOrderByModalidad(modalidad);
    }

    public List<Carrera> listarPorNivel(String nivel){
        return this.carreraRepository.findByNivel(nivel);
    }

    public void crear(Carrera carrera){
        this.carreraRepository.save(carrera);
    }

    public void modificar(Carrera carrera){
        Carrera carreraBD = this.obtenerPorCodigo(carrera.getCodCarrera());
        carreraBD.setNombre(carrera.getNombre());
        carreraBD.setTotalSemestres(carrera.getTotalSemestres());
        carreraBD.setGrado(carrera.getGrado());
        carreraBD.setPerfilProfesional(carrera.getPerfilProfesional());
        carreraBD.setTotalCreditos(carrera.getTotalCreditos());
        carreraBD.setTotalHoras(carrera.getTotalHoras());
        carreraBD.setSiglas(carrera.getSiglas());
        carreraBD.setPrecioCredito(carrera.getPrecioCredito());
        this.carreraRepository.save(carreraBD);

    }
}

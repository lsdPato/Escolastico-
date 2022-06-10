package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.DepartamentoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }


    public Departamento obtenerPorCodigo(Integer codigo){
        Optional<Departamento> departamentoOpt = this.departamentoRepository.findById(codigo);
        if (departamentoOpt.isPresent()){
            return departamentoOpt.get();
        }else{
            return null;
        }
    }

    public void crear(Departamento departamento){
        this.departamentoRepository.save(departamento);
    }

    public void modificar(Departamento departamento){

        Departamento departamentoBd = this.obtenerPorCodigo(departamento.getCodDepartamento());
        departamentoBd.setNombre(departamento.getNombre());
        departamentoBd.setDescripcion(departamento.getDescripcion());
        departamentoBd.setSiglas(departamento.getSiglas());
        this.departamentoRepository.save(departamentoBd);
    }

    public List<Departamento> listarDepartamentos(){
        return this.departamentoRepository.findAll();
    }


}


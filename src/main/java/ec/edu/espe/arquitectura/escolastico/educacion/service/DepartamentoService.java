package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.DepartamentoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import org.springframework.stereotype.Service;

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

        Departamento departamentoBd = this.obtenerPorCodigo(departamento.getCodDepartamento());
        departamentoBd.setNombre(departamento.getNombre());
        departamentoBd.setDescripcion(departamento.getDescripcion());
        departamentoBd.setSiglas(departamento.getSiglas());


    }


}


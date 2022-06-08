package ec.edu.espe.arquitectura.escolastico.seguridad.service;


import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.FuncionalidadRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilFuncionalidadRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Funcionalidad;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionalidadService {
    private final FuncionalidadRepository funcionalidadRepository;

    private final PerfilFuncionalidadRepository perfilFuncionalidadRepository;

    public Funcionalidad obtenerPorCodigo(Integer codigo) {
        Optional<Funcionalidad> funcionalidadOpt = this.funcionalidadRepository.findById(codigo);
        if (funcionalidadOpt.isPresent()) {
            return funcionalidadOpt.get();
        } else {
            return null;
        }
    }

    public List<Funcionalidad> obtenerPorModuloYEstado(String modulo, String estado){
        return this.funcionalidadRepository.findByCodModuloAndEstado(modulo,estado);
    }
    public List<Funcionalidad> obtenerPorEstado(){
        return this.funcionalidadRepository.findByEstado(EstadosEnum.ACTIVO.getValor());
    }


    public void crear(Funcionalidad funcionalidad) {
        funcionalidad.setEstado(EstadosEnum.INACTIVO.getValor());
        this.funcionalidadRepository.save(funcionalidad);
        this.perfilFuncionalidadRepository.saveAll(funcionalidad.getPerfilFuncionalidades());
    }



}

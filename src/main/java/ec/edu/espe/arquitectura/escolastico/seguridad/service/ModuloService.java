
package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.ModuloRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;

@Service
public class ModuloService {
    
    private final ModuloRepository moduloRespository;
    
    public ModuloService(ModuloRepository moduloRespository) {
        this.moduloRespository = moduloRespository;
    }

    public Modulo obtenerPorCodigo(String codigo) {
        Optional<Modulo>  moduloOpt = this.moduloRespository.findById(codigo);
        if (moduloOpt.isPresent()) {
            return moduloOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Modulo modulo) {
        modulo.setEstado(EstadosEnum.INACTIVO.getValor());
        this.moduloRespository.save(modulo);
    }

    public void modificar(Modulo modulo) {
        Modulo moduloDB = this.obtenerPorCodigo(modulo.getCodModulo());
        moduloDB.setNombre(modulo.getNombre());
        moduloDB.setEstado(modulo.getEstado());
        this.moduloRespository.save(moduloDB);
    }

    public List<Modulo> listarModulosActivos() {
        return this.moduloRespository.findByEstado(EstadosEnum.ACTIVO.getValor());
    }
}

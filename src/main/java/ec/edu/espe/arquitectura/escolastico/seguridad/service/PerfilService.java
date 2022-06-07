package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {
    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository){
        this.perfilRepository = perfilRepository;
    }
    public Perfil obtenerPorCodigo(String codigo){
        Optional<Perfil> perfilOpt = this.perfilRepository.findById(codigo);
        if (perfilOpt.isPresent()) {
            return perfilOpt.get();
        } else {
            return null;
        }

    }
    public void crear(Perfil perfil) {
        perfil.setEstado(EstadosEnum.INACTIVO.getValor());
        this.perfilRepository.save(perfil);
    }
    public void modificar(Perfil perfil) {
        Perfil perfilDB = this.obtenerPorCodigo(perfil.getCodPerfil());
        perfilDB.setNombre(perfil.getNombre());
        perfilDB.setEstado(perfil.getEstado());
        this.perfilRepository.save(perfilDB);
    }
    public List<Perfil> listarPerfilesActivos() {
        return this.perfilRepository.findByEstado(EstadosEnum.ACTIVO.getValor());
    }

}

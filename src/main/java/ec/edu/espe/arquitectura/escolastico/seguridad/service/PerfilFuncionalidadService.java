package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioPerfilRespository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.UsuarioPerfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.UsuarioPerfilPK;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilFuncionalidadService {
    private final UsuarioPerfilRespository usuarioPerfilRespository;
    private final PerfilRepository perfilRepository;

    public PerfilFuncionalidadService(UsuarioPerfilRespository usuarioPerfilRespository, PerfilRepository perfilRepository) {
        this.usuarioPerfilRespository = usuarioPerfilRespository;
        this.perfilRepository = perfilRepository;
    }


    public void asignarPerfil(String codUsuario, List<Perfil> perfiles, Usuario usuario){
        perfiles = this.perfilRepository.findByEstado("ACT");
        for (Perfil perfil: perfiles) {
            perfil.getCodPerfil();
            UsuarioPerfil usuarioPerfilTmp = new UsuarioPerfil();

            UsuarioPerfilPK usuarioPerfilPK = new UsuarioPerfilPK();
            usuarioPerfilPK.setCodPerfil(perfil.getCodPerfil());
            usuarioPerfilPK.setCodPerfil(codUsuario);
            usuarioPerfilTmp.setUsuarioPerfilPK(usuarioPerfilPK);

            this.usuarioPerfilRespository.save(usuarioPerfilTmp);


        }



    }
}


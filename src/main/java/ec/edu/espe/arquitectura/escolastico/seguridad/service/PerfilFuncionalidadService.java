package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioPerfilRespository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.NoEncontradoException;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.UsuarioPerfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.UsuarioPerfilPK;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@Service
public class PerfilFuncionalidadService {
    private final UsuarioPerfilRespository usuarioPerfilRespository;
    private final PerfilRepository perfilRepository;
    private final UsuarioRepository usuarioRepository;

    public PerfilFuncionalidadService(UsuarioPerfilRespository usuarioPerfilRespository, PerfilRepository perfilRepository, UsuarioRepository usuarioRepository) {
        this.usuarioPerfilRespository = usuarioPerfilRespository;
        this.perfilRepository = perfilRepository;

        this.usuarioRepository = usuarioRepository;
    }


    public void asignarPerfil(String codUsuario, String mailAud, String codPerfil) throws UnknownHostException {

        Usuario usuarioAud = this.usuarioRepository.findByMail(mailAud);
        String ip = InetAddress.getLocalHost().getHostAddress();
        UsuarioPerfil usuarioPerfilTmp = new UsuarioPerfil();
        UsuarioPerfilPK usuarioPerfilPK = new UsuarioPerfilPK();



        Perfil perfil = this.perfilRepository.findByEstadoAndCodPerfil(EstadosEnum.ACTIVO.getValor(),codPerfil)
                .orElseThrow(() -> new NoEncontradoException("No se encontro el perfil con el codigo"));


        usuarioPerfilPK.setCodPerfil(perfil.getCodPerfil());
        usuarioPerfilPK.setCodUsuario(codUsuario);

        usuarioPerfilTmp.setUsuarioPerfilPK(usuarioPerfilPK);
        usuarioPerfilTmp.setAudUsuario(usuarioAud.getCodUsuario());
        usuarioPerfilTmp.setVersion(0);
        usuarioPerfilTmp.setAudFecha(new Date());
        usuarioPerfilTmp.setAudIp(ip);


        this.usuarioPerfilRespository.save(usuarioPerfilTmp);


    }
}


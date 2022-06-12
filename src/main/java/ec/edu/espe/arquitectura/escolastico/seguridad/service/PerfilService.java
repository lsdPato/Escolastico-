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
import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {
    private final PerfilRepository perfilRepository;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioPerfilRespository usuarioPerfilRespository;

    public PerfilService(PerfilRepository perfilRepository, UsuarioRepository usuarioRepository, UsuarioPerfilRespository usuarioPerfilRespository){
        this.perfilRepository = perfilRepository;
        this.usuarioRepository = usuarioRepository;
        this.usuarioPerfilRespository = usuarioPerfilRespository;
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

package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.ResultadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.RegistroSesionRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.RegistroSesion;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final RegistroSesionRepository registroSesionRepository;


    public Usuario autenticarUsuario(String mail, String clave) {

        String Ip = "192.168.1.1";
        RegistroSesion registroSesion = new RegistroSesion();
        Usuario usuarioBd = this.usuarioRepository.findByMail(mail);

        if (usuarioBd == null) {
            throw new UsuarioNoEncontradoException(
                    "El usuario o contraseña son incorrecto(s).");
        }

        boolean esUsuarioInactivo = usuarioBd.getEstado().equals(EstadosEnum.INACTIVO.getValor());
        if (esUsuarioInactivo) {
            throw new UsuarioInactivoException(
                    "El usuario no está activo y no puede ingresar al sistema.");
        }

        boolean clavesNoCoinciden = !DigestUtils.sha256Hex(clave).equals(usuarioBd.getClave());
        if (clavesNoCoinciden) {
            usuarioBd.setNroIntentosFallidos(usuarioBd.getNroIntentosFallidos() + 1);
            registroSesion.setCodUsuario(usuarioBd.getCodUsuario());
            registroSesion.setFechaConexion(new Date());
            registroSesion.setIpConexion(Ip);
            registroSesion.setError("Intento numero:" + usuarioBd.getNroIntentosFallidos());
            registroSesion.setResultado(ResultadosEnum.FALLIDO.getValor());

            this.registroSesionRepository.save(registroSesion);
            return null;
        }

        registroSesion.setCodUsuario(usuarioBd.getCodUsuario());
        registroSesion.setFechaConexion(new Date());
        registroSesion.setIpConexion(Ip);
        registroSesion.setResultado(ResultadosEnum.SATISFACTORIO.getValor());
        usuarioBd.setNroIntentosFallidos(0);

        this.usuarioRepository.save(usuarioBd);
        this.registroSesionRepository.save(registroSesion);

        return usuarioBd;
    }


}

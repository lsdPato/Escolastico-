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


    public Usuario AuthenUsuario(String mail, String clave) throws UnknownHostException {

        String Ip = InetAddress.getLocalHost().getHostAddress();
        RegistroSesion registroSesion = new RegistroSesion();
        Usuario usuarioBd = this.usuarioRepository.findByMail(mail);
        if (usuarioBd == null) {
            return null;
        } else {
            if (usuarioBd.getEstado().equals(EstadosEnum.ACTIVO.getValor())) {
                if (DigestUtils.sha256Hex(clave).equals(usuarioBd.getClave())) {
                    registroSesion.setCodUsuario(usuarioBd.getCodUsuario());
                    registroSesion.setFechaConexion(new Date());
                    registroSesion.setIpConexion(Ip);
                    registroSesion.setResultado(ResultadosEnum.SATISFACTORIO.getValor());
                    usuarioBd.setNroIntentosFallidos(0);

                } else {
                    usuarioBd.setNroIntentosFallidos(usuarioBd.getNroIntentosFallidos() + 1);
                    registroSesion.setCodUsuario(usuarioBd.getCodUsuario());
                    registroSesion.setFechaConexion(new Date());
                    registroSesion.setIpConexion(Ip);
                    registroSesion.setError("Intento numero:" + usuarioBd.getNroIntentosFallidos());
                    registroSesion.setResultado(ResultadosEnum.FALLIDO.getValor());
                    this.usuarioRepository.save(usuarioBd);
                }
                this.registroSesionRepository.save(registroSesion);
            }

        }

        return usuarioBd;
    }


}

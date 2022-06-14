package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.ResultadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.RegistroSesionRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioPerfilRespository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CambioClaveException;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.UsuarioInactivoException;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.UsuarioNoEncontradoException;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.RegistroSesion;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioPerfilRespository usuarioPerfilRepository;
    private final RegistroSesionRepository registroSesionRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioPerfilRespository usuarioPerfilRepository, RegistroSesionRepository registroSesionRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioPerfilRepository = usuarioPerfilRepository;
        this.registroSesionRepository = registroSesionRepository;
    }

    public Usuario buscarPorCodigo(String codigo) {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(codigo);
        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get();
        } else {
            return null;
        }
    }

    public Usuario buscarPorMail(String mail) {
        Usuario usuario = this.usuarioRepository.findByMail(mail);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado");
        }
        return usuario;
    }

    public Usuario buscarPorCodigoOMail(String valor) {
        Usuario usuario = this.buscarPorCodigo(valor);
        if (usuario == null) {
            usuario = this.buscarPorMail(valor);
        }
        return usuario;
    }


    public List<Usuario> buscarPorNombre(String nombrePattern) {
        return this.usuarioRepository.findByNombreLikeOrderByNombre("%" + nombrePattern + "%");
    }

    public List<Usuario> buscarPorNombreYEstado(String nombrePattern, EstadoPersonaEnum estado) {
        return this.usuarioRepository.findByNombreLikeAndEstadoOrderByNombre(nombrePattern, estado.getValor());
    }

    public List<Usuario> buscarPorEstado(EstadoPersonaEnum estado) {
        return this.usuarioRepository.findByEstado(estado.getValor());
    }

    public Usuario crear(Usuario usuario) {
        String clave = RandomStringUtils.randomAlphabetic(8);
        System.out.println(clave);
        usuario.setClave(DigestUtils.sha256Hex(clave));
        usuario.setFechaCreacion(new Date());

        this.usuarioRepository.save(usuario);
        return usuario;
    }

    public void cambiarClave(String codigoOMail, String claveAntigua, String claveNueva) throws CambioClaveException {
        Usuario usuario = this.buscarPorCodigoOMail(codigoOMail);
        if (usuario == null) {
            throw new CambioClaveException("No existe el usuario para el codigo o correo provisto");
        }
        claveAntigua = DigestUtils.sha256Hex(claveAntigua);
        usuario.getClave();
        if (!usuario.getClave().equals(claveAntigua)) {
            throw new CambioClaveException("La clave antigua no coincide");
        }
        usuario.setClave(DigestUtils.sha256Hex(claveNueva));
        usuario.setFechaCambioClave(new Date());
        this.usuarioRepository.save(usuario);
    }

    public void modificar(Usuario usuario) {
        Usuario usuarioBd = this.buscarPorCodigoOMail(usuario.getMail());
        usuarioBd.setNombre(usuario.getNombre());
        usuarioBd.setEstado(usuario.getEstado());
        this.usuarioRepository.save(usuarioBd);
    }

    public Usuario autenticarUsuario(String mail, String clave) throws UnknownHostException {


        String ip = InetAddress.getLocalHost().getHostAddress();
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
            registroSesion.setIpConexion(ip);
            registroSesion.setError("Intento numero:" + usuarioBd.getNroIntentosFallidos());
            registroSesion.setResultado(ResultadosEnum.FALLIDO.getValor());

            this.registroSesionRepository.save(registroSesion);
            return null;
        }

        registroSesion.setCodUsuario(usuarioBd.getCodUsuario());
        registroSesion.setFechaConexion(new Date());
        registroSesion.setIpConexion(ip);
        registroSesion.setResultado(ResultadosEnum.SATISFACTORIO.getValor());
        usuarioBd.setNroIntentosFallidos(0);

        this.usuarioRepository.save(usuarioBd);
        this.registroSesionRepository.save(registroSesion);

        return usuarioBd;
    }

}

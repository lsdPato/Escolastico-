package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioResource {

    private UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioSrvice) {
        this.usuarioService = usuarioSrvice;
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        usuario = this.usuarioService.crear(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarPorMail(@RequestParam("email") String mail) {
        return ResponseEntity.ok(this.usuarioService.buscarPorMail(mail));
    }
    @GetMapping(path = "/buscarNombre")
    public ResponseEntity<List<Usuario>> buscarPorNombre(@RequestParam("nombre") String nombre) {
        List<Usuario> usuarios = this.usuarioService.buscarPorNombre(nombre);
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping(path = "/buscarEstado")
    public ResponseEntity<List<Usuario>> buscarPorEstado(@RequestParam("estado") String estado) {
        List<Usuario> usuarios = this.usuarioService.buscarPorEstado(EstadoPersonaEnum.valueOf(estado));
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping(path = "/buscarNomEst")
    public ResponseEntity<List<Usuario>> buscarPorNombreYEstado(@RequestParam("nombre") String nombre, @RequestParam("estado") String estado) {
        List<Usuario> usuarios = this.usuarioService.buscarPorNombreYEstado(nombre,EstadoPersonaEnum.valueOf(estado));
        return ResponseEntity.ok(usuarios);
    }


    @PutMapping
    public ResponseEntity<Usuario> modificar(@RequestBody Usuario usuario) {
        try {
            this.usuarioService.modificar(usuario);
            usuario = this.usuarioService.buscarPorCodigo(usuario.getCodUsuario());
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(path = "/cambiarCLave")
    public ResponseEntity<Usuario> modificarClave(@RequestParam("email") String email, @RequestParam("claveAnt") String claveAnt, @RequestParam("claveNue") String claveNue) {
        try {
            this.usuarioService.cambiarClave(email,claveAnt,claveNue);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }
}

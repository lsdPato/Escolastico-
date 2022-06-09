package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.UsuarioService;

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
    public ResponseEntity<Usuario> buscarPorMail(@RequestParam("email") String mail){
        return ResponseEntity.ok(this.usuarioService.buscarPorMail(mail));
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

}

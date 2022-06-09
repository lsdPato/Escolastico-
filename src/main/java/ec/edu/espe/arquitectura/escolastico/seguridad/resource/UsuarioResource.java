package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

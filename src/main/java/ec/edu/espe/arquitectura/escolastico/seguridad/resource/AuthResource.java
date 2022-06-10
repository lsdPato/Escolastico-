package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.exception.UsuarioNoEncontradoException;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthResource {
    private final AuthService service;

    @PutMapping
    public ResponseEntity<Usuario> autenticarUsuario(@RequestParam("email") String email , @RequestParam("clave") String clave) throws UnknownHostException {
        return ResponseEntity.ok( this.service.autenticarUsuario(email,clave));

    }

}

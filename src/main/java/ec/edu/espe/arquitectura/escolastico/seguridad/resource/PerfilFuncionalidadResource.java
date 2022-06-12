package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.PerfilFuncionalidadService;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/perfilFuncionalidad")
@RequiredArgsConstructor
public class PerfilFuncionalidadResource {
    private final PerfilFuncionalidadService service;

    @PostMapping
    public ResponseEntity<String> asignar(@RequestParam("codUsuario")  String usuario, @RequestParam("email")String email, @RequestParam("codPerfil")String codPerfil) {
        try {
            this.service.asignarPerfil(usuario,email,codPerfil);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

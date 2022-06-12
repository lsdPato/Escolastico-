package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.PerfilFuncionalidadService;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/perfil")
@RequiredArgsConstructor
public class PerfilResource {
    private final PerfilService service;


    @GetMapping
    public ResponseEntity<List<Perfil>> getPerfilesActivos() {
        return ResponseEntity.ok(this.service.listarPerfilesActivos());
    }
    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Perfil perfil) {
        try {
            this.service.crear(perfil);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Perfil> modificar(@RequestBody Perfil perfil) {
        try {
            this.service.modificar(perfil);
            this.service.obtenerPorCodigo(perfil.getCodPerfil());
            return ResponseEntity.ok(this.service.obtenerPorCodigo(perfil.getCodPerfil()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping(path = "asignarPerfil")
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

package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.ModuloService;

@RestController
@RequestMapping(path = "/modulo")
public class ModuloResource {
    
    private final ModuloService service;

    public ModuloResource(ModuloService moduloService) {
        this.service = moduloService;
    }

    @GetMapping
    public ResponseEntity<List<Modulo>> getModulosActivos() {
        return ResponseEntity.ok(this.service.listarModulosActivos());
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Modulo modulo) {
        try {
            this.service.crear(modulo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Modulo> modificar(@RequestBody Modulo modulo) {
        try {
            this.service.modificar(modulo);
            modulo = this.service.obtenerPorCodigo(modulo.getCodModulo());
            return ResponseEntity.ok(modulo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    } 

}

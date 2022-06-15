package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Funcionalidad;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.FuncionalidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping(path = "/funcionalidad")
@RequiredArgsConstructor
public class FuncionalidadResource {

    private final FuncionalidadService service;

    @GetMapping
    public ResponseEntity<List<Funcionalidad>> getFuncionalidadEstados() {
        return ResponseEntity.ok(this.service.obtenerPorEstado());

    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Funcionalidad funcionalidad) {
        try {
            this.service.crear(funcionalidad);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(path = "asignar")
    public ResponseEntity<String> AsignarFuncionalidad(String codPerfil, String mailAud,Integer codFuncionalidad) throws UnknownHostException {
        try {
            this.service.asignarFuncionalidad(codPerfil, mailAud, codFuncionalidad);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }


    @PutMapping
    public ResponseEntity<Funcionalidad> modificar(@RequestBody Funcionalidad funcionalidad) {
        try {
            this.service.modificar(funcionalidad);
            this.service.obtenerPorCodigo(funcionalidad.getCodFuncionalidad());
            return ResponseEntity.ok(this.service.obtenerPorCodigo(funcionalidad.getCodFuncionalidad()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


}

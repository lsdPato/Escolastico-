package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Funcionalidad;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.FuncionalidadService;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/funcionalidad")
@RequiredArgsConstructor
public class FuncionalidadResource {

    private final FuncionalidadService service;

@GetMapping
    public ResponseEntity<List<Funcionalidad>> getFuncionalidadEstados(){
        return ResponseEntity.ok(this.service.obtenerPorEstado());

}
@PostMapping
    public ResponseEntity<String> crear(@RequestBody Funcionalidad funcionalidad){
        try{
            this.service.crear(funcionalidad);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseEntity.badRequest().build();
        }
}


}

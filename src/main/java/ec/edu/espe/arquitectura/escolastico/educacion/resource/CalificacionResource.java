package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import ec.edu.espe.arquitectura.escolastico.educacion.service.CalificaionService;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/calificacion")

public class CalificacionResource {
    private final CalificaionService service;

    public CalificacionResource(CalificaionService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Calificacion calificacion){
        try{
            this.service.crear(calificacion);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity<Optional<Calificacion>> getCalificaciones(@RequestParam("nrc") Integer nrc,@RequestParam("codPersona") Integer codPersona) {
        return ResponseEntity.ok(this.service.listarCalificaciones(nrc, codPersona));
    }
    @GetMapping(path = "/periodo")
    public ResponseEntity<List<Calificacion>> getPorPeriodo(@RequestParam("codPersona") Integer codPersona,@RequestParam("codPeriodo") Integer codPeriodo){
        return ResponseEntity.ok(this.service.listarCalificaionPorPeriodo(codPersona,codPeriodo));
    }
    @GetMapping(path = "/persona")
    public ResponseEntity<List<Calificacion>> getPorPeriodo(@RequestParam("codPersona") Integer codPersona){
        return ResponseEntity.ok(this.service.listarCalificaionPorPersonas(codPersona));
    }

    @PutMapping
    public ResponseEntity<Calificacion> modificar(@RequestBody Calificacion calificacion) {
        try {
            this.service.modificar(calificacion);
            this.service.obtenerPorCodigo(calificacion.getPk().getCodNrc(),calificacion.getPk().getCodPersona());
            return ResponseEntity.ok(this.service.obtenerPorCodigo(calificacion.getPk().getCodNrc(),calificacion.getPk().getCodPersona()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

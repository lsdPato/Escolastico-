package ec.edu.espe.arquitectura.escolastico.persona.resource;


import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.persona.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/persona")
public class PersonaResource {
    private final PersonaService service;

    public PersonaResource(PersonaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getPersonasActivas() {
        return ResponseEntity.ok(this.service.listarPersonasActivos());
    }

    @GetMapping(path = "discapacitados")
    public ResponseEntity<List<Persona>> getPersonasDiscapacidad(@RequestParam("discapacidad") String discapacidad) {
        return ResponseEntity.ok(this.service.listarDiscapacidad(discapacidad));
    }

    @GetMapping(path = "identificacion")
    public ResponseEntity<List<Persona>> getPersonasIdentificacion(@RequestParam("discapacidad") String identificacion) {
        return ResponseEntity.ok(this.service.listarDiscapacidad(identificacion));
    }


    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Persona persona) {
        try {
            this.service.crear(persona);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Persona> modificar(@RequestBody Persona persona) {
        try {
            this.service.modificar(persona);
            persona = this.service.obtenerPorCodigo(persona.getCodPersona());
            return ResponseEntity.ok(persona);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}

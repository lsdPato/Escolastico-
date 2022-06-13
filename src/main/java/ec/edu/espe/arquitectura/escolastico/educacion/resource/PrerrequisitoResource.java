package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import ec.edu.espe.arquitectura.escolastico.educacion.dto.PrerrequisitoDto;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Prerrequisito;
import ec.edu.espe.arquitectura.escolastico.educacion.service.PrerrequisitoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/prerrequisito")
public class PrerrequisitoResource {

    private final PrerrequisitoService service;

    public PrerrequisitoResource(PrerrequisitoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Prerrequisito>> getPrerrequisitosMateria(@RequestBody Materia materia){
        return ResponseEntity.ok(this.service.listarPrerrequisitos(materia));
    }

    @PostMapping
    public ResponseEntity<String> generarPrerrequisito(@RequestBody PrerrequisitoDto materiasPrerrequisito){
        try{
            this.service.generarPrerrequisito(materiasPrerrequisito.getMateria(), materiasPrerrequisito.getPrerrequisito());
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> cambiarObligatoriedad(@RequestBody Prerrequisito prerrequisito){
        try{
            this.service.cambiarObligatoriedad(prerrequisito);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


}

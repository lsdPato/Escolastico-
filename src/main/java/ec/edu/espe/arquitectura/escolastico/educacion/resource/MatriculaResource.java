package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/matricula")
public class MatriculaResource {
    private final MatriculaService service;

    public MatriculaResource(MatriculaService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Matricula>> getMatricula(@RequestParam("codPersona") Integer codPersona){
        return ResponseEntity.ok(this.service.listarMatriculas(codPersona));
    }
    @PostMapping
    public ResponseEntity<String> crearMateria(@RequestBody Matricula matricula){
        try{
            this.service.crearMatricula(matricula);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

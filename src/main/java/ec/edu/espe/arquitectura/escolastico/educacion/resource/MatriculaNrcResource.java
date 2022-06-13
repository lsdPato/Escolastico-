package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrcPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.service.MatriculaNrcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/matriculaNrc")
public class MatriculaNrcResource {

    private final MatriculaNrcService service;


    public MatriculaNrcResource(MatriculaNrcService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MatriculaNrc>> getMatriculasActivas(MatriculaNrcPK matriculaNrcConsulta){
        return ResponseEntity.ok(this.service.obtenerMatriculasActivas(matriculaNrcConsulta));
    }

    @PostMapping
    public ResponseEntity<String> crearMatriculaANrc(@RequestBody Matricula matricula, Nrc nrc){
        try{
            this.service.generarMatriculaANrc(matricula,nrc);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<MatriculaNrc> modificarRegistroMatriculaNrc(@RequestBody MatriculaNrc matriculaNrc){
        try{
            this.service.modificarMatriculaNrc(matriculaNrc);
            matriculaNrc = this.service.obtenerRegistro(matriculaNrc.getPk());
            return ResponseEntity.ok(matriculaNrc);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }
}

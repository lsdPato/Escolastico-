package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.service.NrcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Nrc")
public class NrcResource {
    private final NrcService service;

    public NrcResource(NrcService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Nrc>> getNrc(@RequestParam("codPeriodo") Integer codPeriodo, @RequestParam("codMateria") Integer codMateria){
        return ResponseEntity.ok(this.service.listarMateriaYPerido(codPeriodo,codMateria));
    }
    @PostMapping
    public ResponseEntity<String> crearNrc(@RequestBody Nrc nrc){
        try{
            this.service.crear(nrc);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping
    public ResponseEntity<String> modificarNrc(@RequestBody Nrc nrc){
        try{
            this.service.modificar(nrc);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }

}

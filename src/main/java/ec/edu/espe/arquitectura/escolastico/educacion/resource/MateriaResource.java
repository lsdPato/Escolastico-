package ec.edu.espe.arquitectura.escolastico.educacion.resource;


import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.service.MateriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/materia")
public class MateriaResource {

    private final MateriaService service;

    public MateriaResource(MateriaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Materia>> getMateria(String nombrePattern){
        return ResponseEntity.ok(this.service.listarMaterias(nombrePattern));
    }

    @PostMapping
    public ResponseEntity<String> crearMateria(@RequestBody Materia materia){
        try{
            this.service.crearMateria(materia);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Materia> modificarMateria(@RequestBody Materia materia){
        try{
            this.service.modificarMateria(materia);
            materia = this.service.obtenerPorCodigo(materia.getPk().getCodMateria(),materia.getPk().getCodDepartamento());
            return ResponseEntity.ok(materia);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}


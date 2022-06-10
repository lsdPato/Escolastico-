package ec.edu.espe.arquitectura.escolastico.educacion.resource;


import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import ec.edu.espe.arquitectura.escolastico.educacion.service.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoResource {

    private final DepartamentoService departamentoService;


    public DepartamentoResource(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }


    @GetMapping
    public ResponseEntity<List<Departamento>> getDepartamentos(){
        return ResponseEntity.ok(this.departamentoService.listarDepartamentos());
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Departamento departamento){
        try{
            this.departamentoService.crear(departamento);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Departamento> modificar(@RequestBody Departamento departamento){
        try{
            this.departamentoService.modificar(departamento);
            departamento = this.departamentoService.obtenerPorCodigo(departamento.getCodDepartamento());
            return ResponseEntity.ok(departamento);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.service.MatriculaNrcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/matriculaNrc")
public class MatriculaNrcResource {

    private final MatriculaNrcService service;


    public MatriculaNrcResource(MatriculaNrcService service) {
        this.service = service;
    }

}

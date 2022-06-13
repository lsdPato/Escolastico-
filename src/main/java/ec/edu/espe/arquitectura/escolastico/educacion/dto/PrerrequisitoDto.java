package ec.edu.espe.arquitectura.escolastico.educacion.dto;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class PrerrequisitoDto {
    private Materia materia;

    private Materia prerrequisito;

}

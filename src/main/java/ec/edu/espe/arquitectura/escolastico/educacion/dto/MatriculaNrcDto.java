package ec.edu.espe.arquitectura.escolastico.educacion.dto;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MatriculaNrcDto {

    private Matricula matricula;

    private Nrc nrc;
}

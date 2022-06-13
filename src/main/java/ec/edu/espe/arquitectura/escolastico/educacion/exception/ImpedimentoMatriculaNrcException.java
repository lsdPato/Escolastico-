package ec.edu.espe.arquitectura.escolastico.educacion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ImpedimentoMatriculaNrcException extends RuntimeException{

    public ImpedimentoMatriculaNrcException(String mensaje){ super(mensaje); }

}

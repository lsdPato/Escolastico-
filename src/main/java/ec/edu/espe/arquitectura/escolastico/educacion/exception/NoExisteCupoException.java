package ec.edu.espe.arquitectura.escolastico.educacion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.EXPECTATION_FAILED )
public class NoExisteCupoException extends RuntimeException{

    public NoExisteCupoException (String message){ super(message); }

}

package ec.edu.espe.arquitectura.escolastico.seguridad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UsuarioInactivoException extends RuntimeException {
    public UsuarioInactivoException(String message) {
        super(message);
    }
}

package ec.edu.espe.arquitectura.escolastico.seguridad;

public enum EstadoPersonaEnum {
    
    ACTIVO("ACT", "Activo"),
    INACTIVO("INA", "Inactivo"),
    SUSPENDIDO("SUS", "Suspendido"),
    BLOQUEADO("BLO", "Bloqueado"),
    CREADO("CRE", "Creado");

    private final String valor;
    private final String texto;

    private EstadoPersonaEnum(String valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }

    public String getTexto() {
        return this.texto;
    }

    public String getValor() {
        return this.valor;
    }
}

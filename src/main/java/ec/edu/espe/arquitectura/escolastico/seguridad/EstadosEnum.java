package ec.edu.espe.arquitectura.escolastico.seguridad;

public enum EstadosEnum {
    
    ACTIVO("ACT", "Activo"),
    INACTIVO("INA", "Inactivo");

    private final String valor;
    private final String texto;

    private EstadosEnum(String valor, String texto) {
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

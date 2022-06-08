package ec.edu.espe.arquitectura.escolastico.seguridad;

public enum ResultadosEnum {

    SATISFACTORIO("SAT", "Satisfactorio"),
    FALLIDO("FAL", "Fallido");

    private final String valor;
    private final String texto;

    private ResultadosEnum(String valor, String texto) {
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



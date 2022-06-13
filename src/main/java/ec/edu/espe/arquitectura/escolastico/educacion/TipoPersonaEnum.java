package ec.edu.espe.arquitectura.escolastico.educacion;


public enum TipoPersonaEnum {

    DOCENTE("DOC", "Docente"),
    ALUMNO("ALU", "Alumno"),
    DIRECTIVO("DIR", "Directivo"),
    ASPIRANTE("ASP", "Aspirante"),
    EGRESADO("EGR", "Egresado"),
    GRADUADO("GRA", "Graduado");

    private final String valor;

    private  final String texto;

    private TipoPersonaEnum(String valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }

    public String getValor() { return  this.valor; };

    public String getTexto() { return this.texto; }
}

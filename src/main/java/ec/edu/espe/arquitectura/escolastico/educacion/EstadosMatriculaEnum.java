package ec.edu.espe.arquitectura.escolastico.educacion;

public enum EstadosMatriculaEnum {

    ACTIVO("ACT", "Activo"),
    INACTIVO("INA", "Inactivo"),
    APROVADO("APR", "Aprobado"),
    REPROVADO("REP", "Reprobado");

    private final String valor;
    private final String texto;

    EstadosMatriculaEnum(String valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }
    public String getTexto(){ return  this.texto; }

    public String getValor(){ return  this.valor; }


}

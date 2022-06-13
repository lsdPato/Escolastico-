package ec.edu.espe.arquitectura.escolastico.educacion;

public enum TipoPrerrequisitoEnum {

    OBLIGATORIO("OBL","Obligatorio"),
    OPCIONAL("OPC","Opcional");

    private final String valor;
    private final String texto;

    private TipoPrerrequisitoEnum(String valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }

    public String getTexto(){ return this.texto; }

    public String getValor(){ return this.valor; }
}

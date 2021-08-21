public class Req2 {
    private int estrato;
    private String fechaInicio;
    private int financiable;
    private double porcentaje;

    public Req2(int estrato, String fechaInicio, int financiable,   double porcentaje) {
        this.fechaInicio = fechaInicio;
        this.financiable = financiable;
        this.estrato = estrato;
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString(){
        return "estrato = " + estrato + ", fechaInicio = " + fechaInicio + ", financiable = " + financiable + ", porcetaje=" + porcentaje;
    }
}

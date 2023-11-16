import java.io.Serializable;

public class Billetes implements Serializable {
    private int denominacion;
    private int cantidadDeBilletes;
    
    public Billetes(int denominacion, int cantidadDeBilletes) {
        this.denominacion = denominacion;
        this.cantidadDeBilletes = cantidadDeBilletes;
    }

    public int getdenominacion() {
        return denominacion;
    }

    public void setdenominacion(int denominacion) {
        this.denominacion = denominacion;
    }

    public int getCantidadDeBilletes() {
        return cantidadDeBilletes;
    }

    public void setCantidadDeBilletes(int cantidadDeBilletes) {
        this.cantidadDeBilletes = cantidadDeBilletes;
    }
    @Override
  public String toString() {
    return "- "+cantidadDeBilletes+" billetes de $"+denominacion;
  }
}

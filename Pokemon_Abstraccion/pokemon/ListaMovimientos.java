package pokemon;

import java.util.ArrayList;

public class ListaMovimientos {
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos(){
        //Movimientos de tipo Agua
        movimientos.add(new Movimiento("Caparaconcha afilada", 75, Tipo.AGUA, 10));
        movimientos.add(new Movimiento("Pistola de agua", 40, Tipo.AGUA, 25));
        movimientos.add(new Movimiento("Aqua jet", 40, Tipo.AGUA, 20));
        movimientos.add(new Movimiento("Hidropulso", 60, Tipo.AGUA, 20));

        //Movimientos tipo planta
        movimientos.add(new Movimiento("Follaje", 40, Tipo.PLANTA, 40));
        movimientos.add(new Movimiento("Hoja mágica", 60, Tipo.PLANTA,  20));
        movimientos.add(new Movimiento("Bomba germen", 70, Tipo.PLANTA, 15));
        movimientos.add(new Movimiento("Energibola", 90, Tipo.PLANTA, 10));

        movimientos.add(new Movimiento("Látigo",  40, Tipo.NORMAL, 30));
        movimientos.add(new Movimiento("Aranazo",35, Tipo.NORMAL,40));
    }

    public Movimiento buscarMovimientoPorNombre(String nombre){
        for(Movimiento movimiento : movimientos){
            if(movimiento.getNombre().equals(nombre)){
                return movimiento;
            }
        }
        return null;

    }
}

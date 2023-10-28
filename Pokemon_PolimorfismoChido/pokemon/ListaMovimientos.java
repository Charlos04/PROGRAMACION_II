package pokemon;

import java.util.ArrayList;

public class ListaMovimientos {
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos(){
        //Movimientos de tipo Agua
        movimientos.add(new Movimiento("Impactrueno", 40, Tipo.ELECTRICO, 30, TiposMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Látigo", 50, Tipo.NORMAL, 25, TiposMovimiento.FISICO));
        movimientos.add(new Movimiento("Ataque rápido", 40, Tipo.NORMAL, 30, TiposMovimiento.FISICO));
        movimientos.add(new Movimiento("Rayo", 90, Tipo.ELECTRICO, 15, TiposMovimiento.ESPECIAL));

        //Movimientos tipo planta
        movimientos.add(new Movimiento("Ataque Ala", 60, Tipo.VOLADOR, 35, TiposMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Ascuas", 40, Tipo.FUEGO,  25, TiposMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Giro Fuego", 35, Tipo.FUEGO, 15, TiposMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Tajo aereo", 75, Tipo.VOLADOR, 15, TiposMovimiento.FISICO));
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

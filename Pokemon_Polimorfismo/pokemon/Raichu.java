package pokemon;

public class Raichu extends Pokemon{
    private Tipo tipo1 =Tipo.ELECTRICO;


public Raichu(String nombre, int nivel){
    super(60, nivel,nombre,90, 55,90,80,110, 1, 4);
    ListaMovimientos listaMovimientos = new ListaMovimientos();

    
    setMovimiento(0,listaMovimientos.buscarMovimientoPorNombre("Impactrueno"));
    setMovimiento(1,listaMovimientos.buscarMovimientoPorNombre("Látigo"));
    setMovimiento(2,listaMovimientos.buscarMovimientoPorNombre("Ataque rápido"));
    setMovimiento(3,listaMovimientos.buscarMovimientoPorNombre("Rayo"));


}


public double obtenerEfectividad(Pokemon pokemon){
    double efectividad= 1.0;

    if (pokemon.getMovimientos().getTipo() == Tipo.ACERO) efectividad = 0.5;
    if (pokemon.getMovimientos().getTipo() == Tipo.ELECTRICO) efectividad = 0.5;
    if (pokemon.getMovimientos().getTipo() == Tipo.TIERRA) efectividad = 2.0;
    if (pokemon.getMovimientos().getTipo() == Tipo.VOLADOR) efectividad = 0.5;
    

    
    return efectividad;
}
}

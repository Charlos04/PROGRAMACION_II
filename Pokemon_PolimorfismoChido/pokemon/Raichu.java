package pokemon;

public class Raichu extends Pokemon{
    private Tipo tipo =Tipo.ELECTRICO;


public Raichu(String nombre, int nivel){
    super(60, nivel,nombre,90, 55,90,80,110);
    ListaMovimientos listaMovimientos = new ListaMovimientos();

    
    setMovimiento(0,listaMovimientos.buscarMovimientoPorNombre("Impactrueno"));
    setMovimiento(1,listaMovimientos.buscarMovimientoPorNombre("Látigo"));
    setMovimiento(2,listaMovimientos.buscarMovimientoPorNombre("Ataque rápido"));
    setMovimiento(3,listaMovimientos.buscarMovimientoPorNombre("Rayo"));


}


public double obtenerEfectividad(Pokemon atacante, int m){
    double efectividad= 1.0;

    if (atacante.getMovimientos(m).getTipo() == Tipo.ACERO) efectividad = 0.5;
    if (atacante.getMovimientos(m).getTipo() == Tipo.ELECTRICO) efectividad = 0.5;
    if (atacante.getMovimientos(m).getTipo() == Tipo.TIERRA) efectividad = 2.0;
    if (atacante.getMovimientos(m).getTipo() == Tipo.VOLADOR) efectividad = 0.5;
    

    
    return efectividad;
}
}

package pokemon;
public class PokemonPlanta extends Pokemon{
    public PokemonPlanta(String nombre, int nivel){
        super(nombre, Tipo.PLANTA, nivel);

        ListaMovimientos listaMovimientos= new ListaMovimientos();
        
        setMovimiento(0,listaMovimientos.buscarMovimientoPorNombre("Follaje"));
        setMovimiento(1,listaMovimientos.buscarMovimientoPorNombre("Hoja mágica"));
        setMovimiento(2,listaMovimientos.buscarMovimientoPorNombre("Bomba germen"));
        setMovimiento(3,listaMovimientos.buscarMovimientoPorNombre("Energibola"));
    }
   
    
    @Override
    public double obtenerEfectividad(Pokemon pokemon){
        double efectividad=  1.0;

        if (pokemon.getTipo() == Tipo.AGUA) efectividad = 2.0;
        if (pokemon.getTipo() == Tipo.ROCA) efectividad = 2.0;
        if (pokemon.getTipo() == Tipo.TIERRA) efectividad = 2.0;
        if (pokemon.getTipo() == Tipo.ELECTRICO) efectividad = 1.0;
        if (pokemon.getTipo() == Tipo.PLANTA) efectividad = 1.0;
        if (pokemon.getTipo() == Tipo.VOLADOR) efectividad = 0.5;
        if (pokemon.getTipo() == Tipo.VENENO) efectividad = 0.0;

        return efectividad;
    }
}

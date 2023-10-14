package pokemon;
public class PokemonAgua extends Pokemon{
    public PokemonAgua(String nombre, int nivel){
        super(nombre, Tipo.AGUA, nivel);

        ListaMovimientos listaMovimientos= new ListaMovimientos();
        
        setMovimiento(0,listaMovimientos.buscarMovimientoPorNombre("Caparaconcha afilada"));
        setMovimiento(1,listaMovimientos.buscarMovimientoPorNombre("Pistola de agua"));
        setMovimiento(2,listaMovimientos.buscarMovimientoPorNombre("Acua jet"));
        setMovimiento(3,listaMovimientos.buscarMovimientoPorNombre("Hidropulso"));
    }

    @Override
    public double obtenerEfectividad(Pokemon pokemon){
        double efectividad= 1.0;

        if (pokemon.getTipo() == Tipo.FUEGO) efectividad = 2.0;
        if (pokemon.getTipo() == Tipo.ROCA) efectividad = 2.0;
        if (pokemon.getTipo() == Tipo.TIERRA) efectividad = 2.0;

        if (pokemon.getTipo() == Tipo.ACERO) efectividad = 1.0;
        if (pokemon.getTipo() == Tipo.DRAGON) efectividad = 0.5;
        

        
        return efectividad;
    }
}

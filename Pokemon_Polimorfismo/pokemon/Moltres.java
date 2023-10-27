package pokemon;

public class Moltres extends Pokemon{
    private Tipo tipo1= Tipo.FUEGO;
    private Tipo tipo2= Tipo.VOLADOR;

    public Moltres(String nombre, int nivel) {
        super(90, nivel,nombre,100, 90,125,85,90,1,4);
   
        ListaMovimientos listaMovimientos = new ListaMovimientos();

    
        setMovimiento(0,listaMovimientos.buscarMovimientoPorNombre("Ataque Ala"));
        setMovimiento(1,listaMovimientos.buscarMovimientoPorNombre("Ascuas"));
        setMovimiento(2,listaMovimientos.buscarMovimientoPorNombre("Giro Fuego"));
        setMovimiento(3,listaMovimientos.buscarMovimientoPorNombre("Tajo aereo"));
   
    }

    
    public double obtenerEfectividad(Pokemon pokemon){
        double efectividad= 1.0;
    
        if (pokemon.getMovimientos().getTipo() == Tipo.ACERO) efectividad = 0.5;
        if (pokemon.getMovimientos().getTipo() == Tipo.AGUA) efectividad = 2;
        if (pokemon.getMovimientos().getTipo() == Tipo.BICHO) efectividad = 0.25;
        if (pokemon.getMovimientos().getTipo() == Tipo.ELECTRICO) efectividad = 2.0;
        if (pokemon.getMovimientos().getTipo() == Tipo.FUEGO) efectividad = 0.5;
        if (pokemon.getMovimientos().getTipo() == Tipo.HADA) efectividad = 0.5;
        if (pokemon.getMovimientos().getTipo() == Tipo.HIELO) efectividad = 1.0;
        if (pokemon.getMovimientos().getTipo() == Tipo.LUCHA) efectividad = 0.5;
        if (pokemon.getMovimientos().getTipo() == Tipo.PLANTA) efectividad = 0.25;
        if (pokemon.getMovimientos().getTipo() == Tipo.ROCA) efectividad = 0.25;
        if (pokemon.getMovimientos().getTipo() == Tipo.TIERRA) efectividad = 2.0;
        
        
    
        
        return efectividad;
    }
}

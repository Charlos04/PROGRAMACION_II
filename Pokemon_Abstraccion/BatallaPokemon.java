import pokemon.PokemonAgua;
import pokemon.PokemonPlanta;

public class BatallaPokemon  {
    public static void main(String[] args){

        PokemonAgua Oshawott = new PokemonAgua("Oshawott",10);
        PokemonPlanta SpriGatito = new PokemonPlanta("SpriGatito", 10);

        Oshawott.atacar(0, SpriGatito);
        SpriGatito.HpRestante();

        System.out.println();

        SpriGatito.atacar(1, Oshawott);
        Oshawott.HpRestante();

    }
}

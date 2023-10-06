public class BatallaPokemon  {
    public static void main(String[] args){

        PokemonAgua Oshawott = new PokemonAgua("Oshawott",10);
        PokemonPlanta SpriGatito = new PokemonPlanta("SpriGatito", 10);

        Oshawott.atacar("Caparaconcha afilada", SpriGatito);
        SpriGatito.HpRestante(SpriGatito);

        System.out.println();

        SpriGatito.atacar("Látigo", Oshawott);
         Oshawott.HpRestante(Oshawott);

    }
}

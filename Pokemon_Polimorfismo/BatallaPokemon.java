import pokemon.Pokemon;
import pokemon.Raichu;
import pokemon.Moltres;

public class BatallaPokemon  {
    public static void main(String[] args){

        Pokemon raichu= new Raichu("Raichu",1);
        Pokemon moltres= new Moltres("Moltres", 1);

        raichu.atacar(0, raichu, moltres);
        System.out.println();
        moltres.atacar(2, moltres, raichu);
    }
}

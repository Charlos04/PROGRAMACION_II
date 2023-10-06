public class Pokemon {
    private int hp, nivel;
    private String nombre, tipo;

    public Pokemon(String nombre, String tipo, int nivel) {
    this.nivel = nivel;
    this.nombre = nombre;
    this.tipo = tipo;
    hp=100;
    }

    private void calculaDanio(int danio){
        this.hp -= danio;
        System.out.printf("%s recibe %d puntos de danio\n", this.getNombre(), danio);
    }

    public void recibirAtaque(String movimiento){
        System.out.printf("%s recibe ATK %s\n", this.getNombre(),movimiento);
        calculaDanio((int) (Math.random()*10+1));
    }

    public void atacar(String movimiento, Pokemon pokemon){
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(), pokemon.getNombre(), movimiento);
        pokemon.recibirAtaque( movimiento);
    }

    public void HpRestante(Pokemon pokemon){
        System.out.println( pokemon.getNombre()+ " tiene " + this.getHP() + " puntos de vida");
    }

    public int getHP() {
    return hp;
    }

    public int getNivel(){
        return nivel;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    }

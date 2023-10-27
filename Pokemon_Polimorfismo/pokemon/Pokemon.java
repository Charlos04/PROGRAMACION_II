package pokemon;

public abstract class Pokemon {
    private int ps, nivel, ataque, defensa, ataqueEspecial, defensaEspecial;
    private String nombre;
    private double velocidad;
    private Movimiento movimientos[];

    public Pokemon(int ps, int nivel, String nombre, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, double velocidad, int Nivel, Movimiento movimientos[]) {
        this.ps = ps;
        this.nivel = nivel;
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.movimientos= new Movimiento[4];
    }
    

    private void calculaDanio(int danio, double efectividad){
        int variacion= (int)(85+Math.random()*16);
        double puntosRestados= (0.01*danio*efectividad*variacion*danio);
        this.ps -= puntosRestados;
        System.out.printf("%s recibe %.2f puntos de danio\n", this.getNombre(), puntosRestados);
        this.HPRestante();
    }

    public void HPRestante(){
        System.out.println( this.getNombre() + " ahora tiene " + this.getPs() + " puntos de vida");
    }

    public void recibirAtaque(Movimiento movimiento, double efectividad){
        System.out.printf("%s recibe ATK %s\n", this.getNombre(),movimiento.getNombre());
        int danio=0;

        if(movimiento.getTiposMovimiento() ==TiposMovimiento.FISICO){
            danio= (int)((((0.2*pokemon.getNivel()+1)*(pokemon.getAtaque()*movimiento.getPuntosDeAtaque()))/(25*getDefensa()))+2);
        }
        else if(movimiento.getTiposMovimiento() == TiposMovimiento.ESPECIAL) {
            danio = (int)((((0.2*pokemon.getNivel()+1)*(pokemon.getAtaqueEspecial()*movimiento.getPuntosDeAtaque()))/(25*getDefensaEspecial()))+2);
        }
        
        calculaDanio(danio, efectividad);
    
}

    protected boolean seHaConcretadoAtaque(Movimiento movimiento, Pokemon pokemon, int m){
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(), pokemon.getNombre(), movimiento.getNombre()); 
        double efectividad= obtenerEfectividad(pokemon,m);

        if(movimiento.getPp() > 0){
            pokemon.recibirAtaque(movimiento,efectividad);
            return true;
        } else{
            System.err.println("El movimiento no tiene puntos de pp");
            return false;
        }
    }

    public void atacar(int m, Pokemon pokemon){
       Movimiento movimiento= getMovimiento(m);
       boolean seHaConcretadoAtaque = seHaConcretadoAtaque(movimiento, pokemon, m);
       if(seHaConcretadoAtaque){
        pokemon.getMovimiento(m).setPp(movimiento.getPp()-1);
       }
    }


    public abstract double obtenerEfectividad(Pokemon pokemon);

    public int getPs() {
    return ps;
    }

    public int getNivel(){
        return nivel;
    }

    public String getNombre(){
        return nombre;
    }
    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }


    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public Movimiento getMovimiento(int pos){
        return this.movimientos[pos];
    }

    public void setMovimiento(int pos, Movimiento movimientos){
        this.movimientos[pos]=movimientos;
    }
    

}

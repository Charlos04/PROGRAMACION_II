package pokemon;

public abstract class Pokemon {
    private int ps, nivel, ataque, defensa, ataqueEspecial, defensaEspecial;
    private String nombre;
    private double velocidad;
    private Movimiento movimientos[];

    public Pokemon(int ps, int nivel, String nombre, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, double velocidad) {
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
    

    private void calculaDanio(int danio, double efectividad, Pokemon atacante){
        int variacion= (int)(85+Math.random()*16);
        double puntosRestados= (0.01*danio*efectividad*variacion*danio);
        this.ps -= puntosRestados;
        System.out.printf("%s recibe %.2f puntos de danio\n", this.getNombre(), puntosRestados);
        this.HPRestante(atacante);
    }

    public void HPRestante(Pokemon atacante){
        System.out.println( this.getNombre() + " ahora tiene " + this.getPs() + " puntos de vida");
    }

    public void recibirAtaque(Movimiento movimiento, double efectividad, Pokemon atacante){
        System.out.printf("%s recibe ATK %s\n", this.getNombre(),movimiento.getNombre());
        int danio=0;

        if(movimiento.getTiposMovimiento() ==TiposMovimiento.FISICO){
            danio= (int)((((0.2*atacante.getNivel()+1)*(atacante.getAtaque()*movimiento.getPuntosDeAtaque()))/(25*getDefensa()))+2);
        }
        else if(movimiento.getTiposMovimiento() == TiposMovimiento.ESPECIAL) {
            danio = (int)((((0.2*atacante.getNivel()+1)*(atacante.getAtaqueEspecial()*movimiento.getPuntosDeAtaque()))/(25*getDefensaEspecial()))+2);
        }
        
        calculaDanio(danio, efectividad, atacante);
    
}

    protected boolean seHaConcretadoAtaque(Movimiento movimiento, Pokemon pokemon, Pokemon atacante, int m){
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(), pokemon.getNombre(), movimiento.getNombre()); 
        double efectividad= obtenerEfectividad(atacante,m);

        if(movimiento.getPp() > 0){
            pokemon.recibirAtaque(movimiento,efectividad,atacante);
            return true;
        } else{
            System.err.println("El movimiento no tiene puntos de pp");
            return false;
        }
    }

    public void atacar(int m, Pokemon atacante, Pokemon defensor){
       Movimiento movimiento= getMovimiento(m);
       boolean seHaConcretadoAtaque = seHaConcretadoAtaque(movimiento, defensor, atacante, m);
       if(seHaConcretadoAtaque){
        atacante.getMovimiento(m).setPp(movimiento.getPp()-1);
       }
    }


    public abstract double obtenerEfectividad(Pokemon atacante, int m);

    public int getPs() {
    return ps;
    }

    public int getNivel(){
        return nivel;
    }

    public String getNombre(){
        return nombre;
    }

    public void setMovimiento(int pos, Movimiento movimientos){
        this.movimientos[pos]=movimientos;
    }

    public Movimiento getMovimiento(int pos){
        return this.movimientos[pos];

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


    public Movimiento getMovimientos(int m) {
        return movimientos[m];
    }

    

}

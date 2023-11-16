import java.io.Serializable;

public class Movimientos implements Serializable{
    private CantidadBilletes cantidadBilletes;
    private String accion, usuario;
    private int saldo, retiro;
    private boolean exito;
    
    public Movimientos(String accion, String usuario, int saldo, boolean exito) {
        this.accion = accion;
        this.usuario = usuario;
        this.saldo = saldo;
        this.exito = exito;
    }   
    public Movimientos(String accion, String usuario, int saldo, int retiro, boolean exito, CantidadBilletes cantidadBilletes) {
        this.accion = accion;
        this.usuario = usuario;
        this.saldo = saldo;
        this.retiro= retiro;
        this.exito = exito;
        this.cantidadBilletes = cantidadBilletes;
    }
    public void cosultaDeSaldo(){
        System.out.println("Saldo disponible $"+getSaldo()+"\n");
    }

    public int retirar(int saldo, int aRetirar, CantidadBilletes cantidadBilletes){
        if(!retiroExitoso(aRetirar)){
            System.out.println("Saldo insuficiente, ingrese otra cantidad");
            return saldo;
        } else{
            if (aRetirar != (int) aRetirar) {
                System.out.println("Ingrese un numero a retirar válido");
                return saldo;
            }
        int cantidadRestante = (int) aRetirar;
        for (Billetes billete : cantidadBilletes.getBilletesRestantes()) {
            int denominacion = billete.getdenominacion();
            int cantidadDeBilletes = billete.getCantidadDeBilletes();
            int billetesAUtilizar = Math.min(cantidadRestante / denominacion, cantidadDeBilletes);
            cantidadRestante -= billetesAUtilizar * denominacion;
            if (billetesAUtilizar > 0) {
                billete.setCantidadDeBilletes(cantidadDeBilletes - billetesAUtilizar);
            }
        }
        System.out.println("¡Retiro Exitoso!\n");
        cantidadBilletes.guardarBilletes();
        saldo -= aRetirar;
        this.exito = true;
        return saldo;
        }
    }
    public boolean retiroExitoso(int aRetirar){
        if(aRetirar>saldo){
            System.out.println("Saldo insufuciente, ingrese otra cantidad");
            return false;
        } 
        
        int cantidadRestante = (int) aRetirar;
        for (Billetes billete : cantidadBilletes.getBilletesRestantes()) {
            int denominacion = billete.getdenominacion();
            int cantidadDeBilletes = billete.getCantidadDeBilletes();
            int billetesAUtilizar = Math.min(cantidadRestante / denominacion, cantidadDeBilletes);
            cantidadRestante -= billetesAUtilizar * denominacion;
    
            if (cantidadRestante == 0) {
                return true;
            } 
        }
        System.out.println("Billetes insuficientes, ingrese otra cantidad");
        return false;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getRetiro() {
        return retiro;
    }

    public void setRetiro(int retiro) {
        this.retiro = retiro;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }
    
    public CantidadBilletes getCantidadBilletes() {
        return cantidadBilletes;
    }

    public void setcantidadBilletes(CantidadBilletes cantidadBilletes) {
        this.cantidadBilletes = cantidadBilletes;
    }

    
    @Override
    public String toString(){
        String cantidad = (retiro != 0) ? "$" + retiro : "$" + saldo;
        String realizadoString = (exito) ? "SI" : "NO";
        return "Movimiento: "+accion+
        ", Usuario: "+usuario+
        ", Cantidad: "+cantidad+
        ", ¿Se realizó correctamente? "+realizadoString;
    }
    public void setCantidadBilletes(CantidadBilletes cantidadBilletes) {
        this.cantidadBilletes = cantidadBilletes;
    }
}

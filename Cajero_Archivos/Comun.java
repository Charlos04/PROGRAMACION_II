import java.util.InputMismatchException;
import java.util.Scanner;

public class Comun extends Usuario{
    private int saldo;
    private ArchivoTexto registros = new ArchivoTexto();

    public Comun(String usuario, int nip, int saldo){
        super(usuario, nip);
        this.saldo = saldo;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public ArchivoTexto getRegistros() {
        return registros;
    }
    public void setRegistros(ArchivoTexto registros) {
        this.registros = registros;
    }
    @Override
    public boolean comprobaciondeNip(int nip) {
        if(String.valueOf(nip).length() == 4){
            return false;
        } else{ 
            System.out.println("NIP inválido, intente otra vez");
            return true;
        }
    }
    public void menu(CantidadBilletes cantidadBilletes) {
        byte opcion=0;
        int aRetirar = 0;

        Movimientos movimientos = null;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido: " + getUsuario()+ "\n");
          
        do{
        try {
                System.out.println("¿Qué desea realizar?");
                System.out.println("1.- Consultar saldo");
                System.out.println("2.- Retirar efectivo");
                System.out.println("3.- Salir");
                System.out.print("Opción: ");

                opcion = teclado.nextByte();
                switch (opcion) {
                    case 1:
                        movimientos = new Movimientos("Consulta de saldo", getUsuario(), getSaldo(), true);
                        registros.escribir(movimientos.toString(), true);
                        movimientos.cosultaDeSaldo();
                        break;
                    case 2:
                        boolean validacionRetiro = true;
                        do {
                            System.out.print("¿Cuánto desea retirar? ");
                            System.out.println("Mínimo de retiro $" + cantidadBilletes.retiroMinimo()+"\n");
                            if (teclado.hasNextInt()) {
                                aRetirar = teclado.nextInt();
                                validacionRetiro = false;
                            } else {
                                System.out.println("Introduzca números enteros");
                                
                            }
                        } while (validacionRetiro);
                        teclado.nextLine();
                        movimientos = new Movimientos("Retiro de efectivo", getUsuario(), getSaldo(), aRetirar, false, cantidadBilletes);
                        this.saldo = movimientos.retirar(saldo, aRetirar, cantidadBilletes);
                        registros.escribir(movimientos.toString(), true);
                        break;
                    case 3:
                        System.out.println("Gracias por usar el cajero, vuelva pronto");
                            break;
                            
                    default:
                        System.out.println("Elige una opción válida");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un numero entero para elegir");
                opcion = 0;
            }catch (InputMismatchException e) {
                System.out.println("Ingresa un numero entero para elegir");
                opcion = 0;
            }
        } while (opcion <1 || opcion >3);
    teclado.close();
    }
}


import java.util.InputMismatchException;
import java.util.Scanner;
public class Administrador extends Usuario{
    private ArchivoTexto registros = new ArchivoTexto();

    public Administrador(String usuario, int nip){
        super(usuario, nip);
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
    public void menu(CantidadBilletes cantidadBilletes){
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ha entrado al modo administrador");
        do {
            try{
                System.out.println("¿Qué desea hacer?");
                System.out.println("1. Mostrar acciones realizadas");
                System.out.println("2.- Consutar billetes restantes");
                System.out.println("3.- Salir\n");
                System.out.print("Opcion: ");
                
                String input = teclado.nextLine();
                String[] opciones = input.split("\\s+");
                if (opciones.length>0) {
                    opcion = Integer.parseInt(opciones[0]);
                }
                switch (opcion) {
                    case 1: System.out.println("Estas son las acciones realizadas");
                        registros.leer();
                        break;
                    case 2: System.out.println("Estos billetes quedan");
                        cantidadBilletes.leer();
                        break;
                    case 3: System.out.println("Saliendo...");
                        
                        break;

                    default: System.out.println("Elige una opción válida");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un denominacion numérico para la opción");
                opcion = 0;
            }catch (InputMismatchException e) {
                System.out.println("Ingresa un denominacion numérico para la opción");
                opcion = 0;
            }
            
        } while (opcion != 3);
        teclado.close();
    }

    public ArchivoTexto getRegistros() {
        return registros;
    }

    public void setRegistros(ArchivoTexto registros) {
        this.registros = registros;
    } 
}
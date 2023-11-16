
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validacion {
    String nombreUsuario = "";
    String stnip="";
    int nip = 0;
    Usuario usuario = null;
    static ArchivoTexto historial = new ArchivoTexto();

    Scanner teclado=new Scanner(System.in);

    public Validacion(String nombreUsuario, int nip, Usuario usuario) {
        historial.crear();

        this.nombreUsuario = nombreUsuario;
        this.nip = nip;
        this.usuario = usuario;
    }

    public void validacion(Usuario usuario, CantidadBilletes cantidadBilletes){

            try {
                System.out.print("Nombre: ");
                nombreUsuario = teclado.nextLine();

                System.out.print("NIP (4 dígitos):");
                nip = teclado.nextInt();
                this.stnip=String.valueOf(nip);

                if (stnip.length() == 4 ) {
                    if (nombreUsuario.equals("admin") && nip == 3243) {
                        usuario = new Administrador(nombreUsuario, nip);
                        usuario.menu(cantidadBilletes);
                    } else {
                        usuario = new Comun(nombreUsuario, nip, (int)(Math.random()*49000+1000));
                        usuario.menu(cantidadBilletes);
                    }
                } else {
                    System.out.println("El NIP debe tener exactamente 4 dígitos.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar solo números para el NIP.");
                teclado.nextLine();
            }
    }

}

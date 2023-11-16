
public class CajeroAutomáticoMain{
    static CantidadBilletes cantidadBilletes = new CantidadBilletes();
    public static void main(String[] args) {
        String nombreUsuario = "";
        int nip = 0;
        Usuario usuario = null;
        ArchivoTexto historial = new ArchivoTexto();
        historial.crear();

        Validacion ejecucion = new Validacion(nombreUsuario, nip, usuario);
        ejecucion.validacion(usuario, cantidadBilletes);
    }
    
}
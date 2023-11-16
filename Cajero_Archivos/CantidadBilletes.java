import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CantidadBilletes{
    private ArrayList<Billetes> billetesRestantes = new ArrayList<>();
    private String nombreDeArchivo;

    public CantidadBilletes(){
        this.nombreDeArchivo = "billetes.dat";
        cargarBilletes();
    }

    public ArrayList<Billetes> getBilletesRestantes() {
        return billetesRestantes;
    }

    public void cargarBilletes(){
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(this.nombreDeArchivo))) {
            billetesRestantes = (ArrayList<Billetes>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            billetesIniciales();
            guardarBilletes();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer desde el archivo");
        }
    }
    public void guardarBilletes() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(this.nombreDeArchivo))) {
            outputStream.writeObject(this.billetesRestantes);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
        }
    }
    private void billetesIniciales() {
        billetesRestantes = new ArrayList<>();
        billetesRestantes.add(new Billetes(1000, 10));
        billetesRestantes.add(new Billetes(500, 20));
        billetesRestantes.add(new Billetes(200, 100));
        billetesRestantes.add(new Billetes(100, 100));
    }
        public void leer(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(this.nombreDeArchivo));
            try {
                while(true){
                    ArrayList<Billetes> billetes = (ArrayList<Billetes>) inputStream.readObject();
                    System.out.println("Billetes disponibles");
                    for (Billetes billete: billetes) {
                    System.out.println(billete);
                    }
                } 
            } catch (EOFException e) {
                
            }
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer");
        }
    }
    public int retiroMinimo(){
        int cantidadMin = 51000;

        for (Billetes billete : billetesRestantes) {
            int denominacion = billete.getdenominacion();
            int cantidadDisponible = billete.getCantidadDeBilletes();
    
            // Si hay billetes disponibles y el denominacion del billete es menor que la cantidad mínima actual
            if (cantidadDisponible > 0 && denominacion < cantidadMin) {
                cantidadMin = denominacion;
            }
        }
    
        return cantidadMin;
    }
}

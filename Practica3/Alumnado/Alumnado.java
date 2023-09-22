
package com.mycompany.alumnado;

public class Alumnado {

    public static void main(String[] args) {

        Alumno a1 = new Alumno("Carlos Daniel Gutierrez Canul", "ISC", 64742, 3,'B', "Esmeralda");

        System.out.println("Alumno: " + a1.getNombre());
        System.out.println("Carrera: " + a1.getCarrera());
        System.out.println("Matricula: " + a1.getMatricula());
        System.out.println("Semestre: " + a1.getGrado());
        System.out.println("Grupo: " + a1.getGrupo());
        
        String telefono;
        telefono = a1.getTutor().getTelefono().NumeroCompleto();
        System.out.println("Telefono: " + telefono);
    }
}

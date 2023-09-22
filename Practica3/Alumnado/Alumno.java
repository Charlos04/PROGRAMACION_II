
package com.mycompany.alumnado;

import java.util.Scanner;

public class Alumno {
    private String Nombre, carrera, Tutor;
    private int Matricula, Grado;
    private char Grupo;
    public Tutor tutor = new Tutor();
    
    public Alumno(String Nombre, String carrera, int Matricula, int Grado, char Grupo, String Tutor){
        this.Nombre = Nombre;
        this.carrera= carrera;
        this.Matricula  = Matricula;
        this.Grado = Grado;
        this.Grupo= Grupo;
        this.Tutor= Tutor;
    }
      
    public String getNombre(){
        return Nombre;
    }
    
    public String getCarrera(){
        return carrera;
    }
    
    public int getMatricula(){
        return Matricula;
    }

    public int getGrado(){
        return Grado;
    }
    
    public char getGrupo(){
        return Grupo;
    }
    
    public Tutor getTutor(){
        return tutor;
    }
     
}


package com.mycompany.alumnado;

public class Telefono {
    private String pais, lada, numero, nCompleto;
    
    public Telefono(){
        pais= "+52";
        lada="981";
        numero="2091556";
        nCompleto= pais.concat(" "+lada+numero);
    }
    
    public String NumeroCompleto(){
        return nCompleto;
    }

   
    
}

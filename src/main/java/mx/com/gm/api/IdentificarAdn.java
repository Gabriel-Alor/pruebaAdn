
package mx.com.gm.api;


public class IdentificarAdn {
    int contador = 0;
    int contador2 = 0;
    int verificador = 0;
    private String[][] ADN;
    private String[] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] nombre) {
        this.dna = nombre;
    }
    
    
    public boolean hasMutation(String[] adn){
        
         ADN = new String[adn.length][adn[0].length()];
        
        //Llenar la matriz con las letras del arreglo
        for (int i = 0; i < adn.length; i++) {
            for (int j = 0; j < adn[i].length(); j++) {
                ADN[i][j] = String.valueOf(adn[i].charAt(j));
            }
        }
        
        //evaluar las letras de la matriz para identificar mutación CCCC=mutacion
        for (int i = 0; i < ADN.length; i++) {
            for (int j = 0; j < ADN.length; j++) {
                for (int k = 0; k < ADN.length; k++) {
                    if(ADN[i][j].equals(ADN[i][k])){
                        contador++;
                    }
                    if(ADN[j][i].equals(ADN[k][i])){
                         contador2++;
                    }
                }
                if(contador > 3 || contador2 > 3){
                    verificador++;
                    contador = 0;
                    contador2 = 0;
                    j = ADN.length;
                }else{
                    contador = 0;
                    contador2 = 0;
                }
            }
        }
        //si verificador trae un numero mayor a 0 significa que encontro mutación...
        // y devuelve un true de lo contrario devuelve un false
       if(verificador > 0) {
           return true;
        }else{
           return false;
       }     
    }  
     
}

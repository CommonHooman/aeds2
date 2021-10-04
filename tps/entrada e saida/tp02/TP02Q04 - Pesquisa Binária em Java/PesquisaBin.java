import java.util.*;
import java.io.*;

public class PesquisaBin {

    //Checa se o input deve ser terminado
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //Acha o nome da serie a partir do nome de seu arquivo
    public static String processaNomeArquivo(String nomeArquivo){
        String nomeSerie = "";

        for(int i = 0; nomeArquivo.charAt(i) != '.'; i++){
            if(nomeArquivo.charAt(i) == '_')
                nomeSerie += " ";
            else
                nomeSerie += nomeArquivo.charAt(i);
        }

        return nomeSerie;
    }

    public static int pesquisaBinaria(String s, List<String> array, int esq, int dir){
        if (dir >= esq) {
            int meio = esq + (dir - esq) / 2;
  
            // If the element is present at the
            // meiodle itself
            if (array.get(meio).equals(s))
                return meio;
  
            // If element is smaller than meio, then
            // it can only be present in left subarray
            if (array.get(meio).compareTo(s) > 0)
                return pesquisaBinaria(s, array, esq, meio -1);
  
            // Else the element can only be present
            // in right subarray
            return pesquisaBinaria(s, array, meio + 1, dir);
        }
  
        // We reach here when element is not present
        // in array
        return -1;
    }

    public static void main(String[] args){
        List<String> baseSeries = new ArrayList<String>();
        String linha_nova;
        int num_linha = 0, parar = 0;
        
        do{
            linha_nova = MyIO.readLine();

            if(isFim(linha_nova) == true)
                parar = 1;
            else
                baseSeries.add(processaNomeArquivo(linha_nova));
        }while(parar != 1);

        parar = 0;
        Collections.sort(baseSeries);

        do{
            linha_nova = MyIO.readLine();

            if(isFim(linha_nova) == false){
                if(pesquisaBinaria(linha_nova, baseSeries, 0, baseSeries.size()-1) != -1){
                    System.out.println("SIM");
                }else{
                    System.out.println("NÃO");
                }
            }else{
                parar = 1;
            }
        }while(parar != 1);
    }
}

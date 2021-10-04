import java.util.*;

public class PesquisaSeq {

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

    public static int pesquisaSequencial(String s, String[] array){
        for(int i = 0; i < array.length; i++){
            if(s.equals(array[i]))
                return i;
        }

        return -1;
    }

    public static void main(String[] args){
        String[] baseSeries = new String[1000];
        String linha_nova;
        int num_linha = 0, parar = 0;
        
        do{
            linha_nova = MyIO.readLine();

            if(isFim(linha_nova) == true)
                parar = 1;
            else
                baseSeries[num_linha++] = processaNomeArquivo(linha_nova);
        }while(parar != 1);

        baseSeries[num_linha] = null;
        parar = 0;
       
        do{
            linha_nova = MyIO.readLine();

            if(isFim(linha_nova) == false){
                if(pesquisaSequencial(linha_nova, baseSeries) != -1){
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

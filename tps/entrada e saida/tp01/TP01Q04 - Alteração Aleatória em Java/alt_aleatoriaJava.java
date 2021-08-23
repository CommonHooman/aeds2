import java.util.Random;
import java.lang.Math;

class alt_aleatoriaJava{
    
    private static Random gerador = new Random();

    //Checa se o input deve ser terminado
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //Altera os valores de cada caractere da string base com base na cifra
    public static String aleatorizar(String base){
        String resul = "";
        char char_base, char_resul;

        char_base = (char)(Math.abs(gerador.nextInt()) % 26 + 'a');
        char_resul = (char)(Math.abs(gerador.nextInt()) % 26 + 'a');

        for(int i = 0; i < base.length(); i++){
            if(base.charAt(i) == char_base){
                resul += (char)(char_resul);
            }else{
                resul += (char)(base.charAt(i));
            }
        }

        return resul;
    }

    //Reciclagem de main de outras questoes
    public static void main(String[] args){
        gerador.setSeed(4);
        String[] entrada = new String[1000];
        int num_linha = 0;

        do{
            entrada[num_linha] = MyIO.readLine();
        }while(isFim(entrada[num_linha++]) == false);
        num_linha--;

        for(int i = 0; i < num_linha; i++){
            MyIO.println(aleatorizar(entrada[i]));
        }
    }
}

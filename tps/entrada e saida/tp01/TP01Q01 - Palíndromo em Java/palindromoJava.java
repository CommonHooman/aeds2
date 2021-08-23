/*Crie um metodo iterativo que recebe uma string como parametro eretornatruese essa eh um palindromo.  
Na saida padrao, para cada linha de entrada, escreva uma linha de saida com SIM/NAO indicando se a linha eh um palindromo.
Destaca-se que uma linha de entrada pode ter caracteres nao letras. A entrada termina com a leitura de FIM*/

class palindromoJava{
    
    //Checa se a string fornecida eh um palindromo
    public static String isPalindromo(String s){
        //Compara os caracteres
        for(int i = 0, j = s.length()-1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return "NAO";
            }
        }

        return "SIM";
    }


    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //Reciclagem da main de outras questoes
    public static void main(String[] args){
        String[] entrada = new String[1000];
        int num_linha = 0;

        do{
            entrada[num_linha] = MyIO.readLine();
        }while(isFim(entrada[num_linha++]) == false);
        num_linha--;

        for(int i = 0; i < num_linha; i++){
            MyIO.println(isPalindromo(entrada[i]));
        }
    }
}
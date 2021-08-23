public class isJava {

    //Checa se a string de entrada eh composta apenas de vogais
    public static String isVogal(String s){

        //Itera por todos os caracteres da string e checa se qualquer um deles nao eh uma vogal
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u'){
                return "NAO ";
            }
        }

        //Saiu do for = todos caracteres sao vogais
        return "SIM ";
    }

    //Checa se a string de entrada eh composta apenas de consoantes
    public static String isConsoante(String s){

        for(int i = 0; i < s.length(); i++){
            //Se qualquer char for uma vogal OU nao for uma letra (for um numero ou caractere especial), retorna "NAO"
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || !((s.charAt(i) >= 97 && s.charAt(i) <= 122))) {
                return "NAO ";
            }
        }

        //Saiu do for = todos caracteres sao consoantes
        return "SIM ";
    }

    public static String isInteiro(String s){

        for(int i = 0; i < s.length(); i++){
            //Indices decimais dos inteiros na tabela ASCII, 0 = 48 ... 9 = 57
            if(!((s.charAt(i) >= 48 && s.charAt(i) <= 57))){
                return "NAO ";
            }
        }

        //Saiu do for = todos caracteres sao numeros
        return "SIM ";
    }

    public static String isReal(String s){
        //Conta a quantidade de '.' ou ',' na string, o numero maximo permitido eh 1
        int virgula_ponto = 0;

        for(int i = 0; i < s.length(); i++){
            //Tem de ser um numero
            if((s.charAt(i) >= 48 && s.charAt(i) <= 57) == false){
                //OU um '.' ou uma ',' (APENAS UM)
                if((s.charAt(i) == ',' || s.charAt(i) == '.' || s.charAt(i) == ';') && virgula_ponto == 0)
                    virgula_ponto++;
                else
                    return "NAO";
            }
        }

        //Saiu do for = todos caracteres sao numeros OU um '.' ou uma ',' (APENAS UM DOS DOIS)
        return "SIM";
    }

    //Checa se o input deve ser terminado
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args){
        MyIO.setCharset("UTF-8");
        String[] entrada = new String[2000];
        int num_linha = 0;

        do{
            entrada[num_linha] = MyIO.readLine();
        }while(isFim(entrada[num_linha++]) == false);
        num_linha--;

        for(int i = 0; i < num_linha; i++){
            MyIO.println(isVogal(entrada[i]) + isConsoante(entrada[i]) + isInteiro(entrada[i]) + isReal(entrada[i]));
        }
    }
}

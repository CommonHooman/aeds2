class algebraBool{

    /* --- Variaveis globais ---
     * Se as mesmas nao fossem globais, elas teriam de ser passadas como parametros 
     * para todas as chamadas de funcoes (muitas) e acabariam sujando o codigo
     * (elas sao re-inicializadas em cada linha vinda do pub.in) */ 
    static int A, B, C, index;
    static String statement;

    public static int typeCast(char c){
        if(c == '0')
            return 0;
        else if(c == '3')
            return 3;
        
        return 1;
    }

    //Inicializa as variaveis de entrada (globais) e retorna o resultado final de cada linha
    public static int novaLinha(String linha){
        statement = linha;

        //As variaveis A e B *sempre* sao utilizadas
        A = typeCast(statement.charAt(2));
        B = typeCast(statement.charAt(4));
        index = 6;

        //A variavel C nao eh utilizada sempre
        if(typeCast(statement.charAt(0)) == 3){
            C = typeCast(statement.charAt(6));
            index = 8;
        }

        return algebra();
    }

    public static int and(){
        int end = 0;
        int resul_parcial, resul_final = 1;

        /*Roda ate a operacao ser fechada, ou seja, o seu respectivo ')' ser atingido.
        Ou atingir uma variavel de valor 0 (para AND retornar 1, todas suas variaveis tem que ser 1) */
        while(end != -1){
            resul_parcial = algebra();

            if(resul_parcial == 0){
                resul_final = 0;
            }else if(resul_parcial == -1){
                end = -1;
            }
        }

        return resul_final; //Passou pelo while = nenhuma variavel vale 0
    }

    public static int or(){
        int end = 0;
        int resul_parcial, resul_final = 0;

        /*Roda ate a operacao ser fechada, ou seja, o seu respectivo ')' ser atingido.
        Ou atingir uma variavel de valor 1 (se qualquer variavel vale 1, OR retorna 1) */
        while(end != -1){
            resul_parcial = algebra();
            
            if(resul_parcial == 1){
                resul_final =  1;
            }else if(resul_parcial == -1){
                end = -1;
            }
        }

        return resul_final; //Passou pelo while = todas variaveis valem 0
    }

    public static int not(){
        int resul = algebra();
        index++;

        if(resul == 1){
            return 0;
        }

        return 1;
    }
    
    public static int algebra(){
        
        //Processa a linha de algebra
        for( ; index < statement.length(); index++){
            switch(statement.charAt(index)){
                case 'a': //AND
                    index += 4;
                    return and();
                case 'o': //OR
                    index += 3;
                    return or();
                case 'n': //NOT
                    index += 4;
                    return not();
                case 'A':
                    index++;
                    return A;
                case 'B':
                    index++;
                    return B;
                case 'C':
                    index++;
                    return C;
                case ')':
                    index++;
                    return -1;
                default: //Qualquer " " (espaco) ou ","
                    break;
            }
        }

        return 0; //Essa linha nunca vai ser atingida, mas o java reclamou e eu coloquei
    }

    public static boolean isFim(String s){
        return (s.length() == 1 && s.startsWith("0"));
    }

    public static void main(String[] args){
        String[] entrada = new String[2000];
        int num_linha = 0;

        do{
            entrada[num_linha] = MyIO.readLine();
        }while(isFim(entrada[num_linha++]) == false);
        num_linha--;

        for(int i = 0; i < num_linha; i++){
            MyIO.println(novaLinha(entrada[i]));
        }
    }
}

class ciframentoJavaREC{
    //Constante da cifra, o enunciado pediu pra ser 3
    static final int CIFRA = 3;

    //Checa se o input deve ser terminado
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //Altera os valores de cada caractere da string base com base na cifra, recursivamente
    public static String ciframento(String base, String resul, int index){

        //Condicao de saida = fim da string base
        if(index < base.length()){
            resul += (char)(base.charAt(index) + 3);
            resul = ciframento(base, resul, index + 1);
        }

        return resul;
    }

    //Encapsulamento da funcao recursiva
    public static String ciframento(String base){
        return ciframento(base, "", 0);
    }
    
    public static void main(String[] args){
        String[] entrada = new String[1000];
        int num_linha = 0;

        do{
            entrada[num_linha] = MyIO.readLine();
        }while(isFim(entrada[num_linha++]) == false);
        num_linha--;

        for(int i = 0; i < num_linha; i++){
            MyIO.println(ciframento(entrada[i]));
        }
    }
}
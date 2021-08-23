class ciframentoJava{
    //Constante da cifra, o enunciado pediu pra ser 3
    static final int CIFRA = 3;

    //Checa se o input deve ser terminado
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //Altera os valores de cada caractere da string base com base na cifra
    public static String ciframento(String base){
        String resul = "";

        for(int i = 0; i < base.length(); i++){
            resul += (char)(base.charAt(i) + CIFRA);
        }

        return resul;
    }

    //Reciclagem de main de outras questoes
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
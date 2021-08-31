public class donaMonica {
    
    public static void main (String[] args){
        String linha = MyIO.readLine();
        int mae, filho_1, filho_2, i = 0;

        //Le todas as linhas e da o resultado de uma
        while(linha.length() > 1) {
            //Descobre a idade da mae
            mae = (int)(linha.charAt(i) - 48)* 10 ;
            mae += (int)linha.charAt(++i) - 48;
            i += 3;

            //Descobre a idade dos dois filhos mais novos
            if(linha.charAt(i) >= 48 && linha.charAt(i) <= 57){ //Se o 1o filho tiver >= 10 anos
                filho_1 = (int)(linha.charAt(i-1) - 48)* 10 ;
                filho_1 += (int)linha.charAt(i) - 48;
                if(linha.length() == 8){ //Se ambos tiverem >= 10 anos
                    filho_2 = (int)(linha.charAt(6) - 48)* 10 ;
                    filho_2 += (int)linha.charAt(7) - 48;
                }else{ //O 2o filho tem < 10 anos
                    filho_2 = (int)linha.charAt(6) - 48;
                }
            }else{ //Ambos filhos tem < 10 anos
                filho_1 = (int)linha.charAt(i-1) - 48;
                filho_2 = (int)linha.charAt(5) - 48;
            }

            MyIO.println(mae - (filho_1 + filho_2));

            //Le a proxima e atualiza o indexador da mesma
            linha = MyIO.readLine();
            i = 0;
        }
    }
}

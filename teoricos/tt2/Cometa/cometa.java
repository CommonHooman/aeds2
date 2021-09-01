public class cometa {
    
    public static void main(String[] args){
        int ano_atual = MyIO.readInt();
        int prox_cometa;

        while(ano_atual != 0){
            if((ano_atual - 1986) % 76 == 0){
                prox_cometa = ano_atual + 76;
            }else{
                for(prox_cometa = 1986; ano_atual > prox_cometa; prox_cometa += 76){}
            }

            MyIO.println(prox_cometa);
            ano_atual = MyIO.readInt();
        }
    }
}

public class q7 {

    public boolean isDist2(No folha){
        isDist2(raiz, folha, 0);
    }

    //Retorna true se encontrar o no procurado (folha) a uma distancia de 2 nos da raiz
    public boolean isDist2(No pai, No folha, int dist){
        
        if(pai == null){
            return false;
        }else if(pai == folha && dist == 2){
            return true;
        }else if(isDist2(pai.esq, folha, dist+1) == true){
            return true;
        }else{
            return isDist2(pai.dir, folha, dist+1);
        }
    }

    /**
     * COMPLEXIDADE DO METODO:
     * 
     * Melhor caso = O(1) -> retorna false contudo encontra o no procurado na posicao da raiz
     * Pior caso = O(n) -> percorre todos os nos da arvore, retorna true apenas se o no procurado se encontra na ultima folha e a distancia eh igual a 2
     * Caso medio = O(log(n)) -> pode retornar true ou false, encontra o no procurado nas folhas de uma arvore balanceada (de pesquisa)
     */

}

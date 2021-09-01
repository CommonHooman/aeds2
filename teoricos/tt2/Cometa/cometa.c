#include <stdio.h>
#include <stdlib.h>

int main(){
    int ano_atual, prox_cometa;
    scanf(" %i ", &ano_atual);

    while(ano_atual != 0){
        if((ano_atual - 1986) % 76 == 0){
            prox_cometa = ano_atual + 76;
        }else{
            prox_cometa = 1986;
            while( ano_atual > prox_cometa){ prox_cometa += 76; }
        }

        printf("%i\n", prox_cometa);
        scanf(" %i ", &ano_atual);
    }

    return 0;
}
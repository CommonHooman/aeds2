#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    char linha[1000];
    int mae, filho_1, filho_2, filho_3, velho, i = 0;
    scanf("%i", &mae);

    //Le todas as linhas e da o resultado de uma por vez
    while(mae != 0) {
        scanf("%i", &filho_1);
        scanf("%i", &filho_2);

        //Idade do 3o filho
        filho_3 = mae - (filho_1 + filho_2);

        //Dentre os 3 filhos, qual eh o mais velho
        if(filho_1 > filho_2 && filho_1 > filho_3)
            velho = filho_1;
        else if(filho_2 > filho_1 && filho_2 > filho_3)
            velho = filho_2;
        else
            velho = filho_3;

        printf("%i\n", velho);

        //Le a proxima e atualiza o indexador da mesma
        scanf("%i", &mae);
        i = 0;
    }

    return 0;
}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
<<<<<<< HEAD
#include <locale.h>

int isPalindromo(char str[]){

    for (int i = 0, j = strlen(str)-2; i <= j; i++, j--){
=======
//#include <locale.h>

int isPalindromo(char str[]){

    for (int i = 0, j = strlen(str)-2; i <= j; i++, j--){
>>>>>>> novamente, tp1
       if(str[i] != str[j]){
           return 0;
        }
    }

   return 1;
}

int isFim(char s[]){
    return (s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

int main(){
<<<<<<< HEAD
    setlocale(LC_ALL, "en_US.UTF-8");
=======
    setlocale(LC_ALL, "en_US.UTF-8");
>>>>>>> novamente, tp1
    char entrada[1000][1000];
    int num_linha = 0;

    do{
        fgets(entrada[num_linha], 1000, stdin);
    } while (isFim(entrada[num_linha++]) == 0);
    num_linha--;

    for(int i = 0; i < num_linha; i++){
        if(isPalindromo(entrada[i])){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
    }

    return 0;
}
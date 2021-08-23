#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Checa se a string de entrada eh composta apenas de vogais
const char* isVogal(char s[]){

     //Itera por todos os caracteres da string e checa se qualquer um deles nao eh uma vogal
    for(int i = 0; i < strlen(s)-2; i++){
        if(s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u'){
            return "NAO ";
        }
    }

    //Saiu do for = todos caracteres sao vogais
    return "SIM ";
}

//Checa se a string de entrada eh composta apenas de consoantes
const char* isConsoante(char s[]){

    for(int i = 0; i < strlen(s)-2; i++){
        //Se qualquer char for uma vogal OU nao for uma letra (for um numero ou caractere especial), retorna "NAO"
        if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || !((s[i] >= 97 && s[i] <= 122))) {
            return "NAO ";
        }
    }
    //Saiu do for = todos caracteres sao consoantes
    return "SIM ";
}

const char* isInteiro(char s[]){

    for(int i = 0; i < strlen(s)-2; i++){
        //Indices decimais dos inteiros na tabela ASCII, 0 = 48 ... 9 = 57
        if(!((s[i] >= 48 && s[i] <= 57))){
            return "NAO ";
        }
    }

    //Saiu do for = todos caracteres sao numeros
    return "SIM ";
}

const char* isReal(char s[]){
    //Conta a quantidade de '.' ou ',' na string, o numero maximo permitido eh 1
    int virgula_ponto = 0;

    for(int i = 0; i < strlen(s)-2; i++){
        //Tem de ser um numero
        if((s[i] >= 48 && s[i] <= 57) == 0){
            //OU um '.' ou uma ',' (APENAS UM)
            if((s[i] == ',' || s[i] == '.') && virgula_ponto == 0)
                virgula_ponto++;
            else
                return "NAO";
        }
    }

    //Saiu do for = todos caracteres sao numeros
    return "SIM ";
}

int isFim(char s[]){
    return (s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

int main(){
    char entrada[1000][1000];
    int num_linha = 0;

    do{
        fgets(entrada[num_linha], 1000, stdin);
    } while (isFim(entrada[num_linha++]) == 0);
    num_linha--;

    for(int i = 0; i < num_linha; i++){
        printf("%s%s%s%s\n", isVogal(entrada[i]), isConsoante(entrada[i]), isInteiro(entrada[i]), isReal(entrada[i]));
    }

    return 0;
}
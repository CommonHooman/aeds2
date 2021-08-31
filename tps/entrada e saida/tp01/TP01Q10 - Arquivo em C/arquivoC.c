#include <stdio.h>
#include <stdlib.h>

void readFile(FILE *fp){

    while(!(feof(fp))){
        char num[1000];
        fread(num, sizeof(char), 1000, fp);
        readFile(fp);
        printf("%s\n", num);
    }
}

int main(){
    FILE *fp = fopen("pub.in", "rb");
    // int num_linha;
    // fread(num_linha, sizeof(int), 1, fp);

    // while(num_linha > 0);

    readFile(fp);
    fclose(fp);

    return 0;
}
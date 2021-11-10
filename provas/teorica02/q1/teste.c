#include <stdio.h>
#include <stdlib.h>

int main(){
    int *p;
    int v[] = {10, 7, 2, 6, 3};
    p = v;

    printf("p: %d\n*p: %d\n*(p+2): %d\n", p, *p, *(p+2));

    return 0;
}
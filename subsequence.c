#include <stdio.h>
#include <string.h>

int main(){
    char s[1001];
    scanf("%s", s);
    int L = strlen(s);
    for(int ctr=1; ctr<(1<<L); ctr++){
        for(int sh=0; sh<L; sh++){
            if(ctr & (1<<sh)) printf("%c", s[sh]);
        }
        printf("\n");
    }
}

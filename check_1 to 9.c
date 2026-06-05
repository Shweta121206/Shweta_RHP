#include <stdio.h>
int main(){
    char str[1000001];
    scanf("%s", str);
    int flag=0;
    for(int i=0;str[i];i++)
        if(str[i]>='1'&&str[i]<='9') flag|=1<<(str[i]-'1');
    printf(flag==((1<<9)-1)?"Yes":"No");
}

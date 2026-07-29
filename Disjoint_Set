#include <bits/stdc++.h>
using namespace std;
int find(vector<int> &ldr,int i){
    if(ldr[i]!=i){
        ldr[i]=find(ldr,ldr[i]);
    }
    return ldr[i];
}
void join(vector<int> &ldr,int l,int r){
    int x=find(ldr,l);
    int y=find(ldr,r);
    ldr[y]=x;
}
int main(){
    int n,m; cin>>n>>m;
    vector<int> ldr(n+1);
    for(int i=1;i<=n;i++) ldr[i]=i;
    for(int i=1;i<=m;i++){
        int l,r; cin>>l>>r;
        join(ldr,l,r);
    }
    set<int> s;
    for(int i=1;i<=n;i++){
        s.insert(find(ldr,i));
    }
    cout<<s.size();
    return 0;
}

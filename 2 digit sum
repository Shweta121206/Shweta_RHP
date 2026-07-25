#include <bits/stdc++.h>
using namespace std;
int seelcs(string x,string y)
{
   int r=x.length(),c=y.length();
   vector<int> mx(r),my(c);
   mx[0]=x[0]-'0';
   my[0]=y[0]-'0';
   for(int i=1;i<r;i++){
      mx[i]=(mx[i-1]+x[i]-'0')%10;
   }
   for(int i=1;i<c;i++){
      my[i]=(my[i-1]+y[i]-'0')%10;
   }
   if(mx[r-1]!=my[c-1]){
      return -1;
   }
   vector<vector<int>> dp(r+1,vector<int> (c+1,0));
   for(int i=1;i<=r;i++){
      for(int j=1;j<=c;j++){
         if(mx[i-1]==my[j-1]){
            dp[i][j]=1+dp[i-1][j-1];
         }
         else{
            dp[i][j]=(dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1]);
         }
      }
   }
   return dp[r][c];
};
int main(){
   int n; cin>>n;
   int res[n];
   for(int i=0;i<n;i++){
      string x,y; cin>>x>>y;
      res[i]=seelcs(x,y);
   }
   for(int i:res) cout<<i<<endl;
   return 0;
}

#include <bits/stdc++.h>
using namespace std;

long long* getFSmax(vector<vector<long long>>& dp, int col, int n) {
    long long fmax = LLONG_MIN, smax = LLONG_MIN;
    for (int i = 0; i < n; i++) {
        if (dp[i][col] > fmax) {
            smax = fmax;
            fmax = dp[i][col];
        } else if (dp[i][col] > smax) {
            smax = dp[i][col];
        }
    }
    static long long res[2];
    res[0] = fmax;
    res[1] = smax;
    return res;
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> a(n, vector<int>(m));
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> a[i][j];

    vector<vector<long long>> dp(n, vector<long long>(m));
    for (int i = 0; i < n; i++) dp[i][0] = a[i][0];

    for (int j = 1; j < m; j++) {
        long long* fmax = getFSmax(dp, j - 1, n);
        for (int i = 0; i < n; i++) {
            dp[i][j] = a[i][j] + (dp[i][j - 1] == fmax[0] ? fmax[1] : fmax[0]);
        }
    }

    long long ans = LLONG_MIN;
    for (int i = 0; i < n; i++) ans = max(ans, dp[i][m - 1]);
    cout << ans << "\n";
}

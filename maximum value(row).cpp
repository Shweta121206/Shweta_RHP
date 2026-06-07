#include <bits/stdc++.h>
using namespace std;

long long* getFSmax(vector<vector<long long>>& c, int row, int m) {
    long long fmax = LLONG_MIN, smax = LLONG_MIN;
    for (int j = 0; j < m; j++) {
        if (c[row][j] > fmax) {
            smax = fmax;
            fmax = c[row][j];
        } else if (c[row][j] > smax) {
            smax = c[row][j];
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

    vector<vector<long long>> c(n, vector<long long>(m));
    for (int j = 0; j < m; j++) c[0][j] = a[0][j];

    for (int i = 1; i < n; i++) {
        long long* fmax = getFSmax(c, i - 1, m);
        for (int j = 0; j < m; j++) {
            c[i][j] = a[i][j] + (c[i - 1][j] == fmax[0] ? fmax[1] : fmax[0]);
        }
    }

    long long ans = LLONG_MIN;
    for (int j = 0; j < m; j++) ans = max(ans, c[n - 1][j]);
    cout << ans << "\n";
}

#include <bits/stdc++.h>
using namespace std;

int main() {
    cout << "Enter the first string:" << endl;
    string str1;
    getline(cin, str1);

    cout << "Enter the second string:" << endl;
    string str2;
    getline(cin, str2);

    int n = str1.size();
    int m = str2.size();
    vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));

    int maxLength = 0;
    int endIndex = 0;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                    endIndex = i;
                }
            } else {
                dp[i][j] = 0;
            }
        }
    }

    string result = str1.substr(endIndex - maxLength, maxLength);

    cout << "\nDP Table:" << endl;
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            cout << dp[i][j] << " ";
        }
        cout << endl;
    }

    cout << "\nLength of Longest Common Substring: " << maxLength << endl;
    cout << "Longest Common Substring: " << result << endl;
}

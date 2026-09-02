import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class staticrange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int K = 18; // 2^18 >= 200000
        int[][] stTable = new int[K + 1][n + 1];
        int[] logTable = new int[n + 1];
        
        logTable[1] = 0;
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }
        
        for (int i = 1; i <= n; i++) {
            stTable[0][i] = arr[i];
        }
        
        for (int j = 1; j <= K; j++) {
            for (int i = 1; i + (1 << j) - 1 <= n; i++) {
                stTable[j][i] = Math.min(stTable[j - 1][i], stTable[j - 1][i + (1 << (j - 1))]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            
            int j = logTable[R - L + 1];
            int mn = Math.min(stTable[j][L], stTable[j][R - (1 << j) + 1]);
            sb.append(mn).append("\n");
        }
        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Item[] items = new Item[N+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            items[i] = new Item(W, V);
        }
        int[][] DP = new int[N+1][K+1];
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=K;j++) {
                if(j-items[i].weight>=0){
                    DP[i][j] = Math.max(DP[i-1][j],DP[i-1][j-items[i].weight] + items[i].value);
                }else{
                    DP[i][j] = DP[i-1][j];
                }
            }
        }
        System.out.println(DP[N][K]);
    }
}

class Item {
    int weight;
    int value;
    public Item(int W, int V) {
        this.weight = W;
        this.value = V;
    }
}

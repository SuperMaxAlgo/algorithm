import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] office;
    static int[][] cctv;
    static int cnt;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        cctv = new int[9][2];
        cnt = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int num = Integer.parseInt(st.nextToken());
                office[i][j] = num;
                if(num!=0&&num!=6){
                    cnt++;
                    cctv[cnt][0] = i;
                    cctv[cnt][1] = j;
                }
            }
        }

    }
}

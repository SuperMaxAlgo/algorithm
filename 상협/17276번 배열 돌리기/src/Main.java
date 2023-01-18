import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int n, d;
    static int[][] X;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            X = new int[n+1][n+1];
            for(int j=1;j<=n;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=1;k<=n;k++){
                    X[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            if(Math.abs((double)d)>=360){
                d %= 360;
            }
    
            int cnt = 0;
            if(d>0){
                cnt = d/45;
            }else if(d<0){
                cnt = (360+d)/45;
            }
    
            for(int j=0;j<cnt;j++){
                turn();
            }

            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    System.out.print(X[j][k]+" ");
                }
                if(!((i==T-1)&&(j==n))){
                    System.out.println();

                }
            }
        }


        
    }

    // 시계방향으로 45도 돌리기
    static void turn(){
        // X의 주 대각선을 ((1,1), (2,2), …, (n, n)) 가운데 열 ((n+1)/2 번째 열)로 옮긴다.
        int[] tmp = new int[n+1];
        int j = (n+1)/2;
        for(int i=1;i<=n;i++){
            tmp[i] = X[i][j];
        }
        for(int i=1;i<=n;i++){
            X[i][j] = X[i][i];
        }        
        // X의 가운데 행을 X의 주 대각선으로 옮긴다.
        for(int i=1;i<=n;i++){
            X[i][i] = X[j][i];
        }  
        // X의 부 대각선을 X의 가운데 행 ((n+1)/2번째 행)으로 옮긴다.
        for(int i=1;i<=n;i++){
            X[j][i] = X[n+1-i][i];
        }        
        // X의 가운데 열을 X의 부 대각선으로 ((n, 1), (n-1, 2), …, (1, n)) 옮긴다. 
        for(int i=1;i<=n;i++){
            X[i][n+1-i] = tmp[i];
        }  
    }
}

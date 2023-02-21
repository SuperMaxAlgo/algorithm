import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M,N;
        int[][] tomatoes;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int status = Integer.parseInt(st.nextToken());
                tomatoes[i][j] = status;
                if(status == 1){q.add(new int[] {i,j});}
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            for(int dir=0;dir<4;dir++){
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];
                if(nx<0||ny<0||nx>=M||ny>=N){continue;}
                if(tomatoes[ny][nx] == 0){
                    tomatoes[ny][nx] = tomatoes[cy][cx] + 1;
                    q.add(new int[] {ny,nx});
                }
            }
        }

        int max = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){                
                if(tomatoes[i][j] == 0){
                    System.out.println(-1);
                    return;
                }else if(tomatoes[i][j]>max){
                    max = tomatoes[i][j];
                }
            }
        }
        System.out.print(max-1);
    }
}
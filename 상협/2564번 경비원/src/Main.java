import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w,h,n;
    static int[][] loc;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫째 줄에 블록의 가로의 길이와 세로의 길이가 차례로 주어진다. 
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        // 둘째 줄에 상점의 개수가 주어진다. 
        // 블록의 가로의 길이와 세로의 길이, 상점의 개수는 모두 100이하의 자연수이다.
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        loc = new int[n+1][2];

        // 이어 한 줄에 하나씩 상점의 위치가 주어진다. 
        // 상점의 위치는 두 개의 자연수로 표시된다. 
        // 첫째 수는 상점이 위치한 방향을 나타내는데, 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점이 있음을 의미한다. 
        // 둘째 수는 상점이 블록의 북쪽 또는 남쪽에 위치한 경우 블록의 왼쪽 경계로부터의 거리를 나타내고, 상점이 블록의 동쪽 또는 서쪽에 위치한 경우 블록의 위쪽 경계로부터의 거리를 나타낸다. 
        // 마지막 줄에는 동근이의 위치가 상점의 위치와 같은 방식으로 주어진다. 상점의 위치나 동근이의 위치는 블록의 꼭짓점이 될 수 없다.
        int a, b;
        for(int i=0;i<=n;i++){//i==n이면 동근
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());//1: 북쪽, 2:남쪽, 3:서쪽, 4:동쪽
            b = Integer.parseInt(st.nextToken());//북,남쪽이면 왼쪽 경계로부터의 거리 동,서쪽이면 위쪽 경계로부터의 거리
            if(a==1){
                loc[i][0] = b;
                loc[i][1] = 0;
            }else if(a==2){
                loc[i][0] = b;
                loc[i][1] = h;
            }else if(a==3){
                loc[i][0] = 0;
                loc[i][1] = b;
            }else{
                loc[i][0] = w;
                loc[i][1] = b;
            }
        }

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += bfs(loc[i][0],loc[i][1]);
        }
        System.out.println(sum);
    }
    
    static int bfs(int x, int y){
        boolean[][] visited = new boolean[w+1][h+1];    
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {loc[n][0],loc[n][1],0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0]==x&&cur[1]==y){
                //System.out.println(cur[2]);
                return cur[2];
            }
            visited[cur[0]][cur[1]] = true;
            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0||nx>w||ny<0||ny>h||visited[nx][ny]){continue;}
                if(nx==0||nx==w||ny==0||ny==h){
                    q.add(new int[] {nx,ny,cur[2]+1});
                }
            }
        }
        return -1;
    }
}

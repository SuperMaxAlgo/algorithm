import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Cell {
    char c;
    int time;

    public Cell(char c, int time){
        this.c = c;
        this.time = time;
    }
}

public class Main {
    static int R,C,N;
    static Cell[][] grid;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        grid = new Cell[R][C];
        
        //1.가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
        int time = 0;
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0;j<C;j++){
                grid[i][j] = new Cell(s.charAt(j),time);
            }
        }
        
        //2.다음 1초 동안 봄버맨은 아무것도 하지 않는다.
        time++;
        
        while(true){
            //3.다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 즉, 모든 칸은 폭탄을 가지고 있게 된다. 폭탄은 모두 동시에 설치했다고 가정한다.
            if(time<N){
                time++;
                for(int i=0;i<R;i++){
                    for(int j=0;j<C;j++){
                        Cell cell = grid[i][j];
                        if(cell.c=='.'){
                            cell.c = 'O';
                            cell.time = time;
                        }
                    }
                }
            }else{ break; }

            //4.1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
            if(time<N){
                time++;
                for(int i=0;i<R;i++){
                    for(int j=0;j<C;j++){
                        Cell cell = grid[i][j];
                        if(cell.c=='O'&&cell.time==time-3){
                            cell.c = '.';
                            cell.time = time;
                            for(int k=0;k<4;k++){
                                int x = i + dx[k];
                                int y = j + dy[k];
                                if(x<0||y<0||x>=R||y>=C){continue;}
                                cell = grid[x][y];
                                if(cell.time==time-3){continue;}
                                cell.c = '.';
                                cell.time = time;
                            }
                        }
                    }
                }
            }else{ break; }

            //3과 4를 반복한다.            
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                Cell cell = grid[i][j];
                System.out.print(cell.c);
            }
            System.out.println();
        }
    }
}

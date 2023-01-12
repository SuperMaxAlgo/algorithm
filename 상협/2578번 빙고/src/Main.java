import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] bingoBoard = new int[5][5];
    static int[][] index = new int[26][2];
    static boolean[] vertical = new boolean[5];
    static boolean[] horizontal = new boolean[5];
    static boolean[] diagonal1 = new boolean[5];
    static boolean[] diagonal2 = new boolean[5];
    static int bingoCnt = 0;
    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                int num = Integer.parseInt(st.nextToken());
                bingoBoard[i][j] = num;
                index[num][0] = i;//x좌표 저장
                index[num][1] = j;//y좌표 저장
            }
        }

        int cnt = 0;
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                cnt++;
                int num = Integer.parseInt(st.nextToken());
                int x = index[num][0];
                int y = index[num][1];
                bingoBoard[x][y] = -1;
                check(x, y);
                if(bingoCnt>=3){
                    System.out.println(cnt);
                    return;
                }
                // if(check(x,y)){
                //     System.out.println(cnt);
                //     return;
                // }

            }
        }

    }

    static boolean check(int x, int y){
        // for(int i=0;i<5;i++){
        //     for(int j=0;j<5;j++){
        //         System.out.print(bingoBoard[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // 가로
        boolean totalFlag = false;
        boolean bingo = true;
        for(int i=0;i<5;i++){
            if(bingoBoard[i][y]!=-1){
                bingo = false;
            }
        }
        if(bingo){
            if(!vertical[y]){
                bingoCnt++;
                vertical[y] = true;
            }
            totalFlag =  true;
        }
        //세로
        bingo = true;
        for(int i=0;i<5;i++){
            if(bingoBoard[x][i]!=-1){
                bingo = false;
            }
        }        
        if(bingo){
            if(!horizontal[x]){
                bingoCnt++;
                horizontal[x] = true;
            }
            totalFlag =  true;
        }
        //대각선
        if(x==y){
            bingo = true;
            for(int i=0;i<5;i++){
                if(bingoBoard[i][i]!=-1){
                    bingo = false;
                }
            }
            if(bingo){
                if(!diagonal1[x]){
                    bingoCnt++;
                    diagonal1[x] = true;
                }
                totalFlag =  true;
            }
        }        
        if(x+y==4){
            bingo = true;
            for(int i=0;i<5;i++){
                if(bingoBoard[i][4-i]!=-1){
                    bingo = false;
                }
            }
            if(bingo){
                if(!diagonal2[x]){
                    bingoCnt++;
                    diagonal2[x] = true;
                }
                totalFlag =  true;
            }
        }        
        return totalFlag;
    }
}

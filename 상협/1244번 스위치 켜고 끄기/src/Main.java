import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;//스위치 개수
    static int M;//학생 수
    static int[] status;//스위치 상태
    static int[][] students;//학생들 성별, 받은 수

    static void boy(int n){
        for(int i=1;n*i-1<N;i++){
            change(n*i-1);
        }
    }
    
    static void girl(int n){
        change(n);
        for(int i=1;(n+i<N)&&(n-i>=0);i++){
            if(status[n+i]==status[n-i]){
               change(n+i);
               change(n-i); 
            }else{
                break;
            }
        }
    }
    
    static void change(int n){
        status[n] = status[n]^1;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        status = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            status[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        students = new int[M][2];
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(st.nextToken());
            students[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            if(students[i][0]==1){
                boy(students[i][1]);
            }else{
                girl(students[i][1]-1);
            }
        }
        for(int i=0;i<N;i++){
            System.out.print(status[i]+" ");
            if((i+1)%20==0&&i!=N-1){System.out.println();}
        }
    }

}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int testcase=0;testcase<T;testcase++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] result = new int[N][2];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                result[i][0] = Integer.parseInt(st.nextToken());
                result[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(result,(o1,o2)->{
                return o1[0]-o2[0];
            });
            int min = result[0][1];
            int cnt = 0;
            for(int i=1;i<N;i++){
                if(result[i][1]>min){
                    cnt++;
                }else{
                    min = result[i][1];
                }
            }
            System.out.println(N-cnt);
        }
    }
}

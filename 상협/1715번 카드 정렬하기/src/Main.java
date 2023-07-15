import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        while(pq.size()!=1){
            int A = pq.poll();
            int B = pq.poll();
            int sum = A + B;
            cnt += sum;
            pq.add(sum);
        }
        System.out.println(cnt);
    }
}

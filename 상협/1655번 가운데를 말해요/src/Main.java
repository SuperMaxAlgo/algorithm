import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            int input = Integer.parseInt(br.readLine());
            if(maxHeap.size()==minHeap.size()){
                maxHeap.add(input);
            }else{
                minHeap.add(input);
            }
            if(!minHeap.isEmpty()&&!maxHeap.isEmpty()){
                if(minHeap.peek()<maxHeap.peek()){
                    int temp = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(temp);
                }
            }
            sb.append(maxHeap.peek()+"\n");
        }
        System.out.println(sb.toString());
    }
}

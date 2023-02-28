import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            adjList.add(new ArrayList<>());
        }
        int[] parent = new int[N+1];
        for(int i=0;i<N-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : adjList.get(cur)){
                if(parent[i]==0){
                    parent[i] = cur;
                    q.add(i);
                }
            }
        }
        for(int i=2;i<=N;i++){
            System.out.println(parent[i]);
        }
    }
}
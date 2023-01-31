import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    static String s;
    static int len;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        //첫 번째 줄에 알파벳 대문자로 구성된 문자열이 주어진다. 문자열의 길이는 최대 100자이다.
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = st.nextToken();
        len = s.length();
        visited = new boolean[len];

        char c = 'Z';
        int idx = 0;

        for(int i=0;i<len;i++){
            if(s.charAt(i)<c){
                c = s.charAt(i);
                idx = i;
            }
        }        
        System.out.println(idx);
    }

    static void dfs(int idx){
        Stack<Integer> stack = new Stack<>();
        stack.push(idx);
        while(!stack.isEmpty()){
            int cur = stack.pop();
        }

    }
}

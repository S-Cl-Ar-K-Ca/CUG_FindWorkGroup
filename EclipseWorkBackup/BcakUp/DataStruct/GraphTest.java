
import java.util.Arrays;
import java.util.Stack;

public class GraphTest {
    public static void main(String[] args) {
        Vertex v1 =new Vertex('A');
        Vertex v2 =new Vertex('B');
        Vertex v3 =new Vertex('C');
        Vertex v4 =new Vertex('D');
        Vertex v5 =new Vertex('E');
        
        Graph graph =new Graph(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

       graph.addEdge('A', 'B');
       graph.addEdge('A', 'C');
       graph.addEdge('A', 'D');
       graph.addEdge('B', 'E');
       graph.addEdge('C', 'E');    
       
       for(int [] a: graph.adjMat) {
           System.out.println(Arrays.toString(a));
       }
       System.out.println("深度优先搜索的结果：");
       graph.DFS();
    }
}

class Vertex{
    public char Value;
    public boolean wasVisited = false;
    
    public Vertex(char value) {
        // TODO Auto-generated constructor stub
        this.Value =  value;
    }
    public char getValue() {
        return Value;
    }
}


class Graph{
    private int GraphSize;
    public Stack<Integer> stack = new Stack<>();
    
    public int getGraphSize() {
        return GraphSize;
    }
    public int currentSize;
    public Vertex []  vertexs ;
    public int[][] adjMat;
    
    public Graph(int size) {
        // TODO Auto-generated constructor stub
        this.GraphSize = size;
        vertexs = new Vertex[size];
        adjMat = new int[size][size];
    }
    //向当前图中添加节点
    public void addVertex(Vertex v) {
        adjMat[currentSize][currentSize] = 1; //每次加入一个节点就将对角线  置为1
        vertexs[currentSize++] = v;
    }
    
    public void addEdge(char a,char b) {
        int index1 = 0;
        for (int i=0;i < vertexs.length; i++) {
            if (vertexs[i].Value == a) {
                index1 = i;
                break;
            }
        }
        int index2 = 0;
        for (int i=0;i < vertexs.length; i++) {
            if (vertexs[i].Value == b) {
                index2 = i;
                break;
            }
        }
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;
    }
    
    public void DFS() {
        int maxDeep=1;
        vertexs[0].wasVisited = true;
        stack.push(0);
        System.out.println(vertexs[0].Value);
        
        while(! stack.isEmpty()) {
            for(int i= stack.peek()+1;i<vertexs.length;i++) {
                if (adjMat[stack.peek()][i] == 1 && vertexs[i].wasVisited == false) {
                    stack.push(i);
                    maxDeep=Math.max(maxDeep, stack.size());
                    vertexs[i].wasVisited = true;
                    System.out.println(vertexs[i].Value);
                }
            }
            stack.pop();
        }
        System.out.println(maxDeep);
    }
    
    public int getCurrentSize() {
        return currentSize;
    }
    
}
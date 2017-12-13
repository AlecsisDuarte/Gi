
/*  
    First array has all the labels for the tree formed from the second array
    Having this input:

        Input: 1 1 1 2 2 1 2 1 3 2 4 2 5

    We get a tree like this

                            1
                    2              3
                4       5
    With node 1, 2 and 3 having the label 1
    And node 4 and 5 having the label 2
    Therefore the longes path with the same label is 2 (2 -> 1 -> 3)

        Output: 2
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class Node{
    public int value;
    public int label;
    public ArrayList<Node> childs;
    public Node(int value, int label){
        childs = new ArrayList<Node>();
        this.value = value;
        this.label = label;
    }
    public void addChild(Node n){
        this.childs.add(n);
    }
}

public class Test2 {

    public static int containsEqualLables(Node root, int label){
        if(root.label != label) return 0;
        int count = 1;
        for(Node child : root.childs){
            count += containsEqualLables(child, label);
        }
        return count;
    }
    
    public static int solution(int[] A, int[] E) {
         HashMap<Integer, Node> nodes = new HashMap<Integer, Node>(A.length);
         int aIndex = 0;
         for(int i =0 ; i < E.length; i++){
             if(nodes.containsKey(E[i])){
                 Node n = nodes.get(E[i]);
                 n.addChild(new Node(E[++i], A[++aIndex]));
                } else {
                    Node n = new Node(E[i], A[aIndex]);
                    nodes.put(E[i], n);
                    n.addChild(new Node(E[++i], A[++aIndex]));
            }
        }
        int maxPath = 0;
        for(Node n : nodes.values()){
            int pathCount = containsEqualLables(n, n.label) - 1;
            maxPath = pathCount > maxPath ? pathCount : maxPath;
        }
        return maxPath;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[5];
        for(int i = 0; i < a.length; i++){
            a[i] = in.nextInt();
        }
        int[] b = new int[(a.length-1)*2];
        for(int i =0 ; i < b.length; i ++){
            b[i] = in.nextInt();
        }
        System.out.println(solution(a, b));
        in.close();
    }
}
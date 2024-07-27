import java.io.*;
import java.util.*;
import java.lang.*;

class Node{
    int data;
    Node left,right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Main {
    public static Node insertleft(Node node,int value) {
        node.left = new Node(value);
        return node.left;
    }
    public static Node insertright(Node node,int value) {
        node.right = new Node(value);
        return node.right;
    }
    public static void level(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root==null) {
            System.out.println(result);
        }
        q.add(root);
        List<Integer> innerlist = new ArrayList<>();
        innerlist.add(root.data);
        result.add(innerlist);
        innerlist = new ArrayList<>();
        q.add(null);
        while(!q.isEmpty()) {
            Node curr = q.remove();
            if(curr==null) {
                if(q.isEmpty()) {
                    break;
                }
                else {
                    result.add(innerlist);
                    innerlist = new ArrayList<>();
                    q.add(null);
                }
            }
            else {
                if(curr.left!=null) {
                    q.add(curr.left);
                    innerlist.add(curr.left.data);
                }
                if(curr.right!=null) {
                    q.add(curr.right);
                    innerlist.add(curr.right.data);
                }
            }
        }
        List<List<Integer>> finalresult = new ArrayList<>();
        for(int i=result.size()-1;i>=0;i--) {
            finalresult.add(result.get(i));
        }
        System.out.println(result);
        System.out.println(finalresult);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        insertleft(root,2);
        insertright(root,3);
        insertleft(root.left,4);
        insertright(root.left,5);
        insertleft(root.right,6);
        insertright(root.right,7);
        level(root);
    }
}

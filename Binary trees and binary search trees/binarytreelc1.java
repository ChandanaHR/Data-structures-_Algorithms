import java.io.*;
import java.util.*;
import java.lang.*;

class Edge {
    int source;
    int destination;
    Edge(int src,int dest) {
        source = src;
        destination = dest;
    }
}

public class Main {
    static int count = 0;
    public static void preorder(int index,ArrayList<Edge> list[],int size,boolean visited[]) {
        visited[index] = true;
        if(!(list[index].isEmpty())) {
            for(int j=0;j<list[index].size();j++) {
                if(!visited[list[index].get(j).destination]) {
                    preorder(list[index].get(j).destination,list,size,visited);
                }
                else {
                    count++;
                }
             }
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the queries length");
        int m = sc.nextInt();
        int[][] queries = new int[m][2];
        for(int i=0;i<m;i++) {
            for(int j=0;j<2;j++) {
                queries[i][j] = sc.nextInt();
            }
        }
        double size = Math.pow(2,n);
        System.out.println(size);
        ArrayList<Edge> list[] = new ArrayList[(int)size];
        for(int i=0;i<(int)size;i++) {
            list[i] = new ArrayList<>();
        }
        System.out.println((int)size);
        for(int i=1;i<(int)size;i++) {
            int left = 2*i;
            int right = 2*i+1;
            if(left<(int)size) {
                list[i].add(new Edge(i,left));
            }
            if(right<(int)size) {
                list[i].add(new Edge(i,right));
            }
        }
        for(int i=1;i<(int)size;i++) {
            if(!(list[i].isEmpty())) {
                int leftchild = list[i].get(0).destination;
                int rightchild = list[i].get(1).destination;
                System.out.print(i+"->"+leftchild+" "+rightchild);
                System.out.println();
            }
        }
        for(int i=1;i<size;i++) {
            for(int j=0;j<list[i].size();j++) {
                System.out.print(list[i].get(j).source+"-> "+list[i].get(j).destination+" ");
            }
            System.out.println();
        }
        for(int i=0;i<m;i++) {
            int src = queries[i][0];
            int dest = queries[i][1];
            System.out.print(src+" ->"+dest+" ");
            list[src].add(new Edge(src,dest));
            boolean visited[] = new boolean[(int)size];
            preorder(1,list,(int)size,visited);
            list[src] = new ArrayList<>();
        }
        System.out.println();
        System.out.println(count);
    }
}

class Solution {
    public int findlca(int a,int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        HashSet<Integer> set = new HashSet<>();
        while(max!=0) {
            set.add(max);
            max = max/2;
        }
        while(min!=0) {
            if(set.contains(min)) {
                return min;
            }
            min = min/2;
        }
        return 1;
    }
    public int finddistance(int num) {
        int distance = 0;
        while(num>0) {
            num = num>>1;
            distance++;
        }
        return distance;
    }
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int index = 0;
        int[] result = new int[queries.length];
        for(int[] q : queries) {
            int lca = findlca(q[0],q[1]);
            result[index++] = finddistance(q[0])-finddistance(lca)+finddistance(q[1])-finddistance(lca)+1;
        }
        return result;
    }
}

import java.util.*;
class Solution {
    static class UnionFind {
        int[] rank;
        int[] parent;
        UnionFind(int n) {
            this.rank = new int[n];
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                return find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int idx1, int idx2) {
            int root1 = find(idx1);
            int root2 = find(idx2);
            if (root1 != root2) {
                if (rank[root1] < rank[root2]) {
                    parent[root1] = root2;
                } else if (rank[root1] > rank[root2]) {
                    parent[root2] = root1;
                } else {
                    rank[root1]++;
                    parent[root2] = root1;
                }
            }
        }
    } 
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        UnionFind uf = new UnionFind(n);
        for (int r = 0; r < computers.length; r++) {
            for (int c = 0; c < computers[0].length; c++) {
                if (computers[r][c] == 1) {
                    uf.union(r, c);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < uf.parent.length; i++) {
            set.add(uf.find(uf.parent[i]));
        }
        
        return set.size();
    }
}
import java.util.*;
class Solution {
    public static class UnionFind {
        int[] parent, rank;
        
        UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i=0; i<n; i++) {
                this.parent[i] = i;
            }
        }
        
        int find(int idx) {
            if (parent[idx]!=idx) {
                return find(parent[idx]);
            }
            return parent[idx];
        }
        
        void union(int idx1, int idx2) {
            int root1 = find(idx1);
            int root2 = find(idx2);
            
            if (root1!=root2) {
                if (rank[root1]>rank[root2]){
                    parent[root2] = root1;
                } else if (rank[root1]<rank[root2]) {
                    parent[root1] = root2;
                } else {
                    parent[root2] = root1;
                    rank[root1]++;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        UnionFind uf = new UnionFind(n);
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                if (r!=c && computers[r][c]==1) {
                    uf.union(r, c);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            set.add(uf.find(i));
        }
        
        return set.size();
    }
}
const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

class UnionFind {
  constructor(n) {
    this.rank = new Array(n).fill(0);
    this.parent = Array.from({ length: n }, (_, idx) => idx);
  }

  find(idx) {
    if (this.parent[idx] != idx) {
      this.parent[idx] = this.find(this.parent[idx]);
    }
    return this.parent[idx];
  }

  union(idx1, idx2) {
    const root1 = this.find(idx1);
    const root2 = this.find(idx2);

    if (root1 != root2) {
      if (this.rank[root1] > this.rank[root2]) {
        this.parent[root2] = root1;
      } else if (this.rank[root2] > this.rank[root1]) {
        this.parent[root1] = root2;
      } else {
        this.parent[root2] = root1;
        this.rank[root1]++;
      }
    }
  }
}

function solution(arr) {
  const N = Number(arr[0]); // 도시의 수
  const M = Number(arr[1]); // 여행 계획에 속한 도시들의 수

  const uf = new UnionFind(N);
  for (let r = 0; r < N; r++) {
    const rInfo = arr[2 + r].split(" ").map(Number);
    for (let c = 0; c < N; c++) {
      if (rInfo[c] === 1) {
        uf.union(r, c);
      }
    }
  }
  const check = arr[N + 2].split(" ").map(Number);
  for (let c = 0; c < check.length - 1; c++) {
    if (uf.find(check[c] - 1) !== uf.find(check[c + 1] - 1)) {
      return "NO";
    }
  }
  return "YES";
}

console.log(solution(input));
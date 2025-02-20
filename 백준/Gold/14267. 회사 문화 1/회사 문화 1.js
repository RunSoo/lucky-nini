const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

function solution(arr) {
  const [N, M] = arr[0].split(" ").map(Number);
  const childNode = Array.from({ length: N + 1 }, () => []);
  const parentList = arr[1].split(" ").map(Number);
  let ceo = -1;
  for (let i = 0; i < N; i++) {
    if (parentList[i] !== -1) {
      childNode[parentList[i]].push(i + 1);
    } else {
      ceo = i + 1;
    }
  }
  const dp = new Array(N + 1).fill(0);
  for (let j = 0; j < M; j++) {
    const [i, w] = arr[2 + j].split(" ").map(Number);
    dp[i] += w;
  }

  function dfs(idx) {
    for (let i = 0; i < childNode[idx].length; i++) {
      const c = childNode[idx][i];
      dp[c] += dp[idx];
      dfs(c);
    }
  }

  dfs(ceo);
  dp.shift();

  return dp.reduce((curr, acc) => curr + acc + " ", "");
}

console.log(solution(input));
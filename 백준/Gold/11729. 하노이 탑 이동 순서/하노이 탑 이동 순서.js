const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

function solution(arr) {
  const K = Number(arr[0].trim());
  // 칸 3개 => 내가 있는 칸(A), 나머지 칸(B), 목표 칸(C)
  // N개를 옮기려면
  // N-1개를 나머지 칸으로 옮기기 => 이 때는 A: 1, B: 3, C: 2
  // 1개를 C칸으로 옮기려면 A C
  // 2개를 C칸으로 옮기려면 A B, A C, B C
  // 3개를 C칸으로 옮기려면 (A C, A B, C B), A C,
  const move = (n, a, b, c) => {
    if (n == 1) {
      return `${a} ${c}\n`;
    }
    return move(n - 1, a, c, b) + `${a} ${c}\n` + move(n - 1, b, a, c);
  };

  return 2 ** K - 1 + "\n" + move(K, 1, 2, 3).trim();
}

console.log(solution(input));
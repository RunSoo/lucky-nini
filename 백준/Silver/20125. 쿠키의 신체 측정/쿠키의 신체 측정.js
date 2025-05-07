const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

function solution(arr) {
  const N = Number(arr[0]);
  const map = arr.slice(1, arr.length).map((el) => el.trim().split(""));
  const heart = [0, 0];
  const lengths = [0, 0, 0, 0, 0]; // 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리
  outer: for (let r = 0; r < N; r++) {
    for (let c = 0; c < N; c++) {
      if (map[r][c] === "*") {
        heart[0] = r + 1;
        heart[1] = c;
        break outer;
      }
    }
  }
  // 왼쪽 팔 구하기
  for (let c = heart[1] - 1; c >= 0; c--) {
    if (map[heart[0]][c] === "*") lengths[0]++;
    else break;
  }

  // 오른쪽 팔 구하기
  for (let c = heart[1] + 1; c < N; c++) {
    if (map[heart[0]][c] === "*") lengths[1]++;
    else break;
  }

  // 허리 구하기
  for (let r = heart[0] + 1; r < N; r++) {
    if (map[r][heart[1]] === "*") lengths[2]++;
    else break;
  }

  // 왼쪽 다리 구하기
  for (let r = heart[0] + lengths[2] + 1; r < N; r++) {
    if (map[r][heart[1] - 1] === "*") lengths[3]++;
    else break;
  }

  // 오른쪽 다리 구하기
  for (let r = heart[0] + lengths[2] + 1; r < N; r++) {
    if (map[r][heart[1] + 1] === "*") lengths[4]++;
    else break;
  }

  let result = "";
  result += heart[0] + 1 + " " + (heart[1] + 1) + "\n";
  result += lengths.reduce((prev, cur) => prev + " " + cur);
  return result;
}

console.log(solution(input));
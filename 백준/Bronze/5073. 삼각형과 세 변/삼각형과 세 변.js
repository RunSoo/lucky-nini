const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

function solution(arr) {
  let result = "";
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === "0 0 0") break;

    let [a, b, c] = arr[i]
      .split(" ")
      .map(Number)
      .sort((a, b) => a - b);

    if (a + b <= c) result += "Invalid";
    else if (a === b && b === c) result += "Equilateral";
    else if (a === b || b === c || a === c) result += "Isosceles";
    else result += "Scalene";

    result += "\n";
  }
  return result.trim();
}

console.log(solution(input));
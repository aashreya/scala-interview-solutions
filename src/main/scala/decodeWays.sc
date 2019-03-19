// A message containing letters from A-Z is being encoded to numbers using the following mapping:
// 'A' -> 1 , 'B' -> 2 .... 'Z' -> 26

// Given a non-empty string containing only digits, determine the total number of ways to decode it.

// Example 1:

// Input: "12"
// Output: 2
// Explanation: It could be decoded as "AB" (1 2) or "L" (12).

// Input: "226"
// Output: 3
// Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).


val dict = Map('A' -> 1, 'B' -> 2, 'C' -> 3, 'D' -> 4, 'F' -> 6, 'L' -> 12, 'V' -> 22, 'Z' -> 26)
val invDict = Map(1 -> 'A', 2 -> 'B', 3 -> 'C', 6 -> 'F', 12 -> 'L', 22 -> 'V', 26 -> 'Z')

object Solution {
  def numDecodings(s: String): Int = goDecode(s, "")

  def goDecode(s: String, acc: String): Int = {
    if (s.isEmpty)
      return 1
    if (s.length >= 2) {
      val twoChar = s.substring(0, 2)
      println(s.head.asDigit)
      goDecode(s.tail, invDict(s.head.asDigit).toString + acc) + goDecode(s.drop(2), invDict(twoChar.toInt).toString + acc)
    }
    else
      goDecode("", invDict(s.head.asDigit) + acc)
  }
}

val example1 = "12"
val example2 = "226"

Solution.numDecodings(example2)
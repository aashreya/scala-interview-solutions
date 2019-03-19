// Given an input string (s) and a pattern (p),
// implement regular expression matching with support for '.' and '*'
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
// The matching should cover the entire input string (not partial).
// s could be empty and contains only lowercase letters a-z.
// p could be empty and contains only lowercase letters a-z, and characters like . or *.

// ex1
//Input:
//  s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".

//Input:
//s = "ab"
//p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".

//Input:
//s = "aab"
//p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

//Input:
//s = "mississippi"
//p = "mis*is*p*."
//Output: false

object Solution {
  def isMatch(s: String, p: String): Boolean = {
    if (s.isEmpty)
      return true
    if (p.isEmpty)
      return false
    val headChar = p.head
    if (p.tail.length > 0 && p.tail.head == '*') {
      val newStr = s.dropWhile(x => x == headChar)
      //      println(newStr)
      isMatch(newStr, p.drop(2))
    }
    else if (p.head == '.') {
      isMatch(s.tail, p.tail)
    }
    else {
      if (s.head == p.head)
        isMatch(s.tail, p.tail)
      else
        isMatch(s, p.tail)
    }
  }
}

val ex1 = "aa"
val p1 = "a*"

val ex2 = "mississippi"
val p2 = "mis*is*p*."

val ex3 = "aab"
val p3 = "c*a*b"

val ex4 = "ab"
val p4 = ".*"

Solution.isMatch(ex1, p1)
Solution.isMatch(ex2, p2)
Solution.isMatch(ex3, p3)
Solution.isMatch(ex4, p4)
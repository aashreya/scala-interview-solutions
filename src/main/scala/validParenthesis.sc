//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//
//  An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//  Open brackets must be closed in the correct order.
//  Note that an empty string is also considered valid.

// Example 1
// Input: "()"
// Output: true

// Example 2
// Input: "(]"
// Output: false

object Solution {
  def isValid(s: String): Boolean = {
    val mapData = s.foldLeft(List[Char]())((a, b) => {
      b match {
        case '(' | '{' | '[' => b :: a
        case ')' => if (a.head == '(') a.tail else a
        case ']' => if (a.head == '[') a.tail else a
        case '}' => if (a.head == '{') a.tail else a
      }
    })
    println(mapData)
    mapData.isEmpty
  }
}

val ex1 = "()"
val ex2 = "(]"
val ex3 = "([)]"
val ex4 = "{[]}"
Solution.isValid(ex1)
Solution.isValid(ex2)
Solution.isValid(ex3)
Solution.isValid(ex4)
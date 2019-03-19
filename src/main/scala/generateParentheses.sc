// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:
//[ "((()))", "(()())", "(())()", "()(())", "()()()" ]

object Solution {
  def generateParenthesis(n: Int): Unit = {
    val orgString = for {x <- List.range(0, n)} yield "()"

    def goGenerate(fCount: Int, bCount: Int, acc: String): Unit = {
      if (acc.length == n * 2 && checkIfCorrectParentheses(acc) == 0)
        println(acc)
      if (fCount < 0 || bCount < 0 || checkIfCorrectParentheses(acc) < 0)
        return
      goGenerate(fCount - 1, bCount, acc + "(")
      goGenerate(fCount, bCount - 1, acc + ")")
    }

    goGenerate(n, n, "")
  }

  def checkIfCorrectParentheses(parenStr: String) = {
    def checker(a: Int, b: Char): Int = {
      if (a < 0)
        -1
      else if (b == '(')
        a + 1
      else
        a - 1
    }

    parenStr.foldLeft(0)((a, b) => checker(a, b))
  }
}

val example1 = 4
Solution.checkIfCorrectParentheses("((()))")
Solution.checkIfCorrectParentheses("())(()")
Solution.generateParenthesis(example1)
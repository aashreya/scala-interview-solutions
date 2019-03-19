// 17. Letter Combinations of a Phone Number
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
// Example
// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

object Solution {

  val letterMap = Map(2 -> "abc", 3 -> "def", 4 -> "ghi", 5 -> "jki", 6 -> "mno", 7 -> "pqrs", 8 -> "tuv", 9 -> "wxyz")

  def letterCombinations(digits: String): Unit = {
    val letterList: List[String] = digits.map(x => letterMap(x.asDigit)).toList

    def goCombinations(lst: List[String], acc: String): Unit = {
      if (acc.length == digits.length)
        println(acc)
      if (lst.isEmpty || lst.head.length == 0)
        return
      val headelem = lst.head.head
      val newList = lst.head.tail :: lst.tail
      goCombinations(lst.tail, acc + headelem)
      goCombinations(newList, acc)
    }

    goCombinations(letterList, "")
  }

  def testLetter(n: Int) = {
    println(letterMap(n))
  }
}

val example1 = "23"
val example2 = "345"
Solution.letterCombinations(example2)
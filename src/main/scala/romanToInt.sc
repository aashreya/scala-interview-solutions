// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//Symbol       Value
//  I             1
//  V             5
//  X             10
//  L             50
//  C             100
//  D             500
//  M             1000

// Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
//Example
//  Input: "III"
//  Output: 3
// Input: "IX"
// Output: 9
// Input: "LVIII"
// Output: 58
// Explanation: C = 100, L = 50, XXX = 30 and III = 3.
// Input: "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


object Solution {
  def romanToInt(s: String): Int = {

    def replaceTwoChars(str: String): (String, Int) = {
      val initialFilter = List("IX", "IV", "CM", "XC")
      val filteredL = initialFilter.filter(x => str.indexOf(x) >= 0)
      val replacedStr = initialFilter.foldLeft(str)((a, b) => a.replace(b, ""))
      val sumToRet = filteredL.foldLeft(0)((a, b) => a + twoCharToNum(b))
      (replacedStr, sumToRet)
    }

    def stringJoiner(num: Int, ch: Char): Int = {
      val numberFromRoman = charToNumConverter(ch)
      num + numberFromRoman
    }

    val tup = replaceTwoChars(s)
    tup._2 + tup._1.foldLeft(0)((a, b) => stringJoiner(a, b))
  }

  def charToNumConverter(ch: Char) = ch match {
    case 'I' => 1
    case 'V' => 5
    case 'X' => 10
    case 'L' => 50
    case 'C' => 100
    case 'D' => 500
    case 'M' => 1000
    case _ => 0
  }

  def twoCharToNum(str: String) = str match {
    case "IV" => 4
    case "IX" => 9
    case "CM" => 900
    case "XC" => 90
    case _ => 0
  }

  def romanToIntUsingList(s: String): Int = {
    def goRoman(romanChars: List[Char], acc: Int): Int = romanChars match {
      case Nil => acc
      case h :: t :: tail if twoCharToNum(s"$h$t") > 0 => goRoman(tail, acc + twoCharToNum(s"$h$t"))
      case h :: tail if charToNumConverter(h) > 0 => goRoman(tail, acc + charToNumConverter(h))
    }

    goRoman(s.toList, 0)
  }


}

val roman1 = "III"
val roman2 = "IX"
val roman3 = "LVIII"
val roman4 = "MCMXCIV"

Solution.romanToInt(roman3)
Solution.romanToInt(roman4)
Solution.romanToIntUsingList(roman3)
Solution.romanToIntUsingList(roman4)

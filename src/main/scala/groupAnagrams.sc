// Given an array of strings, group anagrams together.

// Example

// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:[["ate","eat","tea"],["nat","tan"],["bat"]]


object Solution {
  def groupAnagrams(strs: List[String]): List[List[String]] = {
    def addToGroup(a: List[List[String]], st: String): List[List[String]] = {
      if (!(a.exists(x => x.nonEmpty && compareAnagrams(x.head, st))))
        List(st) :: a
      else
        a.map(x => if (x.nonEmpty && compareAnagrams(x.head, st)) st :: x else x)
    }

    strs.foldLeft(List(List[String]()))((a, b) => addToGroup(a, b))

  }

  // Puts in map and removes it
  // 2nd approach is sort and compare
  def compareAnagrams(str1: String, str2: String): Boolean = {

    def addToMap(a: Map[Char, Int], b: Char): Map[Char, Int] = {
      if (a.contains(b)) {
        val c = a(b)
        return a + (b -> (c + 1))
      }
      else
        return a + (b -> 1)
    }

    def removeFromMap(a: Map[Char, Int], b: Char): Map[Char, Int] = {
      if (a.contains(b)) {
        val c = a(b)
        return a + (b -> (c - 1))
      }
      else
        return a + (b -> -1)
    }

    val storedData = str1.foldLeft(Map[Char, Int]())((a, b) => addToMap(a, b))
    val removedData = str2.foldLeft(storedData)((a, b) => removeFromMap(a, b))
    if (removedData.values.filter(x => x != 0).size == 0) true else false

  }

}

val example1 = List("eat", "tea", "tan", "ate", "nat", "bat")

val an1 = "eat"
val an2 = "tea"
val an3 = "tex"
//Solution.compareAnagrams(an1, an2)
//Solution.compareAnagrams(an1, an3)


Solution.groupAnagrams(example1)
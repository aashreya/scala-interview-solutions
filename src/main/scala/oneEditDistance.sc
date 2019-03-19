// An edit between two strings is one of the following changes.
// Add a character
// Delete a character
// Change a character
// Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit

//Ex1
// Input:  s1 = "geeks", s2 = "geek"
// Output: yes
// Number of edits is 1

//Ex2
//Input:  s1 = "peaks", s2 = "geeks"
//Output: no
//Number of edits is 2

object Solution {

  def isOneEditDistance(str1: String, str2: String): Boolean = {
    val biggest = if (str1.length >= str2.length) str1 else str2
    val small = if (str2.length <= str1.length) str2 else str1

    val stored = biggest.foldLeft(Map.empty[Char, Int])((a: Map[Char, Int], b: Char) => {
      a + (b -> (a.getOrElse(b, 0) + 1))
    })
    val removed = small.foldLeft(stored)((a, b) => {
      a + (b -> (a.getOrElse(b, 1) - 1))
    })
    removed.values.count(x => x > 0) < 2
  }

  def distanceWithMutableMap(str1: String, str2: String): Boolean = {

    val mutMap = scala.collection.mutable.Map[Char, Int]()
    str1.foreach(x => {
      val num = mutMap.getOrElse(x, 0)
      mutMap(x) = num + 1
    })
    str2.foreach(x => {
      val num = mutMap.getOrElse(x, 1)
      mutMap(x) = num - 1
    })
    println(mutMap)
    mutMap.values.count(x => x > 0) < 2
  }

  def isOneEditDistanceEasy(str1: String, str2: String): Boolean = {
    println(str1.diff(str2))
    if (str1.length > str2.length)
      str1.diff(str2).length < 2
    else
      str2.diff(str1).length < 2
  }
}

val s1 = "geeks"
val s2 = "geek"
val s3 = "peaks"
val s4 = "geeks"

//Solution.isOneEditDistanceEasy(s2, s1)
//Solution.isOneEditDistanceEasy(s3, s4)

Solution.isOneEditDistance(s2, s1)
Solution.isOneEditDistance(s3, s4)

Solution.distanceWithMutableMap(s2, s1)
Solution.distanceWithMutableMap(s3, s4)



